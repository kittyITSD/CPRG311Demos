/**
 * Created on Jul 4, 2006
 *
 * Project: demo03_BasicEchoClientandServerExercises
 */
package demo03b_EchoServerAndClientWithUserLogoff;

import java.io.*;
import java.net.*;
import javax.swing.*;

/**
 * @author dwatson
 * @version 1.0
 * 
 * To determine what your IP address in windows - open a command line dialog
 * box and type at the prompt "ipconfig".
 * 
 * in Linux type "ifconfig etho"
 * 
 */
public class EchoClient
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String text = "";
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try
		{
			String ip = JOptionPane.showInputDialog("Enter ip address");
			int pn = Integer.parseInt(JOptionPane.showInputDialog("Enter port number"));
			Socket s1 = new Socket(ip,pn);
			
			while(!text.equals("quit"))
			{
				text = JOptionPane.showInputDialog("Enter Message or type [quit] to leave");
				
				//Create an output stream to send the message to server.
				OutputStream os = s1.getOutputStream();
				dos = new DataOutputStream(os);
				dos.writeUTF(text);
				
				//Create an input stream to catch the echo message from the server
				InputStream is = s1.getInputStream();
				dis = new DataInputStream(is);
				JOptionPane.showMessageDialog(null,dis.readUTF());
			}
			//close all sockets and streams
			s1.close();
			dis.close();
			dos.close();
			
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
