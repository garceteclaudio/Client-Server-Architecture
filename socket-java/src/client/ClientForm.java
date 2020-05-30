package client;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
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
	private JTextArea textArea;
	
	public ClientForm() {
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(0, 0, 400, 200);
		add(textArea);
		
		JScrollPane scroll = new JScrollPane(textArea);
	    scroll.setBounds(0, 0, 400, 200);
	    add(scroll);
	    
		
		label = new JLabel();
		label.setText("Message:");
		label.setBounds(140, 180, 70, 60);
		add(label);
		
		textfield = new JTextField();
		textfield.setBounds(100, 230, 150, 50);
		add(textfield);

		sendButton = new JButton();
		sendButton.setText("Send to server");
		sendButton.setBounds(110, 290, 130, 30);
		add(sendButton);
		

		
		
		setLayout(null);
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo ( null );
		setResizable(false);
		
				//action listener
		sendButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		//label1.setText("Name has been submitted.");
//		dispose();
//		UserJFrame userJFrame = new UserJFrame();
//		userJFrame.setVisible(true);  
			

			
			Client myClientConnection = null;

			try {
				myClientConnection = new Client("127.0.0.1");
				myClientConnection.sendMessageToServer(textfield.getText());
				String mensaje = myClientConnection.sendMessageToClient();
				textArea.append(mensaje+"\n");
				
				
//				textArea.append(textfield.getText()+"\n");
				
				
				
				
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
