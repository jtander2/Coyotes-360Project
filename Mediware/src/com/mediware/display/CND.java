package com.mediware.display;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.mediware.arch.IO;
import com.mediware.arch.Message;
import com.mediware.arch.Enums.partition;
import com.mediware.gui.LoginPanel;
import com.mediware.gui.MessagePanel;
import com.mediware.gui.ReplyPanel;
import com.mediware.gui.ResetPassword;
import com.mediware.gui.RtvPassword;
import com.mediware.gui.RtvUsername;
import com.mediware.gui.TempPassword;
import com.mediware.gui.ViewMessagePanel;
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

	private IO cndIO;
	private Message[] cndMessages;
	private JFrame currentFrame;
	private ArrayList<JFrame> previousFrames;
	
	public CND(IO io) {
		cndIO = io;
		
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
		for(int i = 0; i < cndMessages.length; i++) {
			System.out.println(cndMessages[i].getMessageType().toString());
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
					displayErrorDialog(params[0], params[1]);
					break;
				case cndDisplayNewPatientPanel:
					displayNewPatientPanel();
					break;
				case cndDisplayPatientSearchPanel:
					displayPatientSearchPanel();
					break;
				case cndDisplayMessagePanel:
					displayMessagePanel();
					break;
				case cndDisplayNewEmployeePanel:
					displayNewEmployeePanel();
					break;
				case cndDisplayEditEmployee:
					displayEditEmployee();
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
					String[] patientParams = cndMessages[i].getMessageData().getLabels();
					displayPatientProfilePanel(patientParams);
					break;
				case cndDisplayPatientVitalsPanel:
					displayPatientVitalsPanel();
					break;
				case cndDisplayPatientHealthHistory:
					int[] historyInts = cndMessages[i].getMessageData().getArguments();
					String[] historyStrings = cndMessages[i].getMessageData().getLabels();
					displayPatientHealthHistory(historyInts, historyStrings);
					break;
					
				case patientHistoryData:
				    	drawHealthHistory(cndMessages[i].getMessageData().getArguments());
				    	break;
				default:
					break;					
			}
			
		}

	}
	

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
	//com.mediware.gui
	//*****************************************************************************
	public void displayLoginPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new LoginPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	
	public void displayMessagePanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new MessagePanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayReplyPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ReplyPanel(cndIO));
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
	
	//*****************************************************************************
	//com.mediware.gui.doctor
	//*****************************************************************************
	public void displayDoctorMainPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new DoctorMainPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayEditEmployee() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EditEmployee(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayEmployeeSearchPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EmployeeSearchPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayEmployeeSelect() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new EmployeeSelect(cndIO));
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
	
	public void displayPatientReport() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientReport(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientSearchPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientSearchPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientSelect() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientSelect(cndIO));
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
	//com.mediware.gui.patient
	//*****************************************************************************
	public void displayPatientHealthHistory(int[] historyInts, String[] historyStrings) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientHealthHistory(cndIO, historyInts, historyStrings));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientMenuPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientMenuPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientProfilePanel(String[] patientData) {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientProfilePanel(cndIO, patientData));
		currentFrame.setVisible(true);
	}
	
	public void displayPatientVitalsPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new PatientVitalsPanel(cndIO));
		currentFrame.setVisible(true);
	}
	
	//Other
	public void displayErrorDialog(String message, String type) {
		JOptionPane.showMessageDialog(currentFrame, message, type, JOptionPane.ERROR_MESSAGE);
	}
	
	//Graph drawing
	public void drawHealthHistory(int[] data) {
	 
	    PatientHealthHistory.findUpperBound(data);
	    ((PatientHealthHistory)currentFrame.getComponent(0)).getGraph().repaint();
	
	}
	
}
