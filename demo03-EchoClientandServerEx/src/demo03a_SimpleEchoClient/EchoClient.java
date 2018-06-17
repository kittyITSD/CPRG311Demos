/**
 * EchoClient
 */
package demo03a_SimpleEchoClient;

/**
 * @author dwatson, kitty
 * @version 1.1
 * Sep 5, 2012
 */

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class EchoClient
{
	/**
	 * @param args
	 */
	public static void main( String[] args )
	{
		try
		{
			// Open a connection to my server listening on port 5555
			Socket s1 = new Socket( "localhost", 5555 );
			
			String text = JOptionPane.showInputDialog( "Enter text: " );
			
			// Creating an output stream to send text to the server
			OutputStream os = s1.getOutputStream();
			DataOutputStream dos = new DataOutputStream( os );
			dos.writeUTF( text );
			
			// Create an input stream to receive echo from server
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream( is );
			JOptionPane.showMessageDialog (null, dis.readUTF() );
			
			dos.close();
			dis.close();
			s1.close();
		
		}
		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
