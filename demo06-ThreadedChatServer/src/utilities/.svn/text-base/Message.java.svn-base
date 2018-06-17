/**
 * Created on Sep 13, 2010
 *
 * Project: demo06-ThreadedChatServerExample
 */
package utilities;

import java.io.*;
import java.util.*;

/**
 * @author dwatson
 * @version 1.0
 */

public class Message implements Serializable
{	
	//Constants
	private static final long serialVersionUID = -6635341076366698125L;
	
	//Attributes
	private String 				user;
	private String				msg;
	private Date				timeStamp;
	
	//Constructors
	/**
	 * User defined constructor
	 * @param user user name
	 * @param msg message being transported
	 * @param timeStamp date and time stamp put on message
	 */
	public Message(String user, String msg, Date timeStamp)
	{
		this.user = user;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	//Getter and Setter Methods
	/**
	 * @return the user
	 */
	public String getUser()
	{
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user)
	{
		this.user = user;
	}

	/**
	 * @return the msg
	 */
	public String getMsg()
	{
		return msg;
	}
	
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp()
	{
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

	//Operational Methods
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Message [msg=" + msg + ", timeStamp=" + timeStamp + ", user="
				+ user + "]";
	}
}
