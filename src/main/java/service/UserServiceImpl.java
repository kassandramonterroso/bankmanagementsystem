package service;

import dao.AccountDao;
import dao.AccountDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import model.UserAccountPojo;

public class UserServiceImpl implements UserService{

	//Creating UserDaoImpl to call Dao layer from service layer
	UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
		
	@Override
	public UserAccountPojo createUser(UserAccountPojo userAccountPojo) {	
		return userDao.createUser(userAccountPojo);
	}

	@Override
	public UserAccountPojo validateUser(UserAccountPojo userAccountPojo) {
		return userDao.validateUser(userAccountPojo);
	}

}
