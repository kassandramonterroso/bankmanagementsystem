package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.UserAccountPojo;

public class UserDaoImpl implements UserDao {

	@Override
	public UserAccountPojo createUser(UserAccountPojo userAccountPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "INSERT INTO user_login(username, password, first_name, last_name) VALUES('"+UserAccountPojo.getUsername()+"', '"+UserAccountPojo.getPassword()+"', '"+UserAccountPojo.getFirstName()+"', '"+UserAccountPojo.getLastName()+"')";                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userAccountPojo;
	}

	@Override
	public UserAccountPojo validateUser(UserAccountPojo userAccountPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT username, password FROM user_login WHERE user_Id="+userAccountPojo.getUserId();                                                        
			ResultSet resultSet = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userAccountPojo;
		
		
	}

}
