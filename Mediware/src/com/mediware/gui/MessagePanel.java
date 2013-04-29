package com.mediware.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.AbstractListModel;

@SuppressWarnings("serial")
public class MessagePanel extends JPanel implements ActionListener, KeyListener {

	private JButton btnViewMessage;
	private JButton btnDeleteMessage;
	private JButton btnCancel;
	private IO io;
	private JList list;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component horizontalStrut;
	private Component horizontalStrut_1;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public MessagePanel(IO cndIO, String[] RhoLabels) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(null, "Messages / Alerts", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 92, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 1;
		add(verticalStrut, gbc_verticalStrut);
		
		String[] labels = new String[RhoLabels.length + 1];
		labels[0] = "Priority:    Date:";
		System.arraycopy(RhoLabels, 0, labels, 1, RhoLabels.length);
		
		final String[] Flabels = labels;
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = Flabels;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setToolTipText("");
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 7;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridx = 2;
		gbc_list.gridy = 1;
		add(list, gbc_list);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 9;
		gbc_horizontalStrut.gridy = 1;
		add(horizontalStrut, gbc_horizontalStrut);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.fill = GridBagConstraints.BOTH;
		gbc_verticalStrut_1.weighty = 5.0;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 9;
		gbc_horizontalStrut_1.gridy = 2;
		add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_2.gridx = 1;
		gbc_verticalStrut_2.gridy = 3;
		add(verticalStrut_2, gbc_verticalStrut_2);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 1;
		gbc_verticalStrut_3.gridy = 4;
		add(verticalStrut_3, gbc_verticalStrut_3);
		
		btnViewMessage = new JButton("View Message");
		GridBagConstraints gbc_btnViewMessage = new GridBagConstraints();
		gbc_btnViewMessage.insets = new Insets(0, 0, 5, 5);
		gbc_btnViewMessage.gridx = 3;
		gbc_btnViewMessage.gridy = 5;
		add(btnViewMessage, gbc_btnViewMessage);
		btnViewMessage.addActionListener (this);
		btnViewMessage.addKeyListener (this);
		
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
		btnCancel.addKeyListener (this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnViewMessage)
		{	// Patient Search button was clicked
		    	if(list.getSelectedIndex() > 0) {
		    	    int[] intParams = {list.getSelectedIndex()};
		    	    String[] stringParams = new String[0];
		    	    mData messageData = new mData(intParams, stringParams);
		    	    partition[] subscribers = {partition.SYS};
		    	    io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysRequestMessageNum);
		    	}
        }
		else if (event.getSource() == btnDeleteMessage)
		{	// Messages / Alerts button was clicked
		    	if(list.getSelectedIndex() > 0) {
	    	    	int[] intParams = {list.getSelectedIndex()};
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysRequestMessageDeletion);
		    	}
        }
		else if (event.getSource() == btnCancel)
		{	// Cancel button was clicked
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToMenu);
        }
		
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {	
		// Check which key was pressed
		if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER)
		{	// Enter was pressed for Patient Search
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.CND};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.cndDisplayPatientSearchPanel);
		}
		else if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE)
		{	// Escape button pressed for Cancel
			int[] intParams = new int[0];
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysGoToMenu);
        }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
