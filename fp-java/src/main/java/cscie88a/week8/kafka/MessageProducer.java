package cscie88a.week8.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class MessageProducer {
    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private Producer<byte[], byte[]> producer;
    private Properties props;
    private String defaultTopic;
    private String bootstrapUrl;
    private boolean skipSendingMessage = true;

    public MessageProducer(String bootstrapUrl, String topic) {
        defaultTopic = topic;
        skipSendingMessage = false;
        this.bootstrapUrl = bootstrapUrl;
        props= new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapUrl);
//        props.put(ProducerConfig.ACKS_CONFIG, 0);
        producer = new KafkaProducer<byte[], byte[]>(props,
                new ByteArraySerializer(), new ByteArraySerializer());
        logger.info("MessageProducer is created with properties: {}", props);
    }

    public MessageProducer(boolean skipSendingMessage) {
        this.skipSendingMessage = skipSendingMessage;
    }

    public void sendMessageByKey(String destinationTopic, String messageKey, String eventBody)  {
        if (!skipSendingMessage) {
            ProducerRecord<byte[], byte[]> record =
                    new ProducerRecord<>(destinationTopic, messageKey.getBytes(), eventBody.getBytes());
            producer.send(record);
            logger.debug("sent message OK: >>>\n " + record);
        } else {
            logger.info("Message sending skipped for messageKey: {}, payload: {}", eventBody, messageKey);
        }
    }

    public void sendMessage(String destinationTopic, String eventBody)  {
        String messageKey = String.valueOf(eventBody.hashCode());
        sendMessageByKey(destinationTopic, messageKey, eventBody);
    }

    public void closeProducer(){
        producer.close();
    }
}
