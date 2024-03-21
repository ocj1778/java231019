package xyz.itwill08.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 처리 클래스(Model)가 반드시 상속받아야 되는 인터페이스
// => 모든 요청 처리 클래스의 메소드가 동일하게 작성되도록 규칙 제공
// => 컨트롤러에서 요청 처리 클래스의 객체로 메소드를 쉽게 호출하기 위한 인터페이스 필드
public interface Controller {
	//요청 처리 메소드를 추상메소드로 작성
	String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}
