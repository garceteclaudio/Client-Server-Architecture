package ar.com.cgarcete;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread  {

	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	private Socket socket = null; 
	private DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd"); 
	private DateFormat fortime = new SimpleDateFormat("hh:mm:ss");

	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos){ 
		this.socket = s; 
		this.dis = dis;
		this.dos = dos;
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
				
				//Recibo del cliente
				clientMsj = dis.readUTF();
				//muestro en consola info importante
				System.out.println("\n"+fordate.format(new Date())+" "+fortime.format(new Date())
				+" Thread: "+this.getId()+" Address: "+socket.getInetAddress()+" Client message: "+clientMsj);
				
				if(clientMsj.equals("q")) {
					socket.close();
					entrarWhile = false;
				}else {
//					System.out.println("\n"+fordate.format(new Date())+" "+fortime.format(new Date())
//						+" Thread: "+this.getId()+" Address: "+socket.getInetAddress()+ ": "+ clientMsj+"\n");
					
					//El servidor escribe al cliente!!! Envio al cliente
					dos.writeUTF("\n"+fordate.format(new Date())+" "+fortime.format(new Date())
					+" Thread: "+this.getId()+" Address: "+socket.getInetAddress()+ ": "+ clientMsj+"\n");
					
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				entrarWhile = false;
			}
		} //FIN WHILE

	}

}
