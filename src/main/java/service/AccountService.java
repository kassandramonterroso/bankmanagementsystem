package service;

import Exception.DepositException;
import Exception.WithdrawlException;
import model.AccountsPojo;

public interface AccountService {

	//Method to view balance
	AccountsPojo viewBalance(AccountsPojo accountsPojo);
		
	//Method to withdraw money from account
	AccountsPojo withdraw(AccountsPojo accountsPojo) throws WithdrawlException;
		
	//Method to deposit money to account
	AccountsPojo deposit(AccountsPojo accountsPojo) throws DepositException;
}
