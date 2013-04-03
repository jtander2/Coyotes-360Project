package com.mediware.data.dataContainers;

public class account {
	
	public enum permission 
	{
		none,
		client,
		ofc,
		ma,
		nurse,
		doctor;
	}
	
	protected int AID;				//Unique user ID
	protected String username;
	protected String password;		//Should be hashed at this point
	protected String email;
	protected int question1;		//Security questions
	protected int question2;
	protected String answer1;
	protected String answer2;
	protected int permissions;

	public account()
	{
		AID = -1;
		username = "";
		password = "";
		email = "";
		question1 = -1;
		question2 = -1;
		permissions = -1;
		answer1 = "";
		answer2 = "";
	}
	
	
	public account(int aid)
	{
		AID = aid;
		
		username = "";
		password = "";
		email = "";
		question1 = 0;
		question2 = 0;
		permissions = -1;
		answer1 = "";
		answer2 = "";
	}
	
	public int getAID() {
		return AID;
	}


	public void setAID(int aID) {
		AID = aID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getQuestion1() {
		return question1;
	}


	public void setQuestion1(int question1) {
		this.question1 = question1;
	}


	public int getQuestion2() {
		return question2;
	}


	public void setQuestion2(int question2) {
		this.question2 = question2;
	}


	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}


	public String getAnswer2() {
		return answer2;
	}


	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}


	public int getPermissions() {
		return permissions;
	}
	
//	public int getNumPermission()
//	{
//		switch(getPermissions())
//		{
//			case client: return 0;
//			case ofc: return 1;
//			case ma: return 2;
//			case nurse: return 3;
//			case doctor: return 4;
//			default: return -1;			//This means this is none
//		}
//	}

//	public void setNumPermission(int permLevel)
//	{
//		switch(permLevel)
//		{
//		case 0: permissions = permission.client;
//		case 1: permissions = permission.ofc;
//		case 2: permissions = permission.ma;
//		case 3: permissions = permission.nurse;
//		case 4: permissions = permission.doctor;
//		default: permissions = permission.none;			//This means this is none
//		}
//	}

	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	
	public account getAccount()
	{
		return this;
	}


	@Override
	public String toString() {
		return "account [AID=" + AID + ", username=" + username + ", password="
				+ password + ", email=" + email + ", question1=" + question1
				+ ", question2=" + question2 + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", permissions=" + permissions + "]";
	}
}
