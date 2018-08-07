package in.co.kani.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

public class KaniKafkaWorker 
{
	private static final Logger logger = Logger.getLogger(KaniKafkaWorker.class);

	public static void startConsumer(String groupId, String topic)
	{
		KafkaConsumer<byte[], String> kafkaConsumer = KafkaConnectionUtils.getKafkaConsumer();
		int numConsumers = kafkaConsumer.partitionsFor(topic).size();
		logger.info("No. of Kafka Consumers to be Created w.r.to Partitions : "+numConsumers);
		final ExecutorService executorService = Executors.newFixedThreadPool(numConsumers);
		final List<WioConsumer> kafKaConsumers = new ArrayList<>();
		for (int i = 0; i < numConsumers; i++) 
		{
			KafkaConsumer<byte[], String> newkafkaConsumer = KafkaConnectionUtils.getKafkaConsumer();
			WioConsumer consumerObject = ConsumerFactory.getConsumer(groupId, topic, newkafkaConsumer);
			kafKaConsumers.add(consumerObject);
			executorService.submit(consumerObject);
			// TODO To see all the All the scenarios.
//			newkafkaConsumer.commitAsync();
		}

		Runtime.getRuntime().addShutdownHook(new Thread() 
		{
			@Override
			public void run() 
			{
				for (WioConsumer consumerloop : kafKaConsumers) 
				{
					consumerloop.shutdown();
				} 
				executorService.shutdown();
				try 
				{
					executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
				}
				catch (InterruptedException e) 
				{
					logger.error("Exception while Executing the Consumers in the Kafka,"+e.getMessage() +e);
					e.printStackTrace();
				}
			}
		});
	}

}
