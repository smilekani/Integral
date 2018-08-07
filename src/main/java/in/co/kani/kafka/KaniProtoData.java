package in.co.kani.kafka;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import in.co.kani.protobuf.generated.KaniTest;
import in.co.kani.protobuf.generated.KaniTest.PROTOKANI;

public class KaniProtoData {

	private KaniTest.PROTOKANI.Builder kaniTest = null;

	public void msgConstructor()
	{
		kaniTest = KaniTest.PROTOKANI.newBuilder();
	}

	public KaniTest.PROTOKANI serialize()
	{
		try
		{
		FileOutputStream output = new FileOutputStream("/home/kanimozhi/eclipse-workspace/googleprotobuf/src/main/resources/test.ser");
		kaniTest.build().writeTo(output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		return kaniTest.build();
		return null;
	}
	
	
	public KaniTest.PROTOKANI deserialize()
	{
		try
		{
		FileInputStream in = new FileInputStream("/home/kanimozhi/eclipse-workspace/googleprotobuf/src/main/resources/test.ser");
		
		PROTOKANI parseFrom = KaniTest.PROTOKANI.parseFrom(in);
		System.out.println("parseFrom  : "+parseFrom);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public KaniTest.PROTOKANI deserialize(byte[] input)
	{
		KaniTest.PROTOKANI protoKani = null;
		try {
			if(input != null && input.length > 0) {
				protoKani = KaniTest.PROTOKANI.parseFrom(input);
				System.out.println("De-serialize o/p ====>> "+new String(protoKani.toByteArray()) +  "protoKani : "+protoKani);
			}else {
				System.out.println("Accepts only byte array input");
			}
		} catch (InvalidProtocolBufferException e) {
			System.err.println("Exception in parsing..");
			e.printStackTrace();
		}

		return protoKani;

	}
	
	public void setConfigUpdateDetail(KaniProtoMO kaniProtoMO)
	{
		kaniTest.setEnabled(kaniProtoMO.isEnabled());
		List<String> wpaList = kaniProtoMO.getWpa();
		if(wpaList != null && !wpaList.isEmpty())
		{
			for (String wpa : wpaList) {
				kaniTest.addWpa(wpa);
			}
		}
		List<String> authenticationList = kaniProtoMO.getAuthentication();
		if(authenticationList != null && !authenticationList.isEmpty())
		{
			for (String authentication : authenticationList) {
				kaniTest.addAuthentication(authentication);
			}
		}
		List<String> ciphersList = kaniProtoMO.getCiphers();
		if(ciphersList != null && !ciphersList.isEmpty())
		{
			for (String ciphers : ciphersList) {
				kaniTest.addCiphers(ciphers);
			}
		}
		kaniTest.setPhy(kaniProtoMO.getPhy());
		kaniTest.setSsid(kaniProtoMO.getSsid());
		kaniTest.setBssid(kaniProtoMO.getBssid());
		kaniTest.setCountry(kaniProtoMO.getCountry());
		kaniTest.setMode(kaniProtoMO.getMode());
		kaniTest.setChannel(kaniProtoMO.getChannel());
		kaniTest.setFrequency(kaniProtoMO.getFrequency());
		kaniTest.setFrequencyOffset(kaniProtoMO.getFrequencyOffset());
		kaniTest.setTxpower(kaniProtoMO.getTxpower());
		kaniTest.setTxpowerOffset(kaniProtoMO.getTxpowerOffset());
		kaniTest.setQuality(kaniProtoMO.getQuality());
		kaniTest.setQualityMax(kaniProtoMO.getQualityMax());
		kaniTest.setNoise(kaniProtoMO.getNoise());
		kaniTest.setSignal(kaniProtoMO.getSignal());
		kaniTest.setBitrate(kaniProtoMO.getBitrate());
	}
	
	public ByteString getByteStringKaniTest()
	{
		return kaniTest.build().toByteString();
	}

}
