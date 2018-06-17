/**
 * Created on May 11, 2011
 *
 * Project: demo01-DataOutputStreamExercise 
 */
package dataOutputStreamExample;

import java.io.*;

/**
 * DataExample.java
 *
 * @author kitty
 * @version 1.0
 * 
 * Class Definition: 
 */
public class DataExample
{
	//Constants
	private static final int N = 100000;
	
	//Attributes
	private long 	unBufferedWriteTime,
					unBufferedReadTime,
					bufferedWriteTime,
					bufferedReadTime;
	
	public void generateRandomNumberFileUnBuffered()
	{
		long start,stop;
		start = System.currentTimeMillis();
		try
		{
			DataOutputStream out = new DataOutputStream(
					new FileOutputStream( "res/random.bin" ));
			
			for(int i = 0; i < N; i++)
			{
				int number = (int)( Math.random() * 255 );
				out.writeInt( number );
				System.out.println( i + " = " + number);
			}
			out.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		unBufferedWriteTime = stop - start;	
	}

	public void readIntegerFileInUnBuffered()
	{
		
	}
	
	public void generateRandomNumberFileBuffered()
	{
		long start,stop;
		start = System.currentTimeMillis();
		try
		{
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(
					new FileOutputStream("res/randombuf.bin")));
			
			for(int i = 0; i < N; i++)
			{
				int number = (int)(Math.random() * 255);
				out.writeInt(number);
				System.out.println(i+" = "+number);
			}
			out.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stop = System.currentTimeMillis();
		bufferedWriteTime = stop - start;
	}
	
	public void readIntegerFileInBuffered()
	{
		
	}
	
	public void printRunTimes()
	{
		System.out.println( "Total time for unbuffered output = " +
							unBufferedWriteTime );
		System.out.println( "Total time for buffered output = " +
							bufferedWriteTime );
		System.out.println( "Total time for unbuffered input = " +
							unBufferedReadTime );
		System.out.println( "Total time for buffered input = " +
							bufferedReadTime );
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DataExample d = new DataExample();
		
		d.generateRandomNumberFileUnBuffered();
		d.readIntegerFileInUnBuffered();
		d.generateRandomNumberFileBuffered();
		d.readIntegerFileInBuffered();
		d.printRunTimes();
	}

}
