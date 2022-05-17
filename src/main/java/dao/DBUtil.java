package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtil {

	static Connection connect;
	
	static {
		try {
			//Load the driver into the memory
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	static Connection dbConnection() throws SQLException {
		//Create a single connection to the database
		String ConnectionUrl = "jdbc:postgresql://localhost:5432/bankmanagementdb";
		String userName = "postgres";
		String passWord = "309758944Kk";
		
		if(connect == null){
			connect = DriverManager.getConnection(ConnectionUrl, userName, passWord);
		} return connect;
	}
	
	

	
}
