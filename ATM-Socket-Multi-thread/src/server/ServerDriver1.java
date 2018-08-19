package server;

public class ServerDriver1
{
	public static void main(String[] args) 
	{
		System.out.println("This is ServerDriver..!!!");
		Runnable server = new Server1(8000);
		Thread serverThrd = new Thread(server);
		System.out.println("Server Thread Started..!!!");
		System.out.println("Server_Thread_Name : "+serverThrd.getName());
		serverThrd.start();

	}

}
