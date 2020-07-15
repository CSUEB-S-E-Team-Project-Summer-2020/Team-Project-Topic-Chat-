package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.xpath.internal.operations.And;

import sun.awt.windows.ThemeReader;

class ServerSideTest {

	@Before
	void TestScoketTest() {
		//check if the serverside is creating the new socket or not
		fail("Not yet implemented");
	}
	@Test
	void TestLoginWithAccount(){
		
		// go to database of the account and find the user and match the password
		//if match send the massage "Login Successful"
		//if no match give three try and ask security question
		
	}
	@ Test
	void AddFriend() {
		//add the friend username to the friend's list of client
		//get back the confirmation
		
	}
	
	@Test
	void DeleteFriend() {
		//add the friend to the list and 
		//delete the same friend username to validate Delete friend
	}
	void 
	
	
	@After
	void TestCloseSocket() {
		
		//if the user enters the logout the socket will close for that user 
		
	}
	

}