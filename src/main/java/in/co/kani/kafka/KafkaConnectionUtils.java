package in.co.kani.kafka;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class KafkaConnectionUtils 
{
//	private static String KAFKA_SERVER_URL = System.getenv("KAFKA_SERVER_URL");
	private static String KAFKA_SERVER_URL = "localhost";
	private static String KAFKA_SERVER_PORT = System.getenv("KAFKA_SERVER_PORT");
	private static String GROUP_ID = System.getenv("GROUP_ID");
	private static Properties props = new Properties();
	private static Properties producerProps = new Properties();

	static
	{
		populateConsumerProperties();	
		populateProducerProperties();
	}

	private static void populateConsumerProperties()
	{
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArrayDeserializer");
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
//		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		props.put("fetch.message.max.bytes", 1000000);
//		props.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 1000000000);
	}
	
	private static void populateProducerProperties()
	{
		producerProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER_URL + ":" + KAFKA_SERVER_PORT);
		producerProps.put("acks", "all");
		producerProps.put("retries", 0);
		producerProps.put("batch.size", 16384);
		producerProps.put("linger.ms", 1);
		producerProps.put("buffer.memory", 335544);
		producerProps.put("message.max.bytes", 1024 * 1024 * 2);
//		producerProps.put("log.segment.bytes", 1000000);
//		producerProps.put("replica.fetch.max.bytes", 1000000);
		producerProps.put("key.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
		producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	}

	public static KafkaConsumer<byte[], String> getKafkaConsumer()
	{
		KafkaConsumer<byte[], String> consumer = new KafkaConsumer<>(props);
		return consumer;
	}
	
	public static KafkaProducer<byte[], String> getKafkaProducer()
	{
		KafkaProducer<byte[], String> producer = new KafkaProducer<>(producerProps);
		return producer;
	}
	
}
