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
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VitalsPanel extends JPanel implements ActionListener {
	private JTextField textFieldBloodPressure;
	private JTextField textFieldWeight;
	private JTextField textFieldTemperature;
	private JTextField textFieldPulse;
	private JButton btnSubmit;
	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public VitalsPanel(IO cndIO) {
		
		this.io = cndIO;
		
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
		
		textFieldBloodPressure = new JTextField();
		GridBagConstraints gbc_textFieldBloodPressure = new GridBagConstraints();
		gbc_textFieldBloodPressure.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBloodPressure.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBloodPressure.gridx = 3;
		gbc_textFieldBloodPressure.gridy = 1;
		add(textFieldBloodPressure, gbc_textFieldBloodPressure);
		textFieldBloodPressure.setColumns(10);
		
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
		
		textFieldPulse = new JTextField();
		GridBagConstraints gbc_textFieldPulse = new GridBagConstraints();
		gbc_textFieldPulse.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPulse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPulse.gridx = 3;
		gbc_textFieldPulse.gridy = 3;
		add(textFieldPulse, gbc_textFieldPulse);
		textFieldPulse.setColumns(10);
		
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
		
		textFieldTemperature = new JTextField();
		GridBagConstraints gbc_textFieldTemperature = new GridBagConstraints();
		gbc_textFieldTemperature.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTemperature.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTemperature.gridx = 3;
		gbc_textFieldTemperature.gridy = 5;
		add(textFieldTemperature, gbc_textFieldTemperature);
		textFieldTemperature.setColumns(10);
		
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
		
		textFieldWeight = new JTextField();
		GridBagConstraints gbc_textFieldWeight = new GridBagConstraints();
		gbc_textFieldWeight.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldWeight.gridx = 3;
		gbc_textFieldWeight.gridy = 7;
		add(textFieldWeight, gbc_textFieldWeight);
		textFieldWeight.setColumns(10);
		
		JComboBox comboBoxWeight = new JComboBox();
		comboBoxWeight.setModel(new DefaultComboBoxModel(new String[] {"lbs", "kg"}));
		comboBoxWeight.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxWeight = new GridBagConstraints();
		gbc_comboBoxWeight.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxWeight.gridx = 4;
		gbc_comboBoxWeight.gridy = 7;
		add(comboBoxWeight, gbc_comboBoxWeight);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 9;
		add(btnSubmit, gbc_btnSubmit);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 9;
		add(btnCancel, gbc_btnCancel);

	}

	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnSubmit)
		{	// Patient Search button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientSearchPanel);
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
