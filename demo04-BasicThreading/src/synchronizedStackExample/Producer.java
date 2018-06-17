/**
 * Created on Jul 7, 2004
 *
 * Project: demo04-BasicThreading
 */
package synchronizedStackExample;

/**
 * Producer.java
 *
 * @author dwatson, kitty
 * @version 1.2
 * 
 * Class Definition: Class Producer generates characters to be added
 * to the SyncStack.
 */
public class Producer implements Runnable
{
	// Attributes
	private SyncStack  		theStack;
	
	// Constructors
	/**
	 * User defined constructor to assign user defined values to
	 * class level attributes.
	 * @param theStack a reference to the object containing the current
	 * operational stack.
	 */
	public Producer( SyncStack theStack )
	{
		this.theStack = theStack;
	}
	
	//Operational Methods
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		char c;
		for( int i = 0; i < 20; i++ )
		{
			c = (char)( Math.random() * 26 + 'A' );
			theStack.push( c );
			System.out.println( "Producer " + Thread.currentThread().getId() + ":  " + c );
			try
			{
				Thread.sleep( (int)(Math.random() * 300 ) );
			}
			catch( InterruptedException e )
			{
				//Ignore it...........
			}
		}
	}
}
