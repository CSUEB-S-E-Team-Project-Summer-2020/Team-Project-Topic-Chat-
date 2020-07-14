import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ClientSide {

	
	public static void main (String[] args) throws IOException{
		
		Scanner sc= new Scanner(System.in);
		int port=7777;
		String host="";
		
		Socket socket= new Socket(host,port);
		
		 OutputStream outputStream = socket.getOutputStream();

	        // Create object output stream from the output stream to send an object through it
	        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
	        ObjectInputStream objectInputStream= new ObjectInputStream(socket.getInputStream());
	        
	        
	        // List of Message objects
	        List<Message> messages = new ArrayList<>();
	        messages.add(new Message("login"));
	        while(true) {
	        System.out.print("Enter message info. <enter> to quit\n");
	        String msg = sc.next();
	        messages.add(new Message(msg));
	    
	        System.out.println("Sending Message Objects");
	        
	        if(msg.equals("logout"))break;
	        }
	        objectOutputStream.writeObject(messages);
	        System.out.println("Closing socket");
	        socket.close();
		
	}
	
}
