package in.co.kani.protobuf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class GoogleProtoBufDemo {
	public static void main(String[] args) {
		AddressBookProto.Person.Builder personBuilder = AddressBookProto.Person.newBuilder();

			FileOutputStream output = null;
			try {
				output = new FileOutputStream("/home/kanimozhi/eclipse-workspace/googleprotobuf/src/test/resources/kani.data");
				try {
					personBuilder.buildPartial().writeTo(output);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			personBuilder.w
			
//			output.write(b);
			finally {
				try {
					output.close();
					System.out.println("Google Proto Buf Msg publishing done !!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


	}
}