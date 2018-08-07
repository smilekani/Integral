package in.co.kani.kafka;

public class KaniKafkaConsumer {
	public static void main(String[] args) {
		KaniKafkaWorker.startConsumer("KANIPROTOGROUP", "KANIPROTO");
	}
}
