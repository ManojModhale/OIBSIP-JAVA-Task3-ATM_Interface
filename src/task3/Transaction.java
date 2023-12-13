package task3;

public class Transaction 
{
	private String transactionName;
	private double amount;
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionName, double amount) 
	{
		super();
		this.transactionName = transactionName;
		this.amount = amount;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction [transactionName=" + transactionName + ", amount=" + amount + "]";
	}

}
