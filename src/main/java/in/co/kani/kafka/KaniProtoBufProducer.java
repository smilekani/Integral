package in.co.kani.kafka;

import java.util.ArrayList;
import java.util.List;

import in.co.kani.protobuf.generated.KaniTest.PROTOKANI;

public class KaniProtoBufProducer {

	public KaniProtoData constructProtoBufMsg() 
	{
		KaniProtoData kaniProtoData = new KaniProtoData();
		kaniProtoData.msgConstructor();

		KaniProtoMO kaniProtoMO = new KaniProtoMO();
		kaniProtoMO.setEnabled("false");
		List<String> wpaList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			wpaList.add(""+i);
		}
		kaniProtoMO.setWpa(wpaList);
		List<String> authenticationList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			authenticationList.add("authentication"+i);
		}
		kaniProtoMO.setAuthentication(authenticationList);
		List<String> ciphers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ciphers.add("ciphers"+i);
		}
		kaniProtoMO.setCiphers(ciphers);
		kaniProtoMO.setPhy("phy");
		kaniProtoMO.setSsid("ssid");
		kaniProtoMO.setBssid("bssid");
		kaniProtoMO.setCountry("country");
		kaniProtoMO.setMode("mode");
		kaniProtoMO.setChannel("channel");
		kaniProtoMO.setFrequency("frequency");
		kaniProtoMO.setFrequencyOffset("frequencyOffset");
		kaniProtoMO.setTxpower("txpower");
		kaniProtoMO.setTxpowerOffset("txpowerOffset");
		kaniProtoMO.setQuality("quality");
		kaniProtoMO.setQualityMax("qualityMax");
		kaniProtoMO.setNoise("noise");
		kaniProtoMO.setSignal("signal");
		kaniProtoMO.setBitrate("bitrate");
		
		kaniProtoData.setConfigUpdateDetail(kaniProtoMO);

		kaniProtoData.serialize();
		kaniProtoData.deserialize();
//		System.out.println("After kaniProto serialize == "+kaniProtoData);;
		byte[] byteArray = kaniProtoData.getByteStringKaniTest().toByteArray();
		System.out.println("byteArray length : "+byteArray.length);
//		PROTOKANI output = kaniProtoData.deserialize(byteArray);
//		System.out.println("After deserialized output ==> "+output);
		return kaniProtoData;
	}

}
