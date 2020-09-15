package ar.com.cgarcete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;



public class ClientHandler extends Thread  {
	
	private final int ID;
	private boolean isDone = false;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private Server server = null;
	private Socket socket = null; 
//	private DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
//	private DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

	public ClientHandler(Server server, Socket socket){ 
		this.server = server;
		this.socket = socket;
		this.ID = socket.getPort();
	} 

	public void run(){
		while(!isDone){
			try {
				server.handle(ID, dis.readUTF());
			} catch (IOException ioe) {
				//Expected EOF error
			} 
		}		
	}
	
	public void send(String message){
		try{
			dos.writeUTF(message);
			dos.flush();
			System.out.println(message + " sent to client: " + ID);
		}catch(IOException e){
			e.printStackTrace();
//			server.removeThread(ID);
		}
	}
	
	public void open() throws IOException{
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
	}
	
	//GETTERS
	public int getID(){
		return ID;
	}
	
	public void close() throws IOException{
		isDone = true;
		socket.close();
		dis.close();
	}

}
