package client;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ClientForm extends JFrame{

	private static final long serialVersionUID = 1L;
	

	private JButton sendButton;
	private JLabel label ;	
	private JTextField textfield;
	
	public ClientForm() {
		
		label = new JLabel();
		label.setText("Insert message:");
		label.setBounds(100, 50, 150, 50);
		add(label);
		
		textfield = new JTextField();
		textfield.setBounds(50, 100, 200, 50);
		add(textfield);
		
		
		sendButton = new JButton();
		sendButton.setText("Send");
		sendButton.setBounds(100, 180, 100, 50);
		add(sendButton);
		
		setLayout(null);
		setSize(400,300);
		setVisible(true);

				//action listener
		sendButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		//label1.setText("Name has been submitted.");
//		dispose();
//		UserJFrame userJFrame = new UserJFrame();
//		userJFrame.setVisible(true);  
			
			System.out.println(textfield.getText());
			
			Client myClientConnection = null;
			try {
				myClientConnection = new Client("192.168.1.6");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				myClientConnection.sendMessageToServer(textfield.getText());
//				System.out.println(myClientConnection.sendMessageToClient());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
			
		}          
		});//Fin addAtionListener
		
	}
	
	public static void main(String[] args) {
		ClientForm miJFrame = new ClientForm();
		miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
