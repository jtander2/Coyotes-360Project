package com.mediware.gui.patient;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientVitalsPanel extends JPanel implements ActionListener {
	private JTextField textFieldBloodPressure;
	private JTextField textFieldWeight;
	private JTextField textFieldTemperature;
	private JTextField textFieldPulse;
	private JTextField textFieldSugarLevel;
	private JButton btnSubmit;
	private JButton btnCancel;
	private IO io;
	private int from;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public PatientVitalsPanel(IO cndIO, int pFrom) {
		
		this.io = cndIO;
		from = pFrom;
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Record Vitals", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 88, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
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
		comboBoxTemp.setModel(new DefaultComboBoxModel(new String[] {"\u00B0F"}));
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
		comboBoxWeight.setModel(new DefaultComboBoxModel(new String[] {"lbs"}));
		comboBoxWeight.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxWeight = new GridBagConstraints();
		gbc_comboBoxWeight.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxWeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxWeight.gridx = 4;
		gbc_comboBoxWeight.gridy = 7;
		add(comboBoxWeight, gbc_comboBoxWeight);
		
		JLabel lblSugar = new JLabel("Sugar/Glucose Level:");
		GridBagConstraints gbc_lblSugar = new GridBagConstraints();
		gbc_lblSugar.anchor = GridBagConstraints.EAST;
		gbc_lblSugar.insets = new Insets(0, 0, 5, 5);
		gbc_lblSugar.gridx = 2;
		gbc_lblSugar.gridy = 9;
		add(lblSugar, gbc_lblSugar);
		
		textFieldSugarLevel = new JTextField();
		GridBagConstraints gbc_textFieldSugarLevel = new GridBagConstraints();
		gbc_textFieldSugarLevel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldSugarLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSugarLevel.gridx = 3;
		gbc_textFieldSugarLevel.gridy = 9;
		add(textFieldSugarLevel, gbc_textFieldSugarLevel);
		textFieldSugarLevel.setColumns(10);
		
		JComboBox comboBoxSugar = new JComboBox();
		comboBoxSugar.setModel(new DefaultComboBoxModel(new String[] {"Mmol/L"}));
		comboBoxSugar.setMaximumRowCount(2);
		GridBagConstraints gbc_comboBoxSugar = new GridBagConstraints();
		gbc_comboBoxSugar.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSugar.gridx = 4;
		gbc_comboBoxSugar.gridy = 9;
		add(comboBoxSugar, gbc_comboBoxSugar);
		
		JLabel lblNewLabel = new JLabel("Optional: Comments, Observations, Concerns");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JTextArea textAreaComments = new JTextArea();
		GridBagConstraints gbc_textAreaComments = new GridBagConstraints();
		gbc_textAreaComments.gridwidth = 3;
		gbc_textAreaComments.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaComments.fill = GridBagConstraints.BOTH;
		gbc_textAreaComments.gridx = 2;
		gbc_textAreaComments.gridy = 12;
		add(textAreaComments, gbc_textAreaComments);
		
		btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 3;
		gbc_btnSubmit.gridy = 14;
		add(btnSubmit, gbc_btnSubmit);
		btnSubmit.addActionListener (this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.gridwidth = 2;
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 4;
		gbc_btnCancel.gridy = 14;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener (this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnSubmit){
		    
		    try {
		
		int bp =   		Integer.parseInt(textFieldBloodPressure.getText());
		int weight =   		Integer.parseInt(textFieldWeight.getText());
		int temp =  		Integer.parseInt(textFieldTemperature.getText());
		int pulse =   		Integer.parseInt(textFieldPulse.getText());
		int sugarLevel =	Integer.parseInt(textFieldSugarLevel.getText());
		
		if(bp <= 0 || weight <= 0 || temp <= 0 || pulse <= 0 || sugarLevel <= 0) {
			int[] intParams = new int[0];
			String[] stringParams = {"Enter in valid parameter!", "Vitals Entry Error"};
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayErrorDialog);
		} else {
			int[] intParams = {bp, weight, temp, pulse, sugarLevel};
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.patientVitalsEntry);
		}
		
		    }catch(NumberFormatException e){
			int[] intParams = new int[0];
			String[] stringParams = {"Enter in all fields!", "Vitals Entry Error"};
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayErrorDialog);
		    }
		    
		}
		else if (event.getSource() == btnCancel)
		{	// Messages / Alerts button was clicked
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

}
