package SomethingNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * A simple Swing-based client for the chat server. Graphically it is a frame
 * with a text field for entering messages and a textarea to see the whole
 * dialog.
 *
 * The client follows the following Chat Protocol. When the server sends
 * "SUBMITNAME" the client replies with the desired screen name. The server will
 * keep sending "SUBMITNAME" requests as long as the client submits screen names
 * that are already in use. When the server sends a line beginning with
 * "NAMEACCEPTED" the client is now allowed to start sending the server
 * arbitrary strings to be broadcast to all chatters connected to the server.
 * When the server sends a line beginning with "MESSAGE" then all characters
 * following this string should be displayed in its message area.
 */
public class ClientSide extends User  {
private static String username="";
private static String password="";
private static boolean loggedin;
private static boolean signedUp; 
private static String sAnswer="";
    String serverAddress;
    static Scanner in;
    static PrintWriter out;


    /**
     * Constructs the client by laying out the GUI and registering a listener with
     * the textfield so that pressing Return in the listener sends the textfield
     * contents to the server. Note however that the textfield is initially NOT
     * editable, and only becomes editable AFTER the client receives the
     * NAMEACCEPTED message from the server.
     * @throws IOException 
     * @throws UnknownHostException 
     */
    public ClientSide(String serverAddress) throws UnknownHostException, IOException {
        this.serverAddress = serverAddress;
        var socket = new Socket("localhost", 59001);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        
        
        
      
    }
 
   /* private String getName() {
        return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }
*/
    

    private void run() throws IOException {
  
          

           
            final JFrame frame= new JFrame("Login Window");
            final JButton Login=new JButton("Login");
            final JButton Signup= new JButton("SignUp");
            
            
            Login.addActionListener(
            		 new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							 LoginOnly log = new LoginOnly(frame);
		                        
		                        log.setVisible(true);
		                        log.setSuccess(signedUp);
		                        // if login successfully
		                        if(log.issucceess()){
		                           System.out.println("your loged IN yee");
		                        }
						}
            			
            		});
            
            Signup.addActionListener(
           		 new ActionListener() 
            		{
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							 SignUp signup = new SignUp(frame);
		                        
							 signup.setVisible(true);
		                      
		                        if(signup.isSucceeded()){
		                           System.out.println("you have successfully signed up");
		                        }
						}
            			
            		});
            
            
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,100);
            frame.setLayout(new FlowLayout());
            frame.getContentPane().add(Login);
            frame.getContentPane().add(Signup);
            frame.setVisible(true);
            String name;
            String pass;
            
            	
            
            var line = in.nextLine();
            System.out.println(username+password);
             out.println("login"+username+" "+password );
            if(line.startsWith("NAMEACCEPTED")) {
         	   loggedin=true;
         	   
            }
            else
            {
         	   loggedin=false;
            }
            out.println("login: "+username+" "+password );
               
    
    }
public boolean login(String login,String password) {
	
	
	System.out.println("In Client: "+login+" "+password);
	
	return false;
}
    public static void main(String[] args) throws Exception {
     
        var client = new ClientSide("localhost");
        client.run();
        
        
        
        
    }
    

	public static  boolean Differ(String username2, String password2) {
		// TODO Auto-generated method stub
		
		username=username2;
		password=password2;
		System.out.println("In Client: "+username2+" "+password2);
		   out.println("login"+username+" "+password );
		   var line = in.nextLine();
           if(line.startsWith("NAMEACCEPTED")) {
        	   loggedin=true;
        	   
        	   JFrame frame2 = new JFrame("Chatter");
        	    JTextField textField2 = new JTextField(50);
        	    JTextArea messageArea2 = new JTextArea(16, 50);
        	   
        	    textField2.setEditable(true);
                messageArea2.setEditable(true);
                frame2.getContentPane().add(textField2, BorderLayout.SOUTH);
                frame2.getContentPane().add(new JScrollPane(messageArea2), BorderLayout.CENTER);
                frame2.pack();
                
                textField2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        out.println(textField2.getText());
                        textField2.setText("");
                    }
                });
                
                
            } else
           {
        	   loggedin=false;
           }
           out.println("login: "+username+" "+password );
		
		return loggedin;
	}
    
	public static boolean DifferSignup(String username3, String password3, String answer) 
	{
		// TODO Auto-generated method stub
		username=username3;
		password=password3;
		sAnswer = answer; 
		
		System.out.println("In Client: " + username3 + " " + password3 + " " + answer);
		   out.println("newA "+username+" "+password+" "+sAnswer+"\n");
		   var line = in.nextLine();
        if(line.startsWith("NAMEACCEPTED")) {
        	signedUp = true;
     	   System.out.println("Run The Message Window");
        }
       
       // out.println("login: "+username+" "+password );
		
		return signedUp ;
		
	}
	
	private static boolean check(boolean checking) {
		
		return checking;	
		
	}
    
    
}
