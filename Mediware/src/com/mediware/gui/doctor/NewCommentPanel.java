package com.mediware.gui.doctor;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class NewCommentPanel extends JPanel implements ActionListener {

	private JButton btnSubmit;
	private JButton btnCancel;
	private IO io;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public NewCommentPanel(IO cndIO) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Comments & Observations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 92, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JTextArea textAreaComments = new JTextArea();
		GridBagConstraints gbc_textAreaComments = new GridBagConstraints();
		gbc_textAreaComments.gridheight = 3;
		gbc_textAreaComments.gridwidth = 9;
		gbc_textAreaComments.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaComments.fill = GridBagConstraints.BOTH;
		gbc_textAreaComments.gridx = 1;
		gbc_textAreaComments.gridy = 1;
		add(textAreaComments, gbc_textAreaComments);
		
		btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 7;
		gbc_btnSubmit.gridy = 5;
		add(btnSubmit, gbc_btnSubmit);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 9;
		gbc_btnCancel.gridy = 5;
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
