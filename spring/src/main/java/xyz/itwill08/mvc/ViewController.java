package xyz.itwill08.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트가 [/view.itwill]의 URL 주소로 요청한 경우 컨트롤러에 의해 실행될 클래스
public class ViewController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test258", "일지매", "서울시 종로구");
		request.setAttribute("member", member);
		return "member_view";
	}
}
