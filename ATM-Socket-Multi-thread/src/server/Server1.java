package server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import util.ThreadPool1;

public class Server1 implements Runnable
{
	DataOutputStream dosClient=null;
	int port;

	public Server1(int port) 
	{
		this.port = port;	
	}
	
	public void run() 
	{
		PrintWriter outToClient;
		try
		{
			ServerSocket serverSock = new ServerSocket(port);
			System.out.println("Socket created");
			ThreadPool1 t = ThreadPool1.getInstance();
			
			while(true)
			{
				Socket clientSock = serverSock.accept();
				System.out.println("Check -- Connection accepted..!!!");
				outToClient = new PrintWriter(clientSock.getOutputStream(),true);
				Thread tRet = t.borrowThread(clientSock);
				
				//DataOutputStream dos ;
				
				dosClient = new DataOutputStream(clientSock.getOutputStream());
				dosClient.writeUTF("Connection Accepted....");

				outToClient.println("Connection Established..!!!");
				tRet.start();	
			}	
		}
		catch (IOException e) 
		{
			try
			{
				dosClient.writeUTF("Server stopped unexpectedly... !!!");
			}
			catch (IOException e1) 
			{
				System.out.println("Nested IO Exception..!!!");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Error while creating server socket");
			ex.printStackTrace();
			System.exit(0);	
		}
		
	}

}
