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
		
		UsName = new JLabel("username: ");
		ccsss.gridx=0;
		ccsss.gridy=0;
		ccsss.gridwidth=1;
		
		p.add(UsName, ccsss);
		
		usernameText= new JTextField(30);
		ccsss.gridx=1;
		ccsss.gridy=0;
		ccsss.gridwidth=2;
		p.add(usernameText,ccsss);
		
		
		PsPass= new JLabel("password: ");
		ccsss.gridx = 0;
		ccsss.gridy = 1;
		ccsss.gridwidth = 1;
		p.add(PsPass, ccsss);
		
		passText = new JTextField(30);
		ccsss.gridx = 1;
		ccsss.gridy = 1;
		ccsss.gridwidth = 2;
		p.add(passText, ccsss);
		p.setBorder(new LineBorder(Color.GRAY));
		
		ansText = new JLabel("answer: ");
		ccsss.gridx = 0;
		ccsss.gridy = 2;
		ccsss.gridwidth = 2;
		p.add(ansText, ccsss);
		
		answerText = new JTextField(30);
		ccsss.gridx = 2;
		ccsss.gridy = 2;
		ccsss.gridwidth = 3;
		p.add(answerText, ccsss);
		
		Login = new JButton("login");
		Login.addActionListener(new ActionListener() {		
		
		public void actionPerformed(ActionEvent e)
		{
			if(Login.authenicate(getUsName(), getPsPass()))
			{
				JOptionPane.showMessageDialog(Logged_In.this, "Hi" + getUsName() + 
						"! Welcome", + "Login", JOptionPane.INFORMATION_MESSAGE);
				succeeded = true;
				dispose();
			} 
			else
			{
				JOptionPane.showMessageDialog(Logged_In.this, "invalid username or password", 
						"Login", JOptionPane.ERROR_MESSAGE);
				usernameText.setText("");
				passText.setText("");
				succeeded = false;
			}
		}
		
	});

	private void login(Frame parent) {
		// TODO Auto-generated method stub
		
	}



	
	
	
	
	
	
	

}
