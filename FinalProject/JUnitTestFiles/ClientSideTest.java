package TestSuiteChatClientSide;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ClientSideTest {

	
	/*
	@SuppressWarnings("static-access")
	@Before
	public void testRunSever() {
		ServerSide server=new ServerSide();
		String[] args = null;
		try {
			server.main(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
		
	
	
	
	
	
@Test
	public void testConnectionToServer() throws UnknownHostException, IOException{
		
	
		
			ClientSide testConnection=new ClientSide("127.0.0.1");
			
			
			assertEquals("127.0.0.1", testConnection.serverAddress);
			
			
			assertTrue(testConnection.in.hasNextLine());
			
			
			testConnection.out.println("login");
			
		
			
			testConnection.Loginbox();
			ActionEvent e=null;
			testConnection.actionPerformed(e);
			Component popup = null;
			
	
		
	
			
			 String password2="something";
			 String username2="me";
			 
			
			 
			testConnection.loginOnlyCheck(username2, password2);
			
			//assertTrue(ClientSide.Differ(username2, password2));
			
			
		
			String name1="Manpreet";
			String pass="444";
			
			LoginOnly find=new LoginOnly(null);
			
			
			
			assertTrue(testConnection.frameM.isVisible());
		
			testConnection.out.println("newA "+"Manpreet"+" "+"Pasword"+" "+"Blue"+"/n");
			assertEquals(testConnection.in.nextLine(),"NAMEACCEPTED");
			
		
			
			
	}
	
	
	@Test
	void testSignUp() throws UnknownHostException, IOException {
		ClientSide testConnection1=new ClientSide("127.0.0.1");
		assertEquals("127.0.0.1", testConnection1.serverAddress);
		
		System.out.println(testConnection1.in.hasNextLine());
		String password2="James";
		 String username2="Jones";
		 String ans="answer";
		 
		 
		testConnection1.SignupCheck(password2, username2, ans);
		
		
		
		testConnection1.out.println("login");
		ClientSide objec;
	
		
		
		testConnection1.Loginbox();
		ActionEvent e=null;
		testConnection1.actionPerformed(e);
		Component popup = null;
		

	

		
		 
		//assertTrue(ClientSide.Differ(username2, password2));
		
		
	
		String name1="Manpreet";
		String pass="444";
		
		//LoginOnly find=new LoginOnly(null);
		
		
		
		assertTrue(testConnection1.frameM.isVisible());
		assertNotNull(testConnection1.textField.getText());
		
		
	}

}
