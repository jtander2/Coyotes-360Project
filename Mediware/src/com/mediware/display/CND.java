package com.mediware.display;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mediware.arch.IO;
import com.mediware.arch.Message;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;
import com.mediware.gui.LoginPanel;
import com.mediware.gui.MessagePanel;
import com.mediware.gui.ResetPassword;
import com.mediware.gui.RtvPassword;
import com.mediware.gui.RtvUsername;
import com.mediware.gui.TempPassword;
import com.mediware.gui.ViewMessagePanel;
import com.mediware.gui.sndMessage;
import com.mediware.gui.doctor.DoctorMainPanel;
import com.mediware.gui.doctor.EditEmployee;
import com.mediware.gui.doctor.EmployeeSearchPanel;
import com.mediware.gui.doctor.EmployeeSelect;
import com.mediware.gui.doctor.MAMainPanel;
import com.mediware.gui.doctor.MAPatientReport;
import com.mediware.gui.doctor.NewCommentPanel;
import com.mediware.gui.doctor.NewEmployeePanel;
import com.mediware.gui.doctor.NewPatientPanel;
import com.mediware.gui.doctor.NurseMainPanel;
import com.mediware.gui.doctor.PatientProfile;
import com.mediware.gui.doctor.PatientReport;
import com.mediware.gui.doctor.PatientSearchPanel;
import com.mediware.gui.doctor.PatientSelect;
import com.mediware.gui.doctor.ViewCommentPanel;
import com.mediware.gui.doctor.VitalsPanel;
import com.mediware.gui.patient.PatientHealthHistory;
import com.mediware.gui.patient.PatientMenuPanel;
import com.mediware.gui.patient.PatientProfilePanel;
import com.mediware.gui.patient.PatientVitalsPanel;


public class CND {

	//private IO used for sending and recieveing messages
	private IO cndIO;
	//array of messages that we will recieve
	private Message[] cndMessages;
	//current frame to display
	private JFrame currentFrame;
	private ArrayList<JFrame> previousFrames;
	
	public CND(IO io) {
		cndIO = io;
		
		//Set initial frame to the login panel
		currentFrame = new JFrame("Mediware Health Services");
		currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentFrame.setSize(600, 600);
		currentFrame.setLayout(new FlowLayout()); 
		currentFrame.setVisible(true);
		displayLoginPanel();
		
		previousFrames = new ArrayList<JFrame>();
	}
	
	public void run() {
		//first retrieve messages
		cndMessages = cndIO.nextFrame(partition.CND);
		
		//loop through all pending messages and take care of the necessary actions
		for(int i = 0; i < cndMessages.length; i++) {
			System.out.println(cndMessages[i].getMessageType().toString());
			
			//Case statement to handle the various message types as defined in mTypes.java
			switch(cndMessages[i].getMessageType()) {
				case cndDisplayDoctorMainPanel:
					displayDoctorMainPanel();
					break;
				case cndDisplayRtvUsername:
					displayRtvUsername();
					break;
				case cndDisplayRtvPassword:
					displayRtvPassword();
					break;
				case cndDisplayErrorDialog:
					String[] params = cndMessages[i].getMessageData().getLabels();
					//display the error dialog with the parameters retrieved from the message
					displayErrorDialog(params[0], params[1]);
					break;
				case cndDisplayNewPatientPanel:
					displayNewPatientPanel();
					break;
				case cndDisplayPatientSearchPanel:
					displayPatientSearchPanel();
					break;
				case cndDisplayMessagePanel:
					displayMessagePanel(cndMessages[i].getMessageData().getLabels());
					break;
				case cndDisplayNewEmployeePanel:
					displayNewEmployeePanel();
					break;
				case cndDisplayEditEmployee:
					displayEditEmployee(cndMessages[i].getMessageData().getLabels());
					break;
				case cndDisplayLoginPanel:
					displayLoginPanel();
					break;
				case cndDisplayMAMainPanel:
					displayMAMainPanel();
					break;	
				case cndDisplayNurseMainPanel:
					displayNurseMainPanel();
					break;	
				case cndDisplayPatientMenuPanel:
					displayPatientMenuPanel();
					break;
				case cndDisplayPatientProfilePanel:
				{
					String[] patientParams = cndMessages[i].getMessageData().getLabels();
					//from variable is used to determine if the next pages cancel button should return to main menu or a different menu
					int[] fromInt = cndMessages[i].getMessageData().getArguments();
					int from = 0;
					if(fromInt.length == 0) {
						from = 0;
					} else {
						from = 1;
					}
					displayPatientProfilePanel(patientParams, from);
					break;
				}
				case cndDisplayPatientVitalsPanel:
				{
					//from variable is used to determine if the next pages cancel button should return to main menu or a different menu
					int[] fromInt = cndMessages[i].getMessageData().getArguments();
					int from = 0;
					if(fromInt.length == 0) {
						from = 0;
					} else {
						from = 1;
					}
					displayPatientVitalsPanel(from);
					break;
				}
				case cndDisplayPatientHealthHistory:
				{
					int[] historyInts = cndMessages[i].getMessageData().getArguments();
					String[] historyStrings = cndMessages[i].getMessageData().getLabels();
					
					//from variable is used to determine if the next pages cancel button should return to main menu or a different menu
					int from = 0;
					if(historyStrings.length == 0) {
						from = 0;
					} else {
						from = 1;
					}
					//display the page initially
					displayPatientHealthHistory(historyInts, from);
					// After the page is displayed send a message to SYS to start fetching the graph
					//this is normally triggered by a change in the comboBox but initially we need to call it
					int[] intParams = new int[0];
					//BP is default
					String[] stringParams = { "Blood Pressure" };
					mData messageData = new mData(intParams, stringParams);
					partition[] subscribers = { partition.SYS };
					cndIO.createMessageToSend(partition.CND, subscribers, messageData, mType.patientHistoryRequest);
					break;
				}
				case patientHistoryData:
				    drawHealthHistory(cndMessages[i].getMessageData().getArguments());
				    break;
				case cndPatientSearchReport:
				    displayPatientSelect(cndMessages[i].getMessageData().getArguments(), cndMessages[i].getMessageData().getLabels());
				    break;
				case cndEmployeeSearchReport:
				    displayEmployeeSelect(cndMessages[i].getMessageData().getArguments(), cndMessages[i].getMessageData().getLabels());
				    break;
				case cndDisplayEmployeeSearchPanel:
					displayEmployeeSearchPanel();
					break;
				case cndPatientReport:
					displayPatientReport(cndMessages[i].getMessageData().getLabels());
					break;
				case cndDisplayMessage:
				    displayMessage(cndMessages[i].getMessageData().getLabels()[0]);
					break;
				case cndDisplaySendMessage:
					displaySendMessage();
					break;
				default:
					break;					
			}
			
		}

	}
	

