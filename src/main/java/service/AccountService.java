package service;

import model.AccountsPojo;

public interface AccountService {

	//Method to create bank account
	AccountsPojo addAccount(AccountsPojo accountsPojo);
		
	//Method to view balance
	double viewBalance(AccountsPojo accountsPojo);
		
	//Method to withdraw money from account
	double withdraw(AccountsPojo accountsPojo, double withdrawlAmount);
		
	//Method to deposit money to account
	double deposit(AccountsPojo accountsPojo, double depositAmount);
}
