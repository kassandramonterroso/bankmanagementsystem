package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountsPojo;

public class AccountDaoImpl implements AccountDao{

	@Override
	public AccountsPojo viewBalance(AccountsPojo accountsPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE user_id="+accountsPojo.getUserId();                                                        
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			accountsPojo.setBalance(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo;
	}

	@Override
	public AccountsPojo withdraw(AccountsPojo accountsPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "UPDATE account_details SET balance="+accountsPojo.getBalance()+ "WHERE user_id="+accountsPojo.getUserId();                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo;
	}

	@Override
	public AccountsPojo deposit(AccountsPojo accountsPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "UPDATE account_details SET balance="+accountsPojo.getBalance()+ "WHERE user_id="+accountsPojo.getUserId();                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo;
	}

}
