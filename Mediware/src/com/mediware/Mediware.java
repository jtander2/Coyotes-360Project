package com.mediware;

import com.mediware.arch.IO;
import com.mediware.display.CND;
import com.mediware.system.SYS;

public class Mediware {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IO io = new IO();
		CND cnd = new CND(io);
		SYS sys = new SYS(io);

		while(true) {
			cnd.run();
			sys.run();
			io.getInbox().emptyReadMessages();
		}
		
		//cnd.displayLoginPanel();
		//cnd.displayLoginPanel2();
		//cnd.displayMessagePanel();
		//cnd.displayReplyPanel();
		//cnd.displayResetPassword();
		//cnd.displayRtvPassword();
		//cnd.displayRtvUsername();
		//cnd.displayTempPassword();
		//cnd.displayViewMessagePanel();
		
		//cnd.displayDoctorMainPanel();
		//cnd.displayEditEmployee();
		//cnd.displayEmployeeSearchPanel();
		//cnd.displayEmployeeSelect();
		//cnd.displayMAMainPanel();				
		//cnd.displayMAPatientReport();
		//cnd.displayNewCommentPanel();			
		//cnd.displayNewEmployeePanel();
		//cnd.displayNewPatientPanel();
		//cnd.displayNurseMainPanel();
		//cnd.displayPatientProfile();
		//cnd.displayPatientReport();
		//cnd.displayPatientSearchPanel();
		//cnd.displayPatientSelect();
		//cnd.displayViewCommentPanel();
		//cnd.displayVitalsPanel();
		
		//cnd.displayPatientHealthHistory();
		//cnd.displayPatientMenuPanel();
		//cnd.displayPatientProfilePanel();
		//cnd.displayPatientVitalsPanel();
		
		//cnd.displayErrorDialog("Invalid Username or Password", "Login Error");
	}
}
