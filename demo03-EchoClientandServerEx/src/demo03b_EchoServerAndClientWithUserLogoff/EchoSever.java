/**
 * Created on Jul 4, 2006
 *
 * Project: demo03_BasicEchoClientandServerExercises
 */
package demo03b_EchoServerAndClientWithUserLogoff;

import java.io.*;
import java.net.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 */
public class EchoSever
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ServerSocket server = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket c1 = null;
		
		try
		{
			server = new ServerSocket(5555);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		while(true)
		{
			try
			{
				System.out.println("Server up and running!!!!!!!!!!");
				c1 = server.accept();
				System.out.println("Accepted a client connection.");
				
				//Read input from client
				dis = new DataInputStream(c1.getInputStream());
				String temp = dis.readUTF();
				temp = c1.getInetAddress()+temp;
				System.out.println(temp);
				
				//Echo text back to client.
				dos = new DataOutputStream(c1.getOutputStream());
				dos.writeUTF(temp);
				
				dis.close();
				dos.close();
				c1.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
