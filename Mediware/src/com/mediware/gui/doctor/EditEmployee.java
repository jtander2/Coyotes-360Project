package com.mediware.gui.doctor;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class EditEmployee extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblEmail;
	private JTextField textField_10;
	private JButton btnNewButton;
	private JButton btnCancel;
	private JLabel lblNewLabel_1;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public EditEmployee() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "View/Edit Employee Profile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 67, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 0;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
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
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 5;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.gridwidth = 5;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 2;
		gbc_lblStreet.gridy = 3;
		add(lblStreet, gbc_lblStreet);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 4;
		add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 4;
		add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
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
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 4;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 6;
		add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		lblWork = new JLabel("Work:");
		GridBagConstraints gbc_lblWork = new GridBagConstraints();
		gbc_lblWork.anchor = GridBagConstraints.EAST;
		gbc_lblWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblWork.gridx = 2;
		gbc_lblWork.gridy = 7;
		add(lblWork, gbc_lblWork);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 4;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 3;
		gbc_textField_8.gridy = 7;
		add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		lblMobile = new JLabel("Mobile:");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 8;
		add(lblMobile, gbc_lblMobile);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.gridwidth = 4;
		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 8;
		add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		add(lblEmail, gbc_lblEmail);
		
		textField_10 = new JTextField();
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.gridwidth = 5;
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 2;
		gbc_textField_10.gridy = 9;
		add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Date of Birth:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_14 = new JTextField();
		GridBagConstraints gbc_textField_14 = new GridBagConstraints();
		gbc_textField_14.insets = new Insets(0, 0, 5, 5);
		gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_14.gridx = 2;
		gbc_textField_14.gridy = 10;
		add(textField_14, gbc_textField_14);
		textField_14.setColumns(10);
		
		lblNewLabel = new JLabel("Employee #");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField_15 = new JTextField();
		GridBagConstraints gbc_textField_15 = new GridBagConstraints();
		gbc_textField_15.insets = new Insets(0, 0, 5, 5);
		gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_15.gridx = 2;
		gbc_textField_15.gridy = 11;
		add(textField_15, gbc_textField_15);
		textField_15.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Admin Level:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 12;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Doctor", "Nurse", "Medical Assistant"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 12;
		add(comboBox, gbc_comboBox);
		
		btnNewButton = new JButton("Save Changes");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 14;
		add(btnNewButton, gbc_btnNewButton);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 5;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 14;
		add(btnCancel, gbc_btnCancel);

	}

}
