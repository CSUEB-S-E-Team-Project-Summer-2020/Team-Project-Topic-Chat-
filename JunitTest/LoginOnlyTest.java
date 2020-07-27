package SomethingNew;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class LoginOnlyTest {

	@Test
	void test() throws UnknownHostException, IOException {
		
		ClientSide test=new ClientSide("localhost");
		final JFrame frame= new JFrame("Login Window");
        final JButton Login=new JButton("Login");
        final JButton Signup= new JButton("SignUp");
        
       
        
        
        Login.addActionListener(
        		 new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						 LoginOnly log = new LoginOnly(frame);
	                        
							
						 
	                        log.setVisible(true);
	                   
					}
        			
        		});
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(Login);
        frame.getContentPane().add(Signup);
        frame.getColorModel();
        frame.setVisible(true);
		
		LoginOnly checking=new LoginOnly(frame);
		checking.addMouseListener(null);
		
		checking.getUsername();
		checking.getPassword();
		assertNotSame(Login,Signup);
		checking.setSuccess(true);
		 assertTrue(checking.issucceess());
		 
		 
		 
		 
		 
		 assertFalse(checking.issucceess());//should fail
		
		 
		 assertSame(Login,Signup);//suppose to fail
		
		 
		
		
	}

}
