package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {
	//회원정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	//전달값(회원정보)을 매개변수로 제공받아 Request Scope 속성값으로 저장하고 속성값을 출력
	//하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 전달값과 같은 이름의 매개변수를 작성하여 전달받아 제공받아 사용
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
}











