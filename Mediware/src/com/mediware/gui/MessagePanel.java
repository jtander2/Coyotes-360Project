package com.mediware.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class MessagePanel extends JPanel implements ActionListener {

	private JButton btnViewMessage;
	private JButton btnDeleteMessage;
	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public MessagePanel(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(null, "Messages / Alerts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 92, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea textAreaMessages = new JTextArea();
		GridBagConstraints gbc_textAreaMessages = new GridBagConstraints();
		gbc_textAreaMessages.gridheight = 3;
		gbc_textAreaMessages.gridwidth = 9;
		gbc_textAreaMessages.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaMessages.fill = GridBagConstraints.BOTH;
		gbc_textAreaMessages.gridx = 1;
		gbc_textAreaMessages.gridy = 1;
		add(textAreaMessages, gbc_textAreaMessages);
		
		btnViewMessage = new JButton("View Message");
		GridBagConstraints gbc_btnViewMessage = new GridBagConstraints();
		gbc_btnViewMessage.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewMessage.gridx = 3;
		gbc_btnViewMessage.gridy = 5;
		add(btnViewMessage, gbc_btnViewMessage);
		btnViewMessage.addActionListener (this);
		
		btnDeleteMessage = new JButton("Delete Message");
		GridBagConstraints gbc_btnDeleteMessage = new GridBagConstraints();
		gbc_btnDeleteMessage.gridwidth = 2;
		gbc_btnDeleteMessage.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteMessage.gridx = 5;
		gbc_btnDeleteMessage.gridy = 5;
		add(btnDeleteMessage, gbc_btnDeleteMessage);
		btnDeleteMessage.addActionListener (this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 8;
		gbc_btnCancel.gridy = 5;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener (this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnViewMessage)
		{	// Patient Search button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientSearchPanel);
        }
		else if (event.getSource() == btnDeleteMessage)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayMessagePanel);
        }
		else if (event.getSource() == btnCancel)
		{	// Messages / Alerts button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayDoctorMainPanel);
        }
		
	}

}
