/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading
 */
package numberGeneratorExerciseSingleton;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class NumGenerator extends Thread
{
	//Attributes
	private String 			threadName;
	private NumTank			tank;
	
	
	//Constructor
	/**
	 * @param threadName
	 * @param tank
	 */
	public NumGenerator(String threadName, NumTank tank)
	{
		this.threadName = threadName;
		this.tank = tank;
	}
	
	public void run()
	{
		for(int i = 0; i < 25; i++)
		{
			tank.addValue(threadName);
			try
			{
				sleep((long)(Math.random()*500));
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
