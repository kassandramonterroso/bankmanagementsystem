package Exception;

public class UserValidationException extends Exception {

	@Override
	public String getMessage() {
		return "Unable to validate login credentials";
	}

	
	
}
