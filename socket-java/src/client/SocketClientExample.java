package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * This class implements java socket client
 * @author pankaj
 *
 */
public class SocketClientExample {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
    	// 192.168.1.6
    	
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        DataInputStream ois = null;
        DataOutputStream oos = null;
        
        boolean estadoWhile = true;
    	Scanner keyboard = null;
    	
        while(estadoWhile==true) {
            //establish socket connection to server
        	keyboard = new Scanner(System.in);
        	socket = new Socket(host, 9876);
            System.out.println("Escribe algo para enviar al servidor: ");
            //input
            String sentence = keyboard.nextLine();
            
            if(sentence.contentEquals("exit")) {
            	estadoWhile=false;
            }
            
            //write to socket using ObjectOutputStream
            oos = new DataOutputStream(socket.getOutputStream());
            oos.writeUTF(sentence);
            
            //read the server response message and syso on console
            ois = new DataInputStream(socket.getInputStream());
            String message = ois.readUTF();
            System.out.println("Respuesta del servidor: " + message);
            

        	
        }
        
        System.out.println("Fin cliente");
        //close resources
        ois.close();
        oos.close();
        
        
        
    }
}