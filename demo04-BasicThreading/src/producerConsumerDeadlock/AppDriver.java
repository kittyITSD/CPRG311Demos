/**
 * Created on Sept 11, 2015
 *
 * Project: demo04-BasicThreading
 */
package producerConsumerDeadlock;

import java.util.LinkedList;

/**
 * AppDriver.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: Class to run the Producer-Consumer Problem program.
 */
public class AppDriver
{
	public static void main( String[] args )
	{
		SharedBuffer buffer	= new SharedBuffer();
		ThreadGroup tg1 = new ThreadGroup( "TG One" );
		
		// Producer implements the Runnable interface
		Producer p1 = new Producer( buffer );
		Thread t1 = new Thread( tg1, p1 );
		t1.start();
		
		// Consumer extends the Thread class
		Consumer c1 = new Consumer( buffer, tg1 );
		c1.start();

		// spin till all the threads are done
		while( tg1.activeCount() > 0 );
		
		System.out.println("All done!");
	}
}
