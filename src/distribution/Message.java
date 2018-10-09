package distribution;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable{
	
	private int objectID;
	private String operation;
	private Object parameter;
	
	public Message(int objectID, String operation, Object parameter) {
		this.objectID = objectID;
		this.operation = operation;
		
		this.parameter = parameter;
	}

	public String getOperation() {
		return this.operation;
	}

	public Object getParameter() {
		return this.parameter;
	}

	public int getObjectID() {
		return this.objectID;
	}
	
}