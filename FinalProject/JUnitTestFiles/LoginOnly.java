package TestSuiteChatClientSide;

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



public class LoginOnly extends JDialog{
	
	private JTextField UserN;
    private JPasswordField fieldpass;
    private JButton buttonLogin;
    private JButton JBSighup;
    private JButton Canceell;
    private boolean succeess;
    private JLabel JLUser;
    private JLabel JLpass;
    private ClientSide object;
 
    public LoginOnly(Frame parent) {
    	
        super(parent, "Login", true);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        JLUser = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(JLUser, cs);
 
        UserN = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(UserN, cs);
 
        JLpass = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(JLpass, cs);
 
        fieldpass = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(fieldpass, cs);
        panel.setBorder(new LineBorder(Color.blue));
 
        buttonLogin = new JButton("Login");
        JBSighup=new JButton("Signup");
 
        buttonLogin.addActionListener(new ActionListener() {
 
        	
        	public void actionPerformed(ActionEvent e) {
                if (ClientSide.loginOnlyCheck(getUsername(), getPassword())) {
                	
                    JOptionPane.showMessageDialog(LoginOnly.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeess = true;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginOnly.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    UserN.setText("");
                    fieldpass.setText("");
                    succeess = false;
 
                }
            }
        });
        
       
        
 
        
        
        
        Canceell = new JButton("Cancel");
        Canceell.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(buttonLogin);
        bp.add(Canceell);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 

	public String getUsername() {
        return UserN.getText().trim();
    }
 
    public String getPassword() {
        return new String(fieldpass.getPassword());
    }
 
    public boolean issucceess() {
        return succeess;
        
    }
    
    public void setSuccess(boolean check) {
    	succeess=check;
    }
}
	


