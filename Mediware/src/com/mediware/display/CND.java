package com.mediware.display;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.mediware.gui.LoginPanel;
import com.mediware.gui.LoginPanel2;
import com.mediware.gui.MessagePanel;
import com.mediware.gui.ReplyPanel;
import com.mediware.gui.ResetPassword;
import com.mediware.gui.RtvPassword;
import com.mediware.gui.RtvUsername;
import com.mediware.gui.TempPassword;
import com.mediware.gui.ViewMessagePanel;
import com.mediware.gui.doctor.DoctorMainPanel;


public class CND {

	private JFrame currentFrame;
	private ArrayList<JFrame> previousFrames;
	
	public CND() {
		currentFrame = new JFrame("Mediware Health Services");
		currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		currentFrame.setSize(400, 400);
		currentFrame.setLayout(new FlowLayout()); 
		currentFrame.setVisible(true);
		
		previousFrames = new ArrayList<JFrame>();
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
		currentFrame.getContentPane().add(new LoginPanel(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayLoginPanel2() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new LoginPanel2(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayMessagePanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new MessagePanel(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayReplyPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ReplyPanel(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayResetPassword() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ResetPassword(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayRtvPassword() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new RtvPassword());
		currentFrame.setVisible(true);
	}
	
	public void displayRtvUsername() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new RtvUsername());
		currentFrame.setVisible(true);
	}
	
	public void displayTempPassword() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new TempPassword(currentFrame));
		currentFrame.setVisible(true);
	}
	
	public void displayViewMessagePanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new ViewMessagePanel(currentFrame));
		currentFrame.setVisible(true);
	}
	
	//*****************************************************************************
	//com.mediware.gui.doctor
	//*****************************************************************************
	public void displayDoctorMainPanel() {
		currentFrame.getContentPane().removeAll();
		currentFrame.setVisible(false);
		currentFrame.getContentPane().add(new DoctorMainPanel(currentFrame));
		currentFrame.setVisible(true);
	}
	
	//*****************************************************************************
	//com.mediware.patient
	//*****************************************************************************
	
}
