/**
 * Created on Sep 13, 2010
 *
 * Project: demo06-ThreadedChatServerExample
 */
package serverSide;

import java.net.*;
import java.io.*;
import java.util.*;

import utilities.Debug;

/**
 * @author dwatson, kitty
 * @version 1.0
 */
public class Server
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// level 0 = normal (OFF)
		// level 1 = debug (ON)
		// this would normally be set outside of the application (through args)
		// and would include a couple more levels
		// e.g. debug.level = verbose, severe, errors, warnings, info, none
		@SuppressWarnings("unused")
		Debug debug = new Debug(1);
		
		ArrayList<Socket> socketList = new ArrayList<Socket>(3);
		try
		{
			ServerSocket ss = new ServerSocket(5555);
			System.out.println("Server up and running!");
			
			while(true)
			{
				Socket cs = ss.accept();
				
				socketList.add(cs);
				
				if(socketList.size() == 2)
				{
					ClientHandler ch = new ClientHandler(
							socketList.get(0),socketList.get(1));
					ch.start();
					socketList.clear();
				}
			}
		}
		catch (SocketException e)
		{
			// not all exceptions are errors, just handle them gracefully!
			Debug.output("Server: Socket has been closed.");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
