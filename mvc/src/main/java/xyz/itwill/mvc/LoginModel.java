package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/login.do]로 요청한 경우 객체로 생성될 모델 역활의 클래스
// => 인증정보를 전달받아 USERINFO 테이블에 저장된 행과 비교하여 인증 처리하고 [/loginform.do]
//주소로 리다이렉트 이동하기 위해 정보가 저장된 ActionForward 객체 반환
// => 인증 성공시 세션(HttpSession 객체)에 권한 관련 정보를 속성값으로 저장
public class LoginModel implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

}
