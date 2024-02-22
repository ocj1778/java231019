package xyz.itwill.exception;

//회원정보가 없는 경우 발생될 예외 정보를 저장하기 위한 클래스
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
 
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}
