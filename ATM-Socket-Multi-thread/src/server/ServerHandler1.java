package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;

public class ServerHandler1 implements Runnable 
{
	Socket s;

	String accountDetailPath,balanceDetailsPath;
	
	public ServerHandler1() 
	{	
		accountDetailPath = ".\\AllTextFiles\\Account_Details.properties";
		balanceDetailsPath = ".\\AllTextFiles\\BalanceDetails.properties";	
	}
	
	public ServerHandler1(Socket sin) 
	{
		this.s = sin;
		System.out.println("In the constructor of server handler");
	}
	
	public void depositMoney(int cusChoice) throws IOException
	{		
		PrintWriter outToClient = new PrintWriter(s.getOutputStream(),true);
		@SuppressWarnings("unused")
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		File fAccountDetails,fBalanceDetails;
		FileInputStream fisAccountDetails=null, fisBalanceDetails=null;//InputStream Declaration
		
		@SuppressWarnings("unused")
		FileOutputStream fosAccountDetails = null,fosBalanceDetails = null;//OutputStram Declaration
		Properties propAccountDetails,propBalanceDetails;
		
		
		/*File fAlice,fTom;
		FileInputStream fisAlice = null,fisTom = null;
		FileOutputStream fosAlice = null,fosTom = null;
		Properties propAlice,propTom;*/
		
		
		
		String savingBalAmount="",checkingBalAmount="";
		
		
		
		outToClient.println("Please Enter Your Account Type(saving/checking) : ");
		System.out.println("Check -- Please Enter Your Account Type(saving/checking) : ");
		BufferedReader brAccountType = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String AccountType = brAccountType.readLine().toUpperCase();
		
		if(cusChoice == 1)
		{
			fAccountDetails = new File(accountDetailPath);
			fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
			propAccountDetails = new Properties();
			propAccountDetails.load(fisAccountDetails);
			
			
			fBalanceDetails = new File(balanceDetailsPath);
			fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
			propBalanceDetails = new Properties();
			propBalanceDetails.load(fisBalanceDetails);
			
			
			if(AccountType.equals("SAVING"))
			{
				savingBalAmount = propBalanceDetails.getProperty("11111111_saving_balance");
				int savAmt = Integer.parseInt(savingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				System.out.println("Check -- Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				outToClient.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				
				int totalAmount = depositAmount+savAmt;
				
				fisAccountDetails.close(); //Close the InputStream for AccountDetails File
				fisBalanceDetails.close(); //Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				outToClient.println("Balance of Alice in Saving Account is : $" + totalAmount);
				
				propBalanceDetails.setProperty("11111111_saving_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				checkingBalAmount = propBalanceDetails.getProperty("11111111_checking_balance");
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				outToClient.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+chkAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				outToClient.println(" Balance of Alice in Checking Account is : $" + totalAmount);
				propBalanceDetails.setProperty("11111111_checking_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
					
			}
			
			else 
			{
				outToClient.println("The Type of Account Does not Exist, Please check...!!!!!");
			}
			
		}
		
		
		if(cusChoice == 0)
		{
			
			fAccountDetails = new File(accountDetailPath);
			fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
			propAccountDetails = new Properties();
			propAccountDetails.load(fisAccountDetails);
			
			
			fBalanceDetails = new File(balanceDetailsPath);
			fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
			propBalanceDetails = new Properties();
			propBalanceDetails.load(fisBalanceDetails);
			
			
			if(AccountType.equals("SAVING"))
			{
				
				savingBalAmount = propBalanceDetails.getProperty("00000000_saving_balance");
				int savAmt = Integer.parseInt(savingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				outToClient.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+savAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				outToClient.println(" Balance of Tom in Saving Account is : $" + totalAmount);
				propBalanceDetails.setProperty("00000000_saving_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("00000000_checking_balance");
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+chkAmt+"in your Saving Account.");
				
				outToClient.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+chkAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				outToClient.println(" Balance of Tom in Checking Account is : $" + totalAmount);
				propBalanceDetails.setProperty("00000000_checking_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
		
		}
		
	}
	
	public void withdrawMoney(int cusChoice) throws IOException
	{
		
		PrintWriter outToClient = new PrintWriter(s.getOutputStream(),true);
		
		@SuppressWarnings("unused")
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		File fAccountDetails,fBalanceDetails;
		FileInputStream fisAccountDetails=null, fisBalanceDetails=null;//InputStream Declaration
		
		@SuppressWarnings("unused")
		FileOutputStream fosAccountDetails = null,fosBalanceDetails = null;//OutputStram Declaration
		Properties propAccountDetails,propBalanceDetails;
		
		String savingBalAmount="",checkingBalAmount="";
		
		outToClient.println("Pleasse Enter Your Account Type(saving/checking) : $");
		BufferedReader brAccountType = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String AccountType = brAccountType.readLine().toUpperCase();
		
		if(cusChoice == 1)
		{
			
			fAccountDetails = new File(accountDetailPath);
			fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
			propAccountDetails = new Properties();
			propAccountDetails.load(fisAccountDetails);
			
			
			fBalanceDetails = new File(balanceDetailsPath);
			fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
			propBalanceDetails = new Properties();
			propBalanceDetails.load(fisBalanceDetails);
			
			
			if(AccountType.equals("SAVING"))
			{
				savingBalAmount = propBalanceDetails.getProperty("11111111_saving_balance");	
				int savAmt = Integer.parseInt(savingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = savAmt-10000;
				
				if(amtlimit>0)
				{
					
					outToClient.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String WDAmount = brDepAmount.readLine();
					
					int WithDrawlAmount = Integer.parseInt(WDAmount);
					
					int chkLimit =0;
					chkLimit = savAmt-WithDrawlAmount;
					
					int totalAmount=0;
					if(chkLimit>10000 || chkLimit==10000)
					{
						totalAmount = savAmt-WithDrawlAmount;
						
						fisAccountDetails.close(); //Close the InputStream for AccountDetails File
						fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
							
						//Open the OutPutStream, After closing the InputStream
						fosBalanceDetails = new FileOutputStream(fBalanceDetails);
						
						outToClient.println("Balance of Alice in Saving Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("11111111_saving_balance", ""+totalAmount);

						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						outToClient.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
				}
				else if(amtlimit==0)
				{
					outToClient.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
				}
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("11111111_checking_balance");	
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = chkAmt-10000;
				
				if(amtlimit>0)
				{
					outToClient.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String WDAmount = brDepAmount.readLine();
					
					int WithDrawlAmount = Integer.parseInt(WDAmount);
					
					int chkLimit =0;
					chkLimit = chkAmt-WithDrawlAmount;
					
					int totalAmount=0;
					if(chkLimit>10000 || chkLimit==10000)
					{
						totalAmount = chkAmt-WithDrawlAmount;

						fisAccountDetails.close(); //Close the InputStream for AccountDetails File
						fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
						
						//Open the OutPutStream, After closing the InputStream
						fosBalanceDetails = new FileOutputStream(fBalanceDetails);
						
						outToClient.println("Balance of Alice in Checking Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("11111111_checking_balance", ""+totalAmount);
							
						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						outToClient.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
				}
				else if(amtlimit==0)
				{
					outToClient.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
				
			}
			else
			{
				outToClient.println("The Type of Account Does not Exist, Please check...!!!!!");
			}
			
		}
		
		
		else if(cusChoice == 0)
		{
			
			
			fAccountDetails = new File(accountDetailPath);
			fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
			propAccountDetails = new Properties();
			propAccountDetails.load(fisAccountDetails);
			
			
			fBalanceDetails = new File(balanceDetailsPath);
			fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
			propBalanceDetails = new Properties();
			propBalanceDetails.load(fisBalanceDetails);
			
			
			/*fTom = new File(tomPath);
			fisTom = new FileInputStream(fTom);
			propTom = new Properties();
			propTom.load(fisTom);*/
		
			if(AccountType.equals("SAVING"))
			{
				savingBalAmount = propBalanceDetails.getProperty("00000000_saving_balance");	
				int savAmt = Integer.parseInt(savingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = savAmt-10000;
				
				if(amtlimit>0)
				{
					outToClient.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String WDAmount = brDepAmount.readLine();
					
					int WithDrawlAmount = Integer.parseInt(WDAmount);
					
					int chkLimit =0;
					chkLimit = savAmt-WithDrawlAmount;
					
					int totalAmount=0;
					if(chkLimit>10000 || chkLimit==10000)
					{
						
						totalAmount = savAmt-WithDrawlAmount;

						fisAccountDetails.close(); //Close the InputStream for AccountDetails File
						fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
						
						//Open the OutPutStream, After closing the InputStream
						fosBalanceDetails = new FileOutputStream(fBalanceDetails);
							
						outToClient.println("Balance of Tom in Saving Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("00000000_saving_balance", ""+totalAmount);

						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						outToClient.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
					
				}
				else if(amtlimit==0)
				{
					outToClient.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
			
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("00000000_checking_balance");	
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				outToClient.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = chkAmt-10000;
				
				if(amtlimit>0)
				{
					outToClient.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String WDAmount = brDepAmount.readLine();
					
					int WithDrawlAmount = Integer.parseInt(WDAmount);
					
					int chkLimit =0;
					chkLimit = chkAmt-WithDrawlAmount;
					
					int totalAmount=0;
					if(chkLimit>10000 || chkLimit==10000)
					{
						 totalAmount = chkAmt-WithDrawlAmount;
						 
						 fisAccountDetails.close(); //Close the InputStream for AccountDetails File
						 fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
							
						 //Open the OutPutStream, After closing the InputStream
						 fosBalanceDetails = new FileOutputStream(fBalanceDetails);
						 
						 outToClient.println("Balance of Tom in Checking Account after Withdrawl is : $" + totalAmount);
						 propBalanceDetails.setProperty("00000000_checking_balance", ""+totalAmount);
							
						 propBalanceDetails.store(fosBalanceDetails, null);
						 fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						outToClient.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
					
				}
				else if(amtlimit==0)
				{
					outToClient.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
			}
			else
			{
				outToClient.println("The Type of Account Does not Exist, Please check...!!!!!");
			}
		}
	}
	
	
	@SuppressWarnings("hiding")
	public void run() 
	{
		System.out.println("In the run of ServerHandler");
		
		ServerHandler1 sh1 = new ServerHandler1();
		
		String accountDetailPath,balanceDetailsPath;
		
		accountDetailPath = ".\\AllTextFiles\\Account_Details.properties";
		balanceDetailsPath = ".\\AllTextFiles\\BalanceDetails.properties";
		
		@SuppressWarnings("unused")
		String cus_name,card_no,atm_pin;
		
		File fAccountDetails,fBalanceDetails;
		FileInputStream fisAccountDetails=null, fisBalanceDetails=null;//InputStream Declaration
		Properties propAccountDetails,propBalanceDetails;
		
		BufferedReader inFromClient = null;
		PrintWriter outToClient = null;
		try
		{
			inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
			outToClient = new PrintWriter(s.getOutputStream(),true);
		}
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{	
			while(true)
			{
				
				fAccountDetails = new File(accountDetailPath);
				fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
				propAccountDetails = new Properties();
				propAccountDetails.load(fisAccountDetails);
				
				fBalanceDetails = new File(balanceDetailsPath);
				fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
				propBalanceDetails = new Properties();
				propBalanceDetails.load(fisBalanceDetails);
				//System.out.println();
				
				System.out.println("===========================Welcome to ATM ========================================");
				System.out.println("\t0. Quit");
				System.out.println("\t1. Deposit Amount");
				System.out.println("\t2. WithDraw Amount");
				System.out.println("===================================================================================");
				
				outToClient.println("===========================Welcome to ATM ========================================");
				outToClient.println("\t0. Quit");
				outToClient.println("\t1. Deposit Amount");
				outToClient.println("\t2. WithDraw Amount");
				outToClient.println("===================================================================================");
				
				outToClient.println("Please Enter your choice : ");
				
				System.out.println("Check -- Before Readline from client..!!!");
				String choice = inFromClient.readLine();
				
				//this is for Deposit of Money
				
				if(choice.equals("1"))
				{
					outToClient.println("Please Enter your Card Number : ");
					
					String cardNumber =  inFromClient.readLine();
					
					if(cardNumber.equals("11111111"))
					{
						cus_name = propAccountDetails.getProperty("11111111_customer_name");
						card_no = propAccountDetails.getProperty("11111111_card_number");
						atm_pin = propAccountDetails.getProperty("11111111_atm_pin");
					
						outToClient.println("Dear "+cus_name+" Please Enter your PIN : ");
						BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(s.getInputStream()));
						String pinNumber = brAtmPin.readLine();
						
						if(pinNumber.equals(atm_pin))
						{
							sh1.depositMoney(1);
						}
						else
						{
							outToClient.println("The Pin You Have Entered is incorrect..!!!");
						}
						
					}
					else if(cardNumber.equals("00000000"))
					{
						cus_name = propAccountDetails.getProperty("00000000_customer_name");
						card_no = propAccountDetails.getProperty("00000000_card_number");
						atm_pin = propAccountDetails.getProperty("00000000_atm_pin");
					
						outToClient.println("Dear "+cus_name+" Please Enter your PIN : ");
						BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(s.getInputStream()));
						String pinNumber = brAtmPin.readLine();
						
						if(pinNumber.equals(atm_pin))
						{
							sh1.depositMoney(0);
						}
						else
						{
							outToClient.println("The Pin You Have Entered is incorrect..!!!");
						}
					}
					else
					{
						outToClient.println("Not a Valid Account Number, Please check your Account Number and Try Again...!!!");
					}
				
				}
				/*
				 * this is the testing one....
				 * if(choice.equals("0"))
					{
						outToClient.println("Server : You chose to Exit..!!!");
						outToClient.println("");
					}
				 	else if(choice.equals("1"))
					{
						outToClient.println("Server : You chose to Deposit..!!!");
						outToClient.println("");
						System.out.println("Server : You chose to Deposit..!!!");
					}
					else if(choice.equals("2"))
					{
						outToClient.println("Server : You chose to Withdraw..!!!");
						outToClient.println("");
						System.out.println("Server : You chose to Withdraw..!!!");
					}
					else 
					{
						outToClient.println("Server : You chose a invalid choice..!!!");
						outToClient.println("");	
						System.out.println("Server : You chose a invalid choice..!!!");
					}
				 * */
				
				//this is for WithDrawl of Money
				
				else if(choice.equals("2"))
				{
					outToClient.println("Please Enter your Card Number : ");
					BufferedReader brCardNumber = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String cardNumber = brCardNumber.readLine();
					
					if(cardNumber.equals("11111111"))
					{
						cus_name = propAccountDetails.getProperty("11111111_customer_name");
						card_no = propAccountDetails.getProperty("11111111_card_number");
						atm_pin = propAccountDetails.getProperty("11111111_atm_pin");
					
						outToClient.println("Dear "+cus_name+" Please Enter your PIN : ");
						BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(s.getInputStream()));
						String pinNumber = brAtmPin.readLine();
						
						if(pinNumber.equals(atm_pin))
						{
							sh1.withdrawMoney(1);
						}
						else
						{
							outToClient.println("The Pin You Have Entered is incorrect..!!!");
						}
						
					}
					else if(cardNumber.equals("00000000"))
					{
						cus_name = propAccountDetails.getProperty("00000000_customer_name");
						card_no = propAccountDetails.getProperty("00000000_card_number");
						atm_pin = propAccountDetails.getProperty("00000000_atm_pin");
					
						outToClient.println("Dear "+cus_name+" Please Enter your PIN : ");
						BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(s.getInputStream()));
						String pinNumber = brAtmPin.readLine();
						
						if(pinNumber.equals(atm_pin))
						{
							sh1.withdrawMoney(0);
						}
						else
						{
							outToClient.println("The Pin You Have Entered is incorrect..!!!");
						}
					}
					else
					{
						outToClient.println("Not a Valid Account Number, Please check your Account Number and Try Again...!!!");
						
					}
					
				}	
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		outToClient.close();
		try
		{
			inFromClient.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	

}
