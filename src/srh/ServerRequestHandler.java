package srh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeoutException;

public class ServerRequestHandler {
	private int port;

	//tcp
	private DataInputStream inFromClient;
	private DataOutputStream outToClient;
	private Socket socket;
	private ServerSocket serverSocketTcp;
	
	public ServerRequestHandler(int port) throws IOException, TimeoutException {
		super();
		this.port = port;
		
		serverSocketTcp = new ServerSocket(port);
		
		
		
			
	}

	public void send(byte[] msg) throws IOException, InterruptedException, TimeoutException {
		
		sendTcp(msg);
	}

	public byte[] receive() throws IOException, InterruptedException, TimeoutException {
		
		return receiveTcp();
	}

	private byte[] receiveTcp() throws IOException {
		socket = serverSocketTcp.accept();
		inFromClient = new DataInputStream(socket.getInputStream());
		
		int receivedMessageSize = inFromClient.readInt();
		
		byte[] msg = new byte[receivedMessageSize];
		inFromClient.read(msg, 0, receivedMessageSize);
		
		return msg;
	}

	public void sendTcp(byte[] msg) throws IOException, InterruptedException {
		outToClient = new DataOutputStream(socket.getOutputStream());
		
		outToClient.writeInt(msg.length);
		outToClient.write(msg, 0, msg.length);
	}
}