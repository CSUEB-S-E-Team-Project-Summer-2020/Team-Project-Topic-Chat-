package SomethingNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.awt.BorderLayout;
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
public class ChatClient extends User  {
private String username="";
private String password="";
private String sAnswer="";
    String serverAddress;
    Scanner in;
    PrintWriter out;


    /**
     * Constructs the client by laying out the GUI and registering a listener with
     * the textfield so that pressing Return in the listener sends the textfield
     * contents to the server. Note however that the textfield is initially NOT
     * editable, and only becomes editable AFTER the client receives the
     * NAMEACCEPTED message from the server.
     */
    public ChatClient(String serverAddress) {
        this.serverAddress = serverAddress;
        
      
    }
    public ChatClient() {
    	
    }

    private String getName() {
        return JOptionPane.showInputDialog(frame, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

    

    private void run() throws IOException {
  
            var socket = new Socket("localhost", 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

           
            
            
          
     
           
               var line = in.nextLine();
               
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
           
			//System.out.print(newLog.toString());
			
           
            
 
            
       
    
    }
public boolean login(String login,String password) {
	
	
	System.out.println("In Client: "+login+" "+password);
	
	return false;
}
    public static void main(String[] args) throws Exception {
     
        var client = new ChatClient("localhost");
        client.run();
    }
    

	public static boolean Differ(String username2, String password2) {
		// TODO Auto-generated method stub
		return false;
	}
    
	public static boolean DifferSignup(String username3, String password3,String answer) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}