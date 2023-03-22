package cscie88a.week8.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import cscie88a.week8.util.FileReader;
import cscie88a.week8.util.SensorEventParser;
import cscie88a.week8.kafka.MessageProducer;
import cscie88a.week8.model.SensorEvent;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Randomly picks sample data from input directory and generates sensor events in json format
 * to output directory
 */
public class    KafkaDataGenerator {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final Instant DEFAULT_START_DATE = Instant.now().truncatedTo(ChronoUnit.DAYS);
    public static final String DEFAULT_DAYS = "1";
    public static final String DEFAULT_TEST_TOPIC = "test";
    public static final String DEFAULT_KAFKA_URL = "localhost:9092";
    private String kafkaTopic ;
    private String kafkaUrl ;
    private String streamingFlag;
    private Integer streamingIntervalSec;
    Set<String> sensorIdList = FileReader.readAllValuesFile("input/sensor-id-small.txt");
    String[] sensorIdArray, sensorTypeArray, windDirectionArray, zipCodeArray;

    Set<String> sensorTypeList = FileReader.readAllValuesFile("input/sensor-type.txt");

    Set<String> windDirectionList = FileReader.readAllValuesFile("input/wind-directions.txt");

    Set<String> zipCodeList = FileReader.readAllValuesFile("input/zipcode.txt");

    Instant dayBeginningEpoch = Instant.now().truncatedTo(ChronoUnit.DAYS);
    MessageProducer kafkaProducer = null ;
    int numberOfDaysRange ;
    long daysInMillis;
    private int numberOfEvents;

    public KafkaDataGenerator() {
        sensorIdArray =  sensorIdList.stream().toArray(String[]::new);
        sensorTypeArray =  sensorTypeList.stream().toArray(String[]::new);
        zipCodeArray =  zipCodeList.stream().toArray(String[]::new);
        windDirectionArray =  windDirectionList.stream().toArray(String[]::new);
        String startDateAsEpochString = System.getProperty("start_date_epoch_millis",null);
        String endDaysFromStartString = System.getProperty("end_no_days_from_start", DEFAULT_DAYS);
        validateStartParameters(startDateAsEpochString, endDaysFromStartString);
        daysInMillis = TimeUnit.DAYS.toMillis(numberOfDaysRange);
        String noOfEventsString = System.getProperty("no_of_events", "500");
        streamingFlag = System.getProperty("streaming", "y");
        String streamingIntervalString = System.getProperty("streaming_interval_sec", "10");
        numberOfEvents = Integer.parseInt(noOfEventsString);
        streamingIntervalSec = Integer.parseInt(streamingIntervalString);
        kafkaTopic = System.getProperty("kafka_topic", DEFAULT_TEST_TOPIC);
        kafkaUrl = System.getProperty("kafka_url", DEFAULT_KAFKA_URL);
        kafkaProducer = new MessageProducer(kafkaUrl, kafkaTopic);
        Runtime.getRuntime().addShutdownHook(new Thread(kafkaProducer::closeProducer));
    }

    private void validateStartParameters(String startDateAsEpochString, String endDaysFromStartString) {
        if(startDateAsEpochString == null) {
            dayBeginningEpoch = DEFAULT_START_DATE;
        }else{
            try {
                dayBeginningEpoch = Instant.ofEpochMilli(Long.parseLong(startDateAsEpochString));
            } catch (NumberFormatException e) {
                System.out.println("invalid date. using default start date");
                dayBeginningEpoch = DEFAULT_START_DATE;
            }
        }

        try {
            numberOfDaysRange = Integer.parseInt(endDaysFromStartString);
        } catch (NumberFormatException e) {
            numberOfDaysRange = Integer.parseInt(DEFAULT_DAYS);
        }
    }

    public void generateData() throws IOException, InterruptedException {
        do{
            for(int i = 0; i< numberOfEvents; i++){
                SensorEvent event = new SensorEvent();

                event.setEventId(UUID.randomUUID().toString());
                //long randomEventTimestampWithinRange = dayBeginningEpoch.toEpochMilli() + ThreadLocalRandom.current().nextLong(0, daysInMillis);
                //event.setEventTimestamp(randomEventTimestampWithinRange);
                // for windowing operations - we can just set the current timestamp as the event time - to see results faster
                event.setEventTimestamp(System.currentTimeMillis());

                int sensorIdRandomIndex = ThreadLocalRandom.current().nextInt(0, sensorIdList.size());
                event.setSensorId(sensorIdArray[sensorIdRandomIndex]);

                int sensorTypeRandomIndex = ThreadLocalRandom.current().nextInt(0, sensorTypeList.size());
                event.setSensorType(sensorTypeArray[sensorTypeRandomIndex]);

                int windDirectionRandomIndex = ThreadLocalRandom.current().nextInt(0, windDirectionList.size());
                event.setWindDirection(windDirectionArray[windDirectionRandomIndex]);

                int zipCodeRandomIndex = ThreadLocalRandom.current().nextInt(0, zipCodeList.size());
                String zipCode = zipCodeArray[zipCodeRandomIndex];
                zipCode = StringUtils.stripStart(zipCode, "\"");
                zipCode = StringUtils.stripEnd(zipCode, "\"");
                event.setZipCode(zipCode);

                Double humidity = ThreadLocalRandom.current().nextDouble(50.0, 90.0);
                event.setHumidityPercentage(humidity.floatValue());

                event.setWindSpeedInMPH(ThreadLocalRandom.current().nextInt(0,85));
                event.setTemperatureInCelcius(ThreadLocalRandom.current().nextInt(-20,50));

                kafkaProducer.sendMessage(kafkaTopic, SensorEventParser.getSensorEventAsJsonString(event));
            }
            if(streamingFlag.equalsIgnoreCase("y")){
                System.out.println("******************Waiting for  "+ streamingIntervalSec +" seconds before it can produce again ******************" );
                TimeUnit.SECONDS.sleep(streamingIntervalSec);
                System.out.println("******************Generating events ******************" );
            }

        }while (streamingFlag.equalsIgnoreCase("y"));

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        KafkaDataGenerator dataGenerator = new KafkaDataGenerator();
        dataGenerator.generateData();
    }

}
