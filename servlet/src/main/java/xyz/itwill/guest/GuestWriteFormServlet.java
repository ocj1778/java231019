package xyz.itwill.guest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//사용자로부터 게시글을 입력받기 위한 HTML 문서로 응답하는 서블릿
// => [글저장] 태그를 클릭한 경우 게시글 삽입페이지(/guest/write.itwill)를 요청하여 페이지 이동 - 입력값 전달
// => [글목록] 태그를 클릭한 경우 게시글 목록페이지(/guest/list.itwill)를 요청하여 페이지 이동
@WebServlet("/guest/writeForm.itwill")
public class GuestWriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>방명록 글쓰기</h1>");
		out.println("<hr>");
		out.println("<form action='write.itwill' method='post' name='insertForm'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>작성자</td>");
		out.println("<td><input type='text' name='writer'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>제목</td>");
		out.println("<td><input type='text' name='subject'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>내용</td>");
		out.println("<td><textarea rows='4' cols='60' name='content'></textarea></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<button type='button' id='saveBtn'>글저장</button>");
		out.println("<button type='reset'>다시쓰기</button>");
		out.println("<button type='button' onclick='location.href=\"list.itwill\";'>글목록</button>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<script type='text/javascript'>");
		out.println("insertForm.writer.focus();");
		out.println("document.getElementById('saveBtn').onclick=function() {");
		out.println("if(insertForm.writer.value=='') {");
		out.println("alert('작성자를 입력해 주세요.');");
		out.println("insertForm.writer.focus();");
		out.println("return;");
		out.println("}");
		out.println("if(insertForm.subject.value=='') {");
		out.println("alert('제목을 입력해 주세요.');");
		out.println("insertForm.subject.focus();");
		out.println("return;");
		out.println("}");
		out.println("if(insertForm.content.value=='') {");
		out.println("alert('내용을 입력해 주세요.');");
		out.println("insertForm.content.focus();");
		out.println("return;");
		out.println("}");
		out.println("insertForm.submit();");
		out.println("}");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

}
