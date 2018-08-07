package in.co.kani.kafka;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public abstract class WioConsumer implements Runnable 
{
	private String groupId;
	private String topic;
	private KafkaConsumer<byte[], String> consumer;
	AtomicBoolean canConsume = new AtomicBoolean(true);

	public WioConsumer(String groupId, String topic, KafkaConsumer<byte[], String> consumer)
	{
		this.groupId = groupId;
		this.topic = topic;
		this.consumer = consumer;
	}

	@Override
	public void run() 
	{
		consumer.subscribe(Arrays.asList(topic));
		while (canConsume.get()) 
		{
			ConsumerRecords<byte[], String> records = consumer.poll(Long.MAX_VALUE);
			System.out.println("records = "+records);
			for (ConsumerRecord<byte[], String> record : records) 
			{
				processJsonRecords(record);
			}
		}
	}

	public void processJsonRecords(ConsumerRecord<byte[], String> record)
	{

	}

	public void shutdown() {
		canConsume.set(false);
		consumer.wakeup();
	}


}
