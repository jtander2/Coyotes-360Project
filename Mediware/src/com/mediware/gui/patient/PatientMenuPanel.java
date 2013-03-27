package com.mediware.gui.patient;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PatientMenuPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public PatientMenuPanel() {
		
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
		
		JButton btnNewButton_1 = new JButton("Enter Vitals");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 2;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Messages / Alerts");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 4;
		gbc_btnNewButton_2.gridy = 4;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnCreateEmployeeProfile = new JButton("Health History");
		GridBagConstraints gbc_btnCreateEmployeeProfile = new GridBagConstraints();
		gbc_btnCreateEmployeeProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateEmployeeProfile.gridx = 4;
		gbc_btnCreateEmployeeProfile.gridy = 6;
		add(btnCreateEmployeeProfile, gbc_btnCreateEmployeeProfile);
		
		JButton btnNewButton = new JButton("Edit Profile");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 8;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lbllogOut = new JLabel("<html><u>Log out</u></html>");
		lbllogOut.setForeground(Color.BLUE);
		GridBagConstraints gbc_lbllogOut = new GridBagConstraints();
		gbc_lbllogOut.gridwidth = 5;
		gbc_lbllogOut.gridx = 5;
		gbc_lbllogOut.gridy = 10;
		add(lbllogOut, gbc_lbllogOut);

	}

}
