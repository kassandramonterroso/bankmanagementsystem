package Exception;

public class WithdrawlException extends Exception {

	@Override
	public String getMessage() {
		return "Cannot withdraw amount greater than current balance";
	}

	
	
}
