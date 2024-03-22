package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//모델(Model) 기능을 제공하기 위한 클래스 - 요청 처리 클래스 : Controller 클래스
//@Controller : 요청 처리 클래스(Controller 클래스)를 Spring Bean으로 등록하기 위한 어노테이션
// => 클래스의 이름을 Spring Bean을 구분하기 위한 식별자(beanName)로 사용 - 클래스 이름의 첫문자는 소문자로 변환
// => value 속성을 사용하여 Spring Bean의 식별자 변경 가능
//@Controller 어노테이션을 사용하면 Controller 인터페이스를 상속받지 않아도 Controller 클래스로 사용
// => 메소드에 @RequestMapping 어노테이션을 사용하여 요청 처리 메소드로 처리되도록 작성
// => @RequestMapping 어노테이션을 사용한 요청 처리 메소드를 여러개 작성 가능
@Controller
@Slf4j
public class HelloController {
	//@RequestMapping : Controller 클래스의 메소드를 클라이언트의 요청을 처리 하기 위한 요청
	//처리 메소드로 설정하기 위한 어노테이션
	// => 클라이언트의 모든 요청방식(Method - GET, POST, PUT, PATCH, DELETE 등)에 의해
	//요청한 경우 호출되는 요청 처리 메소드를 작성할 때 사용
	// => 클라이언트의 요청방식을 구분하여 요청 처리 메소드를 호출해야될 경우 @GetMapping,
	//@PostMapping, @PutMapping, @PatchMapping, @DeleteMapping 등의 어노테이션을 사용하여 설정
	//value 속성 : 클라이언트의 요청정보(Command - URL 주소)를 속성값으로 설정
	// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
	// => 요청 처리 메소드의 value 속성값이 중복될 경우 WAS 프로그램 실행시 에러 발생
	@RequestMapping(value = "/hello")
	public void hello() {//요청 처리 메소드
		//요청 처리 명령 작성
		log.info("[/hello] 페이지 요청 : HelloController 클래스의 hello() 메소드 호출");
	}
}
















