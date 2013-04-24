package com.mediware.data.dataContainers;

public class userinfo extends account
{
	//User Information
	protected String Fname;
	protected String Mname;
	protected String Lname;
	
	//Address
	protected String address1;
	protected String address2;
	protected String city;
	protected String state;
	protected String zip;
	
	//Contact Information
	protected String phoneWork;
	protected String phoneMobile;
	protected String phoneHome;
	
	public userinfo()
	{
		//Basic user information
		Fname = new String();
		Mname = new String();
		Lname = new String();
		
		//Contact Information
		 phoneWork = new String();
		 phoneMobile = new String();
		 phoneHome = new String();
		 
		//Address
		 address1 = new String();
		 address2 = new String();
		 city = new String();
		 state = new String();
		 zip = new String();
	}
	
	public userinfo(int AID)
	{
		this.AID = AID;
		
		//Basic user information
		Fname = new String();
		Mname = new String();
		Lname = new String();
		
		//Contact Information
		 phoneWork = new String();
		 phoneMobile = new String();
		 phoneHome = new String();
		 
		//Address
		 address1 = new String();
		 address2 = new String();
		 city = new String();
		 state = new String();
		 zip = new String();
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getMname() {
		return Mname;
	}

	public void setMname(String mname) {
		Mname = mname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhoneWork() {
		return phoneWork;
	}

	public void setPhoneWork(String phoneWork) {
		this.phoneWork = phoneWork;
	}

	public String getPhoneMobile() {
		return phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile = phoneMobile;
	}

	public String getPhoneHome() {
		return phoneHome;
	}

	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
	}
	
	public userinfo getUserInfo()
	{
		return this;
	}
	 
}
