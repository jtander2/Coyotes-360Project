package com.mediware.arch;

import com.mediware.arch.Enums.mType;
import com.mediware.arch.Enums.partition;


/**
 * Message class for which shall be used by the partitions to communicate
 * data.<br><br>
 * Different message types shall be defined to have different arguments
 * and will have specific subscribers that shall interpret them.
 * 
 * @author John Anderson
 *
 */
public class Message {

    
    private mHeader messageHeader;
    private mType messageType;
    private mData messageData;
    private boolean read;
    
    /**
     * Default Message Constructor
     * 
     * @param publisher
     * @param subscriber
     * @param args
     * @param messageType
     */
    public Message(partition publisher, partition[] subscriber, mData messageData, mType messageType) {
		
		messageHeader = new mHeader(publisher, subscriber, messageData.getArguments().length + messageData.getLabels().length);
		this.messageData = messageData;
		this.messageType = messageType;
		read = false;
		
		
    }
    
    public mHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(mHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public mType getMessageType() {
		return messageType;
	}

	public void setMessageType(mType messageType) {
		this.messageType = messageType;
	}

	public mData getMessageData() {
		return messageData;
	}

	public void setMessageData(mData messageData) {
		this.messageData = messageData;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	/**
     * 
     * @return the number of arguments in the message
     */
    public int getMessageSize() {
	
	return messageHeader.argCount;
	
    }
    
    /**
     * Used in integration for partitions to check if new incoming messages have arrived
     * 
     * @param thisPartition
     * @return <i>true</i> if thisPartition is in the subscriber list for the message
     */
    public boolean checkIsSubscriber(partition thisPartition) {
	
	boolean isSubscriber = false;
	
	for(int i = 0; i < messageHeader.subscriber.length; i++) {
	    
	    if(messageHeader.subscriber[i] == thisPartition) {
		isSubscriber = true;
	    }
	    
	}
	
	return isSubscriber;
    }
    
    /**
     * Implemented purely for functional use and for unit testing.  May need to be used later,
     * in case of multiple partitions having the availability to publish a message.
     * 
     * @return the publisher of the message
     */
    public partition getPublisher() {
	
	return messageHeader.publisher;
	
    }
    
    
    /**
     * mHeader class used in the Message class to contain information about the exchange
     * of the message.<br><br>
     * @author John Anderson
     *
     */
    private class mHeader {
	
		partition publisher;
		partition[] subscriber;
		int argCount;
		
		public mHeader(partition publisher, partition[] subscriber, int argCount) {
		    
		    this.publisher = publisher;
		    this.subscriber = subscriber;
		    this.argCount = argCount;
		    
		}
	
    }
    
}
