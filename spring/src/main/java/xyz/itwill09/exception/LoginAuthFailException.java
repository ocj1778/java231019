package xyz.itwill09.exception;

import lombok.Getter;

//로그인 처리시 사용자로부터 입력받은 아이디와 비밀번호에 대한 인증이 실패한 경우에 
//대한 정보를 저장하여 처리하기 위한 예외클래스
public class LoginAuthFailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Getter
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}
}
