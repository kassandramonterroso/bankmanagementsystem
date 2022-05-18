package Exception;

public class CreateUserException extends Exception{

	@Override
	public String getMessage() {
		return "Unable to create user account";
	}
	
	

}
