package com.mediware.data;
/* -ABOUT-
 /////////////////////////////////////////////////////////////////
  		PROJECT:	CSE 360 
  		TEAM:		COYOTE
		FILENAME: 	database.java
		CREATOR:	Shane Spies
		EMAIL:		stspies@asu.edu
		CREATED: 	[03-27-2013]
		CURRENT: 	[04-18-2013]
		
		DEPENDANCIES: java.sql, java.util, client, 
						employee, userinfo, account, jdbc
						./db/database.sqlite
		
		ABOUT: 	This program performs add/remove/edit/search operations
				on SQLite data. This only performs singular operations such
				as only one add or one delete at a time. This is not intelligent, 
				but it does catch stuff like duplicate data.  This does not check 
				valid data.  Think of these as java SQL stored procedures because
				this assembles SQL strings and executes them.
	
	THIS VERSION: 0.2 Beta	
		-------------------
		CHANGELOG for DATABASE layer - database.java
[ / - Changed | + Feature added | ~Bugfix | - Removed | ->Implemented ] 
		0.2B	+	new col for clientinfo weight, height, dob
				+	BP now has col sug 

		0.1B	~ 	~middlename not searching correctly
				+	wildcard search for userInfo
				+	Able to search for all employees now
		
		0.1B	~	/Data into 6 tables
					+Parser/unparser for BP and alerts
					+Support to search every table
					-dual functionality of inserts
					->new containers
		
		0.01A	~ 	Established generic database structure. 
					Formed methods to work with SQL data
					Uploaded to Dropbox
					Contained datadriver

If you got Firefox, I use this:
https://addons.mozilla.org/en-US/firefox/addon/sqlite-manager/
to look at all of the SQLite data.

 /////////////////////////////////////////////////////////////////
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.mediware.data.dataContainers.account;
import com.mediware.data.dataContainers.alert;
import com.mediware.data.dataContainers.bloodpressure;
import com.mediware.data.dataContainers.client;
import com.mediware.data.dataContainers.employee;
import com.mediware.data.dataContainers.userinfo;


/*
	About our Databases: database.sqlite
	
	We have 1 Database with 6 Tables
		accountInfo
			AID		username	password 	email	question1	question2	answer1		answer2		permissions
		alerts
			AID		priority	date	 	msg
		bloodpressure
			AID		date		BP			pulse		temp		weight 		SuguarLevel(sug)
		clientinfo
			AID		Provider	Policy		igrp  		height 		weight
		employeeInfo
			AID		empNum
		userInfo
			AID		fname		mname 		lname 	address1 	address2 	city 	state	 zip 	phonework 	phonemobile 	phonehome
*/


public class database 
{
	public database()
	{
	}
	
	//private String connectionString  = "jdbc:sqlite:B:\\program_src\\Java\\CSE360-DB\\db\\database.sqlite";
	private String connectionString  = "jdbc:sqlite:db\\database.sqlite";
	
	//SQL Constants
	private String AccountInfoLocation = "\"main\".\"accountInfo\"";
	private String alertsLocation = "\"main\".\"alerts\"";
	private String bloodpressureLocation = "bloodpressure";
	private String clientinfoTableLocation = "\"main\".\"clientinfo\"";
	private String employeeinfoLocation = "\"main\".\"employeeinfo\"";
	private String userinfoLocation = "\"main\".\"userInfo\"";
	
	
	//Insert table information
	private String AccountaddTableInfo = "(username,password,email,question1,answer1,question2,answer2,permissions)";
	private String AlertaddTableInfo = "(AID)";
	private String BPaddTableInfo = "(AID)";
	private String clientinfoaddTable = "(AID)";
	private String employeeinfoaddInfo = "(AID,empNum)";
	private String userinfoaddTable = "(AID)";
	
	/*	--------------------------		Insert Functions		-------------------------------
	 	-					Commands to add in the database are here						  -*/
	
	//Creates an account in the sqlite database returns the account ID -1 or -2 if unsuccessful
	//This only adds an ACCOUNT, account specific handlers will be executed in a WRAPPER function.
	//RETURN -1 -> account is already in the database
	//RETURN -2 -> Unknown error, SQL connection may be bad?
	public int addAccount(account acnt)
	{
		account tempacnt = new account();
		tempacnt.setEmail(acnt.getEmail());
		tempacnt.setUsername( acnt.getUsername() );
		
		//int permissionNumber = acnt.getNumPermission();
		
		if(!findAccount(tempacnt).isEmpty())	
			return -1;	//Account is already in the Database
		
		//Assemble the COMMAND part of the SQLite string
		String sqlCommand = "INSERT INTO " + AccountInfoLocation + " " + AccountaddTableInfo;
		
		//Assemble all of the data parameters
		sqlCommand += " VALUES (";
		sqlCommand += "'" + acnt.getUsername() + "',";
		sqlCommand += "'" +acnt.getPassword() + "',";
		sqlCommand += "'" +acnt.getEmail() + "',";
		sqlCommand += "'" +acnt.getQuestion1() + "',";
		sqlCommand += "'" +acnt.getAnswer1()+ "',";
		sqlCommand += "'" +acnt.getQuestion2() + "',";
		sqlCommand += "'" +acnt.getAnswer2() + "',";
		sqlCommand += "'" +acnt.getPermissions() + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		if(findAccount(tempacnt).isEmpty())	
			return -2;	//For some reason, the account wasn't added
		
		acnt.setAID( findAccount(tempacnt).get(0) );	//We get the account by searching it in the account list
		
		return acnt.getAID();
	}
	
