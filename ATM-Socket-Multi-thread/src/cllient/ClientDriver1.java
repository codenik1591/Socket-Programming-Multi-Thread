package cllient;

/*import clientSide.Client;*/

public class ClientDriver1 
{

	public static void main(String[] args) 
	{
		System.out.println("This is ClientDriver..!!!");
		Runnable client = new Client1();
		Thread clientThrd = new Thread(client);
		clientThrd.setName("Client_Thread");
		System.out.println(clientThrd.getName());
		clientThrd.start();

	}

}
