import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.*;
public class Logged_In extends JDialog {
	

	public JTextField usernameText;
	private JPasswordField passText;
	
	private JLabel UsName;
	private JLabel PsPass;
	
	private JButton Login;
	private JButton SignUp;
	
	
	private boolean check;
	
	
	
	public Logged_In(Frame parent,String check) {
		
		if(check.equals("login")) {
			 login(parent);
		}
		else
		{
			singup(parent);
		}
	
		 
		
		
		
		
		
		
	}



	private void singup(Frame parent) {
		// TODO Auto-generated method stub
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints ccsss = new GridBagConstraints();
		
		ccsss.fill = GridBagConstraints.HORIZONTAL;
		
		UsName = new JLabel("Username: ");
		ccsss.gridx=0;
		ccsss.gridy=0;
		ccsss.gridwidth=1;
		
		p.add(UsName, ccsss);
		
		usernameText= new JTextField(30);
		ccsss.gridx=1;
		ccsss.gridy=0;
		ccsss.gridwidth=2;
		p.add(usernameText,ccsss);
		
		
		PsPass= new JLabel("Password: ");
		ccsss.
		
	}



	private void login(Frame parent) {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	
	
	

}