	//Adds a blank row of alerts for the purpose of a new client account.
	//Returned is the AID or -1, -2
	public int addAlert(int AID)
	{
		//if(existsAlert(AID))	
		//	return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO " + alertsLocation + " " + AlertaddTableInfo;
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + AID + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//if(!existsAlert(AID))	
		//	return -2;	//Account is already in the Database
		
		return AID;
	}
	
	//Adds a blank row of BP for the purpose of a new client account.
	//Returned is the AID or -1, -2
	public int addBP(int AID)
	{
		
		//if(existsBloodPressure(AID))	
		//	return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO " + bloodpressureLocation + " " + BPaddTableInfo;
		
		sqlCommand += " VALUES (";
		sqlCommand += "'" + AID + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//if(!existsBloodPressure(AID))	
		//	return -2;	//Account is already in the Database
		
		return AID;
	}
	
	//Adds a new employee link to number to the database
	//Returned is the AID or -1, -2
	public int addEmployeeInfo(int AID, int empNum)
	{
		
		if(existsEmployeeInfo(AID))	
			return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO " + employeeinfoLocation + " " + employeeinfoaddInfo;
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + AID + "',";
		sqlCommand += "'" + empNum + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		return AID;
	}
	
	//Adds a blank row of BP for the purpose of a new client account.
	//Returned is the AID or -1, -2
	public int addClientInfo(int AID)
	{
		
		if(existsClientInfo(AID))	
			return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO " + clientinfoTableLocation + " " + clientinfoaddTable;
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + AID + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		if(!existsClientInfo(AID))	
			return -2;	//Account is already in the Database
		
		return AID;
	}
	
	//Adds a blank row of BP for the purpose of a new client account.
	//Returned is the AID or -1, -2
	public int addUserInfo(int AID)
	{
		
		if(existsUserInfo(AID))	
			return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO " + userinfoLocation + " " + userinfoaddTable;
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + AID + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		if(!existsUserInfo(AID))	
			return -2;	//Account is already in the Database
		
		return AID;
	}
	
	
	/*	--------------------------		FIND Functions		-------------------------------
 	-							   Return a list of AIDS								  -*/
	
