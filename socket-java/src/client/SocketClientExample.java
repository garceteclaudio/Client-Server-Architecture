package client;

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
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        
        boolean estadoWhile = true;
    	Scanner keyboard = null;
    	
    	
        //establish socket connection to server
    	keyboard = new Scanner(System.in);
      
        
        while(estadoWhile==true) {
        	socket = new Socket(host.getHostName(), 9876);
            System.out.println("Escribe algo para enviar al servidor: ");
            
            //input
            String sentence = keyboard.nextLine();
            
            if(sentence.contentEquals("exit")) {
            	estadoWhile=false;
            }
            
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(sentence);
            

            
            //read the server response message
            ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Server message: " + message);
            

        	
        }
        
        System.out.println("Fin cliente");
        //close resources
        ois.close();
        oos.close();
//        Thread.sleep(100);
        
//        for(int i=0; i<5;i++){
//            //establish socket connection to server
//            socket = new Socket(host.getHostName(), 9876);
//            
//            //write to socket using ObjectOutputStream
//            oos = new ObjectOutputStream(socket.getOutputStream());
//            System.out.println("Sending request to Socket Server");
//            if(i==4)oos.writeObject("exit");
//            else oos.writeObject(""+i);
//            
//            //read the server response message
//            ois = new ObjectInputStream(socket.getInputStream());
//            String message = (String) ois.readObject();
//            System.out.println("Message: " + message);
//            
//            //close resources
//            ois.close();
//            oos.close();
//            Thread.sleep(100);
//        }
        
        
        
    }
}