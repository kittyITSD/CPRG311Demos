/**
 * Created on Sept 11, 2015
 *
 * Project: demo04-BasicThreading
 */
package producerConsumerDeadlock;

import java.util.LinkedList;

/**
 * SharedBuffer.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: Class holds and maintains the buffer of characters.
 */
public class SharedBuffer
{
	private LinkedList<Character> buffer;
	public static int MAX_SIZE = 10;
	
	public SharedBuffer()
	{
		this.buffer = new LinkedList<Character>();
	}
	
	public LinkedList<Character> getBuffer()
	{
		return buffer;
	}
	
	public synchronized int getItemCount()
	{
		return buffer.size();
	}
	
	public Character removeChar()
	{
		Character c = buffer.remove();
		return c;
	}

	public void addChar( Character c )
	{
		buffer.add( c );
	}
}
