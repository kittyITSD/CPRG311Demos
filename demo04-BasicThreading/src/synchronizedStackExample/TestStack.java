/**
 * Created on Jul 7, 2004
 *
 * Project: demo04-BasicThreading
 */
package synchronizedStackExample;

import java.util.*;

/**
 * TestStack.java
 *
 * @author dwatson, kitty
 * @version 1.2
 * 
 * Class Definition: Class to run the Synchronized Stack program.
 */
public class TestStack
{

	public static void main(String[] args)
	{
		SyncStack stack	= new SyncStack();
		ThreadGroup group = new ThreadGroup( "Thread Group One" );
		
		// Producer implements the Runnable interface
		Producer p = new Producer( stack );
		Thread t1 = new Thread( group, p );
		t1.start();

		Thread t2 = new Thread( group, p );
		t2.start();

		Thread t3 = new Thread( group, p );
		t3.start();
		
		// Consumer extends the Thread class
		Consumer c1 = new Consumer( stack, group );
		c1.start();
		
		Consumer c2 = new Consumer( stack, group );
		c2.start();
		
		// wait for all threads in group to finish
		while( group.activeCount() > 0 );
		
		ArrayList<Character> buffer = (ArrayList<Character>)stack.getBuffer();
		Iterator<Character> it = buffer.iterator();
		
		System.out.println( "\n\nThe following are the characters left on the stack\n" );
		while( it.hasNext() )
		{
			System.out.print( it.next() + ", " );
		}
	}
}
