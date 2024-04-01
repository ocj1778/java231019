package xyz.itwill.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] 패턴문자를 사용하여 Spring Bean Configuration File 설정 가능
// => [**] 패턴으로 0개 이상의 하위 폴더를 표현
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	//WebApplicationContext 객체(스프링 컨테이너)를 제공받아 필드에 저장되도록 의존성 주입
	@Autowired
	private WebApplicationContext context;

	//MockMvc 객체를 저장하기 위한 필드 작성
	// => MockMvc 객체 : 요청과 응답을 가상으로 제공하기 위한 객체 - Front Controller의 기능 제공
	private MockMvc mvc;
	
	//@Before : 테스트 메소드 호출 전에 실행되도록 호출될 메소드에 설정하는 어노테이션 - 초기화 작업 
	@Before 
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		// => MockMvcBuilder 객체를 생성하여 반환하기 위한 메소드
		//MockMvcBuilder.build() : MockMvc 객체를 생성하여 반환하는 메소드
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvcRequestBuilders.get(String url) : 요청 URL 주소를 매개변수로 전달받아 Front
		//Controller에게 GET 방식으로 요청하기 위한 RequestBuilder 객체를 반환하는 정적 메소드
		//MockMvc.perform(Builder requestBuilder) : Front Controller에서 RequestBuilder 객체에
		//저장된 정보를 사용하여 페이지를 요청하는 메소드 - 요청 처리 메소드 호출
		// => 요청 처리 메소드의 호출결과를 ResultActions 객체 반환
		//ResultActions.andReturn() : 요청 처리 메소드의 실행결과를 MvcResult 객체로 반환하는 메소드
		// => MvcResult 객체 : 요청 처리 메소드에 의해 저장된 속성값 및 뷰이름이 저장된 객체
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
}
