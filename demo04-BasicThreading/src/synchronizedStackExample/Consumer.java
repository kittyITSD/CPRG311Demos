/**
 * Created on Jul 7, 2004
 *
 * Project: demo04-BasicThreading
 */
package synchronizedStackExample;

/**
 * Consumer.java
 *
 * @author dwatson, kitty
 * @version 1.1
 * 
 * Class Definition: Class Consumer removes characters from the SyncStack.
 */
public class Consumer extends Thread
{
	// Attributes
	private SyncStack  		theStack;
	private int 			number;
	private static int		counter = 1;
	
	/**
	 * @param theStack
	 */
	public Consumer( SyncStack theStack, ThreadGroup group )
	{
		super(group, "SyncStackGroup");
		this.theStack = theStack;
		this.number = counter++;
	}
	// Constructors
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		char c;
		for( int i = 0; i < 20; i++ )
		{
			c = theStack.pop();
			System.out.println( "Consumer " + number + ":  " + c );
			try
			{
				sleep( (int)(Math.random() * 300 ) );
			}
			catch( InterruptedException e )
			{
				//Ignore it...........
			}
		}
	}
}
