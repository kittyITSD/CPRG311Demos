/**
 * Created on Sep 18, 2009
 *
 * Project: demo04-BasicThreading
 */
package basicThreads;

/**
 * @author dwatson, kitty
 * @version 1.1
 */
public class PrintStuffThread extends Thread
{
	//Attributes
	private String s;
	
	//Constructors
	public PrintStuffThread(String s)
	{
		super();
		this.s = s;
	}
	
	//Operational Methods
	public void run()
	{
		for(int i = 0; i < 15; i++)
		{
			System.out.println(s);
			
			try
			{
				sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
