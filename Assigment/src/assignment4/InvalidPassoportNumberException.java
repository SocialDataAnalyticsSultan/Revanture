package assignment4;

public class InvalidPassoportNumberException extends RuntimeException{

	public InvalidPassoportNumberException() {
		super();
	}
	
	public InvalidPassoportNumberException(final String message) {
		super(message);
	}

}
