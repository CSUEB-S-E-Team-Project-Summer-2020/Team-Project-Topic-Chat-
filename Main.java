package logincheck;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Main {
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Messanger");
        final JFrame frame2= new JFrame("Signup");
        final JButton btnLogin = new JButton("Login");
        final JButton btnSignup=new JButton("SignUp");
 //String check="login";
        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getName() + "!");
                        }
                    }
                });
        btnSignup.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                        	btnSignup.setText("Hi " + loginDlg.getName() + "!");
                        }
                    }
                });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnSignup);
        frame.setVisible(true);
        
        
       /* frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 100);
        frame2.setLayout(new FlowLayout());
        frame2.getContentPane().add(btnSignup);
        frame2.setVisible(true);
        */
    }
}