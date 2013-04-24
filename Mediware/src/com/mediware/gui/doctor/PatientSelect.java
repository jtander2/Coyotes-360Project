package com.mediware.gui.doctor;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mediware.arch.IO;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;

@SuppressWarnings("serial")
public class PatientSelect extends JPanel implements ActionListener {

	private JButton btnView;
	private JButton btnCancel;
	private IO io;
	private JList list;
	private int[] aids;

	/**
	 * Create the panel.
	 * @param cndIO 
	 * @param names 
	 * @param aIDS 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PatientSelect(IO cndIO, int[] aIDS, String[] names) {
		
		this.io = cndIO;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Patient Select", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 92, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		aids = aIDS;
		String[] listStuff = new String[names.length+1];
		listStuff[0] = "ID      NAME";
		for(int i = 0; i < names.length; i++) {
		    listStuff[i+1] = aIDS[i] + "    " + names[i];
		}
		
		final String[] listElements = listStuff;
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = listElements;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 9;
		gbc_list.gridheight = 3;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		add(list, gbc_list);
		
		btnView = new JButton("View");
		GridBagConstraints gbc_btnView = new GridBagConstraints();
		gbc_btnView.insets = new Insets(0, 0, 5, 5);
		gbc_btnView.gridx = 7;
		gbc_btnView.gridy = 5;
		add(btnView, gbc_btnView);
		btnView.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 9;
		gbc_btnCancel.gridy = 5;
		add(btnCancel, gbc_btnCancel);
		btnCancel.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent event) {
		// Check which button was clicked on
		if (event.getSource() == btnView)
		{	// Patient Search button was clicked
		    
		    System.out.println(list.getSelectedIndex() + "");
		    	if(list.getSelectedIndex() <= 0) {
		    	    return;
		    	}
		    	
			int[] intParams = {aids[list.getSelectedIndex()-1]};
			String[] stringParams = new String[0];
			mData messageData = new mData(intParams, stringParams);
			partition[] subscribers = {partition.SYS};
			io.createMessageToSend(partition.CND, subscribers, messageData, mType.sysSelectPatient);
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
