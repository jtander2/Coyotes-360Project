package com.mediware.data.dataContainers;
public class bloodpressure 
{
	private int AID;
	private String date;
	private String BP;
	private String pulse;
	private String temp;
	private String weight;
	private String sug;
	
	public bloodpressure()
	{
		 AID = -1;
		 date = "0" ;
		 BP  = "0" ;
		 pulse  = "0" ;
		 temp  = "0" ;
		 weight  = "0" ;
		 sug = "0";
	}
	
	public bloodpressure(int AID)
	{
		 this.AID = AID;
		 date = "0" ;
		 BP  = "0" ;
		 pulse  = "0" ;
		 temp  = "0" ;
		 weight  = "0" ;
		 sug = "0";		 
	}
	
	public bloodpressure(int AID, String date, String BP, String pulse, String temp, String weight, String sug)
	{
		 this.AID = AID;
		 this.date = date;
		 this.BP = BP;
		 this.pulse = pulse;
		 this.temp = temp;
		 this.weight = weight;
		 this.sug = sug;
	}

	//Legacy Constructor for using as date -> sug
	public bloodpressure(int AID, String sug, String BP, String pulse, String temp, String weight)
	{
		 this.AID = AID;
		 this.BP = BP;
		 this.pulse = pulse;
		 this.temp = temp;
		 this.weight = weight;
		 this.sug = sug;
	}
	
	public int getAID() {
		return AID;
	}

	public void setAID(int aID) {
		AID = aID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBP() {
		return BP;
	}

	public void setBP(String bP) {
		BP = bP;
	}

	public String getPulse() {
		return pulse;
	}

	public void setPulse(String pulse) {
		this.pulse = pulse;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public void setSug(String sug){
		this.sug = sug;
	}
	
	public String getSug()
	{
		return sug;
	}
	
	
}
