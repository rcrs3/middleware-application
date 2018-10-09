package srh;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

public class ServerRequestHandler {
	private int port;
	private Socket socket;
	private ServerSocket serverSocketTcp;
	private int receivedMessageSize;
	private DatagramSocket serverSocketUdp;
	private String hostClient;
	private int portClient;
	private String msgToSent;

	public ServerRequestHandler(int port) throws RemoteException {
		super();
		this.port = port;
	}

	public void send(byte[] msg) throws IOException, InterruptedException, TimeoutException {
		sendTcp(msg);
		
	}

	public byte[] receive() throws IOException, InterruptedException, TimeoutException {
		return receiveTcp();
		
	}

	private byte[] receiveTcp() throws IOException {
		if (serverSocketTcp == null) {
			serverSocketTcp = new ServerSocket(port);
		}
		this.socket = serverSocketTcp.accept();
		DataInputStream inFromClient = new DataInputStream(socket.getInputStream());
		this.receivedMessageSize = inFromClient.readInt();

		byte[] msg = new byte[this.receivedMessageSize];
		inFromClient.read(msg);
		return msg;
	}

	public void sendTcp(byte[] msg) throws IOException, InterruptedException {
		if (socket == null) {
			throw new RuntimeException("none accepted connection");
		}

		DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
		outToClient.writeInt(msg.length);
		outToClient.write(msg);
		socket.close();
	}

}
