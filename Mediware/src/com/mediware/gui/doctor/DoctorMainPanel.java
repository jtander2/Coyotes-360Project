package com.mediware.gui.doctor;

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
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class DoctorMainPanel extends JPanel  implements ActionListener, MouseListener {

	/**
	 * Create the panel.
	 */
	private IO io;
	private JButton btnPatientSearch;
	private JButton btnMessagesAlerts;
	private JButton btnCreateNewPatient;
	private JButton btnCreateNewEmployee;
	private JButton btnEditEmployee;
	private JLabel lbllogOut;
	
	public DoctorMainPanel(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(null, "Doctor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Menu Options");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Patient");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		btnPatientSearch = new JButton("Patient Search");
		GridBagConstraints gbc_btnPatientSearch = new GridBagConstraints();
		gbc_btnPatientSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnPatientSearch.gridx = 4;
		gbc_btnPatientSearch.gridy = 3;
		add(btnPatientSearch, gbc_btnPatientSearch);
		btnPatientSearch.addActionListener (this);
		
		btnMessagesAlerts = new JButton("Messages / Alerts");
		GridBagConstraints gbc_btnMessagesAlerts = new GridBagConstraints();
		gbc_btnMessagesAlerts.insets = new Insets(0, 0, 5, 5);
		gbc_btnMessagesAlerts.gridx = 4;
		gbc_btnMessagesAlerts.gridy = 4;
		add(btnMessagesAlerts, gbc_btnMessagesAlerts);
		btnMessagesAlerts.addActionListener (this);
		
		JLabel lblNewLabel_1 = new JLabel("Administrative");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 6;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnCreateNewPatient = new JButton("Create New Patient");
		GridBagConstraints gbc_btnCreateNewPatient = new GridBagConstraints();
		gbc_btnCreateNewPatient.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewPatient.gridx = 4;
		gbc_btnCreateNewPatient.gridy = 7;
		add(btnCreateNewPatient, gbc_btnCreateNewPatient);
		btnCreateNewPatient.addActionListener (this);
		
		btnCreateNewEmployee = new JButton("Create New Employee");
		GridBagConstraints gbc_btnCreateNewEmployee = new GridBagConstraints();
		gbc_btnCreateNewEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateNewEmployee.gridx = 4;
		gbc_btnCreateNewEmployee.gridy = 8;
		add(btnCreateNewEmployee, gbc_btnCreateNewEmployee);
		btnCreateNewEmployee.addActionListener (this);
		
		btnEditEmployee = new JButton("Edit Employee");
		GridBagConstraints gbc_btnEditEmployee = new GridBagConstraints();
		gbc_btnEditEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditEmployee.gridx = 4;
		gbc_btnEditEmployee.gridy = 9;
		add(btnEditEmployee, gbc_btnEditEmployee);
		btnEditEmployee.addActionListener (this);
		
		lbllogOut = new JLabel("<html><u>Log out</u></html>");
		lbllogOut.setForeground(Color.BLUE);
		GridBagConstraints gbc_lbllogOut = new GridBagConstraints();
		gbc_lbllogOut.gridwidth = 4;
		gbc_lbllogOut.gridx = 5;
		gbc_lbllogOut.gridy = 11;
		add(lbllogOut, gbc_lbllogOut);
		lbllogOut.addMouseListener(this);

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnPatientSearch)
		{	// Patient Search button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientSearchPanel);
        }
		else if (event.getSource() == btnMessagesAlerts)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayMessagePanel);
        }
		else if (event.getSource() == btnCreateNewPatient)
		{	// Create New Patient button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayNewPatientPanel);
			
        }
		else if (event.getSource() == btnCreateNewEmployee)
		{	// Create New Employee button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayNewEmployeePanel);
			
        }
		else if (event.getSource() == btnEditEmployee)
		{	// Edit Employee button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayEditEmployee);
        }
	}
		
	@Override
	public void mousePressed(MouseEvent event) {
		// Check to see what was clicked on
			
		if (event.getSource() == lbllogOut)
		{	// Log Out button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayLoginPanel);
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
