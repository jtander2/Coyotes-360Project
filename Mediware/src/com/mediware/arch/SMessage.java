package com.mediware.arch;


public class SMessage{
    
    Message m;
    int sendCount;
    
    
    /**
     * Creates a new scheduled message.  sendCount will determine the number of times
     * the message will be scheduled.  Use negative number for sendCount to have
     * indefinitely scheduled message.
     * 
     * @param m
     * @param sendCount
     */
    public SMessage(Message m, int sendCount) {
	this.m = m;
	this.sendCount = sendCount;
	
    }
    
    /**
     * sendCount--;<br>
     * used to clock a sending of the message for a scheduled number of times.
     * 
     * @return true if sendCount is 0 after decrement (flag for deletion)
     */
    public boolean decrementSendCount() {
	
	sendCount--;
	if(sendCount == 0) {
	    return true;
	}
	
	return false;
	
    }

}
