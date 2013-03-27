package com.mediware.data;



public class client 
{	
	public client()
	{
		 Fname = new String();
		 Mname = new String();
		 Lname = new String();
		
		//Medical Information
		 BP = new String();		//Not too sure on what kinda of data we should be using here
		 Alerts = new String();
		
		//Address
		 address1 = new String();
		 address2 = new String();
		 city = new String();
		 state = new String();
		 zip = new String();
		
		//Insurance Info
		 provider = new String();
		 policy = new String();
		 group = new String();
		
		//Contact Information
		 phoneWork = new String();
		 phoneMobile = new String();
		 phoneHome = new String();
	}
	
	//User Information
	public String Fname;
	public String Mname;
	public String Lname;
	
	//Medical Information
	public String BP;		//Not too sure on what kinda of data we should be using here
	public String Alerts;
	
	//Address
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zip;
	
	//Insurance Info
	public String provider;
	public String policy;
	public String group;
	
	//Contact Information
	public String phoneWork;
	public String phoneMobile;
	public String phoneHome;
	
}
