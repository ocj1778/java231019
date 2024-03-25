package xyz.itwill09.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}

	//HttpServletRequest 인터페이스로 요청 처리 메소드의 매개변수를 작성하여 Front Controller에게
	//클라이언트의 요청정보가 저장된 HttpServletRequest 객체를 제공받아 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
	}
}



