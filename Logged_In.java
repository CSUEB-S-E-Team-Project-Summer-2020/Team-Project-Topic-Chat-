import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.*;
public class Logged_In extends JDialog {
	

	public JTextField usernameText;
	private JPasswordField passText;
	public JTextField answerText; 
	
	private JLabel UsName;
	private JLabel PsPass;
	private JLabel ansText; 
	
	private JButton Login;
	private JButton SignUp;
	
	
	private boolean check;
	
	
	
	public Logged_In(Frame parent,String check) {
		
		if(check.equals("login")) {
			 login(parent, check);
			 
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



	private void login(Frame parent, String check) 
	{
		// TODO Auto-generated method stub
		
		super(parent, "Login", true);
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints ccsss = new GridBagConstraints();
		
		ccsss.fill = GridBagConstraints.HORIZONTAL;
		
		UsName = new JLabel("Username: ");
		ccsss.gridx = 0;
		ccsss.gridy = 0;
		ccsss.gridwidth = 1;
		
		p.add(UsName, ccsss);
		
		usernameText= new JTextField(30);
		ccsss.gridx = 1;
		ccsss.gridy = 0;
		ccsss.gridwidth = 2;
		p.add(usernameText,ccsss);
		
		
		PsPass= new JLabel("Password: ");
		ccsss.gridx = 0;
		ccsss.gridy = 1;
		ccsss.gridwidth = 1;
		p.add(usernameText,ccsss);
		
		
		passText = new JPasswordField(30);
		ccsss.gridx = 1;
		ccsss.gridy = 1;
		ccsss.gridwidth = 2;
		p.add(passText,ccsss);
		p.setBorder(new LineBorder(Color, PINK));
		
		Login = new JButton("login");
		
		Login.addActionListener(new ActionListener())
		{
			public void actionPerformed(Action)
			if(Login.authenticate(getUserName(), getPass()))
			{
				JOptionPane.showMessageDialog(Logged_In.this, "Hello" + getUserName() + 
						"!" + "You have successfully logged in!", JOptionPane.INFORMATION_MESSAGE);
				check = true; 
			}
			
			else
			{
				JOptionPane.showMessageDialog(Logged_In.this, "The username or password is invalid", JOptionPane.ERROR_MESSAGE);
				usernameText.setText(" ");
				passText.setText(" ");
				check = false; 
				
			}
		}

			
		
	}


}
