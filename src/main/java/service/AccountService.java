package service;

import model.AccountsPojo;

public interface AccountService {

	//Method to view balance
	AccountsPojo viewBalance(AccountsPojo accountsPojo);
		
	//Method to withdraw money from account
	AccountsPojo withdraw(AccountsPojo accountsPojo);
		
	//Method to deposit money to account
	AccountsPojo deposit(AccountsPojo accountsPojo);
}
