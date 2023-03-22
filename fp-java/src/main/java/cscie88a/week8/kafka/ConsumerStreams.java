package cscie88a.week8.kafka;

import cscie88a.week8.serialize.SensorEventDeSerializer;
import cscie88a.week8.serialize.SensorEventSerializer;
import cscie88a.week8.model.SensorEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class ConsumerStreams {
    String kafkaUrl ;
    String kafkaTopic ;
    String consumerName;
    KafkaStreams processingStream;
    public static Serde<SensorEvent> SENSOR_EVENT_SERDE = Serdes.serdeFrom(new SensorEventSerializer(), new SensorEventDeSerializer());


    public static void main(String[] args) {
        ConsumerStreams consumerStreams = new ConsumerStreams();
        consumerStreams.start();

    }

    public ConsumerStreams() {
        kafkaTopic = System.getProperty("kafka_topic", "input_topic");
        kafkaUrl = System.getProperty("kafka_url", "localhost:9092");
        consumerName = System.getProperty("kafka_consumer_id", "hw9-consumer");
        String sensor_type_count_topic = System.getProperty("sensor_type_count_topic", "sensor_type_count_topic");
//        String sensor_type_hourly_count_topic = System.getProperty("sensor_type_hourly_count_topic", "sensor_type_hourly_count_topic");
        Properties config = new Properties();
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, consumerName);
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaUrl);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        config.put(StreamsConfig.TOPOLOGY_OPTIMIZATION, "all");
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, SensorEvent> stream = builder.stream(kafkaTopic, Consumed.with(Serdes.String(), SENSOR_EVENT_SERDE));

        KTable<String, Long> countBySensorType = stream.groupBy((key, value) -> value.getSensorType())
                .count();

        countBySensorType.toStream()
                .mapValues((key,values) -> key +" : "+  values.toString())
                .to(sensor_type_count_topic, Produced.with(Serdes.String(), Serdes.String()));


        final Topology topology = builder.build();
        System.out.println(topology.describe());

        processingStream = new KafkaStreams(topology, config);
        Runtime.getRuntime().addShutdownHook(new Thread(processingStream::close));
    }

    public void start(){
        processingStream.start();
    }
}
