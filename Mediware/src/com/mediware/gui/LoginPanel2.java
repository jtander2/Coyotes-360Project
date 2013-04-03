package com.mediware.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.mediware.arch.IO;
import com.mediware.service.LoginService;

@SuppressWarnings("serial")
public class LoginPanel2 extends JPanel {
	 
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblForgotPassword;
    private JButton btnLogin;
    private boolean succeeded;
 
    public LoginPanel2(IO cndIO) {
    	JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.VERTICAL;
 
        lblUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lblUsername, cs);
 
        txtUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(txtUsername, cs);
 
        lblPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lblPassword, cs);
 
        txtPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(txtPassword, cs);
        
        lblForgotPassword = new JLabel("<html><u>Forgot password</u></html>");
        lblForgotPassword.setBorder(new LineBorder(Color.black));
        lblForgotPassword.setForeground(Color.blue);
        
        lblForgotPassword.addMouseListener(new MouseAdapter() {  
            public void mousePressed(MouseEvent me){  
                if(me.getButton() == MouseEvent.BUTTON1){ 
                	JOptionPane.showMessageDialog(null, "This is where the forgot password area will be !", "Forgot Password", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
 
        btnLogin = new JButton("Login");
 
        btnLogin.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                if (LoginService.authenticate(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(LoginPanel2.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                } else {
                    JOptionPane.showMessageDialog(LoginPanel2.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    txtUsername.setText("");
                    txtPassword.setText("");
                    succeeded = false;
 
                }
            }
        });
        
        JPanel bPanel = new JPanel();
        bPanel.setSize(new Dimension(50, 200));
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.Y_AXIS));
        bPanel.add(Box.createRigidArea (new Dimension (0, 20)));
        bPanel.add(lblForgotPassword);
        bPanel.add(Box.createRigidArea (new Dimension (0, 20)));
        bPanel.add(btnLogin);
 
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.add(bPanel, BorderLayout.CENTER);
        this.setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.gray), "Login:"));
    }
 
    public String getUsername() {
        return txtUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(txtPassword.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
}
