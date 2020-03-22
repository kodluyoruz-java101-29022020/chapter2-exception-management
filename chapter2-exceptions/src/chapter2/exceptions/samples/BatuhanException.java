package chapter2.exceptions.samples;

public class BatuhanException extends Exception {

	private String message;
	
	public BatuhanException(String message) {
		this.message = message;
	}
	
}
