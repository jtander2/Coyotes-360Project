package com.mediware.system;

import javax.swing.JOptionPane;

import com.mediware.arch.IO;
import com.mediware.arch.Message;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.partition;
import com.mediware.arch.Enums.mType;
import com.mediware.service.LoginService;
import com.mediware.data.dataContainers.*;
import com.mediware.data.*;

/**
 *  Class for system controls partition. 
 * @author Cameron Keith
 */
public class SYS{
	
	private IO sysIO;
	private datadriver DB = new datadriver();
	private Message[] sysMessages; 		
	private int current_mType;
	private account current_Account;
	
	//constructor - IO as an argument.
	public SYS(IO theIO){
		this.sysIO = theIO;
		//----------
		//the folowing block of code will add a client to the database for testing
		//client theClient = new client("tester", "password"); // UN: test PW:test
		//System.out.println(DB.addClient(theClient)); //adds client to database
		//----------
	}
	
	

	/**
	 * called by main. Checks for messages, executes functions
	 * and sends messages using IO if necessary. 
	 */
	public void run()
	{

		
		//first retrieve messages
		sysMessages = sysIO.nextFrame(partition.SYS);
		for(int i = 0; i < sysMessages.length; i++) {
			switch(sysMessages[i].getMessageType()) {
				case loginRequest:
					LoginService log = new LoginService(DB);
					System.out.println("loginRequest being processed");
					String[] loginParams = sysMessages[i].getMessageData().getLabels();
					// Check if name & pass are valid
		    		if (log.authenticate(loginParams[0], loginParams[1]))
		    		{	// User is valid, so show their main panel based on their user type
		    			//Send a message to CND to display DoctorMainPanel
		    			System.out.println("Should send message to CND");
		    			int[] intParams = new int[0];
		    			String[] stringParams = new String[0];
		    			mData messageData = new mData(intParams, stringParams);
		    			partition[] subscribers = {partition.CND};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayDoctorMainPanel);
		    		}
		    		else
		    		{	// User is invalid
		    			int[] intParams = new int[0];
		    			String[] stringParams = {"Invalid Username or Password", "Login Error"};
		    			mData messageData = new mData(intParams, stringParams);
		    			partition[] subscribers = {partition.CND};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayErrorDialog);
		    		}
					break;
				case loginResponse:
					break;
				case sysCreateEmployee:
					break;
				case sysCreatePatient:
					String[] params = sysMessages[i].getMessageData().getLabels();
					
					//Example of how to display an error message if username is already in the db
					if(params[17].equals("test")) {
						int[] intParams = new int[0];
		    			String[] stringParams = {"Cannot use this username. Please select a new one.", "Create Patient Error"};
		    			mData messageData = new mData(intParams, stringParams);
		    			partition[] subscribers = {partition.CND};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayErrorDialog);
					}
					//End example
					
					break;
				default:
					break;					
			}
			
		}
		
	
		
	}
		
}