package service;

import model.UserAccountPojo;

public interface UserService {

	//Method to create a user account
	UserAccountPojo createUser(UserAccountPojo userAccountPojo);
		
	//Method to validate login
	UserAccountPojo validateUser(UserAccountPojo userAccountPojo);
}
