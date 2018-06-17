/**
 * Created on October 4, 2015
 */
package CounterADT;

/**
 * InvalidCounterException.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: 
 */
@SuppressWarnings("serial")
public class InvalidCounterException extends Exception
{
	public InvalidCounterException()
	{
		
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public InvalidCounterException(String message)
	{
		super(message);
	}
}
