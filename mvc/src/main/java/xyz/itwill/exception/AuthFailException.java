package xyz.itwill.exception;

public class AuthFailException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthFailException(String message) {
		super(message);
	}
}
