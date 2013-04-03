package com.mediware.gui.doctor;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.mediware.arch.IO;

@SuppressWarnings("serial")
public class VitalsPanel extends JPanel {
	private JTextField textBP;
	private JTextField textWeight;
	private JTextField textTemp;
	private JTextField textPulse;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public VitalsPanel(IO cndIO) {
		setBorder(new TitledBorder(null, "Patient Vitals", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 88, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBP = new JLabel("Blood Pressure:");
		GridBagConstraints gbc_lblBP = new GridBagConstraints();
		gbc_lblBP.anchor = GridBagConstraints.EAST;
		gbc_lblBP.insets = new Insets(0, 0, 5, 5);
		gbc_lblBP.gridx = 2;
		gbc_lblBP.gridy = 1;
		add(lblBP, gbc_lblBP);
		
		textBP = new JTextField();
		GridBagConstraints gbc_textBP = new GridBagConstraints();
		gbc_textBP.insets = new Insets(0, 0, 5, 5);
		gbc_textBP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBP.gridx = 3;
		gbc_textBP.gridy = 1;
		add(textBP, gbc_textBP);
		textBP.setColumns(10);
		
		JComboBox comboBoxBP = new JComboBox();
		comboBoxBP.setModel(new DefaultComboBoxModel(new String[] {"mmHg"}));
		comboBoxBP.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxBP = new GridBagConstraints();
		gbc_comboBoxBP.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxBP.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxBP.gridx = 4;
		gbc_comboBoxBP.gridy = 1;
		add(comboBoxBP, gbc_comboBoxBP);
		
		JLabel lblPulse = new JLabel("Pulse:");
		GridBagConstraints gbc_lblPulse = new GridBagConstraints();
		gbc_lblPulse.anchor = GridBagConstraints.EAST;
		gbc_lblPulse.insets = new Insets(0, 0, 5, 5);
		gbc_lblPulse.gridx = 2;
		gbc_lblPulse.gridy = 3;
		add(lblPulse, gbc_lblPulse);
		
		textPulse = new JTextField();
		GridBagConstraints gbc_textPulse = new GridBagConstraints();
		gbc_textPulse.insets = new Insets(0, 0, 5, 5);
		gbc_textPulse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPulse.gridx = 3;
		gbc_textPulse.gridy = 3;
		add(textPulse, gbc_textPulse);
		textPulse.setColumns(10);
		
		JLabel lblBeats = new JLabel("beats/min");
		GridBagConstraints gbc_lblBeats = new GridBagConstraints();
		gbc_lblBeats.anchor = GridBagConstraints.WEST;
		gbc_lblBeats.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeats.gridx = 4;
		gbc_lblBeats.gridy = 3;
		add(lblBeats, gbc_lblBeats);
		
		JLabel lblTemp = new JLabel("Temperature:");
		GridBagConstraints gbc_lblTemp = new GridBagConstraints();
		gbc_lblTemp.anchor = GridBagConstraints.EAST;
		gbc_lblTemp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemp.gridx = 2;
		gbc_lblTemp.gridy = 5;
		add(lblTemp, gbc_lblTemp);
		
		textTemp = new JTextField();
		GridBagConstraints gbc_textTemp = new GridBagConstraints();
		gbc_textTemp.insets = new Insets(0, 0, 5, 5);
		gbc_textTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTemp.gridx = 3;
		gbc_textTemp.gridy = 5;
		add(textTemp, gbc_textTemp);
		textTemp.setColumns(10);
		
		JComboBox comboBoxTemp = new JComboBox();
		comboBoxTemp.setModel(new DefaultComboBoxModel(new String[] {"\u00B0F", "\u00B0C"}));
		comboBoxTemp.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxTemp = new GridBagConstraints();
		gbc_comboBoxTemp.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTemp.gridx = 4;
		gbc_comboBoxTemp.gridy = 5;
		add(comboBoxTemp, gbc_comboBoxTemp);
		
		JLabel lblWeight = new JLabel("Weight:");
		GridBagConstraints gbc_lblWeight = new GridBagConstraints();
		gbc_lblWeight.anchor = GridBagConstraints.EAST;
		gbc_lblWeight.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeight.gridx = 2;
		gbc_lblWeight.gridy = 7;
		add(lblWeight, gbc_lblWeight);
		
		textWeight = new JTextField();
		GridBagConstraints gbc_textWeight = new GridBagConstraints();
		gbc_textWeight.insets = new Insets(0, 0, 5, 5);
		gbc_textWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWeight.gridx = 3;
		gbc_textWeight.gridy = 7;
		add(textWeight, gbc_textWeight);
		textWeight.setColumns(10);
		
		JComboBox comboBoxWeight = new JComboBox();
		comboBoxWeight.setModel(new DefaultComboBoxModel(new String[] {"lbs", "kg"}));
		comboBoxWeight.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxWeight = new GridBagConstraints();
		gbc_comboBoxWeight.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxWeight.gridx = 4;
		gbc_comboBoxWeight.gridy = 7;
		add(comboBoxWeight, gbc_comboBoxWeight);
		
		JButton btnDone = new JButton("Done");
		GridBagConstraints gbc_btnDone = new GridBagConstraints();
		gbc_btnDone.insets = new Insets(0, 0, 0, 5);
		gbc_btnDone.gridx = 3;
		gbc_btnDone.gridy = 9;
		add(btnDone, gbc_btnDone);
		
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 9;
		add(btnCancel, gbc_btnCancel);

	}

}
