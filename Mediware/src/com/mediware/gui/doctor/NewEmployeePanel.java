package com.mediware.gui.doctor;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class NewEmployeePanel extends JPanel implements ActionListener {
	private JTextField textFieldLastName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldFirstName;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JTextField textFieldStreet;
	private JTextField textFieldCity;
	private JTextField textFieldState;
	private JTextField textFieldZipCode;
	private JLabel lblMiddle;
	private JLabel lblFirst;
	private JLabel lblLast;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZip;
	private JLabel lblStreet;
	private JLabel lblHome;
	private JLabel lblWork;
	private JLabel lblMobile;
	private JTextField textFieldHomePhone;
	private JTextField textFieldWorkPhone;
	private JTextField textFieldMobilePhone;
	private JLabel lblEmail;
	private JTextField textFieldEmail;
	private JButton btnCreate;
	private JButton btnCancel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldDOB;
	private JTextField textFieldEmployeeNumber;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblNewLabel;
	private JTextField textFieldUsername;
	private JLabel lblNewLabel_2;
	private JTextField textFieldPassword;
	private JComboBox comboBoxAdminLevel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public NewEmployeePanel(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Create New Employee", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 67, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		textFieldFirstName = new JTextField();
		GridBagConstraints gbc_textFieldFirstName = new GridBagConstraints();
		gbc_textFieldFirstName.gridwidth = 2;
		gbc_textFieldFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFirstName.fill = GridBagConstraints.BOTH;
		gbc_textFieldFirstName.gridx = 2;
		gbc_textFieldFirstName.gridy = 0;
		add(textFieldFirstName, gbc_textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMiddleName = new JTextField();
		GridBagConstraints gbc_textFieldMiddleName = new GridBagConstraints();
		gbc_textFieldMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMiddleName.gridx = 4;
		gbc_textFieldMiddleName.gridy = 0;
		add(textFieldMiddleName, gbc_textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		
		textFieldLastName = new JTextField();
		GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
		gbc_textFieldLastName.gridwidth = 4;
		gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLastName.gridx = 5;
		gbc_textFieldLastName.gridy = 0;
		add(textFieldLastName, gbc_textFieldLastName);
		textFieldLastName.setColumns(10);
		
		lblFirst = new JLabel("First");
		lblFirst.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblFirst = new GridBagConstraints();
		gbc_lblFirst.gridwidth = 2;
		gbc_lblFirst.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirst.gridx = 2;
		gbc_lblFirst.gridy = 1;
		add(lblFirst, gbc_lblFirst);
		
		lblMiddle = new JLabel("Middle");
		lblMiddle.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblMiddle = new GridBagConstraints();
		gbc_lblMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddle.gridx = 4;
		gbc_lblMiddle.gridy = 1;
		add(lblMiddle, gbc_lblMiddle);
		
		lblLast = new JLabel("Last");
		lblLast.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblLast = new GridBagConstraints();
		gbc_lblLast.gridwidth = 3;
		gbc_lblLast.insets = new Insets(0, 0, 5, 5);
		gbc_lblLast.gridx = 5;
		gbc_lblLast.gridy = 1;
		add(lblLast, gbc_lblLast);
		
		lblAddress = new JLabel("Address:");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.WEST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 2;
		add(lblAddress, gbc_lblAddress);
		
		textFieldStreet = new JTextField();
		GridBagConstraints gbc_textFieldStreet = new GridBagConstraints();
		gbc_textFieldStreet.gridwidth = 5;
		gbc_textFieldStreet.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStreet.gridx = 2;
		gbc_textFieldStreet.gridy = 2;
		add(textFieldStreet, gbc_textFieldStreet);
		textFieldStreet.setColumns(10);
		
		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.gridwidth = 5;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 2;
		gbc_lblStreet.gridy = 3;
		add(lblStreet, gbc_lblStreet);
		
		textFieldCity = new JTextField();
		GridBagConstraints gbc_textFieldCity = new GridBagConstraints();
		gbc_textFieldCity.gridwidth = 2;
		gbc_textFieldCity.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCity.gridx = 2;
		gbc_textFieldCity.gridy = 4;
		add(textFieldCity, gbc_textFieldCity);
		textFieldCity.setColumns(10);
		
		textFieldState = new JTextField();
		GridBagConstraints gbc_textFieldState = new GridBagConstraints();
		gbc_textFieldState.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldState.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldState.gridx = 4;
		gbc_textFieldState.gridy = 4;
		add(textFieldState, gbc_textFieldState);
		textFieldState.setColumns(10);
		
		textFieldZipCode = new JTextField();
		GridBagConstraints gbc_textFieldZipCode = new GridBagConstraints();
		gbc_textFieldZipCode.gridwidth = 2;
		gbc_textFieldZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldZipCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZipCode.gridx = 5;
		gbc_textFieldZipCode.gridy = 4;
		add(textFieldZipCode, gbc_textFieldZipCode);
		textFieldZipCode.setColumns(10);
		
		lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.gridwidth = 2;
		gbc_lblCity.insets = new Insets(0, 0, 5, 5);
		gbc_lblCity.gridx = 2;
		gbc_lblCity.gridy = 5;
		add(lblCity, gbc_lblCity);
		
		lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 4;
		gbc_lblState.gridy = 5;
		add(lblState, gbc_lblState);
		
		lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblZip = new GridBagConstraints();
		gbc_lblZip.gridwidth = 2;
		gbc_lblZip.insets = new Insets(0, 0, 5, 5);
		gbc_lblZip.gridx = 5;
		gbc_lblZip.gridy = 5;
		add(lblZip, gbc_lblZip);
		
		lblPhone = new JLabel("Phone:");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.WEST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 6;
		add(lblPhone, gbc_lblPhone);
		
		lblHome = new JLabel("Home:");
		GridBagConstraints gbc_lblHome = new GridBagConstraints();
		gbc_lblHome.anchor = GridBagConstraints.EAST;
		gbc_lblHome.insets = new Insets(0, 0, 5, 5);
		gbc_lblHome.gridx = 2;
		gbc_lblHome.gridy = 6;
		add(lblHome, gbc_lblHome);
		
		textFieldHomePhone = new JTextField();
		GridBagConstraints gbc_textFieldHomePhone = new GridBagConstraints();
		gbc_textFieldHomePhone.gridwidth = 4;
		gbc_textFieldHomePhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHomePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHomePhone.gridx = 3;
		gbc_textFieldHomePhone.gridy = 6;
		add(textFieldHomePhone, gbc_textFieldHomePhone);
		textFieldHomePhone.setColumns(10);
		
		lblWork = new JLabel("Work:");
		GridBagConstraints gbc_lblWork = new GridBagConstraints();
		gbc_lblWork.anchor = GridBagConstraints.EAST;
		gbc_lblWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblWork.gridx = 2;
		gbc_lblWork.gridy = 7;
		add(lblWork, gbc_lblWork);
		
		textFieldWorkPhone = new JTextField();
		GridBagConstraints gbc_textFieldWorkPhone = new GridBagConstraints();
		gbc_textFieldWorkPhone.gridwidth = 4;
		gbc_textFieldWorkPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWorkPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWorkPhone.gridx = 3;
		gbc_textFieldWorkPhone.gridy = 7;
		add(textFieldWorkPhone, gbc_textFieldWorkPhone);
		textFieldWorkPhone.setColumns(10);
		
		lblMobile = new JLabel("Mobile:");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 8;
		add(lblMobile, gbc_lblMobile);
		
		textFieldMobilePhone = new JTextField();
		GridBagConstraints gbc_textFieldMobilePhone = new GridBagConstraints();
		gbc_textFieldMobilePhone.gridwidth = 4;
		gbc_textFieldMobilePhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMobilePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMobilePhone.gridx = 3;
		gbc_textFieldMobilePhone.gridy = 8;
		add(textFieldMobilePhone, gbc_textFieldMobilePhone);
		textFieldMobilePhone.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 5;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 9;
		add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Date of Birth:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldDOB = new JTextField();
		GridBagConstraints gbc_textFieldDOB = new GridBagConstraints();
		gbc_textFieldDOB.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDOB.gridx = 2;
		gbc_textFieldDOB.gridy = 10;
		add(textFieldDOB, gbc_textFieldDOB);
		textFieldDOB.setColumns(10);
		
		lblNewLabel = new JLabel("Employee #");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldEmployeeNumber = new JTextField();
		GridBagConstraints gbc_textFieldEmployeeNumber = new GridBagConstraints();
		gbc_textFieldEmployeeNumber.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmployeeNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmployeeNumber.gridx = 2;
		gbc_textFieldEmployeeNumber.gridy = 11;
		add(textFieldEmployeeNumber, gbc_textFieldEmployeeNumber);
		textFieldEmployeeNumber.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Admin Level:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 12;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBoxAdminLevel = new JComboBox();
		comboBoxAdminLevel.setMaximumRowCount(3);
		comboBoxAdminLevel.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Nurse", "Medical Assistant"}));
		GridBagConstraints gbc_comboBoxAdminLevel = new GridBagConstraints();
		gbc_comboBoxAdminLevel.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAdminLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAdminLevel.gridx = 2;
		gbc_comboBoxAdminLevel.gridy = 12;
		add(comboBoxAdminLevel, gbc_comboBoxAdminLevel);
		
		lblUsername = new JLabel("Username:");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 13;
		add(lblUsername, gbc_lblUsername);
		
		textFieldUsername = new JTextField();
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsername.gridx = 2;
		gbc_textFieldUsername.gridy = 13;
		add(textFieldUsername, gbc_textFieldUsername);
		textFieldUsername.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 14;
		add(lblPassword, gbc_lblPassword);
		
		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 2;
		gbc_textFieldPassword.gridy = 14;
		add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnCreate = new JButton("Create");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 16;
		add(btnCreate, gbc_btnCreate);
		btnCreate.addActionListener (this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 5;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 16;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener (this);

	}

	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnCreate)
		{	// Employee Create button was pressed
			int[] intParams = new int[0];
			String[] stringParams = {textFieldFirstName.getText(),      textFieldMiddleName.getText(), 
									 textFieldLastName.getText(),       textFieldStreet.getText(), 
									 textFieldCity.getText(),           textFieldState.getText(), 
									 textFieldZipCode.getText(),        textFieldHomePhone.getText(), 
									 textFieldWorkPhone.getText(),      textFieldMobilePhone.getText(), 
									 textFieldEmail.getText(),          textFieldDOB.getText(),
									 textFieldEmployeeNumber.getText(), (String)comboBoxAdminLevel.getSelectedItem(),
									 textFieldUsername.getText(),       textFieldPassword.getText()};
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysCreateEmployee);
        }
		else if (event.getSource() == btnCancel)
		{	// Cancel button was pressed
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToMenu);
        }
		
	}

}
