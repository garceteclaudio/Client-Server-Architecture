package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class implements java Socket server
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
        
        
        DataInputStream ois = null;
        DataOutputStream oos = null;
        //ObjectOutputStream
        Socket socket= null;
        
        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request:");
            //creating socket and waiting for client connection
            socket = server.accept();
            
            //read from socket to ObjectInputStream object
            //De Cliente a servidor
            ois = new DataInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = ois.readUTF();
            System.out.println("Message Received from the client: " + message);
                   
            
            //create ObjectOutputStream object
            //De servidor a cliente
            oos = new DataOutputStream(socket.getOutputStream());
            oos.writeUTF("Sv msg: "+ message);
           
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
        server.close();
    }
    
}
