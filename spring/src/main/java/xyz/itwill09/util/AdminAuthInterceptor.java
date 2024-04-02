package xyz.itwill09.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.BadRequestException;

//관리자 관련 권한 처리를 위해 작성된 인터셉터 클래스
//=> 요청 처리 메소드 호출 전에 비로그인 사용자 또는 일반회원이 페이지를 요청할 경우 인위적 예외 발생
public class AdminAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
		}
		
		return true;
	}
}
