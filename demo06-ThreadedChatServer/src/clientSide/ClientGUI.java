/**
 * Created on Sep 13, 2010
 *
 * Project: demo06-ThreadedChatServerExample 
 */
package clientSide;

import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import utilities.*;

/**
 * @author dwatson, kitty
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ClientGUI extends JFrame implements Observer
{
	//Attributes
	private JTextField 			messageToSend;
	private JTextArea			displayMessage;
	private JButton				send, connect, disconnect;
	private Socket				socket;
	private String 				userName;
	private ObjectOutputStream 	oos;
	private InputListener		listener;
	private boolean				newSession;
	
	//Constructor
	/**
	 * Default Constructor
	 */
	public ClientGUI()
	{
		createClientGUI();
	}

	private void createClientGUI()
	{
		this.setTitle("GUI Message Client");
		this.setBounds(400, 300, 500, 700);
		
		Container pane = this.getContentPane();
		pane.setLayout(new BorderLayout(5,5));
		Border buttonEdge = BorderFactory.createRaisedBevelBorder();
		
		//Code block that builds the gui components to send messages
		JPanel fp = new JPanel(new GridLayout(3,1));
		JLabel sendLabel = new JLabel("Message to Send:");
		messageToSend = new JTextField();
		JPanel sendPanel = new JPanel();
		send = new JButton("Send");
		send.setBorder(buttonEdge);
		send.addActionListener(new ButtonListener());
		send.setEnabled(false);
		sendPanel.add(send);
		fp.add(sendLabel);
		fp.add(messageToSend);
		fp.add(sendPanel);
		pane.add(fp, BorderLayout.NORTH);
		
		//Code block to display any message sent from the client
		JPanel sp = new JPanel(new BorderLayout());
		JLabel recieveLabel = new JLabel("Message Board");
		displayMessage = new JTextArea();
		displayMessage.setBorder(BorderFactory.createEtchedBorder());
		displayMessage.setEditable(false);
		//displayMessage.setBounds(0, 0, 1024, 768);
		sp.add(recieveLabel, BorderLayout.NORTH);
		sp.add(displayMessage, BorderLayout.CENTER);
		pane.add(sp,BorderLayout.CENTER);
		
		//Code block to place buttons to connect and disconnect
		JPanel tp = new JPanel(new GridLayout(1,2));
		JPanel cp = new JPanel();
		connect = new JButton("Connect");
		connect.setBorder(buttonEdge);
		connect.addActionListener(new ButtonListener());
		connect.setEnabled(true);
		cp.add(connect);
		JPanel dPanel = new JPanel();
		disconnect = new JButton("Disconnect");
		disconnect.setBorder(buttonEdge);
		disconnect.addActionListener(new ButtonListener());
		disconnect.setEnabled(false);
		dPanel.add(disconnect);
		
		tp.add(cp);
		tp.add(dPanel);
		pane.add(tp, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg)
	{
		Message m = (Message)arg;		
		String msg = m.getUser()+": "+m.getMsg()+" ("+m.getTimeStamp()+")";
		displayMessage.append(msg+"\n");
		
		// connected to another person
		if (m.getMsg().compareTo("You can start chatting!") == 0)
		{
			send.setEnabled(true); // now i can TALK!
			disconnect.setEnabled(true); // and if i don't like the other person, i can run away!
		}
		
		// the other person ran away!
		if (m.getMsg().compareTo("has disconnected.") == 0)
		{
			// i didn't quit the session, so i get to keep my username
			newSession = false;
			disconnectMe(); // drop current session
			connectMe(); // start new session
		}
		
	}
	
	public void connectMe()
	{
		try
		{
			socket = new Socket("localhost",5555);
			// if i didn't disconnect, i want to keep my username
			if(newSession==true)
			{
				userName = JOptionPane.showInputDialog("Enter user name");
			}
			connect.setEnabled(false);
			
			oos = new ObjectOutputStream(socket.getOutputStream());
			displayMessage.append("Connected! Waiting for a chat partner...\n");
			
			//start an input listener thread
			listener = new InputListener(socket,ClientGUI.this);
			Thread t1 = new Thread(listener);
			t1.start();
		}
		catch (HeadlessException e1)
		{
			e1.printStackTrace();
		}
		catch (UnknownHostException e1)
		{
			e1.printStackTrace();
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
	public void disconnectMe()
	{
		displayMessage.append("Disconnected.\n");
		disconnect.setEnabled(false);
		send.setEnabled(false);
		connect.setEnabled(true);
		try
		{
			oos.close();
			socket.close();
			listener = null;
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
	}
	
//***************************************************(
	private class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == connect)
			{
				// if i can get to this button, it means i want to start a new chat session
				newSession = true;
				connectMe();
			}
			if(e.getSource() == send)
			{
				Message m = new Message(userName,messageToSend.getText(),new Date());
				
				try
				{
					oos.writeObject(m);
					displayMessage.append("Me: "+m.getMsg()+" ("+m.getTimeStamp()+")\n");
					messageToSend.setText("");
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
			
			if(e.getSource() == disconnect)
			{
				// if i hit this button, it means i want to quit and next time i connect,
				// i will need to provide my username again
				newSession = true;
				Message m = new Message(userName,"has disconnected.",new Date());
				try
				{
					oos.writeObject(m);
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
				disconnectMe();
			}
		}
	}
	// Main to run client GUI.
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new ClientGUI();
	}
}
