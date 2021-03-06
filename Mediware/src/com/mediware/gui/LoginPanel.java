package com.mediware.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel implements ActionListener, MouseListener, KeyListener {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	/** Future Implementation of Forgot Username and Forgot Password functionality
	private JLabel lblForgotPassword;
	private JLabel lblforgotUsername;
	*/
	private IO logIO;
	
	/**
	 * LoginPanel Layout
	 */
	public LoginPanel(IO io) {
		logIO = io;
		
		setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblUsername = new JLabel("Username:");
		
		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.addKeyListener(this);
		
		JLabel lblPassword = new JLabel("Password:");
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.addKeyListener(this);
		
		//Login button
		btnLogin = new JButton("Login");
		btnLogin.addActionListener (this);
		
		/** Future Implementation of Forgot Username and Forgot Password functionality
		lblForgotPassword = new JLabel("<html><u>Forgot Password?</u></html>");
		lblForgotPassword.setForeground(Color.BLUE);
		lblForgotPassword.addMouseListener(this);
		
		lblforgotUsername = new JLabel("<html><u>Forgot Username?</u></html>");
		lblforgotUsername.setForeground(Color.BLUE);
		lblforgotUsername.addMouseListener (this);
		*/
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(107)
					.addComponent(btnLogin)
					.addContainerGap(274, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()));
//					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
//						.addComponent(lblForgotPassword, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//						.addComponent(lblforgotUsername, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
//		);
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
	//				.addComponent(lblforgotUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
	//				.addComponent(lblForgotPassword)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnLogin)
		{	// Login button was clicked
			// Create a message of type loginRequest to be sent to SYS with the username and password as
			// parameters
			int[] loginInts = new int[0];
			
			//getPassword returns character array - must convert to string
			//before putting into loginParams
			char[] thePW = txtPassword.getPassword();
			String strPW = new String(thePW);
			System.out.println(strPW);
			
			//create message and send message to SYS to check if user is valid
			String[] loginParams = {txtUsername.getText(), strPW};
			mData messageData = new mData(loginInts, loginParams);
			partition[] subscribers = {partition.SYS};
			logIO.createMessageToSend(partition.CND, subscribers, messageData, mType.loginRequest);
        }
	}

	/** Future Implementation of Forgot Username and Forgot Password functionality
	@Override
	public void mousePressed(MouseEvent event) {
		// Check to see what was clicked on
		
		if (event.getSource() == lblforgotUsername)
		{	// Forgot username button was clicked
			// create a message and send it to CND to display the Rtv username window
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			logIO.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayRtvUsername);
		}
		else if (event.getSource() == lblForgotPassword)
		{	// Forgot password button was clicked
			// create a message and send it to CND to display the Rtv password window
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			logIO.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayRtvPassword);
		}
		
	}
	 */
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

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		
		// Check which key was pressed
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{	// Enter button was pressed
			// Create a message of type loginRequest to be sent to SYS with the username and password as
			// parameters
			int[] loginInts = new int[0];
			
			//getPassword returns character array - must convert to string
			//before putting into loginParams
			char[] thePW = txtPassword.getPassword();
			String strPW = new String(thePW);
			System.out.println(strPW);
			
			//create message and send message to SYS to check if user is valid
			String[] loginParams = {txtUsername.getText(), strPW};
			mData messageData = new mData(loginInts, loginParams);
			partition[] subscribers = {partition.SYS};
			logIO.createMessageToSend(partition.CND, subscribers, messageData, mType.loginRequest);
		}
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


