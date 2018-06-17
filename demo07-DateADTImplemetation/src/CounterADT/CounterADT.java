/**
 * Created on October 4, 2015
 */
package CounterADT;

/**
 * CounterADT.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: This interface represents the public contract for the
 * implementation of Counter for the CounterADT Exercise. 
 */
public interface CounterADT
{
	/**
	 * Mutator method to modify the value of the counter.
	 * 
	 * Precondition: A valid Counter object exists and an integer value
	 * is passed.
	 * 
	 * Postcondition: The counter is changed to the value specified
	 * in the argument.
	 * 
	 * @param count the new counter value.
	 * @exception InvalidCounterException is thrown if a negative value
	 * is passed.
	 */
	public void setCounter(int count) throws InvalidCounterException;
	
	/**
	 * Mutator method to increment the value of the counter.
	 * 
	 * Precondition: A valid Counter object exists.
	 * 
	 * Postcondition: The counter value is incremented by 1.
	 */
	public void incCounter();
	
	/**
	 * Mutator method to decrement the value of the counter.
	 * 
	 * Precondition: A valid Counter object exists.
	 * 
	 * Postcondition: The counter value is decremented by 1.
	 *
	 * @throws InvalidCounterException is thrown if the counter value
	 * is currently 0 and cannot be decremented.
	 */
	public void decCounter() throws InvalidCounterException;
	
	/**
	 * Accessor method to return the counter value.
	 * 
	 * Precondition: A valid Counter object exists.
	 * 
	 * Postcondition: An integer value representing the current 
	 * counter value.
	 * 
	 * @return the counter value as an integer value.
	 */
	public int getCounter();
	
	/**
	 * Override toString method from Object.
	 * 
	 * Precondition: A valid Counter object exists.
	 * 
	 * Postcondition: A String of the current counter value.
	 * 
	 * @return the String representation of the counter value.
	 */
	public String toString();
	
	/**
	 * Transformer method to check if the counter is zero.
	 * 
	 * Precondition: A valid Counter object exists.
	 * 
	 * Postcondition: An boolean value representing the current
	 * state of the counter.
	 * 
	 * @return true if the counter is zero, otherwise false.
	 */
	public boolean isZero();
}
