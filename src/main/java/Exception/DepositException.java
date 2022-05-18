package Exception;

public class DepositException extends Exception {

	@Override
	public String getMessage() {
		return "Deposit error. Unable to deposit amount.";
	}

	
	
}
