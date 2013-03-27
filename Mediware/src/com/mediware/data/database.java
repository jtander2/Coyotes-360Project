package com.mediware.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class database 
{
	public database()
	{
	}
	
	//private String connectionString  = "jdbc:sqlite:B:\\program_src\\Java\\CSE360-DB\\db\\database.sqlite";
	private String connectionString  = "jdbc:sqlite:db\\database.sqlite";
	
	//SQL Constants
	private String AccountInfoLocation = "\"main\".\"accountInfo\"";
	private String AccountTableInfo = "(username,password,email,question,answer,permissions)";
	
	public List<account> getAllAccountInfo()
	{
		List<account> accountList = new ArrayList<account>();
		String SQLString = "SELECT * FROM " + AccountInfoLocation;
		ResultSet result = null;
		
		//Execute the command
		result = execSqlCommand(SQLString);
		
		//Parse the information
		try 
		{
			while (result.next())
			{
				account oAccount = new account();
				oAccount.AID = Integer.parseInt(result.getString(0));
				oAccount.username = result.getString(1);
				oAccount.password = result.getString(2);
				oAccount.email = result.getString(3);
				oAccount.question = result.getString(4);
				oAccount.answer = result.getString(5);
				oAccount.permissions = result.getString(6);
				//oAccount.CID = Integer.parseInt(result.getString(7));
				
				accountList.add(oAccount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}
	
	
	//Creates an account in the sqlite database returns the account ID -1 if unsuccessful
	public int addAccount(account acnt)
	{
		account tempacnt = new account();
		tempacnt.email = acnt.email;
		tempacnt.username =  acnt.username;
		
		if(!findAccount(tempacnt).isEmpty())	
			return -1;	//Account is already in the Database
		
		String sqlCommand = "INSERT INTO accountInfo "+AccountTableInfo;
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + acnt.username + "',";
		sqlCommand += "'" +acnt.password + "',";
		sqlCommand += "'" +acnt.email + "',";
		sqlCommand += "'" +acnt.question + "',";
		sqlCommand += "'" +acnt.answer + "',";
		sqlCommand += "'" +acnt.permissions + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		if(findAccount(tempacnt).isEmpty())	
			return -1;	//For some reason, the account wasn't added
		
		acnt.AID = findAccount(tempacnt).get(0);
		//addblankaccountInfo(acnt.AID);	//ADDs a blank account info
		addaccountInfo(acnt);
		
		return acnt.AID;
	}
	
	//Adds in the clientInfo
	public void addblankaccountInfo(int cID)
	{
		String sqlCommand = "INSERT INTO clientinfo (CID) VALUES('" + cID + "')" ;
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
	}
	
	//THis adds some client info based from stuff
	public void addaccountInfo(account acnt)
	{
		String sqlCommand = "INSERT INTO clientinfo " +
				"(CID,fname,mname,lname,BP,alerts,address1,address2,city,state,zip,provider," +
				"policy,igrp,phonework,phonemobile,phonehome) ";
		
		sqlCommand += "VALUES (";
		sqlCommand += "'" + acnt.AID + "',";
		sqlCommand += "'" +acnt.oClient.Fname + "',";
		sqlCommand += "'" +acnt.oClient.Mname + "',";
		sqlCommand += "'" +acnt.oClient.Lname + "',";
		sqlCommand += "'" +acnt.oClient.BP + "',";
		sqlCommand += "'" +acnt.oClient.Alerts + "',";
		sqlCommand += "'" +acnt.oClient.address1 + "',";
		sqlCommand += "'" +acnt.oClient.address2 + "',";
		sqlCommand += "'" +acnt.oClient.city + "',";
		sqlCommand += "'" +acnt.oClient.state + "',";
		sqlCommand += "'" +acnt.oClient.zip + "',";
		sqlCommand += "'" +acnt.oClient.provider + "',";
		sqlCommand += "'" +acnt.oClient.policy + "',";
		sqlCommand += "'" +acnt.oClient.group + "',";
		sqlCommand += "'" +acnt.oClient.phoneWork + "',";
		sqlCommand += "'" +acnt.oClient.phoneMobile + "',";
		sqlCommand += "'" +acnt.oClient.phoneHome + "'";
		sqlCommand += ")";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
	}
	
	//This command finds an account based from any of the search params
	public List<Integer> findAccount(account acnt)
	{
		List<Integer> accountList = new ArrayList<Integer>();
		String sqlCommand = "SELECT * FROM accountInfo WHERE ";
		ResultSet result = null;
		
		//Checks to see if stuff is empty, if it is, don't include it in the sql command
		if(acnt.AID != -1 )	
			sqlCommand += "AID='"+ acnt.AID + "' ";
		else 
			sqlCommand += "AID<>'' ";
		
		
		if(!acnt.username.isEmpty())
			sqlCommand += "AND username='"+ acnt.username + "' ";
		
		if(!acnt.password.isEmpty())
			sqlCommand += "AND password='"+acnt.password + "' ";
		
		if(!acnt.email.isEmpty())
			sqlCommand+="AND email='"+acnt.email + "' ";
		
		if(!acnt.question.isEmpty())
			sqlCommand+="AND question='"+acnt.question + "' ";
		
		if(!acnt.answer.isEmpty())
			sqlCommand+="AND answer='"+acnt.answer + "' ";
		
		if(!acnt.permissions.isEmpty())
			sqlCommand += "AND permissions='"+acnt.permissions + "'";
	
		
		//result = execSqlCommand(sqlCommand);		//executes the command against SQL
		
		Connection connection = null;
		//ResultSet resultset = null;
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
	
	//This command finds an account based from the key
	public account getAccount(int aid)
	{
		String sqlCommand = "SELECT * FROM accountInfo WHERE ";
		ResultSet result = null;
		account oAccount = new account();
		
		//Checks to see if this even exists
		if(existsAccount(aid))	
			sqlCommand += "AID='"+ aid + "'";
		else
			return oAccount;
		
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
					oAccount.AID = result.getInt("AID");
					
					oAccount.username = result.getString("username");
					oAccount.password = result.getString("password");
					oAccount.email = result.getString("email");
					oAccount.question = result.getString("question");
					oAccount.answer = result.getString("answer");
					oAccount.permissions = result.getString("permissions");
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
		
		//Gets the specified customer information
		sqlCommand = "SELECT * FROM clientinfo WHERE ";
		sqlCommand += "CID='"+ aid + "'";
		try 
		{
			Class.forName("org.sqlite.JDBC");	//Checks to see if we have the correct packaged installed
			connection = DriverManager.getConnection(connectionString);	//connects to the DB
			
			statement = connection.createStatement();
			result = statement.executeQuery(sqlCommand);
			try {
				while(result.next())
				{	
					oAccount.oClient.Fname = 		result.getString("fname");
					oAccount.oClient.Mname =		result.getString("mname");
					oAccount.oClient.Lname = 		result.getString("lname");
					
					oAccount.oClient.BP = 			result.getString("BP");
					oAccount.oClient.Alerts = 		result.getString("alerts");
					
					oAccount.oClient.address1 = 	result.getString("address1");
					oAccount.oClient.address2 = 	result.getString("address2");
					oAccount.oClient.city = 		result.getString("city");
					oAccount.oClient.state = 		result.getString("state");
					oAccount.oClient.zip = 			result.getString("zip");
					
					oAccount.oClient.provider = 	result.getString("provider");
					oAccount.oClient.policy = 		result.getString("policy");
					oAccount.oClient.group = 		result.getString("igrp");
					
					oAccount.oClient.phoneWork = 	result.getString("phoneWork");
					oAccount.oClient.phoneMobile = 	result.getString("phoneMobile");
					oAccount.oClient.phoneHome = 	result.getString("phoneHome");
					
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
	
	//Checks to see if an account exists based on ref number
	public boolean existsAccount(int aid)
	{
		account tempaccnt = new account(aid);
		return !findAccount(tempaccnt).isEmpty();
	}
	
	public boolean removeaccount(int aid)
	{
		if(!existsAccount(aid))
			return false;
		
		//Removes the Client info
		String sqlCommand = "DELETE FROM clientinfo WHERE CID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		//Removes the account information
		sqlCommand = "DELETE FROM accountinfo WHERE AID='" + aid + "'" ;
		execSqlCommandNoR(sqlCommand);
		
		return true;
	}
	
	//Generic function to execute SqLite commands
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
	
	//Generic function to execute SqLite commands, does not return anything
	private void execSqlCommandNoR(String Command)
		{
			Connection connection = null;
			//ResultSet resultset = null;
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
	
	//The return codes on this are a bit specific
	// -1 The item isn't found
	// -2 Username cannot be changed because another user already has it
	// -3 the changed email is already linked with another account
	// else it will return the id of the account.
	public int updateAccountInfo(account oAccount)
	{
		if (!existsAccount(oAccount.AID))
			return -1;
		
		account oldAccount = getAccount(oAccount.AID);
		
		//Check to see if the name change is good
		if(oAccount.username.compareTo(oldAccount.username) != 0)	//are we changing the username?
		{
			account tempacnt = new account();
			tempacnt.username = oAccount.username;
			if(!findAccount(tempacnt).isEmpty())	//Did the search return anything?
				return -2;
		}
		
		//Check to see if the email change is good
		if(oAccount.email.compareTo(oldAccount.email) != 0)	//are we changing the email?
		{
			account tempacnt = new account();
			tempacnt.email = oAccount.email;
			if(!findAccount(tempacnt).isEmpty())	//Did the search return anything?
				return -3;
		}
		
		//put the data into the Database
		String sqlCommand = "UPDATE accountInfo SET ";
		sqlCommand += "username='" + oAccount.username + "',";
		sqlCommand += "password='" + oAccount.password + "',";
		sqlCommand += "email='" + oAccount.email + "',";
		sqlCommand += "question='" + oAccount.question + "',";
		sqlCommand += "answer='" + oAccount.answer + "',";
		sqlCommand += "permissions='" + oAccount.permissions + "'";
		sqlCommand += " WHERE AID='" + oAccount.AID + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		//Success!
		return oAccount.AID;
	}
	
	//Updates client information
	public boolean updateClientInfo(int AID, client oClient)
	{
		if (!existsAccount(AID))
			return false;
		
		String sqlCommand = "UPDATE clientinfo SET ";
		
		sqlCommand += "Fname='" + oClient.Fname + "', ";
		sqlCommand += "Mname='" + oClient.Mname + "', ";
		sqlCommand += "Lname='" + oClient.Lname + "', ";
		sqlCommand += "BP='" + oClient.BP + "', ";
		sqlCommand += "Alerts='" + oClient.Alerts + "', ";
		sqlCommand += "address1='" + oClient.address1 + "', ";
		sqlCommand += "address2='" + oClient.address2 + "', ";
		sqlCommand += "city='" + oClient.city + "', ";
		sqlCommand += "state='" + oClient.state + "', ";
		sqlCommand += "zip='" + oClient.zip + "', ";
		sqlCommand += "provider='" + oClient.provider + "', ";
		sqlCommand += "policy='" + oClient.policy + "', ";
		sqlCommand += "igrp='" + oClient.group + "', ";
		sqlCommand += "phonework='" + oClient.phoneWork + "', ";
		sqlCommand += "phonemobile='" + oClient.phoneMobile + "', ";
		sqlCommand += "phonehome='" + oClient.phoneHome + "'";
		sqlCommand += " WHERE CID='" + AID + "'";	
		
		execSqlCommandNoR(sqlCommand);		//executes the command against SQL
		
		return true;
	}
		
}