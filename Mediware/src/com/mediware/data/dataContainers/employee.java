package com.mediware.data.dataContainers;


public class employee extends userinfo 
{
	private int empNum;
	
	public employee()
	{
		AID = -1;
		empNum = -1;
	}
	
	public employee(int AID)
	{
		this.AID = AID;
		empNum = -1;
	}
	
	public employee(int AID, int empNum)
	{
		this.AID = AID;
		this.empNum = empNum;
	}

	public employee(account oAccount, userinfo oUserInfo, employee oEmployee)
	{
		//Account information
		AID = oAccount.getAID();
		
		username = oAccount.getUsername();
		password = oAccount.getPassword();
		email = oAccount.getEmail();
		question1 = oAccount.getQuestion1();
		question2 = oAccount.getQuestion2();
		permissions = oAccount.getPermissions();
		answer1 = oAccount.getAnswer1();
		answer2 = oAccount.getAnswer2();
		
		//User information
		Fname = oUserInfo.getFname();
		Mname = oUserInfo.getMname();
		Lname = oUserInfo.getLname();
		phoneWork = oUserInfo.getPhoneWork();
		phoneMobile = oUserInfo.getPhoneMobile();
		phoneHome = oUserInfo.getPhoneHome();
		address1 = oUserInfo.getAddress1();
		address2 = oUserInfo.getAddress2();
		city = oUserInfo.getCity();
		state = oUserInfo.getState();
		zip = oUserInfo.getZip();
		
		//Employee Account information
		empNum = oEmployee.getEmpNum();
	}
	
	public int getEmpNum() {
		return empNum;
	}

	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
}
