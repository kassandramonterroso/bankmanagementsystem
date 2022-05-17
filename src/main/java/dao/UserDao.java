package dao;

import model.UserAccountPojo;

public interface UserDao {
	
	//Method to create a user account
	UserAccountPojo createUser(UserAccountPojo userAccountPojo);
		
	//Method to validate login
	UserAccountPojo validateUser(UserAccountPojo userAccountPojo);
		

}
