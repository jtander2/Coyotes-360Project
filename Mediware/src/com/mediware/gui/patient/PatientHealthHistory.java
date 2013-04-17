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
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientHealthHistory extends JPanel implements ActionListener {

	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public PatientHealthHistory(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(null, "Health History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextPane textPaneHealthHistory = new JTextPane();
		GridBagConstraints gbc_textPaneHealthHistory = new GridBagConstraints();
		gbc_textPaneHealthHistory.gridwidth = 14;
		gbc_textPaneHealthHistory.insets = new Insets(0, 0, 5, 5);
		gbc_textPaneHealthHistory.fill = GridBagConstraints.BOTH;
		gbc_textPaneHealthHistory.gridx = 1;
		gbc_textPaneHealthHistory.gridy = 1;
		add(textPaneHealthHistory, gbc_textPaneHealthHistory);
		
		JLabel lblYear = new JLabel("Year");
		GridBagConstraints gbc_lblYear = new GridBagConstraints();
		gbc_lblYear.gridwidth = 4;
		gbc_lblYear.insets = new Insets(0, 0, 5, 5);
		gbc_lblYear.gridx = 4;
		gbc_lblYear.gridy = 2;
		add(lblYear, gbc_lblYear);
		
		JLabel lblVitalStat = new JLabel("Vital Stat");
		GridBagConstraints gbc_lblVitalStat = new GridBagConstraints();
		gbc_lblVitalStat.gridwidth = 2;
		gbc_lblVitalStat.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitalStat.gridx = 9;
		gbc_lblVitalStat.gridy = 2;
		add(lblVitalStat, gbc_lblVitalStat);
		
		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setModel(new DefaultComboBoxModel(new String[] {"2013", "2012", "2011", "2010"}));
		GridBagConstraints gbc_comboBoxYear = new GridBagConstraints();
		gbc_comboBoxYear.gridwidth = 4;
		gbc_comboBoxYear.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxYear.gridx = 4;
		gbc_comboBoxYear.gridy = 3;
		add(comboBoxYear, gbc_comboBoxYear);
		
		JComboBox comboBoxVitalStat = new JComboBox();
		comboBoxVitalStat.setMaximumRowCount(5);
		comboBoxVitalStat.setModel(new DefaultComboBoxModel(new String[] {"Blood Pressure", "Pulse", "Temperature", "Weight", "Sugar/Glucose Level"}));
		GridBagConstraints gbc_comboBoxVitalStat = new GridBagConstraints();
		gbc_comboBoxVitalStat.gridwidth = 2;
		gbc_comboBoxVitalStat.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxVitalStat.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVitalStat.gridx = 9;
		gbc_comboBoxVitalStat.gridy = 3;
		add(comboBoxVitalStat, gbc_comboBoxVitalStat);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 13;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener (this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnCancel)
		{	// Cancel button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToMenu);
        }
	}

}
