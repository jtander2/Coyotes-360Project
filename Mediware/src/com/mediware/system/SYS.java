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
		    			int perm = DB.getPermission(AID);
		    			
		    			System.out.println("PERMISSIONS: " + perm);
		    			
		    			if(perm == 0)
		    				System.out.println("No permissions");
		    			else if(perm == 1) //client
		    			{
			    			System.out.println("Should send message to CND to display patient menu");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayPatientMenuPanel);
		    				
		    			}
		    			else if(perm == 2) //ofc
		    			{
	
		    			}
		    			else if(perm == 3) //ma
		    			{
			    			System.out.println("Should send message to CND to display MA main panel");
			    			int[] intParams = new int[0];
			    			String[] stringParams = new String[0];
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayMAMainPanel);
		    			}
		    			else if(perm == 4) //nurse
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
				default:
					break;					
			}
			
		}
		
	
		
	}
		
}