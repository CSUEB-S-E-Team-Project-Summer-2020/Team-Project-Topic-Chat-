package ChatSysetm;
import org.apache.commons.lang3.StringUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ServerSideClientMenu extends Thread{
	private final Socket clientSocket;// Final is not there yet
	private final SeverAcceptConnections server;//final is not there yet

	AccountHolders accountHolders=new AccountHolders();
	private String loginUsername;
	private String usernameString;
	private String passwordString;

	private OutputStream outputStream;
	private InputStream inputStream;
	
	public ServerSideClientMenu(SeverAcceptConnections server, Socket client)
	{
		
		this.server=server;
		this.clientSocket=client;
	
	}
	@Override
	public void run()
	{
		
			try {
				inputStream = clientSocket.getInputStream();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			try {
				this.outputStream = clientSocket.getOutputStream();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
        BufferedReader cin = new BufferedReader(new InputStreamReader(inputStream));
        
		String inputString;
	
		try {
			while((inputString=cin.readLine())!=null)
			{
				
				String[] inputStringArray=StringUtils.split(inputString);
				System.out.println("here");
				String option=inputStringArray[0];
				System.out.println(option);
			
				switch(option){
					case "login":
					{
						usernameString=inputStringArray[1];
						passwordString=inputStringArray[2];
						doLogin(outputStream,usernameString,passwordString);
					}	
					
					break;
					case "signup":
					{
						String securityAnswer;
						usernameString=inputStringArray[1];
						passwordString=inputStringArray[2];
						securityAnswer=inputStringArray[3];
						doSignup(outputStream,usernameString,passwordString,securityAnswer);
						
					}
					break;
					case "msg":
					{
						String[] messageLiSt=StringUtils.split(inputString,null,3);
						doMessage(messageLiSt);
						
					}
					break;
				}
		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doMessage(String[] messageLiSt) throws IOException {
		String sendMessageToString=messageLiSt[1];
		String messageBody=messageLiSt[2];
		boolean ifOnline;
		ifOnline=accountHolders.getStatusofPerson(sendMessageToString);
		if(ifOnline==true)
		{
			String sentString="msg "+sendMessageToString+" : "+loginUsername+" "+messageBody+"\n"; 
			outputStream.write(sentString.getBytes());
			
		}
		else {
			String sentString="msg "+loginUsername+" "+messageBody+"\n"; 
			outputStream.write(sentString.getBytes());

			
		}
		
	}
	@SuppressWarnings("null")
	private void doSignup(OutputStream outputStream, String usernameString2, String passwordString2,String sc) throws IOException {
		
		AccountHolders tempObject = null;
		boolean verifyUsername;
		verifyUsername=tempObject.verifyUsername(usernameString2);
		if(verifyUsername==true)
		{
			 outputStream.write(("AlreadyAccount").getBytes());
		}
		else {
			tempObject.addUsers(usernameString2,passwordString2,sc);
			
		}
		
		
	}
	private void doLogin(OutputStream outputStream, String usernameString2, String passwordString2) throws IOException {
		
		
		//System.out.println("I am here ");

		boolean verifyUsername;
		boolean verifyPassword;
		verifyUsername=accountHolders.verifyUsername(usernameString2);
		//verifyUsername=false;
		if(verifyUsername==false)
		{
			System.out.println("I am here ");
			 outputStream.write(("NoAccount\n").getBytes());
			
		}
		verifyPassword=accountHolders.verifyPassword(passwordString2);
		if(verifyPassword==false && verifyUsername==true)
		{
			outputStream.write(("IncorrectPassword\n").getBytes());
			
		}
		else {
			outputStream.write(("Successful\n").getBytes());
			this.loginUsername=usernameString2;
			accountHolders.changeStatus("online");
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
