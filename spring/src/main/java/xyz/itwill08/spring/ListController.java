package xyz.itwill08.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//모델 기능을 제공하기 위한 요청 처리 클래스 - Controller 클래스
// => Spring-webmvc 라이브러리로 제공된 Controller 인터페이스를 상속받아 작성
//클라이언트가 [/list.do]의 URL 주소로 요청한 경우 컨트롤러에 의해 실행될 클래스
public class ListController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView 클래스로 객체 생성
		// => ModelAndView 객체 : 처리결과와 뷰이름(ViewName)을 저장하기 위한 객체
		ModelAndView modelAndView=new ModelAndView();
		
		//데이타 처리 - Service 클래스의 메소드 호출
		List<Product> productList=new ArrayList<Product>();
		productList.add(new Product(1000, "컴퓨터"));
		productList.add(new Product(2000, "노트북"));
		productList.add(new Product(3000, "테블릿"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView 객체에 요청에 대한 처리 결과를 속성값으로 저장하는 메소드 - Request Scope
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView 객체의 뷰이름을 변경하는 메소드
		modelAndView.setViewName("product_list");
		
		return modelAndView;
	}
}
