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
	private int mPerm;
	
	//constructor - IO as an argument.
	public SYS(IO theIO){
		this.sysIO = theIO;
		//----------
		//the folowing block of code will add a client to the database for testing
		client theClient = new client("doctor", "doctor"); // UN: test PW:test
		System.out.println(DB.addClient(theClient)); //adds client to database
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
		    		{	
		    			//get AID
		    			int AID = DB.findUserPass(loginParams[0], loginParams[1]);
		    			
		    			System.out.println("AID: " + AID);
		    			//determine permissions
		    			mPerm = DB.getPermission(AID);
		    			
		    			System.out.println("PERMISSIONS: " + mPerm);
		    			
		    			if(mPerm == 0)
		    				System.out.println("No permissions");
		    			else if(mPerm == 1) //client
		    			{
			    			System.out.println("Should send message to CND to display patient menu");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayPatientMenuPanel);
		    				
		    			}
		    			else if(mPerm == 2) //ofc
		    			{
	
		    			}
		    			else if(mPerm == 3) //ma
		    			{
			    			System.out.println("Should send message to CND to display MA main panel");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayMAMainPanel);
		    			}
		    			else if(mPerm == 4) //nurse
		    			{
			    			System.out.println("Should send message to CND to display MA main panel");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayNurseMainPanel);
		    			}
		    			else //doctor
		    			{
			    			System.out.println("Should send message to CND to display doctor panel");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayDoctorMainPanel);	
		    			}
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
				case sysLogoutRequest:
					// Clear saved data
					mPerm = 0;	//no permissions
					// Send message to CND to display the login panel
					int[] intParams = new int[0];
					String[] stringParams = new String[0];
					mData messageData = new mData(intParams, stringParams);
					partition[] subscribers = {partition.CND};
					sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayLoginPanel);
					break;
				case sysPatientEditProfileRequest:
					// Send message to CND to display the edit profile screen with the correct parameters
					int[] intPs = new int[0];
					String[] stringPs = {"fname", "mname", "lname", "street", "city", "state", "zip", "homenum", "worknum", "mobilenum", "email", "provider", "policy", "group"};
					mData messageD = new mData(intPs, stringPs);
					partition[] subscriber = {partition.CND};
					sysIO.createMessageToSend(partition.SYS, subscriber, messageD, mType.cndDisplayPatientProfilePanel);					
					break;
				case sysUpdatePatient:
					
					break;
				case sysGoToMenu:
					int[] emptyInts = new int[0];
					String[] emptyStrings = new String[0];
					mData emptyData = new mData(emptyInts, emptyStrings);
					partition[] subscriberCND = {partition.CND};
					if(mPerm == 0) {
						//no permissions
					} else if(mPerm == 1) {
						//patient
						sysIO.createMessageToSend(partition.CND, subscriberCND, emptyData, mType.cndDisplayPatientMenuPanel);
					} else if(mPerm == 2) {
						//ofc
					} else if(mPerm == 3) {
						//ma
						sysIO.createMessageToSend(partition.CND, subscriberCND, emptyData, mType.cndDisplayMAMainPanel);
					} else if(mPerm == 4) {
						//nurse
						sysIO.createMessageToSend(partition.CND, subscriberCND, emptyData, mType.cndDisplayNurseMainPanel);
					} else {
						//doctor
						sysIO.createMessageToSend(partition.CND, subscriberCND, emptyData, mType.cndDisplayDoctorMainPanel);
					}
				default:
					break;					
			}
			
		}
		
	
		
	}
		
}