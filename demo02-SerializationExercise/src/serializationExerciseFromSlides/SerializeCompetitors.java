/**
 * Created on May 10, 2011
 *
 * Project: demo02-SerializationExercise
 */
package serializationExerciseFromSlides;

import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *	ReadWriteCompetitor.java
 *
 * @author kitty
 * @version 1.0
 *
 * Class Description:  
 */
public class SerializeCompetitors
{
	//Constants
	private static final int N = 1000;
	
	//Attributes
	private long 	competitorOutputTime,
					competitorInputTime,
					queueOutputTime,
					queueInputTime;
	
	public void serializeCompetitorsToFile()
	{
		long start, stop;
		start = System.currentTimeMillis();
		Competitor competitor = null;
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream( "res/competitors.ser" ) );
			
			for( int i = 0; i < N; i++ )
			{
				Location location = new Location( "Lindsey Park",
						"1823 McLeod Trail" );
				Event event = new Event( "100 meter free style", location );
				competitor = new Competitor( "Bob", event, 19 );
				oos.writeObject( competitor );
			}
			oos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		competitorOutputTime = stop - start;
	}
	
	public void deserializeCompetitorsFromFile()
	{
		
	}
	
	public void serializeCompetitorQueueToFile()
	{
		long start, stop;
		start = System.currentTimeMillis();
		Competitor competitor = null;
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream( "res/queue.ser" ) );
			ConcurrentLinkedQueue<Competitor> queue = 
									new ConcurrentLinkedQueue<Competitor>(); 
			for( int i = 0; i < N; i++ )
			{
				Location location = new Location( "Lindsey Park",
						"1823 McLeod Trail" );
				Event event = new Event( "100 meter free style", location );
				competitor = new Competitor( "Bob", event, 19 );
				queue.add( competitor );
			}
			oos.writeObject( queue );
			oos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		queueOutputTime = stop - start;
	}
	
	public void deserializeCompetitorQueueFromFile()
	{
		
	}
	
	public void printTimes()
	{
		System.out.println( "Time to write competitors individually = " +
				competitorOutputTime );
		System.out.println( "Time to write competitors with a queue = " +
				queueOutputTime );
		System.out.println( "Time to read competitors individually = " +
				competitorInputTime );
		System.out.println( "Time to read competitors with a queue = " +
				queueInputTime );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SerializeCompetitors s = new SerializeCompetitors();
		s.serializeCompetitorsToFile();
		s.deserializeCompetitorsFromFile();
		s.serializeCompetitorQueueToFile();
		s.deserializeCompetitorQueueFromFile();
		s.printTimes();
	}
}
