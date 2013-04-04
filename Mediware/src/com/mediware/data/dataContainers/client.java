package com.mediware.data.dataContainers;

import java.util.ArrayList;
import java.util.List;

public class client extends userinfo
{	
	public client() 
	{
		//Medical Information
		 BP = new ArrayList<bloodpressure>();
		 Alerts = new ArrayList<alert>();
		
		//Insurance Info
		 provider = new String();
		 policy = new String();
		 group = new String();
		 
		//Inserts a blank null row for the first instance of BP and Alert
		 BP.add(new bloodpressure());
		 Alerts.add(new alert());
	}
	
	public client(int AID)
	{
		this.AID = AID;
		
		//Medical Information
		 BP = new ArrayList<bloodpressure>();
		 Alerts = new ArrayList<alert>();
		
		//Insurance Info
		 provider = new String();
		 policy = new String();
		 group = new String();
		 
		//Inserts a blank null row for the first instance of BP and Alert
		 BP.add(new bloodpressure(AID));
		 Alerts.add(new alert(AID));
	}
	
	public client(String username, String password)
	{
		this.username = username;
		this.password = password;
		
		//Medical Information
		 BP = new ArrayList<bloodpressure>();
		 Alerts = new ArrayList<alert>();
		
		//Insurance Info
		 provider = new String();
		 policy = new String();
		 group = new String();
		 
		//Inserts a blank null row for the first instance of BP and Alert
		 BP.add(new bloodpressure());
		 Alerts.add(new alert());
	}
	
	public client(account oAccount, userinfo oUserInfo, List<bloodpressure> BP, List<alert> Alerts, client oClient)
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
		
		
		//BP and Alerts
		this.BP = BP;	
		this.Alerts = Alerts;
		
		//Client
		provider = oClient.getProvider();
		policy = oClient.getPolicy();
		group = oClient.getGroup();
	}
	
	//Medical Information
	protected List<bloodpressure> BP;
	protected List<alert> Alerts;
	
	//Insurance Info
	protected String provider;
	protected String policy;
	protected String group;
	
	public List<bloodpressure> getBP() {
		return BP;
	}

	public void setBP(List<bloodpressure> bP) {
		BP = bP;
	}

	public List<alert> getAlerts() {
		return Alerts;
	}

	public void setAlerts(List<alert> alerts) {
		Alerts = alerts;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getPolicy() {
		return policy;
	}

	public void setPolicy(String policy) {
		this.policy = policy;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public account getAccount()
	{
		account oAccount = new account();
		oAccount.setAID(AID);
		
		 oAccount.setUsername(username);
		 oAccount.setPassword(password);
		 oAccount.setEmail(email);
		 oAccount.setQuestion1(question1);
		 oAccount.setQuestion2(question2);
		 oAccount.setPermissions(permissions);
		 oAccount.setAnswer1(answer1);
		 oAccount.setAnswer2(answer2 );
		
		return  oAccount;
	}
	
}
