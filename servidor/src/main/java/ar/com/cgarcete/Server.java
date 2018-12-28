package ar.com.cgarcete;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server { 
	private final int PORT = 50000;

	/**
	 * Starts the server, which listens on port 50,000.
	 * @throws Exception 
	 */
	@SuppressWarnings({ "resource" })
	// Can't close ServerSocket because of infinite loop.
	public void start() throws Exception {

		
		System.out.println("MULTI THREADED SERVER.");
		System.out.println("Creating server socket.");
		ServerSocket servSocket = new ServerSocket(PORT);
		System.out.println("IP address: "+ InetAddress.getLocalHost().getHostAddress());
		System.out.println("Listening on port number "+ servSocket.getLocalPort());
		boolean entrarServerWhile = true;

		while (entrarServerWhile) {
			//System.out.println("Waiting for client...");
			Socket clientSocket = servSocket.accept();
			//System.out.println("Client socket accepted, creating session...");

			DataInputStream flujo = new DataInputStream(clientSocket.getInputStream());
			//megToServer = flujo.readUTF();

			Thread thread = new ClientHandler(clientSocket, flujo);
			thread.start();
		}//fin while

	}

}//FIN Server class
