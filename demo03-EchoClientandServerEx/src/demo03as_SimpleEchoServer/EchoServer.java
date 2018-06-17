/**
 * EchoServer
 */
package demo03as_SimpleEchoServer;

/**
 * @author dwatson, kitty
 * @version 1.1
 * Sep 5, 2012
 */

import java.net.*;
import java.io.*;

public class EchoServer
{
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		ServerSocket ss = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Socket c1 = null;
		
		// Bind our server to port 5555
		try
		{
			ss = new ServerSocket( 5555 );
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while( true )
		{
			try
			{
				System.out.println( "Server is up and running!" );
				// Blocking statement - sits and listens for connection
				c1 = ss.accept();
				
				// Read input from client
				dis = new DataInputStream( c1.getInputStream() );
				String text = dis.readUTF();
				text = c1.getInetAddress() + " " + text;
				System.out.println( text );
				
				// Echo text back to client
				dos = new DataOutputStream( c1.getOutputStream() );
				dos.writeUTF( text );
				
				dis.close();
				dos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
