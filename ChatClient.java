



import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.TypeUtilsTest.This;



public class ClientSide {

   
    private String securityAnswer;

 
   
   
   
   
public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket;

    int option;
    InputStream inputStream;
    OutputStream outputStream;
    BufferedReader cin;
    int port =1111;
String host="localhost";
    //ClientSide clinet=new ClientSide("localhost", 1111);
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream.
        socket=new Socket(host,port);
    System.out.println("Connection has made to the with server");
    inputStream=socket.getInputStream();
    outputStream=socket.getOutputStream();
    cin=new BufferedReader(new InputStreamReader(inputStream));
   
       
        boolean loginStatus;
        System.out.println("1: log in"+"/n"+"2: Create Account");
        System.out.println("Enter the option number: ");
       
        option=sc.nextInt();
        switch (option) {
case 1: {

String username;
  String password;
 
  Scanner scan= new Scanner(System.in);
  System.out.println("Enter your Username: ");
  username=scan.nextLine();
  System.out.println("Enter the Password: ");
  password=scan.nextLine();
  doLogin(username,password,outputStream,cin);
 
 

}
break;
case 2:
{

doCreateAccount(outputStream,cin);
}

 
default:
throw new IllegalArgumentException("Unexpected value: " + option);
}
       
       
       
       
       
       
    }






private static void doLogin(String username, String password,OutputStream outputStream,BufferedReader cin ) throws IOException {
	// TODO Auto-generated method stub
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
		  doCreateAccount(outputStream,cin);
		  }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  doStartMessage(cin,outputStream);
	 
}






private static void doCreateAccount(OutputStream outputStream, BufferedReader cin) throws IOException {
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
	doLogin(newUser,newPass,outputStream,cin);
}
else
{
	System.out.println("You made New account: "+newUser);
	 doStartMessage(cin, outputStream);
}
}






private static void doStartMessage(BufferedReader cin, OutputStream outputStream) throws IOException {
	// TODO Auto-generated method stub
	
	
	Thread newperson=new Thread() {
		@Override
		public void run() {
		
			String reading;
		while((reading= cin.readLine()) !=null)
		{
			String[] ListMsg = StringUtils.split(reading,null,3);
			takeMessage(ListMsg);
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