package model;

public class UserAccountPojo {
//Creating and encapsulating variables for a user account
	private int userId;
	private static String username;
	private static String password;
	private static String firstName;
	private static String lastName;
	
	//Creating a parameterized constructor
	public UserAccountPojo(int userId, String username, String password, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName; 
	}
	
	
	public UserAccountPojo() {
	}


	//Creating public getter and setter methods
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
