package xyz.itwill09.exception;

import lombok.Getter;
import xyz.itwill09.dto.Userinfo;

//회원정보를 등록할 때 사용자로부터 입력받은 회원정보의 아이디가 기존 회원정보의 아이디와
//중복될 경우에 대한 문제에 대한 정보를 저장하여 처리하기 위한 예외클래스 
public class ExistsUserinfoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//예외처리에 필요한 값을 저장하기 위한 필드 - 사용자로부터 입력된 회원정보를 필드에 저장
	@Getter
	private Userinfo userinfo;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}
}
