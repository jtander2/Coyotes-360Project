package com.mediware.service;

import com.mediware.data.datadriver;


public class PatientHistoryService {
    
    private static datadriver DB;
	
    public PatientHistoryService(datadriver driver){
		this.DB = driver;
    }
    
    public int[] process(String type) {
	
	switch(type) {
		case "Pulse":
		    	//TODO: Get database values rather than hardcoded
		    int[] pulseData = {100, 125, 135, 90, 20};
		    return pulseData;
		
		case "Temperature":
		    int[] tempData = {97, 105, 101, 99, 98};
		    return tempData;
		    
		case "Blood Pressure":
		    int[] bloodData = {85, 50, 23};
		    return bloodData;
		    
		case "Weight":
		    int[] weightData = {125, 135, 145, 155, 165};
		    return weightData;
		    
		case "Sugar/Glucose Level":
		    int[] sugarData = {87, 80, 75, 70, 80};
		    return sugarData;
		    
		default:
		    System.out.println("Invalid Patient History Category Requested!");
		    return null;
	
	}
	
    }

}
