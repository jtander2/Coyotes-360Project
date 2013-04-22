package com.mediware.data;
/* -ABOUT-
 /////////////////////////////////////////////////////////////////
  		PROJECT:	CSE 360 
  		TEAM:		COYOTE
		FILENAME: 	datadriver.java
		CREATOR:	Shane Spies
		EMAIL:		stspies@asu.edu
		CREATED: 	[03-30-2013]
		CURRENT: 	[03-30-2013]
		
		DEPENDANCIES: java.sql, java.util, client, 
						employee, userinfo, account, jdbc
						./db/database.sqlite database
		
		ABOUT: 	This class performs smart operations on the database.
			It knows to add multiple data to the DB and it replaces dangerous
			sql characters with safe ones.  It also does this when it pulls it
			out from the DB.
	
	
	
	THIS VERSION: 0.1 Beta	
		-------------------
		CHANGELOG for DATABASE layer - database.java
[ / - Changed | + Feature added | ~Bugfix | - Removed | ->Implemented ] 
		0.1B	~	+GetAllClients/Employees
					+gets if an account username and password exists
					+ability to search 'like' names by using end based wildcard
					+Search for userinformation without complete information

		0.02A	~	+find DB for Username and Password combination

		0.01A	~	/Data into 6 tables
					+Parser/unparser for BP and alerts
					+Support to search every table
					-dual functionality of inserts
					->new containers
	

 /////////////////////////////////////////////////////////////////
*/

import java.util.ArrayList;
import java.util.List;

import com.mediware.data.dataContainers.account;
import com.mediware.data.dataContainers.alert;
import com.mediware.data.dataContainers.bloodpressure;
import com.mediware.data.dataContainers.client;
import com.mediware.data.dataContainers.employee;
import com.mediware.data.dataContainers.userinfo;



//TODO Add data valid so SQLinject doesn't work.
public class datadriver 
{

	private database db;	//Used for the internal Database calls
	
	
	public datadriver()
	{
		db = new database();
	}
	
	/*	--------------------------		ADD Functions		-------------------------------
 	-					Commands to add in the database are here						  -*/
	public int addClient(client oClient)
	{
		oClient.setPermissions(0);
		int AID = db.addAccount(oClient.getAccount());
		
		if ( AID < 0 )		//Checks to see if something went wrong
			return AID;
		
		if ( db.addBP(AID) < 0 )
			return -3;		//For some reason, the BP row didn't get added
		
		
		if ( db.addAlert(AID) < 0 )
			return -4;		//For some reason, the alert row didn't get added
		
		
		if ( db.addUserInfo(AID) < 0 )
			return -5;		//For some reason, the userinfo row didn't get added
		
		
		if ( db.addClientInfo(AID) < 0 )
			return -6;		//For some reason, the userinfo row didn't get added
		
		oClient = getClient(AID);
		
		db.updateBP(oClient.getBP(), AID);
		db.updateAlerts(oClient.getAlerts(), AID);
		db.updateUserInfo(oClient.getUserInfo());
		db.updateClientInfo(oClient);
		
		return AID;
	}
	
	public int addEmployee(employee oEmployee)
	{
		int AID = db.addAccount(oEmployee.getAccount());
		
		if ( AID < 0 )		//Checks to see if something went wrong
			return AID;
		
		if ( db.addUserInfo(AID) < 0 )
			return -5;		//For some reason, the userinfo row didn't get added
		db.updateUserInfo(oEmployee.getUserInfo());
		
		if ( db.addEmployeeInfo(AID, oEmployee.getEmpNum()) < 0 )
			return -6;		//For some reason, the userinfo row didn't get added
		
		return AID;
	}
	
