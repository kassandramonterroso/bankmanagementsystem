package model;

public class AccountsPojo {
//Creating and encapsulating accounts variables
	int userId;
	int accountId;
	double balance;
	boolean isActive;
	
	//Creating a parameterized constructor
	public AccountsPojo(int userId, int accountId, double balance, boolean isActive) {
		super();
		this.userId = userId;
		this.accountId = accountId;
		this.balance = balance;
		this.isActive = isActive;
	}
	
	public AccountsPojo() {
	}

	//Creating public getter and setter methods
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	

}
