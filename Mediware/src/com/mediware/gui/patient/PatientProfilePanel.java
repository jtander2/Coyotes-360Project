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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientProfilePanel extends JPanel implements ActionListener, MouseListener {
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
	private JLabel lblHealthInsurance;
	private JLabel lblProvider;
	private JTextField textFieldProvider;
	private JLabel lblPolicy;
	private JLabel lblGroup;
	private JTextField textFieldPolicy;
	private JTextField textFieldGroup;
	private JButton btnSaveChanges;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	private JLabel lblChangePassword;
	private IO io;
	private int from;


	/**
	 * Create the panel.
	 * @param cndIO 
	 * @param from 
	 */
	public PatientProfilePanel(IO cndIO, String[] patientData, int from) {
		
		this.io = cndIO;
		this.from = from;
		
		setBorder(new TitledBorder(null, "Profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		textFieldFirstName.setText(patientData[0]);
		
		textFieldMiddleName = new JTextField();
		GridBagConstraints gbc_textFieldMiddleName = new GridBagConstraints();
		gbc_textFieldMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMiddleName.gridx = 4;
		gbc_textFieldMiddleName.gridy = 0;
		add(textFieldMiddleName, gbc_textFieldMiddleName);
		textFieldMiddleName.setColumns(10);
		textFieldMiddleName.setText(patientData[1]);
		
		textFieldLastName = new JTextField();
		GridBagConstraints gbc_textFieldLastName = new GridBagConstraints();
		gbc_textFieldLastName.gridwidth = 4;
		gbc_textFieldLastName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLastName.gridx = 5;
		gbc_textFieldLastName.gridy = 0;
		add(textFieldLastName, gbc_textFieldLastName);
		textFieldLastName.setColumns(10);
		textFieldLastName.setText(patientData[2]);
		
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
		textFieldStreet.setText(patientData[3]);
		
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
		textFieldCity.setText(patientData[4]);
		
		textFieldState = new JTextField();
		GridBagConstraints gbc_textFieldState = new GridBagConstraints();
		gbc_textFieldState.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldState.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldState.gridx = 4;
		gbc_textFieldState.gridy = 4;
		add(textFieldState, gbc_textFieldState);
		textFieldState.setColumns(10);
		textFieldState.setText(patientData[5]);
		
		textFieldZipCode = new JTextField();
		GridBagConstraints gbc_textFieldZipCode = new GridBagConstraints();
		gbc_textFieldZipCode.gridwidth = 2;
		gbc_textFieldZipCode.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldZipCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldZipCode.gridx = 5;
		gbc_textFieldZipCode.gridy = 4;
		add(textFieldZipCode, gbc_textFieldZipCode);
		textFieldZipCode.setColumns(10);
		textFieldZipCode.setText(patientData[6]);
		
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
		gbc_textFieldHomePhone.gridwidth = 3;
		gbc_textFieldHomePhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldHomePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHomePhone.gridx = 3;
		gbc_textFieldHomePhone.gridy = 6;
		add(textFieldHomePhone, gbc_textFieldHomePhone);
		textFieldHomePhone.setColumns(10);
		textFieldHomePhone.setText(patientData[7]);
		
		lblWork = new JLabel("Work:");
		GridBagConstraints gbc_lblWork = new GridBagConstraints();
		gbc_lblWork.anchor = GridBagConstraints.EAST;
		gbc_lblWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblWork.gridx = 2;
		gbc_lblWork.gridy = 7;
		add(lblWork, gbc_lblWork);
		
		textFieldWorkPhone = new JTextField();
		GridBagConstraints gbc_textFieldWorkPhone = new GridBagConstraints();
		gbc_textFieldWorkPhone.gridwidth = 3;
		gbc_textFieldWorkPhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWorkPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWorkPhone.gridx = 3;
		gbc_textFieldWorkPhone.gridy = 7;
		add(textFieldWorkPhone, gbc_textFieldWorkPhone);
		textFieldWorkPhone.setColumns(10);
		textFieldWorkPhone.setText(patientData[8]);
		
		lblMobile = new JLabel("Mobile:");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 8;
		add(lblMobile, gbc_lblMobile);
		
		textFieldMobilePhone = new JTextField();
		GridBagConstraints gbc_textFieldMobilePhone = new GridBagConstraints();
		gbc_textFieldMobilePhone.gridwidth = 3;
		gbc_textFieldMobilePhone.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMobilePhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldMobilePhone.gridx = 3;
		gbc_textFieldMobilePhone.gridy = 8;
		add(textFieldMobilePhone, gbc_textFieldMobilePhone);
		textFieldMobilePhone.setColumns(10);
		textFieldMobilePhone.setText(patientData[9]);
		
		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 4;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 9;
		add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setText(patientData[10]);
		
		lblHealthInsurance = new JLabel("Health Insurance Information:");
		GridBagConstraints gbc_lblHealthInsurance = new GridBagConstraints();
		gbc_lblHealthInsurance.anchor = GridBagConstraints.WEST;
		gbc_lblHealthInsurance.gridwidth = 4;
		gbc_lblHealthInsurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealthInsurance.gridx = 1;
		gbc_lblHealthInsurance.gridy = 10;
		add(lblHealthInsurance, gbc_lblHealthInsurance);
		
		lblProvider = new JLabel("Provider:");
		GridBagConstraints gbc_lblProvider = new GridBagConstraints();
		gbc_lblProvider.anchor = GridBagConstraints.EAST;
		gbc_lblProvider.insets = new Insets(0, 0, 5, 5);
		gbc_lblProvider.gridx = 2;
		gbc_lblProvider.gridy = 11;
		add(lblProvider, gbc_lblProvider);
		
		textFieldProvider = new JTextField();
		GridBagConstraints gbc_textFieldProvider = new GridBagConstraints();
		gbc_textFieldProvider.gridwidth = 3;
		gbc_textFieldProvider.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProvider.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProvider.gridx = 3;
		gbc_textFieldProvider.gridy = 11;
		add(textFieldProvider, gbc_textFieldProvider);
		textFieldProvider.setColumns(10);
		textFieldProvider.setText(patientData[11]);
		
		lblPolicy = new JLabel("Policy #");
		GridBagConstraints gbc_lblPolicy = new GridBagConstraints();
		gbc_lblPolicy.anchor = GridBagConstraints.EAST;
		gbc_lblPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_lblPolicy.gridx = 2;
		gbc_lblPolicy.gridy = 12;
		add(lblPolicy, gbc_lblPolicy);
		
		textFieldPolicy = new JTextField();
		GridBagConstraints gbc_textFieldPolicy = new GridBagConstraints();
		gbc_textFieldPolicy.gridwidth = 3;
		gbc_textFieldPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPolicy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPolicy.gridx = 3;
		gbc_textFieldPolicy.gridy = 12;
		add(textFieldPolicy, gbc_textFieldPolicy);
		textFieldPolicy.setColumns(10);
		textFieldPolicy.setText(patientData[12]);
		
		lblGroup = new JLabel("Group #");
		GridBagConstraints gbc_lblGroup = new GridBagConstraints();
		gbc_lblGroup.anchor = GridBagConstraints.EAST;
		gbc_lblGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblGroup.gridx = 2;
		gbc_lblGroup.gridy = 13;
		add(lblGroup, gbc_lblGroup);
		
		textFieldGroup = new JTextField();
		GridBagConstraints gbc_textFieldGroup = new GridBagConstraints();
		gbc_textFieldGroup.gridwidth = 3;
		gbc_textFieldGroup.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldGroup.gridx = 3;
		gbc_textFieldGroup.gridy = 13;
		add(textFieldGroup, gbc_textFieldGroup);
		textFieldGroup.setColumns(10);
		textFieldGroup.setText(patientData[13]);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 15;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblChangePassword = new JLabel("<html><u>Change_Password</u></html>");
		lblChangePassword.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblChangePassword = new GridBagConstraints();
		gbc_lblChangePassword.anchor = GridBagConstraints.WEST;
		gbc_lblChangePassword.gridwidth = 2;
		gbc_lblChangePassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblChangePassword.gridx = 1;
		gbc_lblChangePassword.gridy = 16;
		add(lblChangePassword, gbc_lblChangePassword);
		lblChangePassword.addMouseListener(this);
		
		btnSaveChanges = new JButton("Save Changes");
		GridBagConstraints gbc_btnSaveChanges = new GridBagConstraints();
		gbc_btnSaveChanges.insets = new Insets(0, 0, 0, 5);
		gbc_btnSaveChanges.gridx = 2;
		gbc_btnSaveChanges.gridy = 17;
		add(btnSaveChanges, gbc_btnSaveChanges);
		btnSaveChanges.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 5;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 17;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnSaveChanges)
		{	// Patient Search button was clicked
			int[] intParams = new int[0];
			String[] stringParams = {textFieldFirstName.getText(), textFieldMiddleName.getText(), 
					 textFieldLastName.getText(),  textFieldStreet.getText(), 
					 textFieldCity.getText(),      textFieldState.getText(), 
					 textFieldZipCode.getText(),   textFieldHomePhone.getText(), 
					 textFieldWorkPhone.getText(), textFieldMobilePhone.getText(), 
					 textFieldEmail.getText(),     textFieldProvider.getText(), 
					 textFieldPolicy.getText(),    textFieldGroup.getText()};
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysUpdatePatient);
        }
		else if (event.getSource() == btnCancel)
		{	// Cancel button was pressed
			if(from == 0) {
				int[] intParams = new int[0];
				String[] stringParams = new String[0];
				mData messageData = new mData(intParams, stringParams);
				partition[] subscribers = {partition.SYS};
				io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToMenu);
			} else {
				int[] intParams = new int[0];
				String[] stringParams = new String[0];
				mData messageData = new mData(intParams, stringParams);
				partition[] subscribers = {partition.SYS};
				io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToViewedPatientMenu);
			}
        }
		
	}
	
	public void mousePressed(MouseEvent event) {
		// Check to see what was clicked on
			
		if (event.getSource() == lblChangePassword)
		{	// Change password button was pressed
			
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
