package ar.com.cgarcete.frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ar.com.cgarcete.ServerConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientForm extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton sendButton;
	private JLabel label ;	
	private JTextField textfield;
	private JTextArea textArea;
	private ServerConnection myClientConnection = null;
	
	public ClientForm() {
		
		this.paintGUI();
		
		try {
			myClientConnection = new ServerConnection("127.0.0.1");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		sendButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){

			try {
				myClientConnection.sendMessageToServer(textfield.getText());
				String mensaje = myClientConnection.sendMessageToClient();
				textArea.append(mensaje+"\n");
			}catch(Exception exx){
				exx.printStackTrace();
			}
			
		}          
		});//Fin addAtionListener
		
	}//Fin ClientForm
	
	private void paintGUI() {
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
	}
	
	public static void main(String[] args) {
		ClientForm miJFrame = new ClientForm();
		miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miJFrame.setLayout(null);
		miJFrame.setSize(400,400);
		miJFrame.setVisible(true);
		miJFrame.setLocationRelativeTo ( null );
		miJFrame.setResizable(false);
	}
}
