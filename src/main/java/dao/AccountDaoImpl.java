package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountsPojo;

public class AccountDaoImpl implements AccountDao{

	@Override
	public AccountsPojo addAccount(AccountsPojo accountsPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "INSERT INTO account_details(balance, is_active) VALUES(0.0, TRUE) WHERE user_id="+accountsPojo.getUserId();                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo;
	}

	@Override
	public double viewBalance(AccountsPojo accountsPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE user_id="+accountsPojo.getUserId();                                                        
			ResultSet resultSet = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo.getBalance();
	}

	@Override
	public double withdraw(AccountsPojo accountsPojo, double withdrawlAmount) {
		double currentBalance = accountsPojo.getBalance();
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "UPDATE account_details SET balance="+ (currentBalance - withdrawlAmount) + "WHERE user_id="+accountsPojo.getUserId();                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo.getBalance();
	}

	@Override
	public double deposit(AccountsPojo accountsPojo, double depositAmount) {
		double currentBalance = accountsPojo.getBalance();
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "UPDATE account_details SET balance"+ (currentBalance + depositAmount) + "WHERE user_id="+accountsPojo.getUserId();                                                        
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountsPojo.getBalance();
	}

}
