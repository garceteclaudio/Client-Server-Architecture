package ar.com.cgarcete.console;

import ar.com.cgarcete.Server;

public class MainServerConsole{

	public static void main(String[] args) throws Exception {

		Server myServer = new Server();
		System.out.println("Starting server...");
		myServer.start();
	}

}
