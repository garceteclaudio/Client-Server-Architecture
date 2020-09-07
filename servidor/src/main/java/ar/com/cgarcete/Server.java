package ar.com.cgarcete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Set;

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
			System.out.println("Waiting for client...");
			Socket clientSocket = servSocket.accept();
			
		
			System.out.println("Client socket accepted, creating session...");

			DataInputStream flujo = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream flujoServer = new DataOutputStream(clientSocket.getOutputStream());
			
		
			Thread thread = new ClientHandler(clientSocket, flujo,flujoServer);
			thread.start();
			

			
	        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
	        for ( Thread t : threadSet){
	            System.out.println("Thread :"+t+":"+" state : "+t.getState()+ " Thread ID : "+t.getId());
	        }
			
		}//fin while

	}

	public static void main(String[] args) throws Exception {

		Server myServer = new Server();
		System.out.println("Starting server...");
		myServer.start();
	}
}//FIN Server class


