package ar.com.cgarcete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ServerConnection{
	
	private static final int PORT = 50000;
	private static final int NUM_BYTES = 2;

	
	
	private Socket socket = null;
			//InputStream is used for reading,
	private InputStream inputStream = null;
			// OutputStream for writing. 
	private OutputStream outputStream = null;
	
	/**
	 * Constructor for the ServerConnection. Creates a new socket and connects
	 * to a server.
	 * 
	 * @throws UnknownHostException
	 *             If the server is not found.
	 * @throws IOException
	 *             If an error occurs while creating a socket or getting the
	 *             input and output stream of the socket.
	 */
	public ServerConnection(String server) throws Exception {
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
	
	
	

	
	
	/**
	 * Sends a message to the server.
	 * 
	 * @param messages
	 *            The messages to be sent.
	 * @throws IOException
	 *             If an error occurs while writing on the output stream.
	 */
	public void sendPacket(byte[] messages) throws Exception {
		outputStream.write(messages);
	}

	/**
	 * Receives a messages from the server.
	 * 
	 * @return The messages that were received.
	 * @throws IOException
	 *             If an error occurs while reading on the input stream.
	 */
	public byte[] receivePacket() throws Exception {
		byte[] receivedMessages = null;
		receivedMessages = new byte[NUM_BYTES];
		int receivedBytes = 0;
		try {
			while (receivedBytes < NUM_BYTES)
				receivedBytes = inputStream.read(receivedMessages);
		} catch (Exception ste) {
			if (socket != null)
				socket.close();
			throw ste;
		}
		return receivedMessages;
	}

	/**
	 * Closes the socket.
	 * 
	 * @throws IOException
	 *             If an error occurs.
	 */
	public void closeConnection() throws Exception {
		socket.close();
	}

	
}