	//This command finds an account based from any of the search params
	public List<Integer> findAccount(account acnt)
	{
		List<Integer> accountList = new ArrayList<Integer>();
		String sqlCommand = "SELECT * FROM accountInfo WHERE ";
		ResultSet result = null;
		
		//Checks to see if stuff is empty, if it is, don't include it in the sql command
		if(acnt.getAID() != -1 )	
			sqlCommand += "AID='"+ acnt.getAID() + "' ";
		else 
			sqlCommand += "AID<>'' ";
		
		
		if(!acnt.getUsername().isEmpty())
			sqlCommand += "AND username='"+ acnt.getUsername() + "' ";
		
		if(!acnt.getPassword().isEmpty())
			sqlCommand += "AND password='"+ acnt.getPassword() + "' ";
		
		if(!acnt.getEmail().isEmpty())
			sqlCommand+="AND email='"+ acnt.getEmail() + "' ";
		
		if(!(acnt.getQuestion1() <= 0))
			sqlCommand+="AND question1='"+ acnt.getQuestion1() + "' ";
		
		if(!(acnt.getQuestion2() <= 0))
			sqlCommand+="AND question2='"+ acnt.getQuestion2() + "' ";
		
		if(!acnt.getAnswer1().isEmpty())
			sqlCommand+="AND answer1='"+ acnt.getAnswer1() + "' ";
		
		if(!acnt.getAnswer2().isEmpty())
			sqlCommand+="AND answer2='"+ acnt.getAnswer2() + "' ";
		
		if(!acnt.getPassword().isEmpty())
			sqlCommand += "AND password='"+ acnt.getPassword() + "' ";
		
		if(!acnt.getEmail().isEmpty())
			sqlCommand+="AND email='"+ acnt.getEmail() + "' ";
		
		if(!(acnt.getPermissions() < 0))
			sqlCommand += "AND permissions='"+acnt.getPermissions() + "'";
		else if(acnt.getPermissions() == -2)
			sqlCommand += "AND permissions<>'0'";
		
		
		Connection connection = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);	
			try {
				while(result.next())
				{
					accountList.add(result.getInt("AID"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		//return null;	//Something wrong happened
		
		return accountList;
	}
	
	//This command finds a client based from any of the search params
	public List<Integer> findClient(client acnt)
	{
		List<Integer> accountList = new ArrayList<Integer>();
		String sqlCommand = "SELECT * FROM " + clientinfoTableLocation + " WHERE ";
		ResultSet result = null;
		
		//Checks to see if stuff is empty, if it is, don't include it in the sql command
		if(acnt.getAID() != -1 )	
			sqlCommand += "AID='"+ acnt.getAID() + "' ";
		else 
			sqlCommand += "AID<>'' ";
		
		if(!acnt.getProvider().isEmpty())
			sqlCommand += "AND provider='"+ acnt.getUsername() + "' ";
		
		if(!acnt.getPolicy().isEmpty())
			sqlCommand += "AND policy='"+ acnt.getPassword() + "' ";
		
		if(!acnt.getGroup().isEmpty())
			sqlCommand+="AND igrp='"+ acnt.getGroup() + "' ";
		
		if(!acnt.getHeight().isEmpty())
			sqlCommand+="AND height='"+ acnt.getHeight() + "' ";
	
		if(!acnt.getWeight().isEmpty())
			sqlCommand+="AND weight='"+ acnt.getWeight() + "' ";
		
		if(!acnt.getDob().isEmpty())
			sqlCommand+="AND dob='"+ acnt.getDob() + "' ";
		
		Connection connection = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);	
			try {
				while(result.next())
				{
					accountList.add(result.getInt("AID"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		//return null;	//Something wrong happened
		
		return accountList;
	}
	
	//This command finds user information based from any of the search params
	public List<Integer> finduserInfo(userinfo acnt)
	{
		List<Integer> accountList = new ArrayList<Integer>();
		String sqlCommand = "SELECT * FROM "+ userinfoLocation + " WHERE ";
		ResultSet result = null;
		
		//Checks to see if stuff is empty, if it is, don't include it in the sql command
		if(acnt.getAID() != -1 )	
			sqlCommand += "AID='"+ acnt.getAID() + "' ";
		else 
			sqlCommand += "AID<>'' ";
		
		
		if(!acnt.getFname().isEmpty())
			sqlCommand += "AND fname='"+ acnt.getFname() + "' ";
		
		if(!acnt.getMname().isEmpty())
			sqlCommand += "AND mname='"+ acnt.getMname() + "' ";
		
		if(!acnt.getLname().isEmpty())
			sqlCommand+="AND lname='"+ acnt.getLname() + "' ";
		
		if(!acnt.getAddress1().isEmpty())
			sqlCommand+="AND address1='"+ acnt.getAddress1() + "' ";
		
		if(!acnt.getAddress2().isEmpty())
			sqlCommand+="AND address2='"+ acnt.getAddress2() + "' ";
		
		if(!acnt.getCity().isEmpty())
			sqlCommand += "AND city='"+acnt.getCity() + "' ";
		
		if(!acnt.getState().isEmpty())
			sqlCommand+="AND state='"+ acnt.getState() + "' ";
		
		if(!acnt.getZip().isEmpty())
			sqlCommand+="AND zip='"+ acnt.getZip() + "' ";
		
		if(!acnt.getPhoneWork().isEmpty())
			sqlCommand+="AND phonework='"+ acnt.getPhoneWork() + "' ";
		
		if(!acnt.getPhoneMobile().isEmpty())
			sqlCommand+="AND phonemobile='"+acnt. getPhoneMobile() + "' ";
		
		if(!acnt.getPhoneHome().isEmpty())
			sqlCommand+="AND phonehome='"+ acnt.getPhoneHome() + "' ";
		
		
		Connection connection = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);	
			try {
				while(result.next())
				{
					accountList.add(result.getInt("AID"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		//return null;	//Something wrong happened
		
		return accountList;
	}
	
	//searched the database for like names 
	//Search like username = fj would return fjmaps and anything matching
		public List<Integer> searchuserInfo(userinfo acnt)
		{
			List<Integer> accountList = new ArrayList<Integer>();
			String sqlCommand = "SELECT * FROM "+ userinfoLocation + " WHERE ";
			ResultSet result = null;
			
			//Checks to see if stuff is empty, if it is, don't include it in the sql command
			if(acnt.getAID() != -1 )	
				sqlCommand += "AID LIKE'"+ acnt.getAID() + "%' ";
			else 
				sqlCommand += "AID<>'' ";
			
			
			if(!acnt.getFname().isEmpty())
				sqlCommand += "AND fname LIKE '"+ acnt.getFname() + "%' ";
			
			if(!acnt.getMname().isEmpty())
				sqlCommand += "AND mname LIKE '"+ acnt.getMname() + "%' ";
			
			if(!acnt.getLname().isEmpty())
				sqlCommand+="AND lname LIKE '"+ acnt.getLname() + "%' ";
			
			if(!acnt.getAddress1().isEmpty())
				sqlCommand+="AND address1 LIKE'"+ acnt.getAddress1() + "%' ";
			
			if(!acnt.getAddress2().isEmpty())
				sqlCommand+="AND address2 LIKE'"+ acnt.getAddress2() + "%' ";
			
			if(!acnt.getCity().isEmpty())
				sqlCommand += "AND city LIKE'"+acnt.getCity() + "%' ";
			
			if(!acnt.getState().isEmpty())
				sqlCommand+="AND state LIKE'"+ acnt.getState() + "%' ";
			
			if(!acnt.getZip().isEmpty())
				sqlCommand+="AND zip LIKE'"+ acnt.getZip() + "%' ";
			
			if(!acnt.getPhoneWork().isEmpty())
				sqlCommand+="AND phonework LIKE'"+ acnt.getPhoneWork() + "%' ";
			
			if(!acnt.getPhoneMobile().isEmpty())
				sqlCommand+="AND phonemobile LIKE'"+acnt. getPhoneMobile() + "%' ";
			
			if(!acnt.getPhoneHome().isEmpty())
				sqlCommand+="AND phonehome LIKE'"+ acnt.getPhoneHome() + "%' ";
			
			
			Connection connection = null;
			Statement statement = null;
			
			try 
			{
				Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
				connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
				statement = connection.createStatement();
				result = statement.executeQuery(sqlCommand);	
				try {
					while(result.next())
					{
						accountList.add(result.getInt("AID"));
					}
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					connection.close();
					result.close();
					statement.close();
				}
				catch (Exception e )
				{
					e.printStackTrace();
				}
			}
			//return null;	//Something wrong happened
			
			return accountList;
		}
	
	//This command finds an employee based from any of the search params
	public List<Integer> findEmployee(employee acnt)
	{
		List<Integer> accountList = new ArrayList<Integer>();
		String sqlCommand = "SELECT * FROM "+ employeeinfoLocation + " WHERE ";
		ResultSet result = null;
		
		//Checks to see if stuff is empty, if it is, don't include it in the sql command
		if(acnt.getAID() != -1 )	
			sqlCommand += "AID='"+ acnt.getAID() + "' ";
		else 
			sqlCommand += "AID<>'' ";
		
		if(!(acnt.getEmpNum() < 0))
			sqlCommand += "AND empNum='"+acnt.getEmpNum() + "'";
		
		Connection connection = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);	
			try {
				while(result.next())
				{
					accountList.add(result.getInt("AID"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		//return null;	//Something wrong happened
		
		return accountList;
	}
	
	/*	--------------------------		GET Functions		-------------------------------
 	-						   return an entity based on AID	     					  -
 				returns of -1 signals that it doesn't exist								  */
	
	
	//This command gets account information based from the AID
	public account getAccount(int aid)
	{
		String sqlCommand = "SELECT * FROM " + AccountInfoLocation + " WHERE ";
		ResultSet result = null;
		account oAccount = new account(-1);
			
		sqlCommand += "AID='"+ aid + "'";

		Connection connection = null;
		Statement statement = null;
		
		//Gets the account information
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{
					oAccount.setAID(result.getInt("AID"));
					oAccount.setUsername(result.getString("username"));
					oAccount.setPassword(result.getString("password"));
					oAccount.setEmail(result.getString("email"));
					oAccount.setQuestion1(result.getInt("question1"));
					oAccount.setQuestion2(result.getInt("question2"));
					oAccount.setAnswer1(result.getString("answer1"));
					oAccount.setAnswer2(result.getString("answer2"));
					oAccount.setPermissions(result.getInt("permissions"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}	
		return oAccount;
	}
	
	//This command gets the list of alerts based on AID
	public List<alert> getalerts(int aid)
		{
			String sqlCommand = "SELECT * FROM " + alertsLocation + " WHERE ";
			ResultSet result = null;
			List<alert> alerts = new ArrayList<alert>();
				
			sqlCommand += "AID='"+ aid + "'";
			
			//SQL connection vars
			Connection connection = null;
			Statement statement = null;
			
			//Vars used to hold the large data strings
			int AID = -1;
			String Date = "";
			String MSG = "";
			String priority = "";
			
			
			//Gets the account information
			try 
			{
				Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
				connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
				statement = connection.createStatement();
				result = statement.executeQuery(sqlCommand);
				try {
					while(result.next())
					{
						AID = result.getInt("AID");
						Date = result.getString("date");
						MSG = result.getString("msg");
						priority = result.getString("priority");
					}
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					connection.close();
					result.close();
					statement.close();
				}
				catch (Exception e )
				{
					e.printStackTrace();
				}
			}	
			alerts = parseAlerts(AID, Date, MSG, priority);
			return alerts;
		}
	
	//This command gets the list of Blood Pressure based on AID
	public List<bloodpressure> getBP(int aid)
		{
			String sqlCommand = "SELECT * FROM " + bloodpressureLocation + " WHERE ";
			ResultSet result = null;
			List<bloodpressure> bloodpressures = new ArrayList<bloodpressure>();
			
			sqlCommand += "AID='"+ aid + "'";

			//SQL connection vars
			Connection connection = null;
			Statement statement = null;
			
			//Vars used to hold the large data strings
			int AID = -1;
			String date = "";
			String BP = "";
			String pulse = "";
			String temp = "";
			String weight = "";
			String sug = "";
			
			
			//Gets the account information
			try 
			{
				Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
				connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
				statement = connection.createStatement();
				result = statement.executeQuery(sqlCommand);
				try {
					while(result.next())
					{
						AID = result.getInt("AID");
						date = result.getString("date");
						BP = result.getString("BP");
						pulse = result.getString("pulse");
						temp = result.getString("temp");
						weight = result.getString("weight");
						sug = result.getString("sug");
					}
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
				
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					connection.close();
					result.close();
					statement.close();
				}
				catch (Exception e )
				{
					e.printStackTrace();
				}
			}	
			bloodpressures = parseBPs(AID, date, BP, pulse, temp, weight, sug);
			return bloodpressures;
		}
	
	//This command gets account information based from the AID
	public client getClientInfo(int aid)
	{
		String sqlCommand = "SELECT * FROM " + clientinfoTableLocation + " WHERE ";
		ResultSet result = null;
		client oClient = new client(-1);
				
		sqlCommand += "AID='"+ aid + "'";
			
		Connection connection = null;
		Statement statement = null;
			
		//Gets the account information
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{
					oClient.setAID(result.getInt("AID"));
					oClient.setProvider(result.getString("provider"));
					oClient.setPolicy(result.getString("policy"));
					oClient.setGroup(result.getString("igrp"));
					oClient.setHeight("height");
					oClient.setWeight("weight");
					oClient.setDob("dob");
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
				
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}	
		return oClient;
	}
	
	//Gets the employee from the database, only really has the empNum
	public employee getEmployeeInfo(int aid)
	{
		String sqlCommand = "SELECT * FROM " + employeeinfoLocation + " WHERE ";
		ResultSet result = null;
		employee oEmployee = new employee(-1);
			
		sqlCommand += "AID='"+ aid + "'";
			
		Connection connection = null;
		Statement statement = null;
			
		//Gets the account information
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{
					oEmployee.setAID(result.getInt("AID"));
					oEmployee.setEmpNum(result.getInt("empNum"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
				
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}	
		return oEmployee;
	}
	
	//Gets an employee by empID returns AID, -1 if DNE.
	public int getEmployeebyEMPID(int empID)
	{
		String sqlCommand = "SELECT * FROM " + employeeinfoLocation + " WHERE ";
		ResultSet result = null;
		employee oEmployee = new employee(-1);
			
		sqlCommand += "empID='"+ empID + "'";		//TODO Check to make sure this is right
			
		Connection connection = null;
		Statement statement = null;
			
		//Gets the account information
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{
					oEmployee.setAID(result.getInt("AID"));
					oEmployee.setEmpNum(result.getInt("empNum"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
				
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}	
		return oEmployee.getAID();
	}
	
	//This command gets account information based from the AID
	public userinfo getUserInfo(int aid)
	{
		String sqlCommand = "SELECT * FROM " + userinfoLocation + " WHERE ";
		ResultSet result = null;
		userinfo oUserinfo = new userinfo(-1);
		
		sqlCommand += "AID='"+ aid + "'";
		
		Connection connection = null;
		Statement statement = null;
		
		//Gets the account information
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{
					oUserinfo.setAID(result.getInt("AID"));
					
					oUserinfo.setFname(result.getString("fname"));
					oUserinfo.setMname(result.getString("mname"));
					oUserinfo.setLname(result.getString("lname"));
					
					oUserinfo.setAddress1(result.getString("address1"));
					oUserinfo.setAddress2(result.getString("address2"));
					oUserinfo.setCity(result.getString("city"));
					oUserinfo.setState(result.getString("state"));
					oUserinfo.setZip(result.getString("zip"));
					
					oUserinfo.setPhoneWork(result.getString("phonework"));
					oUserinfo.setPhoneMobile(result.getString("phonemobile"));
					oUserinfo.setPhoneHome(result.getString("phonehome"));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				result.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}	
		return oUserinfo;
	}	

	/*	--------------------------		EXISTS Functions		----------------------------
 	-						Checks to see if a row exists based on AID     		    	  -*/
	
	public boolean existsAccount(int aid)
	{
		account tempaccnt = new account(aid);
		return !findAccount(tempaccnt).isEmpty();
	}
	
	public boolean existsClientInfo(int aid)
	{
		client temp = new client(aid);
		return !findClient(temp).isEmpty();
	}
	
	public boolean existsUserInfo(int aid)
	{
		userinfo temp = new userinfo(aid);
		return !finduserInfo(temp).isEmpty();
	}
	
	public boolean existsBloodPressure(int aid)
	{
		return !getBP(aid).isEmpty();
	}
	
	public boolean existsAlert(int aid)
	{
		return !getalerts(aid).isEmpty();
	}
	
	public boolean existsEmployeeInfo(int aid)
	{
		employee temp = new employee(aid);
		return !findEmployee(temp).isEmpty();
	}
	
	/*	--------------------------		REMOVE Functions		----------------------------
 	-				  Removes accounts from DB returns false when account NULL			  -*/
	
	public boolean removeAccount(int aid)
	{
		if(!existsAccount(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ AccountInfoLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	public boolean removeAlert(int aid)
	{
		if(!existsAlert(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ alertsLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	public boolean removeBP(int aid)
	{
		if(!existsBloodPressure(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ bloodpressureLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	public boolean removeClient(int aid)
	{
		if(!existsClientInfo(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ clientinfoTableLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	public boolean removeEmployee(int aid)
	{
		if(!existsEmployeeInfo(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ employeeinfoLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	public boolean removeuserInfo(int aid)
	{
		if(!existsUserInfo(aid))
			return false;
		
		//Removes the account information
		String sqlCommand = "DELETE FROM "+ userinfoLocation +" WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	
	/*	--------------------------		UPDATE Functions		----------------------------
 	-				 Update an account with ID and current information	     			  
	- 								AID cannot be modified 
						refer to individual table rules about unique fields				  -*/
	
	//WARNING: The return codes here mean something, refer to each function about what the return value means.
	//			They will mostly follow a pattern of negative numbers meaning that a field was wrong or that the value
	//			was not found. Positive return values indicate success and what AID was edited.
	
		// -1 The item isn't found
		// -2 Username cannot be changed because another user already has it
		// -3 the changed email is already linked with another account
		// else it will return the AID
	public int updateAccountInfo(account oAccount)
	{
		if (!existsAccount(oAccount.getAID()))
			return -1;
		
		account oldAccount = getAccount(oAccount.getAID());		//Gets the 'old' version of the account
		
		//Check to see if the name change is good
		if(oAccount.getUsername().compareTo(oldAccount.getUsername()) != 0)	//are we changing the username?
		{
			account tempacnt = new account();
			tempacnt.setUsername(oAccount.getUsername());
			if(!findAccount(tempacnt).isEmpty())			//Did the search return anything?
				return -2;		//Somebody else has that username
		}
		
		//Check to see if the email change is good
		if(oAccount.getEmail().compareTo(oldAccount.getEmail()) != 0)	//are we changing the email?
		{
			account tempacnt = new account();
			tempacnt.setEmail(oAccount.getEmail());
			if(!findAccount(tempacnt).isEmpty())	//Did the search return anything?
				return -3; 		//Somebody else has that email
		}
		
		//put the data into the Database
		String sqlCommand = "UPDATE " + AccountInfoLocation + " SET ";
		sqlCommand += "username='" + oAccount.getUsername() + "',";
		sqlCommand += "password='" + oAccount.getPassword() + "',";
		sqlCommand += "email='" + oAccount.getEmail() + "',";
		sqlCommand += "question1='" + oAccount.getQuestion1() + "',";
		sqlCommand += "question2='" + oAccount.getQuestion2() + "',";
		sqlCommand += "answer1='" + oAccount.getAnswer1() + "',";
		sqlCommand += "answer2='" + oAccount.getAnswer2() + "',";
		sqlCommand += "permissions='" + oAccount.getPermissions() + "'";
		sqlCommand += " WHERE AID='" + oAccount.getAID() + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return oAccount.getAID();
	}
	
	// -1 The item isn't found
	// -2 Parse encountered problems
	// else it will return the AID
	public int updateAlerts(List<alert> oAlert, int AID)
	{
		if (!existsAlert(AID))		//Check to see if the row exists
			return -1;
		
		List<String> oTempStrings = unparseAlerts(oAlert);
		
		if(oTempStrings.size() != 3)
			return -2;
		
		//put the data into the Database
		String sqlCommand = "UPDATE " + alertsLocation + " SET ";
		sqlCommand += "date='" + oTempStrings.get(0) + "',";
		sqlCommand += "msg='" + oTempStrings.get(1) + "',";
		sqlCommand += "priority='" + oTempStrings.get(2) + "'";
		sqlCommand += " WHERE AID='" + AID + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return AID;
	}
	
	// -1 The item isn't found
	// -2 Parse encountered problems
	// else it will return the AID
	public int updateBP(List<bloodpressure> oBP, int AID)
	{
		if (!existsBloodPressure(AID))		//Check to see if the row exists
			return -1;
		
		List<String> oTempStrings = unparseBPs(oBP);
		
		if(oTempStrings.size() != 6)
			return -2;
		
		//put the data into the Database
		String sqlCommand = "UPDATE " + bloodpressureLocation + " SET ";
		sqlCommand += "date='" + oTempStrings.get(0) + "',";
		sqlCommand += "BP='" + oTempStrings.get(1) + "',";
		sqlCommand += "pulse='" + oTempStrings.get(2) + "',";
		sqlCommand += "temp='" + oTempStrings.get(3) + "',";
		sqlCommand += "weight='" + oTempStrings.get(4) + "',";
		sqlCommand += "sug='" + oTempStrings.get(5) + "'";
		sqlCommand += " WHERE AID='" + AID + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return AID;
	}
	
	//Updates client information
	// -1 The item isn't found
	// else it will return the id of the account.
	public int updateClientInfo(client oClient)
	{
		if (!existsClientInfo(oClient.getAID()))
			return -1;
		
		//put the data into the Database
		String sqlCommand = "UPDATE " + clientinfoTableLocation + " SET ";
		sqlCommand += "provider='" + oClient.getProvider() + "',";
		sqlCommand += "policy='" + oClient.getPolicy() + "',";
		sqlCommand += "igrp='" + oClient.getGroup() + "',";
		sqlCommand += "height='" + oClient.getHeight() + "',";
		sqlCommand += "weight='" + oClient.getWeight() + "',";
		sqlCommand += "dob='" + oClient.getDob() + "'";
		sqlCommand += " WHERE AID='" + oClient.getAID() + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return oClient.getAID();
	}
	
	// -1 The item isn't found
	// -2 empID cannot be changed because another user already has it
	// else it will return the AID
	public int updateEmployeeInfo(employee oEmployee)
{
	if (!existsEmployeeInfo(oEmployee.getAID()))
		return -1;
	
	employee oldAccount = getEmployeeInfo(oEmployee.getAID());		//Gets the 'old' version of the account
	
	//Check to see if the number change is good
	if(oEmployee.getEmpNum() == oldAccount.getEmpNum())	//are we changing the username?
	{
		employee tempacnt = new employee();
		tempacnt.setEmpNum((oEmployee.getEmpNum()));
		if(!findEmployee(tempacnt).isEmpty())			//Did the search return anything?
			return -2;		//Somebody else has that empID
	}
	
	//put the data into the Database
	String sqlCommand = "UPDATE " + employeeinfoLocation + " SET ";
	sqlCommand += "empNum='" + oEmployee.getEmpNum() + "'";
	sqlCommand += " WHERE AID='" + oEmployee.getAID() + "'";	
	
	execSqlCommandNoR(sqlCommand);		//executes the command against SQL
	
	//Success!
	return oEmployee.getAID();
}

	// -1 The item isn't found
		// -2 Username cannot be changed because another user already has it
		// -3 the changed email is already linked with another account
		// else it will return the AID
	public int updateUserInfo(userinfo oUserInfo)
	{
		if (!existsUserInfo(oUserInfo.getAID()))
			return -1;
		
		//put the data into the Database
		String sqlCommand = "UPDATE " + userinfoLocation + " SET ";
		
		sqlCommand += "fname='" + oUserInfo.getFname() + "',";
		sqlCommand += "mname='" + oUserInfo.getMname() + "',";
		sqlCommand += "lname='" + oUserInfo.getLname() + "',";
		
		sqlCommand += "address1='" + oUserInfo.getAddress1() + "',";
		sqlCommand += "address2='" + oUserInfo.getAddress2() + "',";
		sqlCommand += "city='" + oUserInfo.getCity() + "',";
		sqlCommand += "state='" + oUserInfo.getState() + "',";
		sqlCommand += "zip='" + oUserInfo.getZip() + "',";
		
		sqlCommand += "phonework='" + oUserInfo.getPhoneWork() + "',";
		sqlCommand += "phonemobile='" + oUserInfo.getPhoneMobile() + "',";
		sqlCommand += "phonehome='" + oUserInfo.getPhoneHome() + "'";
		
		sqlCommand += " WHERE AID='" + oUserInfo.getAID() + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return oUserInfo.getAID();
	}

	/*	--------------------------		SQL Functions		----------------------------
 	-						  		 Special functions used	     					  -*/
	
	//Generic function to execute SqLite commands
	/*
	private ResultSet execSqlCommand(String Command)
	{
		Connection connection = null;
		ResultSet resultset = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			resultset = statement.executeQuery(Command);	
			return resultset;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				resultset.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
		}
		return null;	//Something wrong happened
	}
	*/
	
	//Generic function to execute SqLite commands, does not return anything
	private void execSqlCommandNoR(String Command)
		{
			Connection connection = null;
			Statement statement = null;
			
			try 
			{
				Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
				connection = DriverManager.getConnection(connectionString);	//connects to the DB
				
				statement = connection.createStatement();
				statement.execute(Command);
				//statement.executeQuery(Command);
				return;
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			finally 
			{
				try 
				{
					connection.close();
					//resultset.close();
					statement.close();
				}
				catch (Exception e )
				{
					e.printStackTrace();
				}
			}
			return;	//Something wrong happened
		}
	
	//Used to display test data
	public void testDB()
	{
		Connection connection = null;
		ResultSet resultset = null;
		Statement statement = null;
		
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);
			
			statement = connection.createStatement();
			resultset = statement.executeQuery( "SELECT * FROM accountInfo" );		//shows all of the data
			
			while (resultset.next())
			{
				System.out.println( "ID: " + resultset.getString("AID")); 
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				connection.close();
				resultset.close();
				statement.close();
			}
			catch (Exception e )
			{
				e.printStackTrace();
			}
			
		}
	}		
	
	/*	--------------------------		Helper Functions	----------------------------
 	-					 Used to parse data and perform common ops     				  -*/
		
	//Parses a list of alerts from the DB, inputs are delimed by "|"
	private List<alert> parseAlerts(int AID, String date, String msg, String priority)
	{
		List<alert> alerts = new ArrayList<alert>();
		
		alerts.add(new alert(AID));
		
		if (date == null) return alerts;
		
		alerts.clear();
		
		Scanner srcDate = new Scanner(date);
		Scanner srcMsg = new Scanner(msg);
		Scanner srcPriority = new Scanner(priority);
		
		srcDate.useDelimiter("\\|");
		srcMsg.useDelimiter("\\|");
		srcPriority.useDelimiter("\\|");
		
		while(srcDate.hasNext() && srcMsg.hasNext() && srcPriority.hasNext())	//Might not parse right if columns in SQL not barred correctly
		{
			alert Alert = new alert(AID);
			
			Alert.setDate(srcDate.next());
			Alert.setMsg(srcMsg.next());
			Alert.setPriority(srcPriority.nextInt());
			
			alerts.add(Alert);
		}
		
		srcDate.close();
		srcMsg.close();
		srcPriority.close();
		
		return alerts;
	}
	
	//Used to unparse a list of Alerts and insert them into sql
	public List<String> unparseAlerts(List<alert> alerts)
	{
		List<String> sAlerts = new ArrayList<String>();
		String Dates = "";
		String Msg = "";
		String priority = "";
		
		Iterator<alert> sIterator = alerts.iterator();
		
		while(sIterator.hasNext())
		{
			alert sAlert = sIterator.next();
			
			Dates += sAlert.getDate() + "|";
			Msg += sAlert.getMsg()+ "|";
			priority += sAlert.getPriority()+ "|";
		}
		
		sAlerts.add(Dates);			//[0]  = date
		sAlerts.add(Msg);			//[1]  = msg
		sAlerts.add(priority);		//[2]  = priority
		
		return sAlerts;
	}
	
	//Parses a list of Bloodpressures from the DB, inputs are delimed by "|"
	private List<bloodpressure> parseBPs(int AID, String date, String BP, String pulse, String temp, String weight, String sug)
	{
		List<bloodpressure> bps = new ArrayList<bloodpressure>();
		
		bps.add(new bloodpressure(AID));
		
		if (date == null)
			return bps;
		
		bps.clear();
		
		Scanner srcdate = new Scanner(date);
		Scanner srcBP = new Scanner(BP);
		Scanner srcpulse = new Scanner(pulse);
		Scanner srcTemp = new Scanner(temp);
		Scanner srcWeight = new Scanner(weight);
		Scanner srcSug = new Scanner(sug);
		
		srcdate.useDelimiter("\\|");
		srcBP.useDelimiter("\\|");
		srcpulse.useDelimiter("\\|");
		srcTemp.useDelimiter("\\|");
		srcWeight.useDelimiter("\\|");
		srcSug.useDelimiter("\\|");
		
		while(srcdate.hasNext() && srcBP.hasNext() && srcpulse.hasNext() && srcTemp.hasNext() && srcWeight.hasNext() && srcSug.hasNext())	//Might not parse right if columns in SQL not barred correctly
		{
			bloodpressure BloodPressure = new bloodpressure(AID);
			
			BloodPressure.setDate(srcdate.next());
			BloodPressure.setBP(srcBP.next());
			BloodPressure.setPulse(srcpulse.next());
			BloodPressure.setTemp(srcTemp.next());
			BloodPressure.setWeight(srcWeight.next());
			BloodPressure.setSug(srcSug.next());
			
			bps.add(BloodPressure);
		}
		
		srcdate.close();
		srcBP.close();
		srcpulse.close();
		srcTemp.close();
		srcWeight.close();
		srcSug.close();
		
		return bps;
	}
	
	//Used to unparse a list of Alerts and insert them into sql
	public List<String> unparseBPs(List<bloodpressure> BPS)
	{
		List<String> sbp = new ArrayList<String>();
		String Dates = "";
		String BP = "";
		String Pulse = "";
		String Temp = "";
		String Weight = "";
		String Sug = "";
		
		Iterator<bloodpressure> sIterator = BPS.iterator();
		
		while(sIterator.hasNext())
		{
			bloodpressure sBP = sIterator.next();
			
			Dates += sBP.getDate() + "|";
			BP +=  sBP.getBP()+ "|";
			Pulse +=  sBP.getPulse()+ "|";
			Temp += sBP.getTemp()+ "|";
			Weight += sBP.getWeight() + "|";
			Sug += sBP.getSug() + "|";
		}
		
		sbp.add(Dates);			//[0]  = date
		sbp.add(BP);			//[1]  = BP
		sbp.add(Pulse);		//[2]  = pulse
		sbp.add(Temp);		//[3] = temp
		sbp.add(Weight);	//[4] = weight
		sbp.add(Sug);		//[5] = 
		
		return sbp;
	}
}