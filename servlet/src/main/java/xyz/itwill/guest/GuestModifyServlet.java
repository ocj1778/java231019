package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//게시글을 전달받아 GUEST 테이블에 저장된 행을 변경하고 게시글 목록페이지(/guest/list.itwill)를 
//요청하기 위한 URL 주소를 응답하는 서블릿
// => 게시글 입력페이지(/guest/modifyForm.itwill)의 form 태그를 사용해 POST 방식으로 요청한 서블릿
@WebServlet("/guest/modify.itwill")
public class GuestModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿을 GET 방식으로 요청한 경우 - 비정상적인 요청
		if(request.getMethod().equals("GET")) {
			//클라이언트에게 [405] 에러코드를 전달하여 응답
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		
		//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
		request.setCharacterEncoding("utf-8");
		
		//전달값(게시글)을 반환받아 저장
		int num=Integer.parseInt(request.getParameter("num"));
		String writer=request.getParameter("writer");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		//DTO 객체를 생성하여 전달값으로 필드값 변경
		GuestDTO guest=new GuestDTO();
		guest.setNum(num);
		guest.setWriter(writer);
		guest.setSubject(subject);
		guest.setContent(content);
		
		//게시글(GuestDTO 객체)을 전달받아 GUEST 테이블에 저장된 행을 변경하고 변경행의 갯수를 
		//반환하는 DAO 클래스의 메소드 호출
		GuestDAO.getDAO().updateGuest(guest);
		
		//클라이언트에게 요청 URL 주소를 전달하여 응답 처리 - 리다이렉트 이동
		response.sendRedirect("list.itwill");
	}
}
