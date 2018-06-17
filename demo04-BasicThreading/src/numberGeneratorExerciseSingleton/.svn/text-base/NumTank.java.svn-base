/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading
 */
package numberGeneratorExerciseSingleton;

import java.util.*;


/**
 * NumTank.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: This class is constructed using a Singleton Pattern to
 * prevent multiple instances being generated.  The class that holds all
 * NumberEntry objects created by all threads in program.
 */
public class NumTank
{
	//Attributes
	private static NumTank		nt;
	private Vector<NumberEntry> numList;
	private  int				nextNumber;
	
	//Constructor
	/**
	 * Default constructor that constructs an empty vector of NumberEntry
	 * objects.
	 */
	private NumTank()
	{
		numList = new Vector<NumberEntry>(100);
		nextNumber = 1;
	}
	
	//Operational Methods
	
	/**
	 * Method to return the Singleton reference to the NumTank object. The
	 * Singleton pattern ensures only one reference is ever created for the
	 * NumTank class.
	 * @return a reference to the NumTank object.
	 */
	public static NumTank getNumTank()
	{
		if(nt == null)
		{
			nt = new NumTank();
		}
		return nt;	
	}
	
	/**
	 * Method to generate the next value in sequence and indicate which
	 * thread created it.
	 * @param thread name of current thread.
	 */
	public synchronized void addValue(String thread)
	{
		numList.add(new NumberEntry(nextNumber++,thread));
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
