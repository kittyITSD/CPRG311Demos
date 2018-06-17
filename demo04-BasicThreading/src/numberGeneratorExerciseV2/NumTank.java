/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading Version 2
 * This demo makes use of the Observable/Observer pattern to 
 * generate 100 numbers in sequence in a Vector using four
 * threads producing 25 numbers each.
 */
package numberGeneratorExerciseV2;

import java.util.*;


/**
 * NumTank.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: Class that holds all NumberEntry objects created by all
 * threads in program.
 */
public class NumTank implements Observer
{
	//Attributes
	private Vector<NumberEntry> numList;
	private  int				counter;
	
	//Constructor
	/**
	 * Default constructor that constructs an empty vector of NumberEntry
	 * objects.
	 */
	public NumTank()
	{
		numList = new Vector<NumberEntry>(100);
		counter = 1;
	}
	
	//Operational Methods
	
	/**
	 * Method to generate the next value in sequence and indicate which
	 * thread created it.
	 * @param thread name of current thread.
	 */
	/* we're not using this synchronized method now...
	public synchronized void addValue(String thread)
	{
		numList.add(new NumberEntry(nextNumber++,thread));
	}
	*/
	/**
	 * Method to print the numbers in the current list.
	 */
	public void printNumbers()
	{
		for(int i = 0; i < numList.size(); i++)
		{
			System.out.println(numList.get(i));
		}
	}

	
	/**
	 * Method to update the NumberTank list with new numbers and
	 * set which thread updated the list. 
	 * @param ng the observable object NumGenerator
	 * @param o the NumberEntry object to be added to the list.
	 */
	@Override
	// when any one of the NumGenerators updates, this is called to add the object to the list
	public synchronized void update(Observable ng, Object o)
	{
		NumberEntry ne = (NumberEntry)o;
		// we're still maintaining the counter!
		ne.setValue(counter++);
		numList.add(ne);
	}
}
