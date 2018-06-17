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
public class RunPrintStuffThread
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		PrintStuffThread ps1 = new PrintStuffThread("Thread One");
		ps1.start();
		
		PrintStuffThread ps2 = new PrintStuffThread("Thread Two");
		ps2.start();
		
		PrintStuffThread ps3 = new PrintStuffThread("Thread Three");
		ps3.start();
		
		PrintStuffThread ps4 = new PrintStuffThread("Thread Four");
		ps4.start();
		
		// main() continuously checking if threads are still running
		while(ps1.isAlive() || ps2.isAlive() || ps3.isAlive() || ps4.isAlive());
		
		System.out.println("All threads are complete");

	}

}
