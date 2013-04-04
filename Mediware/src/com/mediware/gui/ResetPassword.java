package com.mediware.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class ResetPassword extends JPanel implements ActionListener {
	private JTextField textFieldAnswer1;
	private JTextField textFieldAnswer2;
	private JButton btnNext;
	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public ResetPassword(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Reset Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 183, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Security Question 1");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBoxQuestion1 = new JComboBox();
		comboBoxQuestion1.setModel(new DefaultComboBoxModel(new String[] {"Mother's Maiden Name?", "Favorite Pet's Name?", "Street you grew up on?", "Favorite Sports Team?"}));
		GridBagConstraints gbc_comboBoxQuestion1 = new GridBagConstraints();
		gbc_comboBoxQuestion1.gridwidth = 3;
		gbc_comboBoxQuestion1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxQuestion1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxQuestion1.gridx = 2;
		gbc_comboBoxQuestion1.gridy = 2;
		add(comboBoxQuestion1, gbc_comboBoxQuestion1);
		
		textFieldAnswer1 = new JTextField();
		GridBagConstraints gbc_textFieldAnswer1 = new GridBagConstraints();
		gbc_textFieldAnswer1.gridwidth = 3;
		gbc_textFieldAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAnswer1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnswer1.gridx = 2;
		gbc_textFieldAnswer1.gridy = 3;
		add(textFieldAnswer1, gbc_textFieldAnswer1);
		textFieldAnswer1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Security Question 2");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 3;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 5;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JComboBox comboBoxQuestion2 = new JComboBox();
		comboBoxQuestion2.setModel(new DefaultComboBoxModel(new String[] {"Favorite Sports Team?", "Mother's Maiden Name?", "Favorite Pet's Name?", "Street you grew up on?"}));
		GridBagConstraints gbc_comboBoxQuestion2 = new GridBagConstraints();
		gbc_comboBoxQuestion2.gridwidth = 3;
		gbc_comboBoxQuestion2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxQuestion2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxQuestion2.gridx = 2;
		gbc_comboBoxQuestion2.gridy = 6;
		add(comboBoxQuestion2, gbc_comboBoxQuestion2);
		
		textFieldAnswer2 = new JTextField();
		GridBagConstraints gbc_textFieldAnswer2 = new GridBagConstraints();
		gbc_textFieldAnswer2.gridwidth = 3;
		gbc_textFieldAnswer2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAnswer2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAnswer2.gridx = 2;
		gbc_textFieldAnswer2.gridy = 7;
		add(textFieldAnswer2, gbc_textFieldAnswer2);
		textFieldAnswer2.setColumns(10);
		
		btnNext = new JButton("Next >");
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 2;
		gbc_btnNext.gridy = 9;
		add(btnNext, gbc_btnNext);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 9;
		add(btnCancel, gbc_btnCancel);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnNext)
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
