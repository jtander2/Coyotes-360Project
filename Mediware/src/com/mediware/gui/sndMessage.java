package com.mediware.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings({ "serial", "unused" })
public class sndMessage extends JDialog implements ActionListener{
	private JButton Send;
	private IO io;
	private JTextArea textArea;
	private JComboBox comboBox;
	private JLabel lblPriority;

	/**
	 * Create the panel.
	 * @param cndIO 
	 */
	public sndMessage(IO cndIO) {
		
		this.io = cndIO;
		
		setTitle("Send Message");
		setSize(425, 300);
		setModal(true);
		
		JPanel panel = new JPanel();
		panel.setSize(350, 300);
		
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Message Text", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		getContentPane().add(panel);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 3;
		gbc_textArea.gridwidth = 4;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		panel.add(textArea, gbc_textArea);
		
		lblPriority = new JLabel("Priority:");
		GridBagConstraints gbc_lblPriority = new GridBagConstraints();
		gbc_lblPriority.insets = new Insets(0, 0, 5, 5);
		gbc_lblPriority.anchor = GridBagConstraints.EAST;
		gbc_lblPriority.gridx = 3;
		gbc_lblPriority.gridy = 4;
		panel.add(lblPriority, gbc_lblPriority);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 4;
		panel.add(comboBox, gbc_comboBox);
		
		Send = new JButton("Send");
		GridBagConstraints gbc_Send = new GridBagConstraints();
		gbc_Send.insets = new Insets(0, 0, 0, 5);
		gbc_Send.gridx = 4;
		gbc_Send.gridy = 5;
		panel.add(Send, gbc_Send);
		Send.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == Send)
		{	// Messages / Alerts button was clicked
			int[] intParams = {comboBox.getSelectedIndex()+1};
			String[] stringParams = {textArea.getText()};
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysSendMessage);
			
			//Close window on send
			this.setVisible(false);
        }
		
	}
}
