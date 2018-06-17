/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading Version 2
 * This demo makes use of the Observable/Observer pattern to 
 * generate 100 numbers in sequence in a Vector using four
 * threads producing 25 numbers each.
 */
package numberGeneratorExerciseObserver;

import java.util.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: A threadable object that generates 25 NumberEntry 
 * objects and notifies the NumTank object that an object of type
 * NumberEntry has been produced and should be added to the NumTank. 
 */
public class NumGenerator extends Observable implements Runnable
{
	//Attributes
	private String 			threadName;
	private static int		number = 0;
	
	//Constructor
	/**
	 * @param threadName
	 * @param tank
	 */
	public NumGenerator(String threadName)
	{
		this.threadName = threadName;
	}
	
	public void run()
	{
		for(int i = 0; i < 25; i++)
		{
			this.setChanged();
			this.notifyObservers(new NumberEntry(++number,threadName));
			try
			{
				Thread.sleep((long)(Math.random()*500));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
