package SomethingNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
private static  String username="";
private static  String password="";
private static  String answer="";
private static  boolean loggedin;
private static  boolean messageclass;
private String sAnswer="";
    String serverAddress;
    static Scanner in;
     static PrintWriter out;
    JFrame frameM = new JFrame("Chatter");
    JTextField textField = new JTextField(50);
    static JTextArea messageArea = new JTextArea(20, 50);

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
        final JFrame frame= new JFrame("Login Window");
        final JButton Login=new JButton("Login");
        final JButton Signup= new JButton("SignUp");
        
        
        
        Login.addActionListener(
        		 new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						 LoginOnly log = new LoginOnly(frame);
	                        
	                        log.setVisible(true);
	                   
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
      
       
        
        
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           
            	
            	
                out.println("msg "+textField.getText());
                textField.setText("");
            }
        });
        
        
        
        
        
    }
    
    
 
    private String getName() {
        return JOptionPane.showInputDialog(frameM, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

    

    private void run() throws IOException {
    	
    	
    	
    	
    	
    	
    	
    	}
       
            
            	
 
          
     
           
              /* var line = in.nextLine();
               
               User newLog= new User();
               newLog.Loginbox();
               login(username,password);
               out.println(username+" "+password);
               
               if (line.startsWith("SUBMITNAME")) {
                  
               } else if (line.startsWith("NAMEACCEPTED")) {
                  // this.frame.setTitle("Chatter - " + line.substring(13));
                  // System.out.println("Start Chat box");
                //   textField.setEditable(true);
               } else if (line.startsWith("MESSAGE")) {
                   messageArea.append(line.substring(8) + "\n");
               }
           */
			//System.out.print(newLog.toString());
			
           
            
 
            
       
    
//main
  
    

	public   boolean Differ(String username2, String password2) {
		//login already have account
		
		username=username2;
		password=password2;
		System.out.println("In Client: "+username+" "+password);
		   out.println("login "+username+" "+password+"/n" );
		   var line = in.nextLine();
  if(line.startsWith("NAMEACCEPTED"))
     {
  	
  	   loggedin=true;
  	 if(loggedin==true) {
 		this.frameM.setTitle("ChatBox"+username);
			textField.setEditable(true);

  	 }
     }else if(line.startsWith("MESSAGE")) {
    	 
    	 while(true) {
  			
  			var line2 = in.nextLine();
  			if(line2.startsWith("MESSAGE")) {
  				 messageArea.append(line2.substring(8) + "\n");
  			}
    	 }
    	 
     }else if(line.startsWith("WRONGPASSWORD"))
  {
  	System.out.println("Wrong password please try again");
  	 loggedin=false;
	   messageclass=false;
  
}		
		return loggedin;
	}
    
	public static  boolean DifferSignup(String username3, String password3,String answer3) {
		//new account
		username=username3;
		password=password3;
		answer=answer3;
		System.out.println("In Client: "+username3+" "+answer3);
		
		   out.println("newA "+username+" "+password+" "+answer+"/n");
		   var line = in.nextLine();
		   
        if(line.startsWith("NAMEACCEPTED"))
           {
        	
        	System.out.println("New Account made Logged In"+username);
        	   loggedin=true;
        	 
        	
        	  
        	  
           }
        else if(line.startsWith("MESSAGE")) {
       	 
       	 while(true) {
     			
     			var line2 = in.nextLine();
     			if(line2.startsWith("MESSAGE")) {
     				 messageArea.append(line2.substring(8) + "\n");
     			}
       	 }
        }
        else
        {
        	System.out.println("Account already in system please login useing login window");
        	 loggedin=false;
      	   messageclass=false;
        }
           
         System.out.println("Line check: "+line);
		
		return loggedin;
		
	}



	  public static void main(String[] args) throws Exception {
		     
	        var client = new ClientSide("localhost");
	        
	        
	        client.frameM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        client.frameM.setVisible(true);
	       
	       // client.run();
	        
	        
	        
	    }
	
	
    
    
}