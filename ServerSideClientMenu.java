
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;



import ChatSysetm.ServerSide.SeverAcceptConnections;

public class ServerSideClientMenu extends Thread{
	private Socket clientSocket;// Final is not there yet
	private SeverAcceptConnections server;//final is not there yet
	private String loginString=null;
	private String usernameString;
	private String passwordString;
	private String logoutString=null;
	private String chatString=null;
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
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			this.outputStream = clientSocket.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
        BufferedReader cin = new BufferedReader(new InputStreamReader(inputStream));
		String inputString=null;
	
		try {
			while((inputString=cin.readLine())!=null)
			{
				
				String[] inputStringArray=StringUtils.split(inputString);
				
				String option=inputStringArray[0];
			
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
					
				}
		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("null")
	private void doSignup(OutputStream outputStream1, String usernameString2, String passwordString2,String sc) throws IOException {
		
		AccountHolders tempObject = null;
		boolean verifyUsername;
		verifyUsername=tempObject.verifyUsername(usernameString2);
		if(verifyUsername==true)
		{
			 outputStream1.write(("AlreadyAccount").getBytes());
		}
		else {
			tempObject.addUsers(usernameString2,passwordString2,sc);
			
		}
		
		
	}
	@SuppressWarnings("null")
	private void doLogin(OutputStream outputStream1, String usernameString2, String passwordString2) throws IOException {
		AccountHolders tempObject = null;
		boolean verifyUsername;
		boolean verifyPassword;
		verifyUsername=tempObject.verifyUsername(usernameString2);
		if(verifyUsername==false)
		{
			 outputStream1.write(("NoAccount").getBytes());
			
		}
		verifyPassword=tempObject.verifyPassword(passwordString2);
		if(verifyPassword==false && verifyUsername==true)
		{
			outputStream1.write(("IncorectPassword").getBytes());
			
		}
		else {
			outputStream1.write(("Successful").getBytes());
			tempObject.changeStatus("online");
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
