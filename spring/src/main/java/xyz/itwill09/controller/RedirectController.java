package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model 객체를 사용하여 뷰(View)에게 제공할 객체를 속성값으로 저장 - Request Scope
		model.addAttribute("name", "홍길동");
		
		//뷰(View)를 생성하기 위한 뷰이름(ViewName) 반환
		// => Front Controller(DispatchServlet 객체)는 반환받은 뷰이름을 InternalResourceViewResolver
		//객체에게 전달하여 JSP 문서의 경로를 제공받아 스레드를 이동해 JSP 문서로 응답 처리 - 포워드 이동
		//포워드 이동 : 클라이언트 요청에 의해 실행된 웹프로그램(Front Controller)에서 응답 
		//처리할 웹프로그램(View - JSP)으로 스레드를 이동하여 응답 처리
		// => 클라이언트의 URL 주소는 변경되지 않으면 Request Scope 속성값을 객체로 제공받아 사용 가능
		return "display_forward";
	}
	
	/*
	@RequestMapping("/redirect")
	public String redirect() {
		//요청 처리 메소드의 반환값(뷰이름)에 redirect 접두사를 사용하여 반환하면 Front Controller
		//(DispatchServlet 객체)는 반환받은 URL 주소를 클라이언트에게 전달하여 응답 처리
		// => URL 주소를 응답받은 클라이언트는 브라우저 요청 URL 주소를 변경하여 해당 페이지를
		//요청해 새로운 응답결과를 제공받아 출력 처리 - 리다이렉트 이동
		//리다이렉트 이동 : 클라이언트에게 URL 주소를 전달하여 페이지를 재요청해 실행결과를 응답받아 처리
		// => 클라이언트의 URL 주소는 변경되지만 Request Scope 속성값을 객체로 제공받아 사용 불가능
		return "redirect:/redirect_move";
	}
	
	@RequestMapping("/redirect_move")
	public String redirect(Model model) {
		model.addAttribute("name", "임꺽정");
		return "display_redirect";
	}
	
	*/

	//요청 처리 메소드에 RedirectAttributes 인터페이스를 매개변수를 작성하여 RedirectAttributes
	//객체를 제공받아 사용 가능
	// => RedirectAttributes 객체 : 리다이렉트 이동되는 페이지의 요청 처리 메소드와 뷰에서
	//사용할 수 있는 Request Scope 속성값을 제공하기 위한 객체
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => Request Scope 속성값을 저장하여 리다이렉트 이동되는 페이지의 요청 처리 메소드와
		//뷰에게 속성값을 제공하기 위한 메소드
		attributes.addFlashAttribute("name", "임꺽정");
		return "redirect:/redirect_move";
	}

	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
}
