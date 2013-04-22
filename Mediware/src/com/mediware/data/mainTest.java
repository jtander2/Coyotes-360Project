package com.mediware.data;
import java.util.List;
import java.util.Scanner;

import com.mediware.data.dataContainers.account;
import com.mediware.data.dataContainers.bloodpressure;
import com.mediware.data.dataContainers.client;
import com.mediware.data.dataContainers.employee;


public class mainTest {
	public static void main(String[] args)
	{
		database db = new database();
		//db.testDB();
		datadriver dd = new datadriver();
		Scanner input = new Scanner(System.in);
		String choice = "";
		String subChoice = "";
		
		boolean loop = true;
		
		while(loop)
		{
			client oClient = new client();
			account testAcnt = new account() ; 
			employee oEmployee = new employee();
			boolean subLoop = true;
			
			System.out.println("Welcome to the test program for the Database!");
			System.out.println("---- Version 0.1B -----");
			System.out.println("");
			System.out.println("I	-	Insert Account");
			System.out.println("S	-	Search");
			System.out.println("H	-	Add Blood Pressure to Client");
			System.out.println("U	-	Update Information by ID");
			System.out.println("G	-	Get Account by ID");
			System.out.println("D	-	Delete Account by ID");
			System.out.println("T	-	Add Alert to Client");
			System.out.println("P	-	Find Account from Username and Password.");
			System.out.println("O	-	List all of the Clients AIDs.");
			System.out.println("L	-	List all of the Employee AIDs.");
			System.out.println("M	-	Runs a 'like' search for a client's first name.");
			System.out.println("T	-	Runs a 'like' search for a Empoloyee's first name.");
			System.out.println("Q	-	Quit");
			
			choice = input.nextLine();
			
			
			switch(choice)
			{
			
			
	//-			ADDING CLIENTS/EMPLOYEES INTO THE DATABASE 			-//
			case "I": 	
				while(subLoop == true)
				{
					System.out.println("");
					System.out.println("-Add an Account-");
					System.out.println("Choose what kind of account:");
					System.out.println("C - Client");
					System.out.println("E - Employee");
					System.out.println("R - Return to Main Menu");
					
					subChoice = input.nextLine();
					
					switch(subChoice)
					{
						case "C":
							System.out.println("Type in Username:");
							oClient.setUsername(input.nextLine());
							System.out.println("Type in Password:");
							oClient.setPassword(input.nextLine());
							System.out.println("Type in Email:");
							oClient.setEmail(input.nextLine());
							System.out.println("Account add with ID: "+ dd.addClient(oClient) );
							break;
					
						case "E": 
							System.out.println("Type in Username:");
							oEmployee.setUsername(input.nextLine());
							System.out.println("Type in Password:");
							oEmployee.setPassword(input.nextLine());
							System.out.println("Type in Email:");
							oEmployee.setEmail(input.nextLine());
							System.out.println("Type in Permission level (1-5):");
							oEmployee.setPermissions(tryparse(input.nextLine()));
							System.out.println("Type in employee number (>0):");
							oEmployee.setEmpNum(tryparse(input.nextLine()));
							System.out.println("Account add with ID: "+ dd.addEmployee(oEmployee));
							break;
							
						case "R":
							subLoop = false;
							break;
						
						default:
							System.out.println("Invalid Input"); 
							break;
					}
				}
				break;
				
	//-			UPDATING CLIENTS/EMPLOYEES INTO THE DATABASE 			-//	
			case "U":
				while(subLoop == true)
				{
					System.out.println("");
					System.out.println("-Edit an Account-");
					System.out.println("Type in the AID:");
					System.out.println("Type in -1 to cancel");

					testAcnt.setAID(tryparse(input.nextLine()));
					
					if(testAcnt.getAID() == -1)
						subLoop = false;
					else if(testAcnt.getAID() < 0)
					{
						System.out.println("[ERROR] AID: '" + testAcnt.getAID() + "' does not exist in the database!");
					}
					else if(dd.getPermission(testAcnt.getAID()) < 0)
					{
						System.out.println("[ERROR] AID: '" + testAcnt.getAID() + "' does not have a valid permission!");
						//Probably do something like remove it from the database or set permission based on allowed rows.
					}
					else if (dd.getPermission(testAcnt.getAID()) == 0)	//Begin editing account by assuming it being a client
					{
						//This demonstrates at least one column in each table
						oClient = dd.getClient(testAcnt.getAID());		//We first get the all of the clientinfo
						
						//Allows the editing.  If a field is left blank, we then assume that it's not being edited.
						System.out.println("Type in NEW username for " + oClient.getUsername());
						String IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setUsername(IN);
						
						System.out.println("Type in NEW password:");
						IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setPassword(IN);
						
						System.out.println("Type in NEW Email (current " + oClient.getEmail() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setEmail(IN);
						
						System.out.println("Type in NEW Email (current " + oClient.getEmail() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setEmail(IN);
						
						System.out.println("Type in NEW First Name (current " + oClient.getFname() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setFname(IN);
						
						System.out.println("Type in NEW Provider (current " + oClient.getProvider() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oClient.setProvider(IN);
						
						System.out.println("Edited account with ID: "+ dd.editClient(oClient));
						
						subLoop = false;
						
					}
					else	//Begin editing account by assuming it being an employee
					{
						//This demonstrates at least one column in each table
						oEmployee = dd.getEmployee(testAcnt.getAID());		//We first get the all of the clientinfo
						
						//Allows the editing.  If a field is left blank, we then assume that it's not being edited.
						System.out.println("Type in NEW username for " + oEmployee.getUsername());
						String IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setUsername(IN);
						
						System.out.println("Type in NEW password:");
						IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setPassword(IN);
						
						System.out.println("Type in NEW Email (current " + oEmployee.getEmail() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setEmail(IN);
						
						System.out.println("Type in NEW Email (current " + oEmployee.getEmail() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setEmail(IN);
						
						System.out.println("Type in NEW First Name (current " + oEmployee.getFname() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setFname(IN);
						
						System.out.println("Type in NEW Employee Number (current " + oEmployee.getEmpNum() + " )");
						IN = input.nextLine();
						if(!IN.isEmpty()) oEmployee.setEmpNum(tryparse(IN));
						
						System.out.println("Edited account with ID: "+ dd.editEmployee(oEmployee));
						
						subLoop = false;
					}
					
				}
				break;
				//-			SEARCHING ACCOUNTS INTO THE DATABASE 			-//	
				
			case "S":
				System.out.println("Type in Username:");
				testAcnt.setUsername(input.nextLine());
				System.out.println("Type in Password:");
				testAcnt.setPassword(input.nextLine());
				System.out.println("Type in Email:");
				testAcnt.setEmail(input.nextLine());
				System.out.println("Type in Permission:");
				
				
				testAcnt.setPermissions(tryparse(input.nextLine()));
				
				System.out.println(db.findAccount(testAcnt));
				break;
				
			case "D":				
				System.out.println("Type in AID: ");
				testAcnt.setAID(tryparse(input.nextLine()));
				
				if(testAcnt.getAID() < 0)
				{
					System.out.println("[ERROR] AID: '" + oClient.getAID() + "' does not exist in the database!");
				}
				else if(testAcnt.getPermissions() < 0)
				{
					System.out.println("[ERROR] AID: '" + oClient.getAID() + "' does not have a valid permission!");
					//Probably do something like remove it from the database or set permission based on allowed rows.
				}
				else if (testAcnt.getPermissions() == 0)	//Begin removing account by assuming it being a client
				{
					System.out.println( "Did we remove that Client? " + dd.deleteClient(testAcnt.getAID()) );
				}
				else //Begin removing account by assuming it being a employee
				{
					System.out.println( "Did we remove that Employee? " + dd.deleteEmployee(testAcnt.getAID()) );
				}
				
				break;
				
			case "H" :
				System.out.println("Type in AID: ");
				testAcnt = db.getAccount( tryparse(input.nextLine()) );
				System.out.println(testAcnt.toString());
				
				if(testAcnt.getAID() < 0)
					System.out.println("[ERROR] Account not found!");
				else if(testAcnt.getPermissions() == 0)
				{
					oClient = dd.getClient(testAcnt.getAID());		//Gets all client information
					List<bloodpressure> bp = oClient.getBP();
					
					bloodpressure BP = new bloodpressure(oClient.getAID());
					
					System.out.println("Type in DATE:");
					BP.setDate(input.nextLine());
					System.out.println("Type in BP:");
					BP.setBP(input.nextLine());
					System.out.println("Type in PULSE:");
					BP.setPulse(input.nextLine());
					System.out.println("Type in TEMP:");
					BP.setTemp(input.nextLine());
					System.out.println("Type in WEIGHT:");
					BP.setWeight(input.nextLine());
					
					bp.add(BP);
					oClient.setBP(bp);
					dd.editClient(oClient);
				}
				else
				{
					System.out.println("[Error] User is in EMPLOYEE group");
				}
				break;
			case "G":
				System.out.println("Type in AID: ");
				testAcnt = db.getAccount( tryparse(input.nextLine()) );
				System.out.println(testAcnt.toString());
				
				if(testAcnt.getAID() < 0)
					System.out.println("[ERROR] Account not found");
				else if(testAcnt.getPermissions() == 0)
				{
					oClient = dd.getClient(testAcnt.getAID());
					System.out.println("Usergroup: CLIENT");
					System.out.println("Number of bloodpressures stored: " + oClient.getBP().size());
					System.out.println("Number of Alerts stored: " + oClient.getAlerts().size());
				}
				else
				{
					oEmployee = dd.getEmployee(testAcnt.getAID());
					System.out.println("Usergroup: EMPLOYEE");
					System.out.println("PERMISSIONS: " + oEmployee.getPermissions());
					System.out.println("Employee Number: " + oEmployee.getEmpNum());
				}
				break;
				
			case "E":
				System.out.println("Type in AID for ACCOUNT: ");
				System.out.println("Does this exist? " + dd.existsAccount(tryparse(input.nextLine())));
				break;
				
			case "P":
				System.out.println("Type in the USERNAME: ");
				String username = input.nextLine();
				System.out.println("Type in the PASSWORD: ");
				String password = input.nextLine();
				System.out.println("AID: " + dd.findUserPass(username, password) );
				break;
				
				//Gets all of the clients from the Database
			case "O":
				System.out.println("A list of all of the Clients AIDs: ");
				System.out.println( dd.getAllClients() );
				break;
				
				//Gets all of the employees from the Database
			case "L":
				System.out.println("A list of all of the Employee AIDs: ");
				System.out.println( dd.getAllEmployees() );
				break;
				
			//Runs a 'Like' Search for the first name of a client
			case "M":
				System.out.println("Type in the first name of the client: ");
				String firstname = input.nextLine();
				oClient.setFname(firstname);
				System.out.println("We found clients: ");
				System.out.println(dd.findClientByInfo(oClient.getUserInfo()));
				break;
				
			//Runs a 'Like' Search for the first name of a client
			case "T":
				System.out.println("Type in the first name of the client: ");
				String fname = input.nextLine();
				oEmployee.setFname(fname);
				System.out.println("We found clients: ");
				System.out.println(dd.findEmpByInfo(oEmployee.getUserInfo()));
				break;
				
			case "Q":
				loop = false;
					break;
			default:
				System.out.println("Retry input");
				break;
			}
		}
		input.close();
	}
	
	//returns 0 on unparseable data
	private static int tryparse(String sString)
	{
		try { return Integer.parseInt(sString);}
		catch(NumberFormatException e){}
	return -1;
		
	}
}
