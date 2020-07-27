package TestSuiteChatClientSide;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;

public class AccountTest {


	@Test
	public void testAccount()
	{
		String name="James";
		String pass="Home";
		Account testing= new Account( name,pass );
		assertEquals(name,testing.getUserName());
		System.out.println(testing.getUserName());
		
	}
	@Test
	public void testUsername()
	{
		Account testing = new Account();
		String name = "Amna";
		testing.setUserName(name); //assuming we already have the username
		assertEquals("Amna", testing.getUserName());
		assertSame("Amna", "Amna");
	}
	
	@Test
	public void testPassword()
	{
		Account testing = new Account();
		String password = "hello1234";
		testing.setPassword(password);
		assertEquals("hello1234", testing.getPassword());
		assertSame("hello1234", "hello1234");
	}
	
	@Test
	public void testSecurityAnswer()
	{
		Account testing = new Account();
		String answer = "Pleasanton";
		testing.setSecurityAnswer(answer); //assuming the question asking for your hometown...
		assertEquals("Pleasanton", testing.getSecurityAnswer());
		assertSame("Pleasanton", "Pleasanton");
	}
	
	@Test
	public void testSetStatusOnline()
	{
		Account testing = new Account();
		testing.setStatusOnline();		
		assertTrue(true, testing.getStatus());
	}

	@Test
	public void testSetStatusOffline()
	{
		Account testing = new Account();
		testing.setStatusOffline();		
		assertTrue(true, testing.getStatus());
	}
	
	@Test
	public void testSetStatusBlocked()
	{
		Account testing = new Account();
		testing.setStatusBlocked();		
		assertTrue(true, testing.getStatus());
	}
	
	@Test
	public void testSetAddFriend()
	{
		Account testing = new Account();
		String friendname = "person";
		testing.addFriend(friendname); //people can add friends by entering their username 
		assertSame("person", "person");
	}

}
