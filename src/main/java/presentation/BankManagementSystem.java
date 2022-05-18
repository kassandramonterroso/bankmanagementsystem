package presentation;

import java.util.Scanner;

import Exception.CreateUserException;
import Exception.DepositException;
import Exception.UserValidationException;
import Exception.WithdrawlException;
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
			try {
				userAccountPojo = userService.createUser(newUser);
			} catch (CreateUserException e1) {
				System.out.println(e1.getMessage());
			}
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
			try {
				validatePojo = userService.validateUser(newUser);
			} catch (UserValidationException e) {
				System.out.println(e.getMessage());
			}
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
				newAccount.setUserId(newUser.getUserId());
				Double withdrawAmount = input.nextDouble();
				Double currentBal = newAccount.getBalance();
				if(currentBal >= withdrawAmount) {
					newAccount.setBalance(currentBal - withdrawAmount);
					try {
						accountService.withdraw(newAccount);
					} catch (WithdrawlException e) {
						System.out.println(e.getMessage());
					}
					System.out.println(withdrawAmount + " withdrawn from account");
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
				Double currentBalance = newAccount.getBalance();
				double newBalance = currentBalance + depositAmount;
				newAccount.setUserId(newUser.getUserId());
				newAccount.setBalance(newBalance);	
			try {
				accountService.deposit(newAccount);
			} catch (DepositException e) {
				System.out.println(e.getMessage());
			}
				System.out.println(depositAmount + " deposited to your account");
				System.out.println("Returning to accounts menu...             ");
				System.out.println("                                          ");
				accountsMenu();
				break;
			case 3:
				//fetch balance from account_details
				newAccount.setUserId(newUser.getUserId());
				accountService.viewBalance(newAccount);
				System.out.println("Your current balance is "+ newAccount.getBalance() );
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

