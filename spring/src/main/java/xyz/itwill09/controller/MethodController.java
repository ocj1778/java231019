package xyz.itwill09.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//사용자로부터 값을 입력받기 위한 JSP 문서의 뷰이름(ViewName)을 반환하는 요청 처리 메소드
	// => 클라이언트의 요청방식에 상관없이 요청 처리 메소드 호출
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	//전달값을 반환받아 Request Scope 속성값으로 저장하고 속성값을 출력하기 위한 JSP 문서의
	//뷰이름(ViewName)을 반환하는 요청 처리 메소드 - POST 방식으로 요청되도록 설정
	// => 클라이언트의 요청방식에 상관없이 요청 처리 메소드 호출
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		//비정상적인 요청 - 클라이언트에게 에러코드 또는 에러페이지를 요청할 수 있는 URL 주소를 전달하여 응답 
		if(request.getMethod().equals("GET")) {
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.sendRedirect("method_input");
			return null;
		}
 		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
	
	//사용자로부터 값을 입력받기 위한 JSP 문서의 뷰이름(ViewName)을 반환하는 요청 처리 메소드
	// => 클라이언트가 GET 방식에 페이지를 요청한 경우 요청 처리 메소드 호출
	//method 속성 : RequestMethod(Enum)의 상수(Constant) 중 하나를 속성값으로 설정
	// => RequestMethod(Enum)는 클라이언트의 요청방식을 상수로 제공하는 Java 자료형
	// => method 속성값으로 설정된 요청방식이 아닌 형태로 요청한 경우 클라이언트에게 405 에러코드 전달
	//@RequestMapping 어노테이션 대신 @GetMapping 어노테이션을 사용하여 GET 방식으로 요청한
	//경우 요청 처리 메소드 호출 가능
	//@GetMapping("/method")
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}

	//전달값을 반환받아 Request Scope 속성값으로 저장하고 속성값을 출력하기 위한 JSP 문서의
	//뷰이름(ViewName)을 반환하는 요청 처리 메소드 
	// => 클라이언트가 POST 방식에 페이지를 요청한 경우 요청 처리 메소드 호출
	// => 요청 처리 메소드를 호출하는 요청방식이 다른 경우 페이지의 요청 이름이 같아도 에러 미발생
	//@RequestMapping 어노테이션 대신 @PostMapping 어노테이션을 사용하여 GET 방식으로 요청한
	//경우 요청 처리 메소드 호출 가능
	//@PostMapping("/method")
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
 		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
}
