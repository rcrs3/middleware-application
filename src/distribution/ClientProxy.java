package distribution;

import java.io.Serializable;

public abstract class ClientProxy implements Serializable {
	
	protected String host;
	protected int port;
	protected int objectID;
	
	public ClientProxy(String host, int port, int objectID) {
		this.host = host;
		this.port = port;
		this.objectID = objectID;
	}
	
	public String getHostName() {
		return this.host;
	}
	
	public int getPort() {
		return this.port;
	}
	
	public int getObjectID() {
		return this.objectID;
	}
	
}