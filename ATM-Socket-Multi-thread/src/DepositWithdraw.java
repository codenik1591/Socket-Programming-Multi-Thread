import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class DepositWithdraw 
{
	//String alicePath, tomPath;
	String accountDetailPath,balanceDetailsPath;
	
	public DepositWithdraw() 
	{
		
		accountDetailPath = ".\\AllTextFiles\\Account_Details.properties";
		balanceDetailsPath = ".\\AllTextFiles\\BalanceDetails.properties";
		
	}
	
	public void depositMoney(int cusChoice) throws IOException
	{
		
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
		
		
		
		System.out.println("Please Enter Your Account Type(saving/checking) : ");
		BufferedReader brAccountType = new BufferedReader(new InputStreamReader(System.in));
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
				
				System.out.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				System.out.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				
				int totalAmount = depositAmount+savAmt;
				
				fisAccountDetails.close(); //Close the InputStream for AccountDetails File
				fisBalanceDetails.close(); //Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				System.out.println("Balance of Alice in Saving Account is : $" + totalAmount);
				
				propBalanceDetails.setProperty("11111111_saving_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				checkingBalAmount = propBalanceDetails.getProperty("11111111_checking_balance");
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				System.out.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				System.out.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+chkAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				System.out.println(" Balance of Alice in Checking Account is : $" + totalAmount);
				propBalanceDetails.setProperty("11111111_checking_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
					
			}
			
			else 
			{
				System.out.println("The Type of Account Does not Exist, Please check...!!!!!");
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
				
				System.out.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				System.out.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+savAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				System.out.println(" Balance of Tom in Saving Account is : $" + totalAmount);
				propBalanceDetails.setProperty("00000000_saving_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("00000000_checking_balance");
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				System.out.println("Dear "+name+", you have $"+chkAmt+"in your Saving Account.");
				
				System.out.println("Please Enter The Amount to Deposit : $");
				BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
				String depAmount = brDepAmount.readLine();
				int depositAmount = Integer.parseInt(depAmount);
				
				int totalAmount = depositAmount+chkAmt;
				
				fisAccountDetails.close();//Close the InputStream for AccountDetails File
				fisBalanceDetails.close();//Close the InputStream for BalanceDetails File
				
				//Open the OutPutStream, After closing the InputStream
				fosBalanceDetails = new FileOutputStream(fBalanceDetails);
				
				System.out.println(" Balance of Tom in Checking Account is : $" + totalAmount);
				propBalanceDetails.setProperty("00000000_checking_balance", ""+totalAmount);
				
				propBalanceDetails.store(fosBalanceDetails, null);
				fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
				
			}
		
		}
		
	}
	
	public void withdrawMoney(int cusChoice) throws IOException
	{
		
		File fAccountDetails,fBalanceDetails;
		FileInputStream fisAccountDetails=null, fisBalanceDetails=null;//InputStream Declaration
		@SuppressWarnings("unused")
		FileOutputStream fosAccountDetails = null,fosBalanceDetails = null;//OutputStram Declaration
		Properties propAccountDetails,propBalanceDetails;
		
		String savingBalAmount="",checkingBalAmount="";
		
		System.out.println("Pleasse Enter Your Account Type(saving/checking) : $");
		BufferedReader brAccountType = new BufferedReader(new InputStreamReader(System.in));
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
				
				System.out.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = savAmt-10000;
				
				if(amtlimit>0)
				{
					
					System.out.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
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
						
						System.out.println("Balance of Alice in Saving Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("11111111_saving_balance", ""+totalAmount);

						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						System.out.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
				}
				else if(amtlimit==0)
				{
					System.out.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
				}
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("11111111_checking_balance");	
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("11111111_customer_name");
				
				System.out.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = chkAmt-10000;
				
				if(amtlimit>0)
				{
					System.out.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
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
						
						System.out.println("Balance of Alice in Checking Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("11111111_checking_balance", ""+totalAmount);
							
						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						System.out.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
				}
				else if(amtlimit==0)
				{
					System.out.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
				
			}
			else
			{
				System.out.println("The Type of Account Does not Exist, Please check...!!!!!");
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
				
				System.out.println("Dear "+name+", you have $"+savAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = savAmt-10000;
				
				if(amtlimit>0)
				{
					System.out.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
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
							
						System.out.println("Balance of Tom in Saving Account after Withdrawl is : $" + totalAmount);
						propBalanceDetails.setProperty("00000000_saving_balance", ""+totalAmount);

						propBalanceDetails.store(fosBalanceDetails, null);
						fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						System.out.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
					
				}
				else if(amtlimit==0)
				{
					System.out.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
			
			}
			
			else if(AccountType.equals("CHECKING"))
			{
				
				checkingBalAmount = propBalanceDetails.getProperty("00000000_checking_balance");	
				int chkAmt = Integer.parseInt(checkingBalAmount);
				
				String name = propAccountDetails.getProperty("00000000_customer_name");
				
				System.out.println("Dear "+name+", you have $"+chkAmt+" in your Saving Account.");
				
				int amtlimit = 0;
				amtlimit = chkAmt-10000;
				
				if(amtlimit>0)
				{
					System.out.println("Please Enter The Amount you Want to With Draw(Maximum=$"+amtlimit+") : $");
					BufferedReader brDepAmount = new BufferedReader(new InputStreamReader(System.in));
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
						 
						 System.out.println("Balance of Tom in Checking Account after Withdrawl is : $" + totalAmount);
						 propBalanceDetails.setProperty("00000000_checking_balance", ""+totalAmount);
							
						 propBalanceDetails.store(fosBalanceDetails, null);
						 fosBalanceDetails.close();//Close OutPutStream for BalanceDetail File
						
					}
					else
					{
						System.out.println("You can withdraw at max $"+amtlimit+" from your Account, so that balance should be more than $10000..!!! You cannot withdraw more....");
					}
					
				}
				else if(amtlimit==0)
				{
					System.out.println("Since you have reached your debit limit, you cannot withdraw more money..!!!!");
					
				}
				
			}
			else
			{
				System.out.println("The Type of Account Does not Exist, Please check...!!!!!");
			}
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		/*String alicePath = ".\\AllTextFiles\\AliceDetails.properties";
		String tomPath = ".\\AllTextFiles\\TomDetails.properties";*/
		
		String accountDetailPath,balanceDetailsPath;
		accountDetailPath = ".\\AllTextFiles\\Account_Details.properties";
		balanceDetailsPath = ".\\AllTextFiles\\BalanceDetails.properties";
		
		
		
		boolean flag = true;
		
		@SuppressWarnings("unused")
		String cus_name,card_no,atm_pin;
		BufferedReader brChoice;
		
		DepositWithdraw dw = new DepositWithdraw();
		

		File fAccountDetails,fBalanceDetails;
		FileInputStream fisAccountDetails=null, fisBalanceDetails=null;//InputStream Declaration
		Properties propAccountDetails,propBalanceDetails;
		
		
		/*
		File fAlice,fTom;
		FileInputStream fisAlice = null,fisTom=null;
		Properties propAlice,propTom;*/
		
		while(flag==true)
		{
			

			fAccountDetails = new File(accountDetailPath);
			fisAccountDetails = new FileInputStream(fAccountDetails);//InputStream for AccountDetails
			propAccountDetails = new Properties();
			propAccountDetails.load(fisAccountDetails);
			
			
			fBalanceDetails = new File(balanceDetailsPath);
			fisBalanceDetails = new FileInputStream(fBalanceDetails);//InputStream for BalanceDetails
			propBalanceDetails = new Properties();
			propBalanceDetails.load(fisBalanceDetails);
			
			
			System.out.println("===========================Welcome to ATM Demo ====================================");
			System.out.println("\t0. Quit");
			System.out.println("\t1. Deposit Amount");
			System.out.println("\t2. WithDraw Amount");
			System.out.println("===================================================================================");
			
			
			System.out.println("Pleasse Enter your choice : ");
			brChoice = new BufferedReader(new InputStreamReader(System.in));
			String choice = brChoice.readLine();
			
			if(choice.equals("0"))
			{
				System.out.println("Quitting the Application..!!!!");
				System.exit(0);
				
			}
			
			else if(choice.equals("1"))
			{
				System.out.println("Please Enter your Card Number : ");
				BufferedReader brCardNumber = new BufferedReader(new InputStreamReader(System.in));
				String cardNumber = brCardNumber.readLine();
				
				if(cardNumber.equals("11111111"))
				{
					cus_name = propAccountDetails.getProperty("11111111_customer_name");
					card_no = propAccountDetails.getProperty("11111111_card_number");
					atm_pin = propAccountDetails.getProperty("11111111_atm_pin");
				
					System.out.println("Dear "+cus_name+" Please Enter your PIN : ");
					BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(System.in));
					String pinNumber = brAtmPin.readLine();
					
					if(pinNumber.equals(atm_pin))
					{
						dw.depositMoney(1);
					}
					else
					{
						System.out.println("The Pin You Have Entered is incorrect..!!!");
					}
					
				}
				else if(cardNumber.equals("00000000"))
				{
					cus_name = propAccountDetails.getProperty("00000000_customer_name");
					card_no = propAccountDetails.getProperty("00000000_card_number");
					atm_pin = propAccountDetails.getProperty("00000000_atm_pin");
				
					System.out.println("Dear "+cus_name+" Please Enter your PIN : ");
					BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(System.in));
					String pinNumber = brAtmPin.readLine();
					
					if(pinNumber.equals(atm_pin))
					{
						dw.depositMoney(0);
					}
					else
					{
						System.out.println("The Pin You Have Entered is incorrect..!!!");
					}
					
				}
				else
				{
					System.out.println("Not a Valid Account Number, Please check your Account Number and Try Again...!!!");
				}
			
			}
			
			
			
			else if(choice.equals("2"))
			{
				System.out.println("Please Enter your Card Number : ");
				BufferedReader brCardNumber = new BufferedReader(new InputStreamReader(System.in));
				String cardNumber = brCardNumber.readLine();
				
				if(cardNumber.equals("11111111"))
				{
					cus_name = propAccountDetails.getProperty("11111111_customer_name");
					card_no = propAccountDetails.getProperty("11111111_card_number");
					atm_pin = propAccountDetails.getProperty("11111111_atm_pin");
				
					System.out.println("Dear "+cus_name+" Please Enter your PIN : ");
					BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(System.in));
					String pinNumber = brAtmPin.readLine();
					
					if(pinNumber.equals(atm_pin))
					{
						dw.withdrawMoney(1);
					}
					else
					{
						System.out.println("The Pin You Have Entered is incorrect..!!!");
					}
					
				}
				else if(cardNumber.equals("00000000"))
				{
					cus_name = propAccountDetails.getProperty("00000000_customer_name");
					card_no = propAccountDetails.getProperty("00000000_card_number");
					atm_pin = propAccountDetails.getProperty("00000000_atm_pin");
				
					System.out.println("Dear "+cus_name+" Please Enter your PIN : ");
					BufferedReader brAtmPin = new BufferedReader(new InputStreamReader(System.in));
					String pinNumber = brAtmPin.readLine();
					
					if(pinNumber.equals(atm_pin))
					{
						dw.withdrawMoney(0);
					}
					else
					{
						System.out.println("The Pin You Have Entered is incorrect..!!!");
					}
				}
				else
				{
					System.out.println("Not a Valid Account Number, Please check your Account Number and Try Again...!!!");
					
				}
				
			}
			
		}
		
		fisAccountDetails.close();
		fisBalanceDetails.close();

	}

}
