package xyz.itwill.exception;

//아이디가 중복될 경우 발생될 예외 정보를 저장하기 위한 클래스
// => 예외 클래스는 반드시 Exception 클래스(RuntimeException 클래스)를 상속받아 작성
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message) {
		super(message);
	}
}
