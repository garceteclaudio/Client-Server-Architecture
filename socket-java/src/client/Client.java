package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
	private static final int PORT = 9876;

	private Socket socket = null;
			//InputStream is used for reading,
	private InputStream inputStream = null;
			// OutputStream for writing. 
	private OutputStream outputStream = null;

	
	public Client(String server) throws Exception {
		SocketAddress sockaddr = new InetSocketAddress(server, PORT);
		socket = new Socket();

		socket.setSoTimeout(10000);
		socket.connect(sockaddr);
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}

	public void sendMessageToServer(String message) throws Exception {
		DataOutputStream flujo = new DataOutputStream(this.socket.getOutputStream());
		flujo.writeUTF(message);
	}
	
	public String sendMessageToClient( ) throws Exception {
		DataInputStream flujo = new DataInputStream(this.socket.getInputStream());
		return flujo.readUTF();
	}
	
	
	
	public void closeConnection() throws Exception {
		socket.close();
	}
	

}
