package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//요청 처리 메소드의 명령에 의해 생성된 결과값을 뷰(JSP)에게 제공하는 방법
//1.ModelAndView 객체의 addObject() 메소드를 호출하여 결과값을 속성값으로 저장하여 제공 

@Controller
public class ResultController {
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		
		//ModelAndView.addObject(String attributeName, Object attributeVale) 
		// => ModelAndView 객체에 결과값을 속성값으로 저장하는 메소드 - Request Scope
		// => 뷰(JSP)에서는 EL 또는 JSTL를 사용하여 속성명으로 속성값(객체)를 제공받아 출력 처리
		modelAndView.addObject("mavName", "홍길동");
		
		return modelAndView;
	}
}
