package ar.com.client;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ReceivedMessagesHandler implements Runnable {

	  private InputStream server;

	  public ReceivedMessagesHandler(InputStream server) {
	    this.server = server;
	  }

	  public void run() {
	    // receive server messages and print out to screen
	    Scanner scanner = new Scanner(server);
	    String tmp = "";
	    while (scanner.hasNextLine()) {
	      tmp = scanner.nextLine();
	      
	      if (tmp.charAt(0) == '[') {
	        tmp = tmp.substring(1, tmp.length()-1);
	        System.out.println(
	            "\nUSERS LIST: " +
	            new ArrayList<String>(Arrays.asList(tmp.split(","))) + "\n"
	            );
	      }else{
	        try {
	          System.out.println("\n" + getTagValue(tmp));
	          // System.out.println(tmp);
	        } catch(Exception ignore){}
	      }
	    }
	    scanner.close();
	  }

	  // I could use a javax.xml.parsers but the goal of Client.java is to keep everything tight and simple
	  public static String getTagValue(String xml){
	    return  xml.split(">")[2].split("<")[0] + xml.split("<span>")[1].split("</span>")[0];
	  }

	}