	/*	--------------------------		GET Functions		-------------------------------
 	-					Commands to get large classes of data							  -*/
	public client getClient(int AID)
	{
		account oAccount = db.getAccount(AID);
			if (oAccount.getAID() < 0) return null;
			
		userinfo oUserInfo = db.getUserInfo(AID);
			if (oUserInfo.getAID() < 0) return null;
			
		List<bloodpressure> BP = db.getBP(AID);
		List<alert> alerts = db.getalerts(AID);
		
		client oClient = db.getClientInfo(AID);
			if (oClient.getAID() < 0) return null;
			
		return new client(oAccount, oUserInfo, BP, alerts, oClient);
	}
	
	public employee getEmployee(int AID)
	{
		account oAccount = db.getAccount(AID);
			if (oAccount.getAID() < 0) return null;
		
		userinfo oUserInfo = db.getUserInfo(AID);
			if (oUserInfo.getAID() < 0) return null;
		
		employee oEmployee  = db.getEmployeeInfo(AID);
			if (oEmployee.getAID() < 0) return null;
		
		return new employee(oAccount, oUserInfo, oEmployee);
	}
	
	//Returns the permission level of the associated AID, used to determine account type
	public int getPermission(int AID)
	{
		account oAccount = db.getAccount(AID);
		
		if(oAccount.getAID() < 0)
			return -1;
		
		return db.getAccount(AID).getPermissions();
	}
	
	public account getAccount(int AID)
	{
		return db.getAccount(AID);
	}
	
	//Gets all of the clients in the database
	public List<client> getAllClients()
	{
		List<client> accountList = new ArrayList<client>();
		List<Integer> aList = new ArrayList<Integer>();
		aList = getAllClientsNum();
		
		for(int i = 0; i < aList.size(); i++)	//populate the data in the list
		{
			accountList.add(getClient(aList.get(i)));
		}
		
		return accountList;
	}
	
	//Gets all of the Employees in the Database
	public List<employee> getAllEmployees()
	{
		List<Integer> aList = new ArrayList<Integer>();
		List<employee> accountList = new ArrayList<employee>();
		aList = getAllEmployeesNum();
		
		for(int i = 0; i < aList.size(); i++)	//populate the data in the list
		{
			accountList.add(getEmployee(aList.get(i)));
		}
	
		return accountList;
	}
	
	//Gets all of the clients in the database and returns their reference ID
	public List<Integer> getAllClientsNum()
	{
		List<Integer> aList = new ArrayList<Integer>();
		client oClient = new client();
		oClient.setPermissions(0);
		
		aList = db.findAccount(oClient.getAccount());
		
		return aList;
	}
	
	//Gets all of the Employees in the Database and returns their reference ID
	public List<Integer> getAllEmployeesNum()
	{
		List<Integer> aList = new ArrayList<Integer>();
		employee oEmployee = new employee();
		oEmployee.setPermissions(-2);		//Special token to search all things not zero
		
		aList = db.findAccount(oEmployee.getAccount());
		
		return aList;
	}
	
	
	/*	--------------------------		EXISTS Functions		-------------------------------
 	-					Commands to see if an account ID exists							    	-*/
	public boolean existsAccount(int AID)
	{
		return db.existsAccount(AID);
	}
	
	public boolean existsClientInfo(int aid)
	{
		return db.existsClientInfo(aid);
	}
	
	public boolean existsUserInfo(int aid)
	{
		return db.existsUserInfo(aid);
	}
	
	public boolean existsBloodPressure(int aid)
	{
		return db.existsBloodPressure(aid);
	}
	
	public boolean existsAlert(int aid)
	{
		return db.existsAlert(aid);
	}
	
	public boolean existsEmployeeInfo(int aid)
	{
		return db.existsEmployeeInfo(aid);
	}
	
	//Check to see if a username is available to use
	public boolean isUsernameAvail(String username)
	{
		account oAccount = new account();
		oAccount.setUsername(username);
		
		return !db.findAccount(oAccount).isEmpty();
	}
		
		//Check to see if a password is available to use
	public boolean isEmailAvail(String email)
	{
		account oAccount = new account();
		oAccount.setEmail(email);
		
		return !db.findAccount(oAccount).isEmpty();
	}
	
