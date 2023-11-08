package xyz.itwill.exception;

//프로그램 개발자가 필요에 의해 직접 선언한 예외클래스
// => 예외클래스는 반드시 Exception 클래스를 상속받아 작성 - 일반 예외
// => RuntimeException 클래스를 상속받아 예외클래스 작성 가능 - 실행 예외
public class PasswordMismatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PasswordMismatchException() {
		// TODO Auto-generated constructor stub
	}
	
	public PasswordMismatchException(String message) {
		//super 키워드를 사용하여 부모클래스의 생성자를 호출할 때 메세지를 전달하여 부모클래스의
		//객체에 예외 메세지 저장
		super(message);
	}
}
