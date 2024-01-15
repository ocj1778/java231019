package xyz.itwill.guest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;

//글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 게시글 목록페이지(/guest/list.itwill)를 
//요청하기 위한 URL 주소를 응답하는 서블릿
@WebServlet("/guest/remove.itwill")
public class GuestRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달값이 없는 경우 - 비정상적인 요청
		if(request.getParameter("num")==null) {
			//클라이언트에게 [400] 에러코드를 전달하여 응답
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		//전달값을 반환받아 정수값으로 변환하여 저장
		int num=Integer.parseInt(request.getParameter("num"));
		
		//글번호를 전달받아 GUEST 테이블에 저장된 행을 삭제하고 삭제행의 갯수를 반환하는 DAO 클래스의 메소드 호출
		int rows=GuestDAO.getDAO().deleteGuest(num);
		
		if(rows>0) {//삭제된 게시글이 있는 경우
			response.sendRedirect("list.itwill");
		} else {//삭제된 게시글이 없는 경우 - 비정상적인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
