package crh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.util.concurrent.TimeoutException;

import java.net.Socket;

public class ClientRequestHandler {

	private String host;
	private int port;
	
	//tcp
	private Socket socket;
	private DataInputStream inFromServer;
	private DataOutputStream outToServer;


	public ClientRequestHandler(String host, int port) throws IOException, TimeoutException {
		this.host = host;
		this.port = port;

		this.socket = new Socket(host, port);
		this.inFromServer = new DataInputStream(socket.getInputStream());
		this.outToServer = new DataOutputStream(socket.getOutputStream());
	}

	public void send(byte[] msg) throws IOException, InterruptedException, TimeoutException {
		sendTcp(msg);
		
	}

	public byte[] receive() throws Exception {
		return receiveTcp();
		
	}

	public void sendTcp(byte[] msg) throws IOException, InterruptedException {
		outToServer.writeInt(msg.length);
		outToServer.write(msg, 0 , msg.length);
	}

	public byte[] receiveTcp() throws IOException {
        int receivedMessageSize = inFromServer.readInt();
        byte[] msgReceived = new byte[receivedMessageSize];
        inFromServer.read(msgReceived, 0, receivedMessageSize);
        return msgReceived;
    }
}