package in.co.kani.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

import in.co.kani.protobuf.generated.KaniTest;

public class KaniTestConsumer extends WioConsumer
{
	private static final Logger logger = Logger.getLogger(KaniTestConsumer.class);
	
	public KaniTestConsumer(String groupId, String topic, KafkaConsumer<byte[], String> consumer) {
		super(groupId, topic, consumer);
	}
	
	@Override
	public void processJsonRecords(ConsumerRecord<byte[], String> record) {
		logger.info("Processing Records in KaniTest consumer .....");
		KaniProtoData kaniProtoData = new KaniProtoData();
		KaniTest.PROTOKANI kaniTestDeserializedData = (KaniTest.PROTOKANI) kaniProtoData.deserialize(record.value().getBytes());
		logger.info("kaniTestDeserializedData : "+kaniTestDeserializedData);
	}

}
