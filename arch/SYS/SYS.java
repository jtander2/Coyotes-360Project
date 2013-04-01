package arch;

import java.util.ArrayList;


/**
 *  Class for system controls partition. 
 * 
 * 
 * @author Cameron Keith
 *
 */
public class SYS{
	
	private IO sysIO;
	private Message[] sysMessages; 		
	private int current_mType;
	
	//constructor - IO as an argument.
	public SYS(IO theIO){
		this.sysIO = theIO;
	}
	
	/**
	 * called by main. Checks for messages, executes functions
	 * and sends messages using IO if necessary. 
	 */
	public void run()
	{
		//first retrieve messages
		sysMessages = sysIO.nextFrame();
		
		
	}
		
}