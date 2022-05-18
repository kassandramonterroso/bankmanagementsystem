package presentation;

import java.util.Scanner;

import model.UserAccountPojo;
import model.AccountsPojo;
import service.UserService;
import service.UserServiceImpl;
import service.AccountService;
import service.AccountServiceImpl;



public class BankManagementSystem {
	
//Creating a scanner object for user input
		static Scanner input = new Scanner(System.in);
		
//Creating static objects
		static UserAccountPojo newUser = new UserAccountPojo();
		static AccountsPojo newAccount = new AccountsPojo();
		static AccountService accountService = new AccountServiceImpl();
		static UserService userService = new UserServiceImpl();
	

//Creating menu methods to be called on after user input
	protected static void mainMenu() {
		System.out.println("_________________________________");
		System.out.println("      Bank Management System     ");
		System.out.println("               ...               ");
		System.out.println("____________Main Menu____________");
		System.out.println("                                 ");
		System.out.println("Options:                         ");
		System.out.println("        (1) Create new user      ");
		System.out.println("        (2) Login to account     ");
		System.out.println("        (3) Exit                 ");
		System.out.println("                                 ");
		System.out.println("Please select an option:         ");
		mainMenuSwitch();
	}
	
	protected static void accountsMenu() {
		System.out.println("__________Accounts Menu__________");
		System.out.println("                                 ");
		System.out.println("Options:                         ");
		System.out.println("        (1) Withdraw from account");
		System.out.println("        (2) Deposit to account   ");
		System.out.println("        (3) View balance         ");
		System.out.println("        (4) Exit Accounts Menu   ");
		System.out.println("                                 ");
		System.out.println("Please select an option:         ");
		accountsMenuSwitch();
	}
	
	
	//Creating a main menu switch statement
	protected static void mainMenuSwitch() {
		int option = input.nextInt();
		switch(option) {
			case 1:
				//Contact service layer to create a new user
				System.out.println("Please enter first name:     ");
				System.out.println("                             ");
				input.nextLine();
				System.out.println("                             ");
				newUser.setFirstName(input.nextLine());
				System.out.println("                             ");
				System.out.println("Please enter last name:      ");
				String lastName = input.nextLine();
				System.out.println("                             ");
				newUser.setLastName(lastName);
				System.out.println("Please enter a username:     ");
				System.out.println("                             ");
				String user = input.nextLine(); 
				System.out.println("                             ");
				newUser.setUsername(user);
				System.out.println("Please enter a password:     ");
				System.out.println("                             ");
				String pass = input.nextLine();
				newUser.setPassword(pass);
				UserAccountPojo userAccountPojo = null;
				userAccountPojo = userService.createUser(newUser);
				System.out.println("Account successfully created!");
				System.out.println("                             ");
				System.out.println("Returning to main menu...    ");
				System.out.println("                             ");
				mainMenu();
				break;
			case 2:
				System.out.println("Username:                ");
				input.nextLine();
				newUser.setUsername(input.nextLine());
				System.out.println("                         ");
				System.out.println("Password:                ");
				newUser.setPassword(input.nextLine());
				System.out.println("                         ");
				UserAccountPojo validatePojo = null;
				validatePojo = userService.validateUser(newUser);
				if(validatePojo.getUserId() != 0) {
					System.out.println("Login successful!        ");
					System.out.println("                         ");
					accountsMenu();
					break;
				}else {
					System.out.println("Login unsuccessful...    ");
					System.out.println("                         ");
					System.out.println("Returning to main menu...");
					System.out.println("                         ");
					mainMenu();
					break;
				}
			case 3:
				System.out.println("Thank you for using Bank Management System!");
				System.out.println("Hope to see you soon!                      ");
				System.exit(0);
			default:
				System.out.println("Please select a valid option.              ");
				System.out.println("                                           ");
				mainMenuSwitch();
				break;
		}
	}

	
	
	//Creating an accounts menu switch statement
	protected static void accountsMenuSwitch() {
		int option = input.nextInt();
		switch(option) {
			case 1:
				//withdraw from account, no overdraft
				System.out.println("Please enter an amount to withdraw:      ");
				Double withdrawAmount = input.nextDouble();
				if(withdrawAmount <= newAccount.getBalance()) {
					accountService.withdraw(newAccount, withdrawAmount);
					System.out.println(withdrawAmount + " withdrawed from account");
					System.out.println("Returning to accounts menu...            ");
					System.out.println("                                         ");
					accountsMenu();
					break;
				} else {
					System.out.println("Insufficient funds!                      ");
					System.out.println("Returning to accounts menu...            ");
					System.out.println("                                         ");
					accountsMenu();
				}
				break;		
			case 2:
				//deposit to account
				System.out.println("Please enter an amount to deposit:        ");
				Double depositAmount = input.nextDouble();
				accountService.deposit(newAccount, depositAmount);
				System.out.println(depositAmount + " deposited to your account");
				System.out.println("Returning to accounts menu...             ");
				System.out.println("                                          ");
				accountsMenu();
				break;
			case 3:
				//fetch balance from account_details
				System.out.println("Your current balance is " + accountService.viewBalance(newAccount));
				System.out.println("Returning to accounts menu...     ");
				System.out.println("                                  ");
				accountsMenu();
				break;
			case 4:
				System.out.println("Returning to main menu...    ");
				System.out.println("                             ");
				mainMenu();
				break;
			default:
				System.out.println("Please select a valid option.             ");
				accountsMenuSwitch();
				break;
		}
		
	}
	
	
	public static void main(String[] args) {
		//Call main menu method to start program
		mainMenu(); 
		
	
	
	
		

	}

}

