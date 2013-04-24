package com.mediware.gui.patient;

import java.awt.Color;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientHealthHistory extends JPanel implements ActionListener {

	private JButton btnCancel;
	private PatientHealthData graph;
	private JLabel maxLabel;
	private IO io;

	/**
	 * Create the panel.
	 * 
	 * @param cndIO
	 */
	public PatientHealthHistory(IO cndIO, int[] pIntData, String[] pStringData) {

		this.io = cndIO;

		setBorder(new TitledBorder(null, "Health History",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 200, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 300, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		// Frame for graph
		graph = new PatientHealthData();
		graph.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		graph.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 10;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 1;
		add(graph, gbc_panel);

		JLabel lblVitalStat = new JLabel("Vital Stat");
		GridBagConstraints gbc_lblVitalStat = new GridBagConstraints();
		gbc_lblVitalStat.gridwidth = 2;
		gbc_lblVitalStat.insets = new Insets(0, 0, 5, 5);
		gbc_lblVitalStat.gridx = 9;
		gbc_lblVitalStat.gridy = 2;
		add(lblVitalStat, gbc_lblVitalStat);

		maxLabel = new JLabel("100");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 13;
		gbc_lblNewLabel.gridy = 1;
		add(maxLabel, gbc_lblNewLabel);

		JComboBox<String> comboBoxVitalStat = new JComboBox<String>();
		comboBoxVitalStat.setMaximumRowCount(5);
		comboBoxVitalStat.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Blood Pressure", "Pulse", "Temperature",
						"Weight", "Sugar/Glucose Level" }));
		comboBoxVitalStat.setSelectedItem(1); // set the combobox to display
												// whatever string type is
												// passed in
		GridBagConstraints gbc_comboBoxVitalStat = new GridBagConstraints();
		gbc_comboBoxVitalStat.gridwidth = 2;
		gbc_comboBoxVitalStat.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxVitalStat.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxVitalStat.gridx = 9;
		gbc_comboBoxVitalStat.gridy = 3;
		add(comboBoxVitalStat, gbc_comboBoxVitalStat);
		HistoryComboBoxListener cbListener = new HistoryComboBoxListener();
		comboBoxVitalStat.addActionListener(cbListener);

		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 13;
		gbc_btnCancel.gridy = 3;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);

	}

	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnCancel) { // Cancel button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = { partition.SYS };
			io.createMessageToSend(partition.CND, subscribers, messageData,
					mType.sysGoToMenu);
		}
	}

	private class HistoryComboBoxListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			String dataRequest = (String) (((JComboBox<?>) event.getSource())
					.getSelectedItem());
			// Request Data from SYS based on the selected item in the combo
			// box.
			int[] intParams = new int[0];
			String[] stringParams = { dataRequest };
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = { partition.SYS };
			io.createMessageToSend(partition.CND, subscribers, messageData,
					mType.patientHistoryRequest);

		}
	}

	/**
	 * Returns the upperbound of the data, plus a little bit. To make the graph
	 * look nice
	 * 
	 * @param data
	 * @return
	 */
	public static int findUpperBound(int[] data) {

		int up = 0;

		for (int i = 0; i < data.length; i++) {

			if (up < data[i]) {
				up = data[i];
			}

		}

		return (int) Math.floor(up * 1.2);
	}

	public PatientHealthData getGraph() {
		return graph;
	}

	public void setMaxLabel() {
		maxLabel.setText(graph.max + "");
	}
}
