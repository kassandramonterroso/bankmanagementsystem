package service;

import Exception.CreateUserException;
import Exception.UserValidationException;
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
	public UserAccountPojo createUser(UserAccountPojo userAccountPojo) throws CreateUserException {	
		return userDao.createUser(userAccountPojo);
	}

	@Override
	public UserAccountPojo validateUser(UserAccountPojo userAccountPojo) throws UserValidationException {
		return userDao.validateUser(userAccountPojo);
	}

}
