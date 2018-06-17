/**
 * Created on Jul 7, 2004
 *
 * Project: demo04-BasicThreading
 */
package synchronizedStackExample;
/*

 */
import java.util.*;


/**
 * SyncStack.java
 *
 * @author dwatson, kitty
 * @version 1.1
 * 
 * Class Definition: Class holds and maintains the synchronized stack of
 * Character objects.
 */
public class SyncStack
{
	// Attributes
	private List<Character> buffer = new ArrayList<Character>();
	
	//Getters and Setters
	/**
	 * Method to return the stack buffer 
	 * @return Returns the buffer.
	 */
	public List<Character> getBuffer()
	{
		return buffer;
	}
	
	// Operational Methods
	/**
	 * Method to pop the next value off the top of the stack.
	 * @return the next value on the stack
	 */
	public synchronized char pop()
	{
		char c;
		while( buffer.size() == 0 )
		{
			try
			{
				this.wait();
			}
			catch( InterruptedException e )
			{
				// Ignore it......
			}
		}
		c = ( (Character)buffer.remove( buffer.size() - 1 ) ).charValue();
		return c;
	}
	
	/**
	 * Method to push a new value on to the top of the stack.
	 * @param c the value being added to the top of the stack
	 */
	public synchronized void push( char c )
	{
		Character charObject = new Character( c );
		buffer.add( charObject );
		this.notify();
	}
}
