package com.mediware.service;

import com.mediware.data.*;

public class LoginService {
	
	private datadriver DB;
	
	public LoginService(datadriver driver){
		this.DB = driver;
	}
	
	public boolean authenticate(String username, String password) {
		System.out.println(username + password);
		// Make sure username and password are not empty
		if(username.equals("") || password.equals(""))
			return false;
		else if(DB.findUserPass(username, password) != -1){
			System.out.println("USER FOUND");
			// at this point, the user is found. check which permissions they have to determine which
			// page to move on to
			// (to be written)
			//
			return true;
		}
		System.out.println(DB.findUserPass(username, password));
		
		//User does not exist in the database
		System.out.println("USER DOES NOT EXIST");
		return false;
	}

}
