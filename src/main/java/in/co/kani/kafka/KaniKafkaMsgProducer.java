package in.co.kani.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;

public class KaniKafkaMsgProducer 
{
	public static void startProducer(String topic)
	{
		KafkaProducer<byte[], String> kafkaProducer = KafkaConnectionUtils.getKafkaProducer();
		KaniKafkaProducer kaniKafkaProducer = new KaniKafkaProducer(topic, kafkaProducer);

		kaniKafkaProducer.publishMsg();
	}
}
