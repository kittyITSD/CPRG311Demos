/**
 * Created on Sept 11, 2015
 *
 * Project: demo04-BasicThreading
 */
package producerConsumerDeadlock;

/**
 * Consumer.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: Class removes characters from the SharedBuffer.
 */
public class Consumer extends Thread
{
	private SharedBuffer buffer;

	public Consumer( SharedBuffer buffer, ThreadGroup group )
	{
		super(group, "TG One");
		this.buffer = buffer;
	}

	public void run()
	{
		for( int i = 0; i < 20; i++ )
		{
			// wait until there's something in buffer
			while( buffer.getItemCount() == 0 );
			
			char c = buffer.removeChar();
			
			System.out.println( "Consumer: " + c );
			
			// sleep for random-ish time
			try
			{
				Thread.sleep( (int)( Math.random() * 100 ) );
			}
			catch( InterruptedException e )
			{
				e.printStackTrace();
			}
		}
	}
}
