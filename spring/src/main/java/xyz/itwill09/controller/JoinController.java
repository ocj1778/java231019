package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	//회원정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//전달값(회원정보)을 매개변수로 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력
	//하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 전달값과 같은 이름의 매개변수를 작성하여 전달값을 제공받아 사용
	// => 매개변수에 @RequestParam 어노테이션을 사용하여 전달값의 이름과 매개변수의 이름이
	//다른 경우 400 에러코드가 발생되도록 작성
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	//전달값(회원정보)을 매개변수로 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력
	//하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 전달값과 같은 이름의 매개변수를 작성하여 전달값을 제공받아 사용
	// => 매개변수에 @RequestParam 어노테이션 대신 @ModelAttribute 어노테이션을 사용
	//@ModelAttribute : 값(객체)를 뷰(View)에게 제공하기 위한 어노테이션
	// => @ModelAttribute 어노테이션을 메소드에 사용하면 메소드의 반환값을 컨트롤러 클래스의
	//모든 요청 처리 메소드의 뷰(View)에게 제공
	// => @ModelAttribute 어노테이션을 매개변수에 사용하면 매개변수에 저장된 값(객체)을 요청 
	//처리 메소드의 뷰(View)에게 제공 - Model 객체를 사용하지 않고 매개변수에 저장된 값(객체)을
	//뷰에게 속성값 제공
	// => 전달값의 이름과 매개변수의 이름을 같지 않아도 400 에러코드 미발생
	//value 속성 : 뷰(View)에서 속성값을 사용할 수 있는 식별자(속성명)을 속성값으로 설정
	// => value 속성값으로 설정된 이름의 전달값을 얻어와 매개변수에 저장하여 사용 가능
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "id") String id, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
		return "join_display";
	}
	
}











