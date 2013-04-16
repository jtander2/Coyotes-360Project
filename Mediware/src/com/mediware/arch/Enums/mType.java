package com.mediware.arch.Enums;


public enum mType {
    loginRequest,
    loginResponse,
    cndDisplayDoctorMainPanel,
    cndDisplayRtvUsername,
    cndDisplayRtvPassword,
    cndDisplayErrorDialog,
    cndDisplayNewPatientPanel,
    cndDisplayPatientSearchPanel,
    cndDisplayMessagePanel,
    cndDisplayNewEmployeePanel,
    cndDisplayEditEmployee,
    cndDisplayLoginPanel,
    cndDisplayMAMainPanel,
    cndDisplayNurseMainPanel,
    cndDisplayPatientMenuPanel,
    
    sysCreatePatient,   // Message has string array created as follows:
    					// Index = 0      1      2      3      4      5     6       7          8           9         10      11         12        13      14    15      16       17        18
    					//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, provider, policynum, groupnum, dob, height, weight, username, password};
    
    sysCreateEmployee   // Message has string array created as follows:
						// Index = 0      1      2      3      4      5     6       7          8           9         10   11       12            13         14        15
						//      {fname, mname, lname, street, city, state, zip, homephone, workphone, mobilephone, email, dob, employeenum, permissions, username, password};

}
