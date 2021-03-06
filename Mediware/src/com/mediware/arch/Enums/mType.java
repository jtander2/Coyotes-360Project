package com.mediware.arch.Enums;


public enum mType {
    loginRequest,
    loginResponse,
    cndDisplayDoctorMainPanel,
    cndDisplayRtvUsername,
    cndDisplayRtvPassword,
    cndDisplaySendMessage,
    cndDisplayErrorDialog,
    cndDisplayNewPatientPanel,
    cndDisplayPatientSearchPanel,
    cndDisplayMessagePanel,
    cndDisplayNewEmployeePanel,
    cndDisplayEditEmployee,			//{fname, mname, lname, street, city, state, zip, homenum, worknum, mobilenum, email, empNum}
    cndDisplayLoginPanel,
    cndDisplayMAMainPanel,
    cndDisplayNurseMainPanel,
    cndDisplayPatientMenuPanel,
    cndDisplayPatientVitalsPanel,
    cndDisplayPatientHealthHistory,
    cndDisplayEmployeeSearchPanel,
    cndDisplayPatientProfilePanel, 	//Takes in string parameters to be displayed to the user originally for updating
    								// Index = 0      1      2      3       4     5     6      7       8         9         10      11       12      13
    								//      {fname, mname, lname, street, city, state, zip, homenum, worknum, mobilenum, email, provider, policy, group}
    
    sysCreatePatient,   			// Message has string array created as follows:
    								// Index = 0      1      2      3      4      5     6       7          8           9         10      11         12        13      14    15      16       17        18
    								//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, provider, policynum, groupnum, dob, height, weight, username, password};
    
    sysCreateEmployee,   			// Message has string array created as follows:
									// Index = 0      1      2      3      4      5     6       7          8           9         10   11       12            13         14        15
									//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, dob, employeenum, permissions, username, password};
    sysLogoutRequest,
    sysPatientEditProfileRequest,
    sysUpdatePatient,				//Takes in string parameters to be updated in the db for the current patient who is logged in
									// Index = 0      1      2      3       4     5     6      7       8         9         10      11       12      13
									//      {fname, mname, lname, street, city, state, zip, homenum, worknum, mobilenum, email, provider, policy, group}
    sysGoToMenu,					//This will figure out what the current permissions of the logged in user are and call either cndDisplayDoctorMainPanel, cndDisplayNurseMainPanel, cndDisplayPatientMenuPanel, or cndDisplayPatientProfilePanel accordingly
    patientHistoryRequest,
    patientHistoryData,
    patientVitalsEntry, 			// Integer Arguments - bp, weight, temp, pulse, sugarLevel
    doctorPatientSearchRequest,
    doctorEmployeeSearchRequest,
    cndPatientSearchReport,
    cndEmployeeSearchReport,
    cndPatientReport,
    sysSelectPatient,
    sysUpdateEmployee,				//    {fname, mname, lname, street, city, state, zip, homenum, worknum, mobilenum, email, permission  empNum}
    sysRequestClientUpdate,			//	  {fname, mname, lname, street, city, state, zip, homenum, worknum, mobilenum, email, provider, policy, group, weight, height}
    sysSelectEmployee,
    sysRequestMessages,
    sysRequestMessageNum,
    sysRequestMessageDeletion,
    cndDisplayMessage,
    sysSendMessage,
    sysGoToViewedPatientMenu
}

//patientHistoryRequest - 1 arg - String - type of data being requested
//patientHistoryData	- 1 arg - String - type of data - n args - int - data at each point being graphed
