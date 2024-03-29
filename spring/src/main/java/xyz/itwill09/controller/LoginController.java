package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill09.dto.Member;

@Controller
public class LoginController {
	//사용자에게 인증정보를 입력받기 위한 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login_form";
	}
	
	/*
	//전달값(인증정보)를 매개변수로 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로
	//저장하고 로그인 성공 메세지를 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 매개변수를 String 클래스로 작성하여 전달값을 하나씩 제공받아 사용
	//요청 처리 메소드의 매개변수 자료형을 HttpSession 인터페이스로 작성하면 Front Controller에서
	//세션 바인딩 처리된 HttpSession 객체을 제공받아 매개변수에 저장하여 사용
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, Model model, HttpSession session) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//인증 실패
			//인증 실패 관련 정보를 Model 객체로 Request Scope 속성값으로 저장
			//Request Scope : 현재 요청 처리 메소드와 포워드 이동 되는 뷰에서만 속성값을 제공받아 사용 
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
			model.addAttribute("id", id);
			return "login_form";//입력페이지 이동
		}
		
		//인증 성공 - 권한 관련 정보를 Session Scope 속성값으로 저정
		//Session Scope : 동일한 세션을 사용하는 모든 요청 처리 메소드와 뷰에서 속성값을 제공받아 사용
		session.setAttribute("loginId", id);
		
		return "login_display";
	}
	*/

	//전달값(인증정보)를 매개변수로 제공받아 인증 처리 후 권한 관련 정보를 Session Scope 속성값으로
	//저장하고 로그인 성공 메세지를 출력하는 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	// => 매개변수를 Member 클래스로 작성하여 모든 전달값이 저장된 Command 객체로 제공받아 사용
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Member member, Model model, HttpSession session) {
		if(!member.getId().equals("abc123") || !member.getPasswd().equals("123456")) {
			model.addAttribute("message", "아이디 또는 비밀번호를 잘못 입력 하였습니다.");
			return "login_form";
		}
		session.setAttribute("loginId", member.getId());
		return "login_display";
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginId");
		session.invalidate();
		
		return "logout_display";
	}
	
	//로그인 상태의 사용자만 접근 가능한 페이지
	@RequestMapping("/login_user")
	public String login(HttpSession session, Model model) {
		if(session.getAttribute("loginId")==null) {
			model.addAttribute("message", "로그인 사용자만 접근 가능합니다.");
			return "login_form";
		}
		
		return "login_display";
	}
}
