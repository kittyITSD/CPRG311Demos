/**
 * Created on May 31, 2011
 *
 * Project: demo07-DateADTImplemetationExample 
 */
package dateADTExercise;

/**
 * InvalidDateException.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: 
 */
@SuppressWarnings("serial")
public class InvalidDateException extends Exception
{
	public InvalidDateException()
	{
		
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public InvalidDateException(String message)
	{
		super(message);
	}
}
