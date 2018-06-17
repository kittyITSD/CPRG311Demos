/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading
 */
package numberGeneratorExerciseV1;

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
public class NumTank
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
	public synchronized void addValue(String thread)
	//public void addValue(String thread)
	{
		numList.add(new NumberEntry(counter++,thread));
	}
	
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
}
