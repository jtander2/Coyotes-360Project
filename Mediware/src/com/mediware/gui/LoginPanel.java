package com.mediware.gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.mediware.gui.doctor.DoctorMainPanel;
import com.mediware.service.LoginService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginPanel extends JPanel implements ActionListener, MouseListener {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblForgotPassword;
	private JLabel lblforgotUsername;
	private JFrame parentFrame;
	
	/**
	 * LoginPanel Layout
	 */
	public LoginPanel(JFrame parentFrame) {
		this.parentFrame = parentFrame;
		setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblUsername = new JLabel("Username:");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		
		lblForgotPassword = new JLabel("<html><u>Forgot Password?</u></html>");
		lblForgotPassword.setForeground(Color.BLUE);
		lblForgotPassword.addMouseListener(this);
		
		//Login button
		btnLogin = new JButton("Login");
		btnLogin.addActionListener (this);
		
		lblforgotUsername = new JLabel("<html><u>Forgot Username?</u></html>");
		lblforgotUsername.setForeground(Color.BLUE);
		lblforgotUsername.addMouseListener (this);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword)
							.addGap(18)
							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addComponent(btnLogin)
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblForgotPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblforgotUsername, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(9)
					.addComponent(btnLogin)
					.addGap(11)
					.addComponent(lblforgotUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblForgotPassword)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnLogin)
		{	// Login button was clicked
			
			// Check if name & pass are valid
    		if (LoginService.authenticate(txtUsername.getText(), txtPassword.getPassword().toString()))
    		{	// User is valid, so show their main panel based on their user type
    			parentFrame.getContentPane().add(new DoctorMainPanel(parentFrame));
    			setVisible(false);
    		}
    		else
    		{	// User is invalid
    			JOptionPane.showMessageDialog(parentFrame, "Invalid Username or Password", "Login Error", JOptionPane.ERROR_MESSAGE);
    		}
        }
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// Check to see what was clicked on
		
		if (event.getSource() == lblforgotUsername)
		{	// Forgot username button was clicked
			JDialog dlgRetrieveUsername = new RtvUsername();
			dlgRetrieveUsername.setVisible(true);
		}
		else if (event.getSource() == lblForgotPassword)
		{	// Forgot password button was clicked
			JDialog dlgRetrievePassword = new RtvPassword();
			dlgRetrievePassword.setVisible(true);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


