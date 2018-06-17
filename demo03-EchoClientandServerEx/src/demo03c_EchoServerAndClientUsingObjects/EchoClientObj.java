/**
 * Created on Jul 4, 2006
 *
 * Project: demo03_BasicEchoClientandServerExercises
 */
package demo03c_EchoServerAndClientUsingObjects;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.util.*;

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

public class EchoClientObj
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String text = "";
		String user = "";
		String logOff = "";
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		try
		{
			String ip = JOptionPane.showInputDialog("Enter ip address");
			int pn = Integer.parseInt(JOptionPane.showInputDialog("Enter port number"));
			
			user = JOptionPane.showInputDialog("Enter User Name");
			
			while(!logOff.equals("quit"))
			{
				Socket s1 = new Socket(ip,pn);
				
				text = JOptionPane.showInputDialog("Enter Message");
				
				Message msg = new Message(user,text,new Date());
				
				//Create an object output stream to send the message to server.
				OutputStream os = s1.getOutputStream();
				oos = new ObjectOutputStream(os);
				oos.writeObject(msg);
				
				//Create an object input stream to catch the echo message
				//from the server
				InputStream is = s1.getInputStream();
				ois = new ObjectInputStream(is);
				msg = (Message)ois.readObject();
				JOptionPane.showMessageDialog(null,msg.toString());
				
				//close all sockets and streams
				s1.close();
				ois.close();
				oos.close();
				
				logOff = JOptionPane.showInputDialog("Enter \"quit\" to end connection");
			}
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
