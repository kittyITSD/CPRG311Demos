/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading Version 2
 * This demo makes use of the Observable/Observer pattern to 
 * generate 100 numbers in sequence in a Vector using four
 * threads producing 25 numbers each.
 */
package numberGeneratorExerciseV2;

/**
 * RunThreads.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: Class to create, run and monitor all threads.
 */
public class RunThreads
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		NumTank nt = new NumTank();
		
		NumGenerator ng1 = new NumGenerator("Thread 1");
		NumGenerator ng2 = new NumGenerator("Thread 2");
		NumGenerator ng3 = new NumGenerator("Thread 3");
		NumGenerator ng4 = new NumGenerator("Thread 4");
		
		ng1.addObserver(nt);
		ng2.addObserver(nt);
		ng3.addObserver(nt);
		ng4.addObserver(nt);
		
		ThreadGroup tg = new ThreadGroup("Threads");
		
		Thread t1 = new Thread(tg,ng1);
		Thread t2 = new Thread(tg,ng2);
		Thread t3 = new Thread(tg,ng3);
		Thread t4 = new Thread(tg,ng4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		while(tg.activeCount() > 0);
		
		nt.printNumbers();
	}
}
