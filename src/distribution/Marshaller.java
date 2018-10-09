package distribution;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Marshaller {

	public static byte[] marshall(Object obj) throws IOException {
		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		ObjectOutput objOutput = new ObjectOutputStream(byteArrayOutput);
		objOutput.writeObject(obj);		
		
		return byteArrayOutput.toByteArray();
	}
	
	public static Object unmarshall(byte[] obj) throws ClassNotFoundException, IOException  {
		ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(obj);
		ObjectInput objInput = new ObjectInputStream(byteArrayInput);

		return objInput.readObject();		
	}	
}