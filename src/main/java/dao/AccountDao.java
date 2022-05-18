package dao;

import model.AccountsPojo;

public interface AccountDao {
		
	//Method to view balance
	AccountsPojo viewBalance(AccountsPojo accountsPojo);
		
	//Method to withdraw money from account
	AccountsPojo withdraw(AccountsPojo accountsPojo, double withdrawlAmount);
		
	//Method to deposit money to account
	AccountsPojo deposit(AccountsPojo accountsPojo, double depositAmount);
}
