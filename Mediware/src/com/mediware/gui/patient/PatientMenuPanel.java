package com.mediware.gui.patient;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientMenuPanel extends JPanel implements ActionListener, MouseListener {

	private JButton btnEnterVitals;
	private JButton btnMessagesAlerts;
	private JButton btnHealthHistory;
	private JButton btnEditProfile;
	private JLabel lbllogOut;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public PatientMenuPanel(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Patient", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Menu Options");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		btnEnterVitals = new JButton("Enter Vitals");
		GridBagConstraints gbc_btnEnterVitals = new GridBagConstraints();
		gbc_btnEnterVitals.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnterVitals.gridx = 4;
		gbc_btnEnterVitals.gridy = 2;
		add(btnEnterVitals, gbc_btnEnterVitals);
		btnEnterVitals.addActionListener(this);
		
		btnMessagesAlerts = new JButton("Messages / Alerts");
		GridBagConstraints gbc_btnMessagesAlerts = new GridBagConstraints();
		gbc_btnMessagesAlerts.insets = new Insets(0, 0, 5, 5);
		gbc_btnMessagesAlerts.gridx = 4;
		gbc_btnMessagesAlerts.gridy = 4;
		add(btnMessagesAlerts, gbc_btnMessagesAlerts);
		btnMessagesAlerts.addActionListener(this);
		
		btnHealthHistory = new JButton("Health History");
		GridBagConstraints gbc_btnHealthHistory = new GridBagConstraints();
		gbc_btnHealthHistory.insets = new Insets(0, 0, 5, 5);
		gbc_btnHealthHistory.gridx = 4;
		gbc_btnHealthHistory.gridy = 6;
		add(btnHealthHistory, gbc_btnHealthHistory);
		btnHealthHistory.addActionListener(this);
		
		btnEditProfile = new JButton("Edit Profile");
		GridBagConstraints gbc_btnEditProfile = new GridBagConstraints();
		gbc_btnEditProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditProfile.gridx = 4;
		gbc_btnEditProfile.gridy = 8;
		add(btnEditProfile, gbc_btnEditProfile);
		btnEditProfile.addActionListener(this);
		
		lbllogOut = new JLabel("<html><u>Log out</u></html>");
		lbllogOut.setForeground(Color.BLUE);
		GridBagConstraints gbc_lbllogOut = new GridBagConstraints();
		gbc_lbllogOut.gridwidth = 5;
		gbc_lbllogOut.gridx = 5;
		gbc_lbllogOut.gridy = 10;
		add(lbllogOut, gbc_lbllogOut);
		lbllogOut.addMouseListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnEnterVitals)
		{	// Enter Vitals button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientVitalsPanel);
        }
		else if (event.getSource() == btnMessagesAlerts)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.SYS, subscribers, messageData, mType.sysRequestMessages);
        }
		else if (event.getSource() == btnHealthHistory)
		{	// Health History button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientHealthHistory);
        }
		else if (event.getSource() == btnEditProfile)
		{	// Edit Profile Button was selected
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysPatientEditProfileRequest);
        }
	}
	
	public void mousePressed(MouseEvent event) {
		// Check to see what was clicked on
			
		if (event.getSource() == lbllogOut)
		{	// Log Out button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysLogoutRequest);
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
