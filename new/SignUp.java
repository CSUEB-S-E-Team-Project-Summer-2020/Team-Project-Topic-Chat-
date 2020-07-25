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
        
    }
	
	
}
