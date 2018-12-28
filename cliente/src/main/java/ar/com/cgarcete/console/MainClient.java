package ar.com.cgarcete.console;

import java.util.Scanner;

import ar.com.cgarcete.ServerConnection;

public class MainClient {

	private static ServerConnection myClientConnection;
	private static Scanner keyboard = null;
	private static boolean playAgain = true;

	public static void main(String[] args) throws Exception {
		keyboard = new Scanner(System.in);
		System.out.println("Enter server IP:");
		String setIp = keyboard.nextLine();
		myClientConnection = new ServerConnection(setIp);

		do {
			System.out.println("Enter message to the server: \n");
			String sentence = keyboard.nextLine();
			myClientConnection.sendMessageToServer(sentence);

			if(sentence.equals("q")) {
				myClientConnection.closeConnection();
				playAgain = false;
			}
		}while (playAgain);


	}

}//FIN CLASE
