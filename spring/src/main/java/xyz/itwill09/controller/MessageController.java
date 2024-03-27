package xyz.itwill09.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill09.dto.Product;

//스프링 메세지(Spring Message) : Spring 프레임워크로 메세지를 관리하기 위한 기능
//1.메세지가 저장된 Properties 파일 생성
// => 스프링 컨테이너가 참조할 수 있도록 [src/main/webapp] 폴더에 Properties 파일을 작성하는 것을 권장
//2.Spring Bean Configuration File(servlet-context.xml)에 메세지 관리 기능을 제공하는 클래스를
//Spring Bean으로 등록하고 메세지가 저장된 Properties 파일의 경로를 객체 필드에 저장되도록 인젝션 처리
//3.뷰(JSP)에서 spring 태그 라이브러리의 message 태그를 사용하여 메세지를 제공받아 출력 처리

@Controller
@RequestMapping("/message")
public class MessageController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String message(@ModelAttribute Product product) {
		return "message/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String message(@ModelAttribute @Valid Product product, Errors errors) {
		if(errors.hasErrors()) {
			return "message/register";
		}
		return "message/success";
	}
}










