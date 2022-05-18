package service;

import Exception.CreateUserException;
import Exception.UserValidationException;
import model.UserAccountPojo;

public interface UserService {

	//Method to create a user account
	UserAccountPojo createUser(UserAccountPojo userAccountPojo) throws CreateUserException;
		
	//Method to validate login
	UserAccountPojo validateUser(UserAccountPojo userAccountPojo) throws UserValidationException;
}
