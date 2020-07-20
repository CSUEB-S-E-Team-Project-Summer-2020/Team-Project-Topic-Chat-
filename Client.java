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
	String question="";
	String secondCheck="";
	boolean moveToMessage=false;
	
	
	
	
while(true) {
		
		System.out.println("Please login: ");
		username=sc.nextLine();
		System.out.println("password: ");
		password=sc.nextLine();
		client.output.write(("login"+username+password).getBytes());
	
		check=client.bufferIn.readLine();
		if(check.equals("NoAccount")) {
			//System.clearProperty(null);
			System.out.println("Please Enter new UserName: ");
			username=sc.nextLine();
			
			System.out.println("Enter password ");
			password=sc.nextLine();

			System.out.println("Enter security question Answer: ");
			question=sc.nextLine();
			client.output.write(("signup"+username+password+question).getBytes());
		
		}
		else if(check.equals("IncorrectPassword"))
		{
			
			
				do
				{
					System.out.println("Enter password ");
					password=sc.nextLine();
					client.output.write(("login"+username+password).getBytes());
					secondCheck=client.bufferIn.readLine();
				}while(secondCheck.equals("IncorrectPassword"));
				
				
				
			
				
			}
		else
		{
			
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
