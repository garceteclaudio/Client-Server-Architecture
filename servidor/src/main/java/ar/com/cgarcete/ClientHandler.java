package ar.com.cgarcete;

import java.io.DataInputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread  {

	private DataInputStream dis = null;
	private Socket socket = null; 
	private DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
	private DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

	public ClientHandler(Socket s, DataInputStream dis){ 
		this.socket = s; 
		this.dis = dis; 
	} 

	@Override
	public void run()  
	{

		boolean entrarWhile = true;
		String clientMsj;
		int contador = 0;

		while (entrarWhile)  
		{
			try{
				contador=contador+1;
				
				clientMsj = dis.readUTF();
				
				if(clientMsj.equals("q")) {
					socket.close();
					entrarWhile = false;
				}else {
					System.out.println("\n"+fordate.format(new Date())+" "+fortime.format(new Date())
						+" Thread: "+this.getId()+" Address: "+socket.getInetAddress()+ ": "+ clientMsj+"\n");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				entrarWhile = false;
			}
		} //FIN WHILE

	}

}
