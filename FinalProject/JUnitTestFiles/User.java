package TestSuiteChatClientSide;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class User implements ActionListener {
	
	
	public String username;
	public String password;
	private String sAnswer;
	public String serverAddress;
	public Scanner in;
	public PrintWriter out;
	public JFrame frame;
	public JTextField textField;
	public JPasswordField passField;
	public JTextArea messageArea;


	private static JLabel userLabel;
	protected static JTextField userText;
	protected static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JButton button2;
	private static JLabel success;
	
	
	
	
	

	
	

public void Loginbox() {
	
    JFrame frame=new JFrame();
    JPanel panel= new JPanel();
    frame.setSize(100,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.add(panel);
    panel.setLayout(null);
    
    userLabel=new JLabel("User");
    
    userLabel.setBounds(10,20,80,25);
    panel.add(userLabel);
    
    userText=new JTextField(20);
    userText.setBounds(100,20,165,25);
    panel.add(userText);
    
    
     passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(10, 50, 80, 25);
    panel.add(passwordLabel);

     passwordText = new JPasswordField();
    passwordText.setBounds(100, 50, 165, 25);
    panel.add(passwordText);

    button = new JButton("Login");
    button2= new JButton("SignUp");
    button.setBounds(10,80,80,25);
    button2.setBounds(120, 80, 80, 25);
    
    button.addActionListener(new User()); //GUI implements actionlistener
    button2.addActionListener(new User());
    panel.add(button);
    panel.add(button2);
  
     success = new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);

    frame.getBaselineResizeBehavior();
    frame.getMaximumSize();
    frame.setVisible(true);
   
 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub


	
	
	String user=userText.getText();
	 String passw=passwordText.getText();
	
	
	//System.out.println(user+ " "+passw);
	//this.username=user;
	//this.password=passw;
	
}
	
public String getUsername() {
	return userText.getText();
	
	
}
public String getPassword() {
    return new String(passwordText.getPassword());
}







}