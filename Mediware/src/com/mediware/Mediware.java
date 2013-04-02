package com.mediware;

import com.mediware.arch.IO;
import com.mediware.arch.Enums.partition;
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
			
			io.nextFrame(partition.CND);
			io.nextFrame(partition.SYS);
		}
		//cnd.displayLoginPanel();
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
