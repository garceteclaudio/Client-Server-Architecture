package ar.com.server;

import java.io.IOException;

public class TestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    try {
			new Server(12345).run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