	//Getters and Setters
	public IO getCndIO() {
		return cndIO;
	}

	public void setCndIO(IO cndIO) {
		this.cndIO = cndIO;
	}

	public JFrame getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(JFrame currentFrame) {
		this.currentFrame = currentFrame;
	}

	public ArrayList<JFrame> getPreviousFrames() {
		return previousFrames;
	}

	public void setPreviousFrames(ArrayList<JFrame> previousFrames) {
		this.previousFrames = previousFrames;
	}
	
	//*****************************************************************************
	//com.mediware.gui display functions which switch current frame viewed
	//*****************************************************************************
	public void displayLoginPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new LoginPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	
	public void displayMessagePanel(String[] labels) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new MessagePanel(cndIO, labels));
		currentFrame.setVisible(true);
	}
	
	public void displayResetPassword() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ResetPassword(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayRtvPassword() {
		JDialog dlgRetrievePassword = new RtvPassword(cndIO);
		dlgRetrievePassword.setVisible(true);
	}
	
	public void displayRtvUsername() {
		JDialog dlgRetrieveUsername = new RtvUsername(cndIO);
		dlgRetrieveUsername.setVisible(true);
	}
	
	public void displayTempPassword() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new TempPassword(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayViewMessagePanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ViewMessagePanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displaySendMessage() {
		JDialog dlgSendMessage = new sndMessage(cndIO);
		dlgSendMessage.setVisible(true);

		}
	
	//*****************************************************************************
	//com.mediware.gui.doctor display functions which switch current frame viewed
	//*****************************************************************************
	public void displayDoctorMainPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new DoctorMainPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayEditEmployee(String msg[]) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EditEmployee(cndIO, msg));
		currentFrame.setVisible(true);
	}
	
	public void displayEmployeeSearchPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EmployeeSearchPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayEmployeeSelect(int[] intParams, String[] stringParams) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EmployeeSelect(cndIO, intParams, stringParams));
		currentFrame.setVisible(true);
	}
	
	public void displayMAMainPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new MAMainPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayMAPatientReport() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new MAPatientReport(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayNewCommentPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new NewCommentPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayNewEmployeePanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new NewEmployeePanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayNewPatientPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new NewPatientPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayNurseMainPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new NurseMainPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientProfile() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientProfile(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientReport(String [] labels) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientReport(cndIO, labels));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientSearchPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientSearchPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientSelect(int[] AIDS, String[] names) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientSelect(cndIO, AIDS, names));
		currentFrame.setVisible(true);
	}
	
	public void displayViewCommentPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ViewCommentPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayVitalsPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new VitalsPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	//*****************************************************************************
	//com.mediware.gui.patient display functions which switch current frame viewed
	//*****************************************************************************
	public void displayPatientHealthHistory(int[] historyInts, int from) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientHealthHistory(cndIO, historyInts, from));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientMenuPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientMenuPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientProfilePanel(String[] patientData, int from) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientProfilePanel(cndIO, patientData, from));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientVitalsPanel(int from) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientVitalsPanel(cndIO, from));
		currentFrame.setVisible(true);
	}
	
	//Other
	public void displayErrorDialog(String message, String type) {
		JOptionPane.showMessageDialog(currentFrame, message, type, JOptionPane.ERROR_MESSAGE);
	}
	
	public void displayMessage(String message) {
	    JOptionPane.showMessageDialog(currentFrame, message, "Message", JOptionPane.INFORMATION_MESSAGE);
	    
	}
	
	//Graph drawing
	public void drawHealthHistory(int[] data) {
	 
	    int max = PatientHealthHistory.findUpperBound(data);
	    for(int i = 0; i < currentFrame.getContentPane().getComponentCount(); i++) {
		if(currentFrame.getContentPane().getComponent(i) instanceof PatientHealthHistory) {
		    ((PatientHealthHistory)currentFrame.getContentPane().getComponent(i)).getGraph().addData(data, max);
		    ((PatientHealthHistory)currentFrame.getContentPane().getComponent(i)).getGraph().repaint();
		    ((PatientHealthHistory)currentFrame.getContentPane().getComponent(i)).setMaxLabel();
		}
	    }
	
	}
	
}
