

package test;
import chat.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;


class ServerSideTests {
	
		
	
	@Test 
	void testConnetion() throws UnknownHostException, IOException
	{
		
		
		var socket = new Socket("localhost", 59001);
		Scanner in = new Scanner(socket.getInputStream());
	    String inputString=in.nextLine();
	    socket.close();
		assertEquals("SUBMITTED",inputString);
		
	}
	@Test
	void CreateTheAccountTest() throws UnknownHostException, IOException
	{
		var socket = new Socket("localhost", 59001);
		Scanner in = new Scanner(socket.getInputStream());
	    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
	    String inputString=in.nextLine();
	    out.println("newA "+"new"+" "+"new"+" "+"new"+"\n");
	    inputString=in.nextLine();
	    socket.close();
	    boolean varibale = false;
	    if(inputString.equals("NAMEACCEPTED new"))
	    	varibale=true;
	    assertTrue(varibale);

		
	}
	@Test
	void dologinTest() throws UnknownHostException, IOException
	{
		
		var socket = new Socket("localhost", 59001);
		Scanner in = new Scanner(socket.getInputStream());
	    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
	    String inputString=in.nextLine();
	    out.println("login "+"me"+" "+"me"+"\n");
	    inputString=in.nextLine();
	    socket.close();
		assertEquals("NAMEACCEPTED me",inputString);
		
	}
	@Test
	void doMessageTest() throws UnknownHostException, IOException
	{
		
		var socket = new Socket("localhost", 59001);
		Scanner in = new Scanner(socket.getInputStream());
	    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
	    String inputString=in.nextLine();
	    out.println("newA "+"new"+" "+"new"+" "+"new"+"\n");
	    inputString=in.nextLine();
	    Scanner in2 = new Scanner(socket.getInputStream());
	    PrintWriter out2= new PrintWriter(socket.getOutputStream(), true);
	    out2.println("newA "+"nick"+" "+"nick"+" "+"nick"+"\n");
	    inputString=in2.nextLine();
	    out.println("msg "+"new "+"hi"+"\n");
	    inputString=in.nextLine();
	    socket.close();
	    assertEquals("nick hi", inputString);
	    
	}
	@Test
	void addFriendTest() throws UnknownHostException, IOException
	{
		var socket = new Socket("localhost", 59001);
		Scanner in = new Scanner(socket.getInputStream());
	    PrintWriter out= new PrintWriter(socket.getOutputStream(), true);
	    String inputString=in.nextLine();
	    out.println("newA "+"new"+" "+"new"+" "+"new"+"\n");
	    out.println("add me");
	    inputString=in.nextLine();
	    socket.close();
	    
	    assertEquals("NAMEACCEPTED new",inputString);
		
	}

}
