


import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.TypeUtilsTest.This;



public class ClientSide {

	private final String host;
	private final int port;
    private String securityAnswer;
    private InputStream inputStream;
   private OutputStream outputStream;
   private  BufferedReader cin;
   private Socket socket;
   
    //constructor
   public ClientSide(String host, int port)
   {
	   this.host=host;
	   this.port=port;
	   
   }
   
   
   
public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket;

    int option;

   // int port =1111;
//String host="localhost";

    ClientSide clinet=new ClientSide("localhost", 1111);
    clinet.serverconnect();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        //socket=new Socket(host,port);
        final  JFrame JFrame =  new JFrame("test");     
  final JButton btnLogin= new JButton("login");
  final JButton signup=new JButton("signup");
  String checking = null;
  btnLogin.addActionListener(
		  new ActionListener(){
			  public void actionPerformed(ActionEvent e) {
				  Logged_In loginD=new Logged_In(JFrame,checking);
				  Logged_In signupD=new Logged_In(JFrame,checking);
				  loginD.setVisible(true);
			  }
		  
		
		  
		  });
  
  JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JFrame.setSize(300, 100);
  JFrame.setLayout(new FlowLayout());
  JFrame.getContentPane().add(signup);
  JFrame.setVisible(true);
  
  
  JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JFrame.setSize(300, 100);
  JFrame.setLayout(new FlowLayout());
  JFrame.getContentPane().add(btnLogin);
  JFrame.setVisible(true);
       
        boolean loginStatus;
        System.out.println("1: log in"+"/n"+"2: Create Account");
        System.out.println("Enter the option number: ");
       
        option=sc.nextInt();
        switch (option) {
case 1: {


  clinet.doLogin();
 
 

}
break;
case 2:
{

	clinet.doCreateAccount();
}

 
default:
throw new IllegalArgumentException("Unexpected value: " + option);
}
       
       
       
       
       
       
    }






public void serverconnect() throws UnknownHostException, IOException {
	// TODO Auto-generated method stub
	
	this.socket=new Socket(host,port);
	  System.out.println("Connection has made to the with server");
	    this.inputStream=socket.getInputStream();
	    this.outputStream=socket.getOutputStream();
	    this.cin=new BufferedReader(new InputStreamReader(inputStream));
	
}



private void doLogin() throws IOException {
	// TODO Auto-generated method stub
	
	String username;
	  String password;
	 
	  Scanner scan= new Scanner(System.in);
	  System.out.println("Enter your Username: ");
	  username=scan.nextLine();
	  System.out.println("Enter the Password: ");
	  password=scan.nextLine();
	
	
	
	 String tempString="login "+username+" "+password+"\n";
	 String verifyString;
	  try {
		outputStream.write(tempString.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  try {
		verifyString=cin.readLine();
		 if(verifyString.equals("NoAccount"));
		  {
		  System.out.print("Coreee");
		  doCreateAccount();
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  doStartMessage();
	 
}






private void doCreateAccount() throws IOException {
	
String sending;
String newUser;
String newPass;
boolean check =false;
String answer;
String verifyString;
Scanner scan= new Scanner(System.in);
System.out.println("Enter your Username: ");
newUser=scan.nextLine();
System.out.println("Enter the Password: ");
newPass=scan.nextLine();
System.out.println("Enter your Question answer: ");
answer=scan.nextLine();

sending="login "+outputStream+" "+cin+" "+answer+"\n";
try {
	outputStream.write(sending.getBytes());
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
verifyString=cin.readLine();
if(verifyString.equals("AlreadyAccount")) {
	System.out.println("This username is already in the system: "+newUser);
	doLogin();
}
else
{
	System.out.println("You made New account: "+newUser);
	 doStartMessage();
}
}






private  void doStartMessage() throws IOException {
	// TODO Auto-generated method stub
	
	
	Thread newperson=new Thread() {
		@Override
		public void run() {
		
			String reading;
		try {
			while((reading= cin.readLine()) !=null)
			{
				String[] ListMsg = StringUtils.split(reading,null,3);
				takeMessage(ListMsg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
			
			
			
		}

		private void takeMessage(String[] listMsg) {
			// TODO Auto-generated method stub
			
			String username=listMsg[1];
			String msg=listMsg[2];
			
			System.out.println("Yout got message from : "+username+" "+msg+"\n");
		
			
			
			
		}
		
		
		
		
		
		
	};
	
}


}//end of class