/**
 * Created on Sep 13, 2010
 *
 * Project: demo05-SimpleObserverObservablePattern 
 */
package observerObservablePattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author dwatson, kitty
 * @version 2.0
 */
public class Coolant implements Observer
{
	//Constants
	private final int LOWER = -75;
	private final int UPPER = 75;
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable p, Object arg)
	{
		Pipe pipe = (Pipe)p;
		
		if(pipe.getTemperature() <= LOWER)
		{
			System.out.println("Shutting off coolant, temperature at "+
					pipe.getTemperature());
		}
		else if(pipe.getTemperature() >= UPPER)
		{
			System.out.println("Starting up coolant, temperature at "+
					pipe.getTemperature());
		}
		else
		{
			System.out.println("Temperature normal at "+
					pipe.getTemperature());
		}
	}
}
