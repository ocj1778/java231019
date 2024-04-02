package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.BadRequestException;
import xyz.itwill09.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
@RequiredArgsConstructor
public class UserinfoController {
	private final UserinfoService userinfoService;
	
	//회원정보를 입력받기 위한 뷰이름을 반환하는 요청 처리 메소드
	// => 비로그인 사용자 또는 관리자가 아닌 일반회원이 페이지를 요청할 경우 인위적 예외 발생 - 500 에러코드 발생
	// => try~catch 구문을 사용하여 예외가 발생될 경우 에러메세지를 출력하는 뷰이름 반환 - 500 에러코드 미발생
	/*
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		try {
			//페이지를 요청한 사용자가 비로그인 사용자이거나 관리자가 아닌 일반회원인 경우
			if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
				throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
			}
		} catch (BadRequestException e) {
			return "userinfo/user_error";
		}
		return "userinfo/user_write";	
	}
	*/
	
	//예외 처리 메소드(Exception Handle Method)를 사용하여 예외 처리
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo ==null || loginUserinfo.getStatus() != 9) {
			throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
		}
		return "userinfo/user_write";	
	}
	
	/*
	//회원정보를 전달받아 USERINFO 테이블에 삽입하고 로그인 페이지를 요청할 수 있는 URL 주소로
	//응답하는 요청 처리 메소드
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			//매개변수로 전달받은 회원정보의 아이디가 중복될 경우 ExistsUserinfoException 발생
			userinfoService.addUserinfo(userinfo);
		} catch (ExistsUserinfoException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("userinfo", e.getUserinfo());
			return "userinfo/user_write";	
		}
		return "redirect:/userinfo/login";	
	}
	*/
	
	//예외 처리 메소드(Exception Handle Method)를 사용하여 예외 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(@ModelAttribute Userinfo userinfo, Model model) {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";	
	}
	
	//인증정보를 입력받기 위한 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";	
	}
	
	/*
	//인증정보를 전달받아 USERINFO 테이블에 저장된 행을 검색해 인증 처리하고 환영메세지를 
	//출력하는 뷰이름을 반환하는 요청 처리 메소드
	// => 인증 성공 후 세션에 권한 관련 정보(회원정보)를 속성값으로 저장
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session, Model model) {
		try {
			//매개변수로 전달받은 인증정보에 대한 인증실패시 LoginAuthFailException 발생
			Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
			session.setAttribute("loginUserinfo", authUserinfo);	
		} catch (LoginAuthFailException e) {
			model.addAttribute("message", e.getMessage());
			model.addAttribute("userid", e.getUserid());
			return "userinfo/user_login";	
		}
		return "userinfo/user_login";	
	}
	*/
	
	//예외 처리 메소드(Exception Handle Method)를 사용하여 예외 처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) {
		Userinfo authUserinfo=userinfoService.loginAuth(userinfo);
		session.setAttribute("loginUserinfo", authUserinfo);	
		return "userinfo/user_login";	
	}
	
	//로그아웃 처리하고 로그인 페이지를 요청할 수 있는 URL 주소로 응답하는 요청 처리 메소드
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUserinfo");
		session.invalidate();
		return "redirect:/userinfo/login";	
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 속성값으로 저장해 회원목록을 출력하는
	//뷰이름을 반환하는 요청 처리 메소드
	// => 비로그인 사용자가 페이지를 요청할 경우 인위적 예외 발생
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		//페이지를 요청한 사용자가 비로그인 사용자인 경우
		if(loginUserinfo == null) {
			throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
		}
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}

	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 속성값으로 저장해 
	//회원정보를 출력하는 뷰이름을 반환하는 요청 처리 메소드
	// => 비로그인 사용자가 페이지를 요청할 경우 인위적 예외 발생
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model, HttpSession session) {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		//페이지를 요청한 사용자가 비로그인 사용자인 경우
		if(loginUserinfo == null) {
			throw new BadRequestException("비정상적인 방식으로 페이지를 요청 하였습니다.");
		}
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	
	/*
	//@ExceptionHandler : 예외 처리 기능의 메소드를 설정하기 위한 어노테이션
	// => Controller 클래스의 요청 처리 메소드에서 예외가 발생되면 Front Controller에 의해
	//자동 호출되어 예외 처리하는 메소드 - 예외 처리 메소드
	// => 예외 처리 메소드의 매개변수에 예외 처리에 필요한 객체를 전달받아 예외를 처리할 수
	//있으며 클라이언트에게 응답할 뷰이름 반환 - 리다이렉트 이동가능
	//value 속성 : 예외 처리하기 위한 클래스(Class 객체)를 속성값으로 설정
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
	@ExceptionHandler(value = BadRequestException.class)
	public String badRequestExceptionHandler() {
		return "userinfo/user_error";
	}
	
	@ExceptionHandler(ExistsUserinfoException.class)
	public String existsUserinfoExceptionHandler(ExistsUserinfoException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";	
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String loginAuthFailExceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";	
	}
	
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String userinfoNotFoundExceptionHandler() {
		return "userinfo/user_error";	
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";	
	}
	*/
}















