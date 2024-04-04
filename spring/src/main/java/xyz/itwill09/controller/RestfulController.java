package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.itwill09.dto.RestMember;

//REST(Representational State Transfer) : 자원(Resource)의 표현(Representational)에 의해 
//상태(State)를 전달(Transfer)한는 것을 의미
// => 페이지 요청에 대한 실행결과를 클라이언트에게 XML 또는 JSON 형식의 텍스트 데이타로 응답 처리
//Restful API : REST 기능을 사용하여 두 컴퓨터의 시스템이 안전하게 값을 주고 받기 위한 프로그램
// => 스마트기기의 프로그램(앱) 실행에 필요한 정보를 전달받거나 실행결과를 제공받기 위해 사용

@Controller
@RequestMapping("/rest")
public class RestfulController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "rest/input";
	}
	
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	*/
	
	//@ResponseBody : 요청 처리 메소드의 반환값(문자열)을 리스폰즈 메세지 몸체부에 저장하여
	//문자값(텍스트 데이타)으로 클라이언트에게 전달하여 응답하는 어노테이션
	// => 반환값을 ViewResolver 객체를 사용하여 뷰로 변환하여 응답 처리하지 않고 요청 처리
	//메소드의 반환값으로 응답 처리
	// => @ResponseBody 대신 ResponseEntity 클래스를 요청 처리 메소드의 반환형으로 작성하여 응답 처리 가능
	//@RequestBody : 리퀘스트 메세지 몸체부에 저장된 모든 전달값을 문자열로 제공받기 위한 어노테이션
	// => POST, PUT, PATCH, DELETE 등의 요청방식으로 페이지를 요청한 경우 리퀘스트 메세지 몸체부에
	//저장된 전달값을 문자열로 제공받아 매개변수에 저장
	// => GET 방식으로 페이지를 요청한 경우 리퀘스트 메세지 몸체부가 비어 있으므로 @RequestBody 어노테이션 사용 불가능
	// => 비동기식 방식으로 페이지 요청시 JSON 형식의 텍스트 데이타로 전달된 값을 매개변수로 
	//저장하기 위해 사용
	// => @RequestBody 어노테이션 대신 RequestEntity 클래스를 사용하여 전달값 저장 가능
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	@ResponseBody
	public String join(@RequestBody String input) {
		return input;
	}
	
	//@ResponseBody 어노테이션을 사용하여 요청 처리 메소드의 반환값(RestMember 객체)을 리스폰즈
	//메세지 몸체부에 문자열로 저장하여 클라이언트에게 응답 처리
	//문제점)리스폰즈 메세지 몸체부에는 Java 객체를 저장하여 응답 처리 불가능 - 406 에러코드 발생
	//해결법)요청 처리 메소드에 의해 반환되는 Java 객체를 문자열(XML 또는 JSON)로 변환하여  
	//리스폰즈 메세지 몸체부에 저장하여 응답 처리
	// => 프로젝트에 jackson-databind 라이브러리를 빌드 처리하면 요청 처리 메소드에 의해 반환되는
	//Java 객체를 JSON 형식의 문자열로 변경하여 리스폰즈 메세지 몸체부에 저장하여 응답 처리 
	@RequestMapping("/member")
	@ResponseBody
	public RestMember restMember() {
		return RestMember.builder().id("abc123").name("홍길동").email("abc@itwill.xyz").build();
	}
}









