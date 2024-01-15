package xyz.itwill.guest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.GuestDAO;
import xyz.itwill.dto.GuestDTO;

//GUEST 테이블에 저장된 모든 행(게시글)을 검색하여 HTML 문서로 응답하는 서블릿
// => [글쓰기] 태그를 클릭한 경우 게시글 입력페이지(/guest/writeForm.itwill)를 요청하여 페이지 이동
// => 게시글의 [변경] 태그를 클릭한 경우 게시글 입력페이지(/guest/modifyForm.itwill)를 요청하여 
//페이지 이동 - 요청 페이지에 글번호 전달
// => 게시글의 [삭제] 태그를 클릭한 경우 게시글 삭제페이지(/guest/remove.itwill)를 요청하여 
//페이지 이동 - 요청 페이지에 글번호 전달
@WebServlet("/guest/list.itwill")
public class GuestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//GUEST 테이블에 저장된 모든 행을 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
		List<GuestDTO> guestList=GuestDAO.getDAO().selectGuestList();
		
		//HTML 문서를 동적으로 생성하여 리스폰즈 메세지의 몸체부에 저장
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>게시글목록</h1>");
		out.println("<hr>");
		out.println("<table width='1000'>");
		out.println("<tr>");
		out.println("<td align='right'>");
		out.println("<button type='button' onclick='location.href=\"writeForm.itwill\";'>글쓰기</button>");
		out.println("</td>");
		out.println("</tr>");
		if(guestList.isEmpty()) {//List 객체에 저장된 요소가 없는 경우
			out.println("<tr>");
			out.println("<td align='right'>");
			out.println("<table border='1' cellspacing='0' width='100%'>");
			out.println("<tr>");
			out.println("<td align='center'>검색된 게시글이 하나도 없습니다.</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</td>");
			out.println("</tr>");
		} else {//List 객체에 저장된 요소가 있는 경우
			//List 객체의 요소(GuestDTO 객체)를 차례대로 제공받아 변수에 저장하여 처리하는 반복문
			for(GuestDTO guest : guestList) {
				out.println("<tr>");
				out.println("<td align='right'>");
				out.println("<table border='1' cellspacing='0' width='100%'>");
				out.println("<tr>");
				out.println("<th width='150'>작성자</th>");
				out.println("<td width='200' align='center'>"+guest.getWriter()+"</td>");
				out.println("<th width='150'>작성날자</th>");
				out.println("<td width='200' align='center'>"+guest.getRegdate()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='150'>제목</th>");
				out.println("<td width='500' colspan='3'>"+guest.getSubject()+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<th width='150'>내용</th>");
				out.println("<td width='500' colspan='3'>"+guest.getContent().replace("\n", "<br>")+"</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan='4' align='right'>");
				out.println("<button type='button' onclick='location.href=\"modifyForm.itwill?num="+guest.getNum()+"\";'>변경</button>");
				out.println("<button type='button' onclick='location.href=\"remove.itwill?num="+guest.getNum()+"\";'>삭제</button>");
				out.println("</td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>&nbsp;</td>");
				out.println("</tr>");
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

}




























