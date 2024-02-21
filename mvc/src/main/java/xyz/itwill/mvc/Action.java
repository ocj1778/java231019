package xyz.itwill.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 모델 역활의 클래스가 반드시 상속받아야 되는 인터페이스
// => 모델 역활의 클래스에 요청 처리 메소드에 대한 작성 규칙 제공
// => 컨트롤러 역활의 서블릿에서 모델 객체로 요청 처리 메소드를 쉽게 호출할 수 있으며 유지보수의 효율성 증가

//인터페이스에는 요청 처리 메소드를 추상메소드로 선언
// => 인터페이스를 상속받은 모든 자식클래스는 반드시 추상메소드를 오버라이드 선언 - 메소드 작성 규칙 제공
// => 요청 처리 메소드는 매개변수로 HttpServletRequest 객체와 HttpServletResponse 객체를 전달
//받을 수 있도록 작성하고 뷰 관련 정보(ActionForward 객체)를 반환하도록 작성
public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException;
}
