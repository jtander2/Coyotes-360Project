package com.mediware.data.dataContainers;
import java.util.Scanner;

public class alert 
{
	private int AID;
	private String date;		//Date alert was made
	private String msg;			//Message associated
	private int priority;		//Number out of 10
	
	public alert()
	{
		AID = -1;
		date = "0";
		msg = "0";
		priority = -1;
	}
	
	public alert(int AID)
	{
		this.AID = AID;
		date = "0";
		msg = "0";
		priority = -1;
	}
	
	public alert(int AID, String date, String msg, int priority)
	{
		this.AID = AID;
		this.date = "0";
		this.msg = "0";
		this.priority = priority;
	}

	//This parses data and sets it to the current alert, returns false on failure
	public boolean parseFromString(int AID,String alert)
	{
		boolean success = true;
		Scanner src = new Scanner(alert);
		src.useDelimiter("|");
		
		if(src.hasNext())
			date = src.next();
		else success = false;
		
		if(src.hasNext())
			msg = src.next();
		else success = false;
		
		if(src.hasNext())
			priority = src.nextInt();
		else success = false;
		
		src.close();
		
		if(success)
		{
			this.AID = AID;
			return true;
		}
		
		this.AID = -1;
		date = new String();
		msg = new String();
		priority = -1;
		return false;
	}
	
	//Returns data in DATE|MSG|PRIOTIY format
	public String toString()
	{
		return date + "|" + msg + "|" + priority;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
