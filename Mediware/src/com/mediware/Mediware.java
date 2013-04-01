package com.mediware;

import javax.swing.JFrame;

import com.mediware.display.CND;

public class Mediware {
	private static JFrame frame;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CND cnd = new CND();
		cnd.displayLoginPanel();
		//cnd.displayLoginPanel2();
		//cnd.displayMessagePanel();
		//cnd.displayReplyPanel();
		//cnd.displayResetPassword();
		//---scnd.displayRtvPassword(); //not working yet
		//---cnd.displayRtvUsername();  //not working yet
		//cnd.displayTempPassword();
		//cnd.displayViewMessagePanel();
		
		//cnd.displayDoctorMainPanel();
	}
}
