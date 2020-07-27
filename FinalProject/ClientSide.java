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

    
    public ClientSide(String serverAddress) throws UnknownHostException, IOException {
    	
        this.serverAddress = serverAddress;
        var socket = new Socket("localhost", 59001);
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
        final JFrame frame= new JFrame("Login Window");
        final JButton Login=new JButton("Login");
        final JButton Signup= new JButton("SignUp");
        
        var check= in.nextLine();
        
      System.out.println("Made a connection: "+check);
        
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
       
            
            	
 
          
     
  
  
    

	public static  boolean loginOnlyCheck(String username2, String password2) {
		//login already have account
		


		username=username2;
		password=password2;
		System.out.println("In Client: "+username+" "+password);
		   out.println("login "+username+" "+password+"\n" );
		   
	
	
	var line = in.nextLine();
	System.out.println(line);
	
  if(line.startsWith("NAMEACCEPTED"))
     {
	  
  		
  	   loggedin=true;
  	 out.println("MESSAGE" );
  	
  	 System.out.println("StartMessaging");

  	 }else if(line.startsWith("WRONGPASSWORD"))
  {
  	System.out.println("Wrong password please try again");
  	 loggedin=false;
	   messageclass=false;
  
}		
	
		return loggedin;
	}
	
	
    
	public static  boolean SignupCheck(String username3, String password3,String answer3) {
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
	       
	        if(loggedin==true) {
	        client.run();
	        
	        }
	        
	    }
	
	
    
    
}