package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill09.dto.Hewon;

@Controller
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 반환하는 메소드 - Service 클래스의 메소드
	private Hewon getHewon(String id) {
		return Hewon.builder().id("abc123").name("홍길동").email("abc@itwill.xyz").build();
	}
	 
	//아이디를 전달받아 아이디의 회원정보를 검색하여 뷰에게 제공하기 위한 요청 처리 메소드
	// => 아이디로 검색된 회원정보를 속성값으로 저장하여 뷰(JSP)에서 HTML 태그로 출력되도록 응답 처리
	@RequestMapping("/hewon_view")
	public String view(@RequestParam(defaultValue = "abc123") String id, Model model) {
		//Service 클래스의 메소드를 호출하여 매개변수로 전달받은 아이디의 회원정보를 검색해 반환받아 저장 
		Hewon hewon=getHewon(id);
		
		//Model 객체를 사용하여 검색된 회원정보를 속성값으로 저장하여 뷰에게 제공
		// => 현재 요청 처리 메소드의 뷰에게만 속성값을 객체로 제공하여 응답 처리 - Request Scope
		model.addAttribute(hewon);//속성명 생략 - 속성값에 대한 클래스명을 속성명으로 사용
		
		return "hewon_view";
	}
	
	//아이디를 전달받아 아이디의 회원정보를 검색하여 뷰에게 제공하기 위한 요청 처리 메소드
	// => 아이디로 검색된 회원정보를 속성값으로 저장하여 뷰(JSP)에서 입력태그의 초기값으로 사용하여 응답 처리
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update(@RequestParam(defaultValue = "abc123") String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "hewon_update";
	}
	
}














