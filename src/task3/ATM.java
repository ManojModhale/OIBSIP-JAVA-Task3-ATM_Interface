package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM
{
	Scanner sc=new Scanner(System.in);
	List<BankAccount> acc;
	public ATM() 
	{
		super();
		// TODO Auto-generated constructor stub
		BankAccount account1=new BankAccount(2010110, "Gaurav", "Patil", "1234", 1500);
		BankAccount account2=new BankAccount(2010169, "Anshul", "Khambe", "4321", 2000);
		BankAccount account3=new BankAccount(2010145, "Ganesh", "Pansare", "9513", 3000);
		BankAccount account4=new BankAccount(2010127, "Rohit", "Shinde", "7531", 500);
		BankAccount account5=new BankAccount(2010181, "Hrishikesh", "Nandgaokar", "9876", 1200);
		acc=new ArrayList<BankAccount>();
		acc.add(account1);
		acc.add(account2);
		acc.add(account3);
		acc.add(account4);
		acc.add(account5);
	}
	
	public int getAccNumber(String firstName,String lastName)
	{
		int acNumber=0;
		for (BankAccount user_account : acc) 
		{
			if((firstName.equals(user_account.getFirstName())) && (lastName.equals(user_account.getLastName())) )
			{
				acNumber=user_account.getAccNo();
				break;
			}
		}
		return acNumber;
	}
	public String getPinNo(int acNumber,String firstName,String lastName)
	{
		String pinNo = null;
		for(BankAccount user_account:acc)
		{
			if((acNumber==user_account.getAccNo()) && (firstName.equals(user_account.getFirstName())) && 
					(lastName.equals(user_account.getLastName())))
			{
				pinNo=user_account.getPin();
				break;
			}
		}
		return pinNo;
	}
	
	public void start()
	{
		//login 
		System.out.println("Welcome to ATM Interface");
		System.out.println("First You Have to Login to proceed with your transactions");
		BankAccount currentUser=login();
		
		if(currentUser!=null)
		{
			int choice;
			do
			{	System.out.println();			
				System.out.println("1.Access Account Number\t 2.Display Balance");
				System.out.println("3.Withdraw\t 4.Deposit");
				System.out.println("5.Transfer\t 6.Transaction History");
				System.out.println("7.Exit");
				
				System.out.println("Enter your Choice : ");
				choice=sc.nextInt();
				switch(choice)
				{
					case 1:
					{
						System.out.println("To Access Account Number, you have to Enter Firstname & Lastname ");
						System.out.println("Enter Firstname : ");
						String firstName=sc.next();
						System.out.println("Enter LastName : ");
						String lastName=sc.next();
						int accNo=getAccNumber(firstName, lastName);
						System.out.println("The Account Number is "+accNo);
						break;
					}
					case 2:
					{
						displayBalance(currentUser);
						break;
					}
					case 3:
					{
						withdrawAmount(currentUser);
						break;
					}
					case 4:
					{
						depositAmount(currentUser);
						break;
					}
					case 5:
					{
						transfer(currentUser);
						break;
					}
					case 6:
					{
						transactionHistory(currentUser);
						break;
					}
					case 7:
					{
						System.out.println("Exiting from ATM App.");
						System.exit(0);
					}
					default:
					{
						System.out.println("Invalid Choice...");
					}
				}
				
			}while(choice!=8);
			
		}
		else
		{
			System.out.println("Login Failed.");
			int option;
			do
			{
				System.out.println("If you have not remember Credentials.");
				System.out.println("To access Credentials, Enter 1.Access Account Number\t 2.Access Account Pin\t 3.Login again");
				option=sc.nextInt();
				switch (option) 
				{
	            case 1:
	                // Retrieve Account Number logic
	            	System.out.println("To Access Account Number, you have to Enter Firstname & Lastname ");
					System.out.println("Enter Firstname : ");
					String firstName1=sc.next();
					System.out.println("Enter LastName : ");
					String lastName1=sc.next();
					int accNo1=getAccNumber(firstName1, lastName1);
					System.out.println("The Account Number is "+accNo1);
	                break;
	            case 2:
	                // Retrieve Account Pin logic
	            	System.out.println("To Access Account Pin, you have to Enter AccountNo , Firstname , Lastname ");
					System.out.println("Enter Account Number : ");
					int acNumber=sc.nextInt();
					System.out.println("Enter Firstname : ");
					String firstName=sc.next();
					System.out.println("Enter LastName : ");
					String lastName=sc.next();
					String pinNo=getPinNo(acNumber, firstName, lastName);
					System.out.println("The Account Pin is "+pinNo);
	                break;
	            case 3:
	            	System.out.println("Do you want to Login again.");
	            	start();
	            	break;
	            default:
	                System.out.println("Invalid option. Exiting from ATM App.");
				}
			}while(option!=4);			
		}
	}
	
	public BankAccount login()
	{
		BankAccount currentUser = null;
		System.out.println("Enter AccNo : ");
		int accNo=sc.nextInt();
		System.out.println("Enter Pin : ");
		String pinNo=sc.next();
		
		for (BankAccount user_account : acc) 
		{
			if((accNo==user_account.getAccNo()) && (pinNo.equals(user_account.getPin())) )
			{
				System.out.println("Login Successfully. Welcome '"+user_account.getFirstName()+" "
												+user_account.getLastName()+"'");
				currentUser=user_account;
				break;
			}
		}
		
		if(currentUser==null)
		{
			System.out.println("Invalid Login Credentials");
		}
		
		return currentUser;
	}
	
	public void withdrawAmount(BankAccount currentUser)
	{
		System.out.println("Enter amount to be Withdraw : ");
		double amount=sc.nextDouble();
		currentUser.withdraw(amount);
	}
	
	public void depositAmount(BankAccount currentUser)
	{
		System.out.println("Enter amount to be Deposit : ");
		double amount=sc.nextDouble();
		currentUser.deposit(amount);
	}
	
	public void displayBalance(BankAccount currentUser)
	{
		System.out.println("Dear "+currentUser.getFirstName()+" "+currentUser.getLastName()+" "
				+ "your current Balance is '"+currentUser.getBalance()+"'");
	}
	
	public void transfer(BankAccount currentUser)
	{
		BankAccount recipient=null;
		System.out.println("Enter Recipient's Account Number : ");
		int acNumber=sc.nextInt();
		for (BankAccount user_account : acc) 
		{
			if( (acNumber==user_account.getAccNo()) )
			{
				recipient=user_account;
				break;
			}
		}
		
		if(recipient!=null)
		{
			System.out.println("Enter Amount to be Transfer to Recipient : ");
			double amount=sc.nextDouble();
			currentUser.transfer(recipient, currentUser, amount);		
		}
		else
		{
			System.out.println("Recipient not found.");
		}
	}
	public void transactionHistory(BankAccount currentUser)
	{
		List<Transaction> transactionss=currentUser.getTransactions();
		System.out.println("Transaction History for "+currentUser.getFirstName()+" "+currentUser.getLastName()+" = ");
		
		for (Transaction transaction : transactionss) 
		{
			System.out.println(transaction.getTransactionName()+" of Rs."+transaction.getAmount());
		}
		
	}
	
	
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		ATM atm=new ATM();
		atm.start();
		
		sc.close();
	}

}
