package distribution;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;

import crh.ClientRequestHandler;

public class Requestor implements Serializable {

	public Object invoke(String host, int port, int objectID, String operation, Object parameters) throws Exception {
		ClientRequestHandler client = new ClientRequestHandler(host, port);
		Message message = new Message(objectID, operation, parameters);		
		
		client.send(Marshaller.marshall(message));
		
		return Marshaller.unmarshall(client.receive());		
	}
	
}