package crh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

import java.net.Socket;

public class ClientRequestHandler {

	private String host;
	private int port;
	private DatagramSocket clientSocket;
	private byte[] msgReceived;
	private int receivedMessageSize;

	public ClientRequestHandler(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void send(byte[] msg) throws IOException, InterruptedException, TimeoutException {
		sendTcp(msg);
		
	}

	public byte[] receive() throws Exception {
		return this.msgReceived;
		
	}

	public void sendTcp(byte[] msg) throws IOException, InterruptedException {
		Socket socket = new Socket(this.host, this.port);
		DataOutputStream outToServer = new DataOutputStream(socket.getOutputStream());
		DataInputStream inFromServer = new DataInputStream(socket.getInputStream());
		outToServer.writeInt(msg.length);
		outToServer.write(msg);
		this.receivedMessageSize = inFromServer.readInt();
		msgReceived = new byte[this.receivedMessageSize];
		
		inFromServer.read(this.msgReceived);
		socket.close();
	}

}
