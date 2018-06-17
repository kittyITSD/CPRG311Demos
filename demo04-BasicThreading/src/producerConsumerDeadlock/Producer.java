/**
 * Created on Sept 11, 2015
 *
 * Project: demo04-BasicThreading
 */
package producerConsumerDeadlock;

/**
 * Producer.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: Class generates characters and adds them to the SharedBuffer.
 */
public class Producer implements Runnable
{
	private SharedBuffer buffer;
	
	public Producer( SharedBuffer buffer )
	{
		this.buffer = buffer;
	}

	public void run()
	{
		char c;
		
		for( int i = 0; i < 20; i++ )
		{
			// wait until buffer isn't full anymore
			while ( buffer.getItemCount() == SharedBuffer.MAX_SIZE );
			
			c = (char)( Math.random() * 26 + 'A' );
			buffer.addChar( c );
			
			System.out.println( "Producer: " + c );
			
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
