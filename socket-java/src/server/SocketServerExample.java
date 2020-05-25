package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements java Socket server
 * @author pankaj
 *
 */
public class SocketServerExample {
    
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);
        
        
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Socket socket= null;
        
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request:");
            //creating socket and waiting for client connection
            socket = server.accept();
            
            //read from socket to ObjectInputStream object
            //De Cliente a servidor
            ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received from the client: " + message);
           
            //create ObjectOutputStream object
            //De servidor a cliente
            oos = new ObjectOutputStream(socket.getOutputStream());
            //write object to Socket
            oos.writeObject("Hi Client "+message);
           
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) {
                //close resources
                break;
            }

        }
        ois.close();
        oos.close();
        socket.close();
        
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
    
}
