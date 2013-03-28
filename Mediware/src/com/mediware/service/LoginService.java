package com.mediware.service;

public class LoginService {
	
	public static boolean authenticate(String username, String password) {
		
		// Make sure username and password are not empty
		if(username.equals("") || password.equals(""))
			return false;
		
		// Look up user in the database to make sure they are valid and have correct login credentials
		// If so, return true
		// If not, return false
		
		return true;
	}

}
