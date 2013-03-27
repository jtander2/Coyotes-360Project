package com.mediware.data;

import java.util.Scanner;

public class mainTest {
	public static void main(String[] args)
	{
		database db = new database();
		//db.testDB();
		Scanner input = new Scanner(System.in);
		String choice;
		
		while(true)
		{
			account testAcnt = new account() ; 
			System.out.println("Welcome to the test program for the Database");
			System.out.println("I	-	Insert into table");
			System.out.println("S	-	Search");
			System.out.println("D	-	Delete");
			System.out.println("G	-	Get");
			System.out.println("U	-	Update account information");
			System.out.println("J	-	Update Client Information");
			System.out.println("Q	-	Quit");
			
			choice = input.nextLine();
			
			switch(choice)
			{
			
			case "I": 
				System.out.println("Type in Username:");
				testAcnt.username = input.nextLine();
				System.out.println("Type in Password:");
				testAcnt.password = input.nextLine();
				System.out.println("Type in Email:");
				testAcnt.email = input.nextLine();
				System.out.println("Type in Permission:");
				testAcnt.permissions = input.nextLine();
				System.out.println("Account add with ID: "+db.addAccount(testAcnt));
				break;
				
			case "U":
				System.out.println("Type in the AID:");
				testAcnt.AID = Integer.parseInt(input.nextLine());
				System.out.println("Type in Username:");
				testAcnt.username = input.nextLine();
				System.out.println("Type in Password:");
				testAcnt.password = input.nextLine();
				System.out.println("Type in Email:");
				testAcnt.email = input.nextLine();
				System.out.println("Type in Permission:");
				testAcnt.permissions = input.nextLine();
				System.out.println("Edited account with ID: "+db.updateAccountInfo(testAcnt));
				break;
				
			case "J":
				System.out.println("Type in the AID:");
				testAcnt.AID = Integer.parseInt(input.nextLine());
				System.out.println("Type in First Name:");
				testAcnt.oClient.Fname = input.nextLine();
				System.out.println("Type in Middle Name:");
				testAcnt.oClient.Mname = input.nextLine();
				System.out.println("Type in Last Name:");
				testAcnt.oClient.Lname = input.nextLine();
				System.out.println("Type in BP:");
				testAcnt.oClient.BP = input.nextLine();
				System.out.println("Edited account: "+db.updateClientInfo(testAcnt.AID,testAcnt.oClient));
				break;
				
			case "S":
				System.out.println("Type in Username:");
				testAcnt.username = input.nextLine();
				System.out.println("Type in Password:");
				testAcnt.password = input.nextLine();
				System.out.println("Type in Email:");
				testAcnt.email = input.nextLine();
				System.out.println("Type in Permission:");
				testAcnt.permissions = input.nextLine();
				
				System.out.println(db.findAccount(testAcnt));
				break;
				
			case "D":				
			System.out.println("Type in AID: ");
			testAcnt.AID = Integer.parseInt(input.nextLine());
			db.removeaccount(testAcnt.AID);
			System.out.println(testAcnt);
				 break;
				 
			case "G":
				System.out.println("Type in AID: ");
				testAcnt.AID = Integer.parseInt(input.nextLine());
				testAcnt = db.getAccount(testAcnt.AID);
				System.out.println(testAcnt);
				
				break;
			case "Q":		//Does nothing 
					break;
			default:
				System.out.println("Retry input");
				break;
			}
		}
		
	}
}
