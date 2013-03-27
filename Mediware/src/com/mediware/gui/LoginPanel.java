package com.mediware.gui;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblUsername = new JLabel("Username:");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		
		JLabel lblForgotPassword = new JLabel("<html><u>Forgot Password?</u></html>");
		lblForgotPassword.setForeground(Color.BLUE);
		
		JButton btnLogin = new JButton("Login");
		
		JLabel lblforgotUsername = new JLabel("<html><u>Forgot Username?</u></html>");
		lblforgotUsername.setForeground(Color.BLUE);
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
}
