package in.co.kani.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class KaniKafkaProducer {
	private String topic;
	private KafkaProducer<byte[], String> producer;
	public KaniKafkaProducer(String topic, KafkaProducer<byte[], String> producer)
	{
		this.topic = topic;
		this.producer = producer;
	}

	public void publishMsg()
	{		
		int i = 0;
		while (i < 50)
		{
			try {

				sendMsg(topic, producer);
				//				TimeUnit.SECONDS.sleep(1000);
			}
			catch ( Exception e   ){
				System.out.println("I was interrupted."+e);
				e.printStackTrace();
			}
			i++;
		}
	}

	protected void sendMsg(String topic, KafkaProducer<byte[], String> producer) {
		
		KaniProtoBufProducer jmsMessageProducer = new KaniProtoBufProducer();
		KaniProtoData proto = jmsMessageProducer.constructProtoBufMsg();

		final byte[] message = proto.getByteStringKaniTest().toByteArray();
		System.out.println("message : "+new String(message));

		producer.send(new ProducerRecord<byte[], String>(topic, new String(message)),	
				new Callback() 
		{
			public void onCompletion(RecordMetadata recordMetadata, Exception e) 
			{
				if ( e == null )
				{
					System.out.println("Partition: "+recordMetadata.partition()
					+", Offset" + recordMetadata.offset()
					+ ", timestamp: " + recordMetadata.timestamp());
					System.out.println(message);
				}
				else 
				{
					e.printStackTrace();
				}
			}
		});
	}



}
