package TestSuiteChatClientSide;



import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import SomethingNew.SignUp;







import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;



class SignUpTest 
{

	@Test
	void test() throws UnknownHostException, IOException 
	{
		
		
		
		
		ClientSide test = new ClientSide("localhost");
		final JFrame frame = new JFrame("Login Window");
		final JButton Signup = new JButton("Signup");
				
		System.out.println(test.in.hasNextLine());
		Signup.addActionListener(
          		 new ActionListener() 
           		{
						public void actionPerformed(ActionEvent e)
						{
							// TODO Auto-generated method stub
							 SignUp signup = new SignUp(frame);
		                        
							 signup.setVisible(true);
						}
           		});
		
		SignUp checking=new SignUp(frame);
		checking.addMouseListener(null);
		
		checking.getUsername();
		checking.getPassword();
		checking.getAnswer();
		assertSame(Signup,Signup);
		 
		checking.setSucced(true);
		assertTrue(checking.isSucceeded()); 
		
	}
	
	

	

}