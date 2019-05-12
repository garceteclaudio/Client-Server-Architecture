package ar.com.cgarcete.frame;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ServerForm extends JFrame{

	private JTextArea txtmensajes;

	
	public ServerForm() {
		txtmensajes = new JTextArea();
		txtmensajes.setBounds(10, 10, 400, 400);
		add(txtmensajes);
		setLayout(null);
		setSize(500,500);
		setVisible(true);

		
	}
	
	public void formView() {

	}
	
	public static void main(String[] args) {
		ServerForm miJFrame = new ServerForm();
		miJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
