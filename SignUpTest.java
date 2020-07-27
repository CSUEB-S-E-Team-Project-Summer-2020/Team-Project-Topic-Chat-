import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;



class SignUpTest 
{

	@Test
	void test() 
	{
		fail("Not yet implemented");
		
		System.out.println(test.in.hasNextLine());
		
		ChatClient test = new ChatClient("localhost");
		final JFrame frame = new JFrame("Login Window");
		final JButton Signup = new JButton("Signup");
				
	
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
		assertNotSame(Login,Signup);
		assertTrue(checking.isSucceeded()); 
		
	}
	
	

	

}
