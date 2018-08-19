package cllient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 implements Runnable 
{
	Socket clientSock;
	PrintWriter outToServer=null;

	public void run()
	{
		@SuppressWarnings("unused")
		BufferedReader inFromClient = null;
		inFromClient = new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			clientSock = new Socket("127.0.0.1",8000);
			outToServer = new PrintWriter(clientSock.getOutputStream(),true);
			System.out.println("In the run method of client");
			//outToServer.println("Heyy Serverr..!!!");
			
		}
		catch (IOException e)
		{
			System.out.println("Error While Creating ocket....!!!");
			e.printStackTrace();
		}
		finally
		{
			outToServer.close();
		}
		
		
		while(true)
		{
			outToServer.println("Heyy Serverr..!!!");
		}
		
	}

}
