package SomethingNew;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class SignUp extends JDialog{

	private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JTextField answer;
    
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbanswer;
    private JButton btnLogin;
    private JButton btnSignup;
    private JButton btnCancel;
    private boolean succeeded;
    private boolean madenewaccount;
 
    public SignUp(Frame parent) {
    	
        super(parent, "SignUp", true);
	
    
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints cs = new GridBagConstraints();

    cs.fill = GridBagConstraints.HORIZONTAL;

    lbUsername = new JLabel("Username: ");
    cs.gridx = 0;
    cs.gridy = 0;
    cs.gridwidth = 1;
    panel.add(lbUsername, cs);
    

    tfUsername = new JTextField(20);
    cs.gridx = 1;
    cs.gridy = 0;
    cs.gridwidth = 2;
    panel.add(tfUsername, cs);

    lbPassword = new JLabel("Password: ");
    cs.gridx = 0;
    cs.gridy = 1;
    cs.gridwidth = 1;
    panel.add(lbPassword, cs);

    pfPassword = new JPasswordField(20);
    cs.gridx = 1;
    cs.gridy = 1;
    cs.gridwidth = 2;
    panel.add(pfPassword, cs);
    
    lbanswer= new JLabel("Answer: ");
    cs.gridx=0;
    cs.gridy = 2;
    cs.gridwidth = 1;
    panel.add(lbanswer, cs);
    
    answer = new JTextField(20);
    cs.gridx = 2;
    cs.gridy = 2;
    cs.gridwidth = 2;
    panel.add(answer, cs);
    
    
    
    
    panel.setBorder(new LineBorder(Color.PINK));

    
    btnSignup=new JButton("Signup");

    btnSignup.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (ChatClient.DifferSignup(getUsername(), getPassword(),getAnswer())) {
                JOptionPane.showMessageDialog(SignUp.this,
                        "Hi " + getUsername() + "! You have successfully Made a new Account.",
                        "Login",
                        JOptionPane.INFORMATION_MESSAGE);
                succeeded = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(SignUp.this,
                        "User Name is already taken",
                        "Signup",
                        JOptionPane.ERROR_MESSAGE);
              
                tfUsername.setText("");
                pfPassword.setText("");
                succeeded = false;

            }
        }
    });
    
    
    btnCancel = new JButton("Cancel");
    btnCancel.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
    JPanel bp = new JPanel();
    bp.add(btnSignup);
    bp.add(btnCancel);

    getContentPane().add(panel, BorderLayout.CENTER);
    getContentPane().add(bp, BorderLayout.PAGE_END);

    pack();
    setResizable(false);
    setLocationRelativeTo(parent);
}


    public String getUsername() 
    {
    	return tfUsername.getText().trim();
    }

    public String getPassword() 
    {
    	return new String(pfPassword.getPassword());
    }

    public String getAnswer()
    {
    	return  answer.getText().trim();
    }

    public boolean isSucceeded() 
    {
    	return succeeded;
    }
   
   
}
