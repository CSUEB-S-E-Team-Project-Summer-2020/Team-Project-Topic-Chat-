package chat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.awt.BorderLayout;
import java.awt.Frame;

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
public class ClientSide {
	private String username="";
	private String password="";
	private String sAnswer="";
	private int attemps;
    String serverAddress;
    Scanner in;
    PrintWriter out;
    JFrame frame = new JFrame("Chatter");
    JTextField textField = new JTextField(50);
    JTextArea messageArea = new JTextArea(16, 50);
  
    public ClientSide(String serverAddress) {
        this.serverAddress = serverAddress;

        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.CENTER);
        frame.pack();

        // Send on enter then clear to prepare for next message
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }
    

    private String getloginfo() {
    	
    	//JFrame frame1 = new JFrame("login Window");
    	
        username=JOptionPane.showInputDialog(frame, "Enter the username:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
        password=JOptionPane.showInputDialog(frame, "Enter the password:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
        return ("login "+username+" "+password+"\n");
        //return ("newA "+username+" "+password+" "+"s"+"\n");

        
    }

    private String getNewAccountInfo() {
    	
        username=JOptionPane.showInputDialog(frame, "Enter the username:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
        password=JOptionPane.showInputDialog(frame, "Enter the password:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
        sAnswer=JOptionPane.showInputDialog(frame, "Enter the Security Answer:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
        //System.out.println("newA "+username+" "+password+" "+sAnswer+"\n");
        return ("newA "+username+" "+password+" "+sAnswer+"\n");
        
        
    }


    private void run() throws IOException {
        try {
        	
            var socket = new Socket("localhost", 59001);
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            attemps=0;
            int choice;
            String[] options= {"Signup","Login"};
       	 choice = JOptionPane.showOptionDialog(null,
				 "Select a Option", 
				 "DVD Collection", 
				 JOptionPane.YES_NO_CANCEL_OPTION, 
				 JOptionPane.QUESTION_MESSAGE, 
				 null, 
				 options,
				 options[options.length - 1]);
		 		
            while (in.hasNextLine()) {
                var line = in.nextLine();
                if (line.startsWith("SUBMITTED")) 
                {
                	if(choice==0)
                	{
                		out.println(getNewAccountInfo());
                	}
                	if(choice==1) {
                		out.println(getloginfo());
                   	 	attemps++;
					}
                	 
                } 
                if(line.startsWith("WRONGPASSWORD"))
                {
                	if(attemps<3)
                	{
                	out.println(getloginfo());
                	}
                	else {
                		 out.println(getNewAccountInfo());
					}
                }
                if(line.startsWith("NEWACCOUNT"))
                {
                	 out.println(getNewAccountInfo());
                }
                if (line.startsWith("NAMEACCEPTED")) {
                	System.out.println("This hass been clled");
                	
                    this.frame.setTitle("Chatter - " + line.substring(13));
                    textField.setEditable(true);
                } else if (line.startsWith("MESSAGE")) {
                    messageArea.append(line.substring(8) + "\n");
                }
                
            }
        } finally {
            frame.setVisible(false);
            frame.dispose();
        }
    }

    public static void main(String[] args) throws Exception {
      
        var client = new ClientSide("localhost");
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}