	/*	--------------------------		FIND Functions		-------------------------------
 	-					Commands to find and return data from the DB					  -*/
	
	//This function checks for Username and Password in accounts
	//Returns : -1 = No User found | positive int = AID
	public int findUserPass(String username, String password)
	{
		account oAccount = new account();
		oAccount.setUsername(username);
		oAccount.setPassword(password);
		
		List<Integer> oIntList = db.findAccount(oAccount);
		
		if(oIntList.isEmpty())	//Does a quick check to see if the user is good.
			return -1;
		
		//What if someone had a like username and the same password? (amazingly)
		if(oIntList.size() > 1)	
		{
			for(int i = 0; i <= oIntList.size(); i++)
			{
				account iAccount = getAccount(oIntList.get(i));
				if(iAccount.getUsername().matches(username) && iAccount.getPassword().matches(password))
					return oIntList.get(i);		//This one matched in the list
			}
			return -1;		
		}
		
		return oIntList.get(0);
	}
	
	//Searches for an employee via the user information like name
	public List<employee> findEmpByInfo(userinfo oUserInfo)
	{
		List<employee> lUserInfo = new ArrayList<employee>();
		List<Integer> lAID = db.searchuserInfo(oUserInfo);
		
		for(int i = 0; i < lAID.size(); i++)
		{
			int AID = lAID.get(i);
			employee oEmployee = getEmployee(AID);
			if(oEmployee != null)
				lUserInfo.add(oEmployee);
		}
		
		return lUserInfo;
	}
	
	//Searches for an client via the user information like name searches not case sense
	public List<client> findClientByInfo(userinfo oUserInfo)
	{
		List<client> lUserInfo = new ArrayList<client>();
		List<Integer> lAID = db.searchuserInfo(oUserInfo);
		
		for(int i = 0; i < lAID.size(); i++)
		{
			int AID = lAID.get(i);
			client oClient = getClient(AID);
			if(oClient != null)
				lUserInfo.add(oClient);
		}
		return lUserInfo;
	}
	
	
	/*	--------------------------		EDIT Functions		-------------------------------
 	-					Commands to edit the data in the database						  -*/
	
	public boolean editClient(client oClient)
	{
		//TODO Make sure we can actually perform all of the required edits first
		int AID = oClient.getAID();
		
		if( db.updateAccountInfo(oClient.getAccount()) < 0 ) return false;
		if( db.updateBP(oClient.getBP(), AID) < 0)  return false;
		if( db.updateAlerts(oClient.getAlerts(), AID) < 0) return false;
		if( db.updateUserInfo(oClient.getUserInfo()) < 0 ) return false;
		if( db.updateClientInfo(oClient) < 0 ) return false;
		
		return true;
	}
	
	public boolean editEmployee(employee oEmployee)
	{
		//TODO Make sure we can actually perform all of the required edits first
		
		if( db.updateAccountInfo(oEmployee.getAccount()) < 0 ) return false;
		if( db.updateUserInfo(oEmployee.getUserInfo()) < 0 ) return false;
		if( db.updateEmployeeInfo(oEmployee) < 0 ) return false;
		
		return true;
	}
	

	/*	--------------------------		DELETE Functions		-------------------------------
 	-					Commands to remove in the database are here						  -*/

	public boolean deleteClient(int AID)
	{
		if ( !db.removeAccount(AID) )	
			return false;
		
		if ( !db.removeBP(AID) )
			return false;		//For some reason the BP row wasn't there.
		
		if ( !db.removeAlert(AID))
			return false;	
		
		if ( !db.removeuserInfo(AID))
			return false;		
		
		if ( !db.removeClient(AID))
			return false;		
		return true;
	}
	
	public boolean deleteEmployee(int AID)
	{
		if ( !db.removeAccount(AID) )	
			return false;
		
		if ( !db.removeuserInfo(AID))
			return false;
		
		if ( !db.removeEmployee(AID))
			return false;	
		
		return true;
	}
}
