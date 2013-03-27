package com.mediware.data;


public class account {
	
	
	public int AID;
	public String username;
	public String password;
	public String email;
	public String question;
	public String permissions;
	public String answer;
	
	public client oClient;

	public account()
	{
		AID = -1;
		username = "";
		password = "";
		email = "";
		question = "";
		permissions = "";
		answer = "";
		
		oClient = new client();
	}
	
	
	public account(int aid)
	{
		AID = aid;
		
		username = "";
		password = "";
		email = "";
		question = "";
		permissions = "";
		answer = "";
		
		//refreshInfo();
		oClient = new client();
	}
	
	//Refreshes the account information if it's valid from the database
	public void refreshInfo()
	{
		database db = new database();
		
		if(!db.existsAccount(AID))
			return;
		
		account taccount = db.getAccount(AID);

		username = taccount.username;
		password = taccount.password;
		email = taccount.email;
		question = taccount.question;
		permissions = taccount.permissions;
		answer = taccount.answer;
		oClient = taccount.oClient;
		
	}
	
	public void prepareforSQL()
	{
		//Stuff in the SQL cannot have the following characters
			// ' ; " < > =   MAKE SURE THESE ARE NEVER PASSED
	}
}
