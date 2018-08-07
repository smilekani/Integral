package in.co.kani.kafka;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;

public class ConsumerFactory 
{
	private static final Logger logger = Logger.getLogger(ConsumerFactory.class);
	private static Map<String, String> consumerMap = new HashMap<>();

	static
	{
		if(consumerMap != null && consumerMap.size() <= 0)
			buildConsumerMap();
	}

	private static void buildConsumerMap() 
	{
		consumerMap.put("KANIPROTO", KaniTestConsumer.class.getName());
	}

	public static WioConsumer getConsumer(String groupId, String topic, KafkaConsumer<byte[], String> newkafkaConsumer)
	{
		System.out.println("groupId : "+groupId+"topic : "+topic);
		WioConsumer wioConsumer = null;
		try 
		{
			Class<?> consumerClass = Class.forName(consumerMap.get(topic));
			Constructor<?> consumerConstructor = consumerClass.getConstructor(String.class, String.class, KafkaConsumer.class);
			Object object = consumerConstructor.newInstance(new Object[] { groupId, topic, newkafkaConsumer});
			wioConsumer = (WioConsumer)object;

		} 
		catch (ClassNotFoundException | NoSuchMethodException | SecurityException |
				InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) 
		{
			logger.error("Exception while getting the Consumer,"+e.getMessage()+e);
			e.printStackTrace();
		}
		return wioConsumer;
	}

}
