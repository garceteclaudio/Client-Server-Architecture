package ar.com.client;

import java.io.IOException;
import java.net.UnknownHostException;

public class TestClient {
	  public static void main(String[] args) throws UnknownHostException, IOException {
		    new Client("127.0.0.1", 12345).run();
		  }
}
