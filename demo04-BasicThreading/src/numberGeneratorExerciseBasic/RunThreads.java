/**
 * Created on Jul 11, 2006
 *
 * Project: demo04-BasicThreading
 */
package numberGeneratorExerciseBasic;

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
		
		NumGenerator ng1 = new NumGenerator("Thread 1",nt);
		NumGenerator ng2 = new NumGenerator("Thread 2",nt);
		NumGenerator ng3 = new NumGenerator("Thread 3",nt);
		NumGenerator ng4 = new NumGenerator("Thread 4",nt);
		
		ng1.start();
		ng2.start();
		ng3.start();
		ng4.start();
		
		while(ng1.isAlive() || 
				ng2.isAlive() || 
				ng3.isAlive() || 
				ng4.isAlive());
		
		nt.printNumbers();
	}
}
