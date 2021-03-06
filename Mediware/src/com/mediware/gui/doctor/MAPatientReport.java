package com.mediware.gui.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MAPatientReport extends JPanel implements ActionListener {
	private JTextField textFieldDOB;
	private JTextField textFieldFirstName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldLastName;
	private JTextField textFieldHeight;
	private JTextField textFieldWeight;
	private JButton btnTakeVitals;
	private JButton btnViewProfile;
	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public MAPatientReport(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(null, "Patient Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 136, 61, 105, 51, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		textFieldFirstName = new JTextField();
		GridBagConstraints gbc_textFieldFirstName = new GridBagConstraints();
		gbc_textFieldFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFirstName.gridx = 2;
		gbc_textFieldFirstName.gridy = 1;
		add(textFieldFirstName, gbc_textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMiddleName = new JTextField();
		GridBagConstraints gbc_textFieldMiddleName = new GridBagConstraints();
		gbc_textFieldMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMiddleName.gridx = 3;
		gbc_textFieldMiddleName.gridy = 1;
		add(textFieldMiddleName, gbc_textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		
		textFieldLastName = new JTextField();
		GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
		gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLastName.gridx = 4;
		gbc_textFieldLastName.gridy = 1;
		add(textFieldLastName, gbc_textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblFirst = new JLabel("First");
		lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblFirst = new GridBagConstraints();
		gbc_lblFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirst.gridx = 2;
		gbc_lblFirst.gridy = 2;
		add(lblFirst, gbc_lblFirst);
		
		JLabel lblMiddle = new JLabel("Middle");
		lblMiddle.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
		gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddle.gridx = 3;
		gbc_lblMiddle.gridy = 2;
		add(lblMiddle, gbc_lblMiddle);
		
		JLabel lblLast = new JLabel("Last");
		lblLast.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblLast = new GridBagConstraints();
		gbc_lblLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblLast.gridx = 4;
		gbc_lblLast.gridy = 2;
		add(lblLast, gbc_lblLast);
		
		JLabel lblDOB = new JLabel("Date of Birth:");
		GridBagConstraints gbc_lblDOB = new GridBagConstraints();
		gbc_lblDOB.insets = new Insets(0, 0, 5, 5);
		gbc_lblDOB.anchor = GridBagConstraints.BELOW_BASELINE_TRAILING;
		gbc_lblDOB.gridx = 1;
		gbc_lblDOB.gridy = 3;
		add(lblDOB, gbc_lblDOB);
		
		textFieldDOB = new JTextField();
		GridBagConstraints gbc_textFieldDOB = new GridBagConstraints();
		gbc_textFieldDOB.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDOB.gridx = 2;
		gbc_textFieldDOB.gridy = 3;
		add(textFieldDOB, gbc_textFieldDOB);
		textFieldDOB.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 3;
		gbc_lblHeight.gridy = 3;
		add(lblHeight, gbc_lblHeight);
		
		textFieldHeight = new JTextField();
		GridBagConstraints gbc_textFieldHeight = new GridBagConstraints();
		gbc_textFieldHeight.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHeight.gridx = 4;
		gbc_textFieldHeight.gridy = 3;
		add(textFieldHeight, gbc_textFieldHeight);
		textFieldHeight.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeight.gridx = 3;
		gbc_lblWeight.gridy = 4;
		add(lblWeight, gbc_lblWeight);
		
		textFieldWeight = new JTextField();
		GridBagConstraints gbc_textFieldWeight = new GridBagConstraints();
		gbc_textFieldWeight.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWeight.gridx = 4;
		gbc_textFieldWeight.gridy = 4;
		add(textFieldWeight, gbc_textFieldWeight);
		textFieldWeight.setColumns(10);
		
		btnTakeVitals = new JButton("Take Vitals");
		GridBagConstraints gbc_btnTakeVitals = new GridBagConstraints();
		gbc_btnTakeVitals.insets = new Insets(0, 0, 5, 5);
		gbc_btnTakeVitals.gridx = 2;
		gbc_btnTakeVitals.gridy = 6;
		add(btnTakeVitals, gbc_btnTakeVitals);
		
		btnViewProfile = new JButton("View/Edit Profile");
		GridBagConstraints gbc_btnViewProfile = new GridBagConstraints();
		gbc_btnViewProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewProfile.gridx = 2;
		gbc_btnViewProfile.gridy = 7;
		add(btnViewProfile, gbc_btnViewProfile);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 7;
		add(btnCancel, gbc_btnCancel);

	}

	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnTakeVitals)
		{	// Patient Search button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientSearchPanel);
        }
		else if (event.getSource() == btnViewProfile)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayMessagePanel);
        }
		else if (event.getSource() == btnCancel)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayMessagePanel);
        }
		
	}

}
