/**
 * Created on Sep 13, 2010
 *
 * Project: demo05-SimpleObserverObservablePattern
 */
package observerObservablePattern;

import java.util.Observable;

/**
 * @author dwatson, kitty
 * @version 2.0
 */
public class Pipe extends Observable
{
	private int pressure;
	private int temperature;

	public int getPressure()
	{
		return pressure;
	}

	public void setPressure(int pressure)
	{
		this.pressure = pressure;
		setChanged();
		notifyObservers();
	}
	
	public int getTemperature()
	{
		return temperature;
	}

	public void setTemperature(int temperature)
	{
		this.temperature = temperature;
		setChanged();
		notifyObservers();
	}
}
