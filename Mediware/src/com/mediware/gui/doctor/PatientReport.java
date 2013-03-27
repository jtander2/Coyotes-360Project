package com.mediware.gui.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;

@SuppressWarnings("serial")
public class PatientReport extends JPanel {
	private JTextField textDOB;
	private JTextField textFirst;
	private JTextField textMiddle;
	private JTextField textLast;
	private JTextField textHeight;
	private JTextField textWeight;

	/**
	 * Create the panel.
	 */
	public PatientReport() {
		setBorder(new TitledBorder(null, "Patient Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 136, 61, 105, 51, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		add(lblName, gbc_lblName);
		
		textFirst = new JTextField();
		GridBagConstraints gbc_textFirst = new GridBagConstraints();
		gbc_textFirst.insets = new Insets(0, 0, 5, 5);
		gbc_textFirst.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFirst.gridx = 2;
		gbc_textFirst.gridy = 1;
		add(textFirst, gbc_textFirst);
		textFirst.setColumns(10);
		
		textMiddle = new JTextField();
		GridBagConstraints gbc_textMiddle = new GridBagConstraints();
		gbc_textMiddle.insets = new Insets(0, 0, 5, 5);
		gbc_textMiddle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMiddle.gridx = 3;
		gbc_textMiddle.gridy = 1;
		add(textMiddle, gbc_textMiddle);
		textMiddle.setColumns(10);
		
		textLast = new JTextField();
		GridBagConstraints gbc_textLast = new GridBagConstraints();
		gbc_textLast.insets = new Insets(0, 0, 5, 5);
		gbc_textLast.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLast.gridx = 4;
		gbc_textLast.gridy = 1;
		add(textLast, gbc_textLast);
		textLast.setColumns(10);
		
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
		
		textDOB = new JTextField();
		GridBagConstraints gbc_textDOB = new GridBagConstraints();
		gbc_textDOB.insets = new Insets(0, 0, 5, 5);
		gbc_textDOB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDOB.gridx = 2;
		gbc_textDOB.gridy = 3;
		add(textDOB, gbc_textDOB);
		textDOB.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		GridBagConstraints gbc_lblHeight = new GridBagConstraints();
		gbc_lblHeight.anchor = GridBagConstraints.EAST;
		gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeight.gridx = 3;
		gbc_lblHeight.gridy = 3;
		add(lblHeight, gbc_lblHeight);
		
		textHeight = new JTextField();
		GridBagConstraints gbc_textHeight = new GridBagConstraints();
		gbc_textHeight.insets = new Insets(0, 0, 5, 5);
		gbc_textHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeight.gridx = 4;
		gbc_textHeight.gridy = 3;
		add(textHeight, gbc_textHeight);
		textHeight.setColumns(10);
		
		JLabel lblWeight = new JLabel("Weight:");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeight.gridx = 3;
		gbc_lblWeight.gridy = 4;
		add(lblWeight, gbc_lblWeight);
		
		textWeight = new JTextField();
		GridBagConstraints gbc_textWeight = new GridBagConstraints();
		gbc_textWeight.insets = new Insets(0, 0, 5, 5);
		gbc_textWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWeight.gridx = 4;
		gbc_textWeight.gridy = 4;
		add(textWeight, gbc_textWeight);
		textWeight.setColumns(10);
		
		JButton btnTakeVitals = new JButton("Take Vitals");
		GridBagConstraints gbc_btnTakeVitals = new GridBagConstraints();
		gbc_btnTakeVitals.insets = new Insets(0, 0, 5, 5);
		gbc_btnTakeVitals.gridx = 2;
		gbc_btnTakeVitals.gridy = 6;
		add(btnTakeVitals, gbc_btnTakeVitals);
		
		JButton btnViewHistory = new JButton("View History");
		GridBagConstraints gbc_btnViewHistory = new GridBagConstraints();
		gbc_btnViewHistory.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewHistory.gridx = 2;
		gbc_btnViewHistory.gridy = 7;
		add(btnViewHistory, gbc_btnViewHistory);
		
		JButton btnComments = new JButton("Comments");
		GridBagConstraints gbc_btnComments = new GridBagConstraints();
		gbc_btnComments.insets = new Insets(0, 0, 5, 5);
		gbc_btnComments.gridx = 2;
		gbc_btnComments.gridy = 8;
		add(btnComments, gbc_btnComments);
		
		JButton btnViewProfile = new JButton("View/Edit Profile");
		GridBagConstraints gbc_btnViewProfile = new GridBagConstraints();
		gbc_btnViewProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewProfile.gridx = 2;
		gbc_btnViewProfile.gridy = 9;
		add(btnViewProfile, gbc_btnViewProfile);

	}

}
