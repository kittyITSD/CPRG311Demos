/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading Version 2
 * This demo makes use of the Observable/Observer pattern to 
 * generate 100 numbers in sequence in a Vector using four
 * threads producing 25 numbers each.
 */
package numberGeneratorExerciseV3;

import java.util.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class NumGenerator extends Observable implements Runnable
{
	//Attributes
	private String 			threadName;
	// private NumTank		tank;
	
	//Constructor
	/**
	 * @param threadName
	 * @param tank
	 */
	public NumGenerator(String threadName)
	{
		this.threadName = threadName;
		// this.tank = tank;
	}
	
	public void run()
	{
		for(int i = 0; i < 25; i++)
		{
			// tank.addValue(threadName);
			// NumTank is observing me, so I will send an update and let it know I'm generating a new NumberEntry
			this.setChanged();
			this.notifyObservers(new NumberEntry(0,threadName));
			try
			{
				Thread.sleep(500);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
