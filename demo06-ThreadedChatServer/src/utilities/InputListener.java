/**
 * Created on Sep 15, 2010
 *
 * Project: demo06-ThreadedChatServerExample 
 */
package utilities;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 * @author dwatson, kitty
 * @version 1.0
 */
public class InputListener extends Observable implements Runnable
{
	//Attributes
	private int 				listenerNumber;
	private Socket				socket;
	private ObjectInputStream	ois;
	
	// Constructors
	/**
	 * @param socket the socket being monitored
	 * @param obs class to be notified when something changes
	 */
	public InputListener(Socket socket,Observer obs)
	{
		listenerNumber = 0;
		this.socket = socket;
		this.addObserver(obs);
	}
	/**
	 * @param listenerNumber number assigned to this listener
	 * @param socket the socket being monitored
	 * @param obs class to be notified when something changes
	 */
	public InputListener(int listenerNumber, Socket socket, Observer obs)
	{
		this.listenerNumber = listenerNumber;
		this.socket = socket;
		this.addObserver(obs);
	}
	//Getter and Setter Methods
	/**
	 * @return the listenerNumber
	 */
	public int getListenerNumber()
	{
		return listenerNumber;
	}
	/**
	 * @param listenerNumber the listenerNumber to set
	 */
	public void setListenerNumber(int listenerNumber)
	{
		this.listenerNumber = listenerNumber;
	}
	
	//Operational Methods
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{		
		try
		{
			ois = new ObjectInputStream(socket.getInputStream());
			
			while(true)
			{
				Debug.output("input listener number "+listenerNumber);
				Object o = ois.readObject();
				setChanged();
				notifyObservers(o);
				
				Message m = (Message) o;
				if (m.getMsg().compareTo("has disconnected.") == 0)
				{
					Debug.output(m.getUser()+" is disconnecting...");
					ois.close();
					socket.close();
				}
					
			}
		}
		catch (SocketException e)
		{
			// not all exceptions are errors, 
			// just handle them gracefully!
			Debug.output("input listener number "+
			listenerNumber+": Socket has been closed.");
		}
		catch (EOFException e)
		{
			// not all exceptions are errors, 
			// just handle them gracefully!
			Debug.output("input listener number "+
			listenerNumber+": No stream available.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
