package com.mediware.system;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mediware.arch.IO;
import com.mediware.arch.Message;
import com.mediware.arch.mData;
import com.mediware.arch.Enums.partition;
import com.mediware.arch.Enums.mType;
import com.mediware.service.LoginService;
import com.mediware.service.PatientHistoryService;
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
	private int AID;
	
	//constructor - IO as an argument.
	public SYS(IO theIO){
		this.sysIO = theIO;
		//----------
		//the folowing block of code will add a client to the database for testing
		//client theClient = new client("doctor", "doctor"); // UN: test PW:test
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
		    		{	
		    			//get AID
		    		    	AID = DB.findUserPass(loginParams[0], loginParams[1]);
		    			
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
					
				case sysCreateEmployee:
					//create a new employee - insert in database
					// Message has string array created as follows:
					// Index = 0      1      2      3      4      5     6       7          8           9         10   11       12            13         14        15
					//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, dob, employeenum, permissions, username, password};
					
					String[] paramE = sysMessages[i].getMessageData().getLabels();
					
					//first check and make sure username is available
						if(DB.isUsernameAvail(paramE[14])) {
							int[] intParams = new int[0];
			    			String[] stringParams = {"Username is already taken! Please select a new one.", "Create Employee Error"};
			    			mData messageData = new mData(intParams, stringParams);
			    			partition[] subscribers = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayErrorDialog);
						}
						
		    			//Run another check to see if the email we're adding is valid
		    			if(DB.isEmailAvail(paramE[10])){
							int[] intParams1 = new int[0];
			    			String[] stringParams1 = {"Email is already in use! Please select a new one.", "Create Employee Error"};
			    			mData messageData1 = new mData(intParams1, stringParams1);
			    			partition[] subscribers1 = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers1, messageData1, mType.cndDisplayErrorDialog);
		    			} 
		    			
		    			//Run yet another check to see if the empNumber is not in use
		    			if(DB.isEmpNumAvail(paramE[12])){
							int[] intParams1 = new int[0];
			    			String[] stringParams1 = {"That employee number is already in use! Please select a new one.", "Create Employee Error"};
			    			mData messageData1 = new mData(intParams1, stringParams1);
			    			partition[] subscribers1 = {partition.CND};
			    			sysIO.createMessageToSend(partition.SYS, subscribers1, messageData1, mType.cndDisplayErrorDialog);
		    			} 
		    			
					else{						
						//create and fill out new employee
						employee E = new employee();
						E.setFname(paramE[0]);
						E.setMname(paramE[1]);
						E.setLname(paramE[2]);
						E.setAddress1(paramE[3]);
						E.setCity(paramE[4]);
						E.setState(paramE[5]);
						E.setZip(paramE[6]);
						E.setPhoneHome(paramE[7]);
						E.setPhoneWork(paramE[8]);
						E.setPhoneMobile(paramE[9]);
						E.setEmail(paramE[10]);
						//E.setDOB(paramE[11]);
						E.setEmpNum(Integer.parseInt(paramE[12]));
						E.setUsername(paramE[14]);
						E.setPassword(paramE[15]);
						
						//for permissions
						if(paramE[13].equals("ma"))
							E.setPermissions(3);
						else if(paramE[13].equals("nurse"))
							E.setPermissions(4);
						else
						{
							E.setPermissions(5);
						}
												
						//insert the newly created employee into the database
						DB.addEmployee(E);
						

						//Send message back to SYS (self) sysGoToMenu
						int[] emptyInt = new int[0];
		    			String[] emptyParams = {"", ""};
		    			mData messageData = new mData(emptyInt, emptyParams);
		    			partition[] subscribers = {partition.SYS};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.sysGoToMenu);
					}
					
					break;
				case sysCreatePatient:
					String[] paramC = sysMessages[i].getMessageData().getLabels();
					
					//Example of how to display an error message if username is already in the db
					if(DB.isUsernameAvail(paramC[17])) {
						int[] intParams = new int[0];
		    			String[] stringParams = {"Cannot use this username. Please select a new one.", "Create Patient Error"};
		    			mData messageData = new mData(intParams, stringParams);
		    			partition[] subscribers = {partition.CND};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.cndDisplayErrorDialog);
					}else{
						
						//create new patient and add to DB
						// Message has string array created as follows:
						// Index = 0      1      2      3      4      5     6       7          8           9         10      11         12        13      14    15      16       17        18
						//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, provider, policynum, groupnum, dob, height, weight, username, password};
						client C;
					    	if(sysMessages[i].getMessageData().getArguments().length == 1) {
					    	C = new client(sysMessages[i].getMessageData().getArguments()[0]); // UN: test PW:test
					}	else {
					    C = new client(AID);
					}
						C.setUsername(paramC[17]);
						C.setPassword(paramC[18]);
						C.setFname(paramC[0]);
						C.setMname(paramC[1]);
						C.setLname(paramC[2]);
						C.setAddress1(paramC[3]);
						C.setCity(paramC[4]);
						C.setState(paramC[5]);
						C.setZip(paramC[6]);
						C.setPhoneHome(paramC[7]);
						C.setPhoneWork(paramC[8]);
						C.setPhoneMobile(paramC[9]);
						C.setEmail(paramC[10]);
						C.setProvider(paramC[11]);
						C.setPolicy(paramC[12]);
						C.setGroup(paramC[13]);
						//C.setDOB(paramC[14];		//TODO add these data
						//C.setHeight(paramC[15]);
						//C.setWeight(paramC[16]);   
						
						//insert the newly created patient into the database
						DB.addClient(C);
						
						//Send message back to SYS (self) sysGoToMenu
						int[] emptyInt = new int[0];
		    			String[] emptyParams = {"", ""};
		    			mData messageData = new mData(emptyInt, emptyParams);
		    			partition[] subscribers = {partition.SYS};
		    			sysIO.createMessageToSend(partition.SYS, subscribers, messageData, mType.sysGoToMenu);
					
					}
					
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
					client oc = DB.getClient(AID);
					String[] stringPs = {oc.getFname(), oc.getMname(), oc.getLname(), oc.getAddress1(), oc.getCity(), oc.getState(), oc.getZip(), oc.getPhoneHome(), oc.getPhoneWork(), oc.getPhoneMobile(), oc.getEmail(), oc.getProvider(), oc.getPolicy(), oc.getGroup()};
					mData messageD = new mData(intPs, stringPs);
					partition[] subscriber = {partition.CND};
					sysIO.createMessageToSend(partition.SYS, subscriber, messageD, mType.cndDisplayPatientProfilePanel);					
					break;
					
				case sysUpdatePatient:
					//for updating patient info
					System.out.println(this.AID);
					
					String[] paramCl = sysMessages[i].getMessageData().getLabels();
					
					System.out.println(paramCl[2]);
		
					client C = DB.getClient(this.AID);
					
					//edits database
					C.setFname(paramCl[0]);
					C.setMname(paramCl[1]);
					C.setLname(paramCl[2]);
					C.setAddress1(paramCl[3]);
					C.setCity(paramCl[4]);
					C.setState(paramCl[5]);
					C.setZip(paramCl[6]);
					C.setPhoneHome(paramCl[7]);
					C.setPhoneWork(paramCl[8]);
					C.setPhoneMobile(paramCl[9]);
					C.setEmail(paramCl[10]);
					C.setProvider(paramCl[11]);
					C.setPolicy(paramCl[12]);
					C.setGroup(paramCl[13]);
					
					DB.editClient(C);
					
					//Send message back to SYS (self) sysGoToMenu
					int[] emptyInt = new int[0];
	    			String[] emptyParams = {"", ""};
	    			mData message_Data = new mData(emptyInt, emptyParams);
	    			partition[] subscribers_1 = {partition.SYS};
	    			sysIO.createMessageToSend(partition.SYS, subscribers_1, message_Data, mType.sysGoToMenu);
					
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
						sysIO.createMessageToSend(partition.SYS, subscriberCND, emptyData, mType.cndDisplayPatientMenuPanel);
					} else if(mPerm == 2) {
						//ofc
					} else if(mPerm == 3) {
						//ma
						sysIO.createMessageToSend(partition.SYS, subscriberCND, emptyData, mType.cndDisplayMAMainPanel);
					} else if(mPerm == 4) {
						//nurse
						sysIO.createMessageToSend(partition.SYS, subscriberCND, emptyData, mType.cndDisplayNurseMainPanel);
					} else {
						//doctor
						sysIO.createMessageToSend(partition.SYS, subscriberCND, emptyData, mType.cndDisplayDoctorMainPanel);
					}
					break;
					
				case patientHistoryRequest:
				    //CND is requesting patient history for type of StringArg[0]
				    
				    String type = sysMessages[i].getMessageData().getLabels()[0];
				    PatientHistoryService phs = new PatientHistoryService(DB);
				    
				    int[] data = phs.process(type, AID);
				    String[] stringPs1 = {type};
				    mData messageD1 = new mData(data, stringPs1);
				    partition[] subscriber1 = {partition.CND};
				    sysIO.createMessageToSend(partition.SYS, subscriber1, messageD1, mType.patientHistoryData);

				    break;
				case patientVitalsEntry:
				    bloodpressure newBP = new bloodpressure(AID, sysMessages[i].getMessageData().getArguments()[4] + "", sysMessages[i].getMessageData().getArguments()[0] + "", sysMessages[i].getMessageData().getArguments()[3] + "", sysMessages[i].getMessageData().getArguments()[2] + "", sysMessages[i].getMessageData().getArguments()[1] + "");
				    
					client fucker = DB.getClient(AID);
					fucker.getBP().add(newBP);
				    DB.editClient(fucker);
				    
					break;
				case doctorPatientSearchRequest:
				    String lastName = sysMessages[i].getMessageData().getLabels()[0];
				    userinfo searchClient = new userinfo();
				    searchClient.setLname(lastName);
				    
				    Object[] clients = DB.findClientByInfo(searchClient).toArray();
				    
				    String[] names = new String[clients.length];
				    int[] ids = new int[clients.length];
				    
				    for(int index = 0; index < clients.length; index++) {
					names[i] = ((client)clients[i]).getFname() + " " + ((client)clients[i]).getLname();
					ids[i] = ((client)clients[i]).getAID();
				    }
				    
				    mData messageD11 = new mData(ids, names);
				    partition[] subscriber11 = {partition.CND};
				    sysIO.createMessageToSend(partition.SYS, subscriber11, messageD11, mType.cndPatientSearchReport);
				    break;
				    
				case sysSelectPatient:
				    	int searchedClientAID = sysMessages[i].getMessageData().getArguments()[0];
				    
					int[] intPs1 = {searchedClientAID};
					client oc1 = DB.getClient(searchedClientAID);
					String[] stringPs11 = {oc1.getFname(), oc1.getMname(), oc1.getLname(), oc1.getAddress1(), oc1.getCity(), oc1.getState(), oc1.getZip(), oc1.getPhoneHome(), oc1.getPhoneWork(), oc1.getPhoneMobile(), oc1.getEmail(), oc1.getProvider(), oc1.getPolicy(), oc1.getGroup()};
					mData messageD111 = new mData(intPs1, stringPs11);
					partition[] subscriber111 = {partition.CND};
					sysIO.createMessageToSend(partition.SYS, subscriber111, messageD111, mType.cndDisplayPatientProfilePanel);
				    
				    break;
				default:
					break;					
			}
			
		}
		
	
		
	}
		
}