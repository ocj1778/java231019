package xyz.itwill09.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.BadRequestException;

//Interceptor 클래스 : 요청 처리 메소드 호출 전 또는 후에 삽입되어 실행될 기능을 제공하는 클래스
// => Interceptor 클래스는 반드시 HandlerInterceptor 인터페이스를 상속받아 작성
// => HandlerInterceptor 인터페이스의 기본 메소드(Default Method) 중 필요한 메소드만 오버라이드 선언하여 사용
// => Interceptor 클래스는 Front Controller에 의해 관리되므로 Spring Bean Configuration File
//(servlet-context.xml)에서 Spring Bean으로 등록하여 요청 처리 메소드 호출 전 또는 후에 실행되도록 설정
// => Filter 클래스는 Front Controller 이전에 위치하여 실행되고 Interceptor 클래스는 Front 
//Controller 다음에 위치하여 실행 - Filter 클래스는 WAS 프로그램에 의해 관리(web.xml 파일로 설정) 

//로그인 사용자 관련 권한 처리를 위해 작성된 인터셉터 클래스
// => 요청 처리 메소드 호출 전에 비로그인 사용자가 페이지를 요청할 경우 인위적 예외 발생
public class LoginAuthInterceptor implements HandlerInterceptor {
	//preHandle 메소드 : 요청 처리 메소드 호출 전에 실행될 명령을 작성하기 위한 메소드
	// => false 반환 : 요청 처리 메소드 미호출, true 반환 : 요청 처리 메소드 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo == null) {
			//인위적 예외 발생 - 요청 처리 메소드 미호출
			throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
		}
		
		return true;
	}
	
	//postHandle 메소드 : 요청 처리 메소드가 호출되어 실행된 후 반환된 뷰이름으로 ViewResolver
	//객체가 뷰(View)를 생성하기 전에 실행될 명령을 작성하는 메소드
	// => ModelAndView 객체를 제공받아 ViewName 또는 속성값을 저장(변경)하기 위한 사용 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//afterCompletion 메소드 : 요청 처리 메소드가 호출되어 실행된 후 반환된 뷰이름으로 ViewResolver
	//객체가 뷰(View)를 생성하기 후에 실행될 명령을 작성하는 메소드
	// => 뷰(View)를 변경하기 위해 사용
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}














