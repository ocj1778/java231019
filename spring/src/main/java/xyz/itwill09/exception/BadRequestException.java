package xyz.itwill09.exception;

//비정상적으로 페이지를 요청할 경우에 대한 정보를 저장하여 처리하기 위한 예외클래스
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}
