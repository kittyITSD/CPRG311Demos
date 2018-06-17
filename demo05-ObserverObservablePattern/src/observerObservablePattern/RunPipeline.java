/**
 * Created on Sep 13, 2010
 *
 * Project: demo05-SimpleObserverObservablePattern
 */
package observerObservablePattern;

/**
 * @author dwatson, kitty
 * @version 2.0
 */
public class RunPipeline
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// one pipe object (the observable)
		Pipe pipe = new Pipe();
		
		// 2 valves to control pressure on each pipe (observer)
		Valve v1 = new Valve();
		Valve v2 = new Valve();
		
		// 1 cooling system to control temperature of pipe (observer)
		Coolant c1 = new Coolant();
		
		// create list of observers
		pipe.addObserver(v1);
		pipe.addObserver(v2);
		pipe.addObserver(c1);
		
		// testing...
		System.out.println("Change pressure to high:");
		pipe.setPressure(110);
		System.out.println("\nChange pressure to low:");
		pipe.setPressure(29);
		System.out.println("\nChange pressure to normal:");
		pipe.setPressure(75);
		
		System.out.println("\nChange temperature to high:");
		pipe.setTemperature(100);
		System.out.println("\nChange temperature to low:");
		pipe.setTemperature(-100);
		System.out.println("\nChange temperature to normal:");
		pipe.setTemperature(35);
	}
}
