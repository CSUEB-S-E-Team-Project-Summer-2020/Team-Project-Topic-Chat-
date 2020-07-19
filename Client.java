import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
	
	private String host;
	private int port;
	private Socket socket;
	private InputStream input;
	private OutputStream output;
	private BufferedReader bufferIn;
	
	List<Message> message = new ArrayList<>();
	//message arry

public Client(String host, int port) {
		// TODO Auto-generated constructor stub

	this.host=host;
	this.port=port;
	
	}

public static void main (String[] args) throws IOException{
	
	
	

	Client client = new Client("127.0.0.1",1111);
	
	
	client.promptConnection();
	
	Scanner sc= new Scanner(System.in);
	
	String username;
	String password;
	String check="";
while(true) {
		
		System.out.println("Please login ");
		username=sc.nextLine();
		client.output.write(username.getBytes());
		System.out.println("password ");
		password=sc.nextLine();
		client.output.write(password.getBytes());
		check=client.bufferIn.readLine();
		if(check.equals("ok")) {
			break;
		}
		
		
		
		
	}

	
}

public void promptConnection() {
	// TODO Auto-generated method stub
	
	try {
		this.socket=new Socket(host,port);
		System.out.println("Connected to ");
		this.output=socket.getOutputStream();
		this.input=socket.getInputStream();
		this.bufferIn=new BufferedReader(new InputStreamReader(input));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
}

private static void promptLogin() {
	// TODO Auto-generated method stub

	
}
}
