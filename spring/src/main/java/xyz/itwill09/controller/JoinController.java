package xyz.itwill09.controller;

import java.util.Map;

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
	
	/*
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
	*/
	
	/*
	//전달값(회원정보)을 매개변수로 제공받아 DTO 객체의 필드값으로 저장한 후 DTO 객체를 Request
	//Scope 속성값으로 저장하여 속성값을 출력하고 JSP 문서의 뷰이름을 반환하는 요청 처리 메소드
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		//DTO 클래스로 객체를 생성하여 전달값으로 DTO 객체의 필드값 변경
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);

		//DTO 객체를 Mode 객체의 속성값 저장 - 뷰에게 DTO 객체 제공
		//model.addAttribute("member", member);
		//Model.addAttribute(Object attributeValue) : 객체를 속성값으로 저장하여 뷰에게 제공하는 메소드
		// => 매개변수에 속성명을 전달하지 않으면 속성값으로 저장되는 객체의 자료형(클래스)의
		//이름을 속성명으로 사용 - 첫번째 문자는 소문자로 변환되어 사용
		// => 속성값이 원시형(Wrapper 클래스) 또는 String 클래스는 반드시 속성명 설정
		model.addAttribute(member);
		
		return "join_display";
	}	
	*/

	/*
	//요청 처리 메소드의 매개변수 자료형을 DTO 클래스로 작성하면 Front Controller는 DTO 클래스로
	//객체를 생성하여 매개변수에 저장되도록 제공
	// => 전달값의 이름과 같은 이름의 객체 필드에 전달값을 자동으로 저장하여 제공
	//Command 객체 : 전달값이 필드에 저장된 객체를 매개변수에 저장하고 매개변수에 저장된 객체를
	//속성값으로 저장해 뷰에서 사용할 수 있도록 제공하는 객체
	// => Command 객체로 사용하기 위해 매개변수에 @ModelAttribute 어노테이션 사용
	// => @ModelAttribute 어노테이션을 사용하지 않아도 뷰에서 사용할 수 있는 속성값으로 제공
	//Command 객체는 ModelAttribute 어노테이션의 value 속성 생략 가능
	// => value 속성이 생략된 경우 Command 객체의 자료형(클래스)을 자동으로 속성명으로 설정
	//하여 사용 - 첫번째 문자는 소문자로 변환되어 사용
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute 어노테이션의 value 속성값을 변경하여 뷰에게 속성값을 제공하기 위한
	//속성명을 변경 가능
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("hewon") Member member) {
		return "join_display";
	}
	*/
	
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("hewon") Member member, Model model) {
		if(member.getId().equals("abc123")) {//아이디가 중복된 경우
			model.addAttribute("message", "이미 사용중인 아이디를 입력 하였습니다.");
			return "join_form";
		}
		return "join_display";
	}
	*/

	//요청 처리 메소드의 매개변수 자료형을 Map 인터페이스로 작성하면 Front Controller는 Map
	//객체를 생성하여 매개변수에 저장되도록 제공
	// => Map 객체에는 모든 전달값의 이름(맵키 - String)과 전달값(맵값 - String)이 엔트리로
	//생성되어 추가
	// => 전달값이 저장된 Map 객체를 제공받아 매개변수에 저장하기 위해서는 반드시 @RequestParam
	//어노테이션을 매개변수에 작성
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("hewon", map);
		return "join_display";
	}
}
