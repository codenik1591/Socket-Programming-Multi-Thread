package util;
import java.net.Socket;

import server.ServerHandler1;

public class ThreadPool1
{

	private volatile static ThreadPool1  uniqInst;
	public static Thread[] thrdArr = new Thread[3];
	
	private static int counter = 0;
	private Thread thrd;
	

	public static ThreadPool1 getInstance()
	{
		if(uniqInst ==null)
		{
			synchronized (ThreadPool1.class)
			{
				if(uniqInst == null)
				uniqInst = new ThreadPool1();
			}
		}	
					
		return uniqInst;
	}
	
	public Thread borrowThread(Socket s)
	{
		System.out.println("In the borrow method");
		
		ServerHandler1 serHand = new ServerHandler1(s);
		System.out.println("Check -- Socket Object sent to ServerHandler1..!!!");
		thrdArr[counter] = new Thread(serHand);
		thrd = thrdArr[counter];
		counter++;
		return thrd;
	}
	
	

}
