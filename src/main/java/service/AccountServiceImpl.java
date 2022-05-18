package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.UserDao;
import model.AccountsPojo;

public class AccountServiceImpl implements AccountService {

	//Creating AccountDaoImpl to call Dao layer from service layer
	AccountDao accountDao;
	
	public AccountServiceImpl() {
		accountDao = new AccountDaoImpl();
	}
	
	@Override
	public AccountsPojo viewBalance(AccountsPojo accountsPojo) {
		return accountDao.viewBalance(accountsPojo);
	}

	@Override
	public AccountsPojo withdraw(AccountsPojo accountsPojo, double withdrawlAmount) {
		return accountDao.withdraw(accountsPojo, withdrawlAmount);
	}

	@Override
	public AccountsPojo deposit(AccountsPojo accountsPojo, double depositAmount) {
		return accountDao.deposit(accountsPojo, depositAmount);
	}

}
