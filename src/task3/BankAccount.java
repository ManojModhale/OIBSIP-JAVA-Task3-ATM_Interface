package task3;

import java.util.ArrayList;
import java.util.List;

public class BankAccount 
{
	private int accNo;
	private String firstName;
	private String lastName;
	private String pin;
	private double balance;
	private List<Transaction> transactions;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(int accNo, String firstName, String lastName, String pin, double balance) {
		super();
		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
		this.balance = balance;
		this.transactions = new ArrayList<>();
	}
	public int getAccNo() {
		return accNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPin() {
		return pin;
	}
	public double getBalance() {
		return balance;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	
	
	public boolean withdraw(double amount)
	{
		if(amount>0 && amount<=balance)
		{
			balance=balance-amount;
			transactions.add(new Transaction("Withdraw", amount));
			System.out.println("Rs."+amount+" Withdrawal Successfully.");
			return true;
		}
		else
		{
			System.out.println("Insufficient Balance.");
			return false;
		}
		
	}
	
	public void deposit(double amount)
	{
		if(amount>0)
		{
			balance=balance+amount;
			transactions.add(new Transaction("Deposit", amount));
			System.out.println("Rs."+amount+" Deposited Successfully.");
		}
		else
		{
			System.out.println("Invalid Deposit amount.");
		}
	}
	
	public void transfer(BankAccount recipient,BankAccount currentUser,double amount)
	{
		if(currentUser.withdraw(amount))
		{
			recipient.deposit(amount);
			transactions.add(new Transaction(("To "+recipient.getFirstName()+" "+recipient.getLastName()+"'s Account Transfer"), amount));
			System.out.println("Rs."+amount+" transfered to "+recipient.getFirstName()+"'s Account Successfully.");
		}
		else
		{
			System.out.println("Transfer Failed, Insufficient Balance.");
		}
	}

}
