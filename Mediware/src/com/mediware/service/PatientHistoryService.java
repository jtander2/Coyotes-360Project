package com.mediware.service;

import com.mediware.data.datadriver;
import com.mediware.data.dataContainers.*;

public class PatientHistoryService {
    
    private static datadriver DB;
	
    public PatientHistoryService(datadriver driver){
		this.DB = driver;
    }
    
    public int[] process(String type, int AID) {
	client oClient = DB.getClient(AID);
	
	switch(type) {
		case "Pulse":
		   int[] pulseData = new int[oClient.getBP().size()-1];
		   
		   for(int i = 1; i < oClient.getBP().size(); i++)
			   pulseData[i-1] = Integer.parseInt(oClient.getBP().get(i).getPulse());
			   
		    return pulseData;
		
		case "Temperature":
			int[] tempData = new int[oClient.getBP().size()-1];
			   
			for(int i = 1; i < oClient.getBP().size(); i++)
				tempData[i-1] = Integer.parseInt(oClient.getBP().get(i).getTemp());
			
		    return tempData;
		    
		case "Blood Pressure":
			int[] bloodPressure = new int[oClient.getBP().size()-1];
			   
			for(int i = 1; i < oClient.getBP().size(); i++)
				bloodPressure[i-1] = Integer.parseInt(oClient.getBP().get(i).getBP());
		    return bloodPressure;
		    
		case "Weight":
			int[] weightData = new int[oClient.getBP().size()-1];
			   
			for(int i = 1; i < oClient.getBP().size(); i++)
				weightData[i-1] = Integer.parseInt(oClient.getBP().get(i).getWeight());
		    return weightData;
		    
		case "Sugar/Glucose Level":
			int[] sugarData = new int[oClient.getBP().size()-1];
			   
			for(int i = 1; i < oClient.getBP().size(); i++)
				sugarData[i-1] = Integer.parseInt(oClient.getBP().get(i).getSug());
		    return sugarData;
		    
		default:
		    System.out.println("Invalid Patient History Category Requested!");
		    return null;
	
	}
	
    }

}
