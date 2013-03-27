package com.mediware.gui.patient;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PatientProfilePanel extends JPanel {
	private JTextField textLast;
	private JTextField textMiddle;
	private JTextField textFirst;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JTextField textStreet;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZip;
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
	private JTextField textHome;
	private JTextField textWork;
	private JTextField textMobile;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblHealthInsurance;
	private JLabel lblProvider;
	private JTextField textProvider;
	private JLabel lblPolicy;
	private JLabel lblGroup;
	private JTextField textPolicy;
	private JTextField textGroup;
	private JButton btnNewButton;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public PatientProfilePanel() {
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
		
		textFirst = new JTextField();
		GridBagConstraints gbc_textFirst = new GridBagConstraints();
		gbc_textFirst.gridwidth = 2;
		gbc_textFirst.insets = new Insets(0, 0, 5, 5);
		gbc_textFirst.fill = GridBagConstraints.BOTH;
		gbc_textFirst.gridx = 2;
		gbc_textFirst.gridy = 0;
		add(textFirst, gbc_textFirst);
		textFirst.setColumns(10);
		
		textMiddle = new JTextField();
		GridBagConstraints gbc_textMiddle = new GridBagConstraints();
		gbc_textMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_textMiddle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMiddle.gridx = 4;
		gbc_textMiddle.gridy = 0;
		add(textMiddle, gbc_textMiddle);
		textMiddle.setColumns(10);
		
		textLast = new JTextField();
		GridBagConstraints gbc_textLast = new GridBagConstraints();
		gbc_textLast.gridwidth = 4;
		gbc_textLast.insets = new Insets(0, 0, 5, 5);
		gbc_textLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLast.gridx = 5;
		gbc_textLast.gridy = 0;
		add(textLast, gbc_textLast);
		textLast.setColumns(10);
		
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
		
		textStreet = new JTextField();
		GridBagConstraints gbc_textStreet = new GridBagConstraints();
		gbc_textStreet.gridwidth = 5;
		gbc_textStreet.insets = new Insets(0, 0, 5, 5);
		gbc_textStreet.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStreet.gridx = 2;
		gbc_textStreet.gridy = 2;
		add(textStreet, gbc_textStreet);
		textStreet.setColumns(10);
		
		lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 8));
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.gridwidth = 5;
		gbc_lblStreet.insets = new Insets(0, 0, 5, 5);
		gbc_lblStreet.gridx = 2;
		gbc_lblStreet.gridy = 3;
		add(lblStreet, gbc_lblStreet);
		
		textCity = new JTextField();
		GridBagConstraints gbc_textCity = new GridBagConstraints();
		gbc_textCity.gridwidth = 2;
		gbc_textCity.insets = new Insets(0, 0, 5, 5);
		gbc_textCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCity.gridx = 2;
		gbc_textCity.gridy = 4;
		add(textCity, gbc_textCity);
		textCity.setColumns(10);
		
		textState = new JTextField();
		GridBagConstraints gbc_textState = new GridBagConstraints();
		gbc_textState.insets = new Insets(0, 0, 5, 5);
		gbc_textState.fill = GridBagConstraints.HORIZONTAL;
		gbc_textState.gridx = 4;
		gbc_textState.gridy = 4;
		add(textState, gbc_textState);
		textState.setColumns(10);
		
		textZip = new JTextField();
		GridBagConstraints gbc_textZip = new GridBagConstraints();
		gbc_textZip.gridwidth = 2;
		gbc_textZip.insets = new Insets(0, 0, 5, 5);
		gbc_textZip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textZip.gridx = 5;
		gbc_textZip.gridy = 4;
		add(textZip, gbc_textZip);
		textZip.setColumns(10);
		
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
		
		textHome = new JTextField();
		GridBagConstraints gbc_textHome = new GridBagConstraints();
		gbc_textHome.gridwidth = 3;
		gbc_textHome.insets = new Insets(0, 0, 5, 5);
		gbc_textHome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHome.gridx = 3;
		gbc_textHome.gridy = 6;
		add(textHome, gbc_textHome);
		textHome.setColumns(10);
		
		lblWork = new JLabel("Work:");
		GridBagConstraints gbc_lblWork = new GridBagConstraints();
		gbc_lblWork.anchor = GridBagConstraints.EAST;
		gbc_lblWork.insets = new Insets(0, 0, 5, 5);
		gbc_lblWork.gridx = 2;
		gbc_lblWork.gridy = 7;
		add(lblWork, gbc_lblWork);
		
		textWork = new JTextField();
		GridBagConstraints gbc_textWork = new GridBagConstraints();
		gbc_textWork.gridwidth = 3;
		gbc_textWork.insets = new Insets(0, 0, 5, 5);
		gbc_textWork.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWork.gridx = 3;
		gbc_textWork.gridy = 7;
		add(textWork, gbc_textWork);
		textWork.setColumns(10);
		
		lblMobile = new JLabel("Mobile:");
		GridBagConstraints gbc_lblMobile = new GridBagConstraints();
		gbc_lblMobile.anchor = GridBagConstraints.EAST;
		gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobile.gridx = 2;
		gbc_lblMobile.gridy = 8;
		add(lblMobile, gbc_lblMobile);
		
		textMobile = new JTextField();
		GridBagConstraints gbc_textMobile = new GridBagConstraints();
		gbc_textMobile.gridwidth = 3;
		gbc_textMobile.insets = new Insets(0, 0, 5, 5);
		gbc_textMobile.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMobile.gridx = 3;
		gbc_textMobile.gridy = 8;
		add(textMobile, gbc_textMobile);
		textMobile.setColumns(10);
		
		lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 9;
		add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.gridwidth = 4;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 2;
		gbc_textEmail.gridy = 9;
		add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
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
		
		textProvider = new JTextField();
		GridBagConstraints gbc_textProvider = new GridBagConstraints();
		gbc_textProvider.gridwidth = 3;
		gbc_textProvider.insets = new Insets(0, 0, 5, 5);
		gbc_textProvider.fill = GridBagConstraints.HORIZONTAL;
		gbc_textProvider.gridx = 3;
		gbc_textProvider.gridy = 11;
		add(textProvider, gbc_textProvider);
		textProvider.setColumns(10);
		
		lblPolicy = new JLabel("Policy #");
		GridBagConstraints gbc_lblPolicy = new GridBagConstraints();
		gbc_lblPolicy.anchor = GridBagConstraints.EAST;
		gbc_lblPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_lblPolicy.gridx = 2;
		gbc_lblPolicy.gridy = 12;
		add(lblPolicy, gbc_lblPolicy);
		
		textPolicy = new JTextField();
		GridBagConstraints gbc_textPolicy = new GridBagConstraints();
		gbc_textPolicy.gridwidth = 3;
		gbc_textPolicy.insets = new Insets(0, 0, 5, 5);
		gbc_textPolicy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPolicy.gridx = 3;
		gbc_textPolicy.gridy = 12;
		add(textPolicy, gbc_textPolicy);
		textPolicy.setColumns(10);
		
		lblGroup = new JLabel("Group #");
		GridBagConstraints gbc_lblGroup = new GridBagConstraints();
		gbc_lblGroup.anchor = GridBagConstraints.EAST;
		gbc_lblGroup.insets = new Insets(0, 0, 5, 5);
		gbc_lblGroup.gridx = 2;
		gbc_lblGroup.gridy = 13;
		add(lblGroup, gbc_lblGroup);
		
		textGroup = new JTextField();
		GridBagConstraints gbc_textGroup = new GridBagConstraints();
		gbc_textGroup.gridwidth = 3;
		gbc_textGroup.insets = new Insets(0, 0, 5, 5);
		gbc_textGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGroup.gridx = 3;
		gbc_textGroup.gridy = 13;
		add(textGroup, gbc_textGroup);
		textGroup.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 15;
		add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("<html><u>Change_Password</u></html>");
		lblNewLabel_1.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 16;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		btnNewButton = new JButton("Save Changes");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 17;
		add(btnNewButton, gbc_btnNewButton);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 5;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 17;
		add(btnCancel, gbc_btnCancel);

	}

}
