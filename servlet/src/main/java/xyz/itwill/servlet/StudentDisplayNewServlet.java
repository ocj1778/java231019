package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.itwill.dao.StudentDAO;
import xyz.itwill.dto.StudentDTO;

//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 클라이언트에게 HTML 문서로 응답하는 서블릿
// => DAO 클래스의 메소드를 호출하여 학생정보를 검색하여 결과를 반환받아 응답 처리
@WebServlet("/new.itwill")
public class StudentDisplayNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//STUDENT 테이블에 저장된 모든 학생정보를 검색하여 List 객체로 반환하는 DAO 클래스의 메소드 호출
		List<StudentDTO> studentList=StudentDAO.getDAO().selectStudentList();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>학생목록</h1>");
		out.println("<hr>");
		out.println("<table border='1' cellspacing='0'>");
		out.println("<tr>");
		out.println("<th width='100'>학번</th>");
		out.println("<th width='150'>이름</th>");
		out.println("<th width='200'>전화번호</th>");
		out.println("<th width='300'>주소</th>");
		out.println("<th width='250'>생년월일</th>");
		out.println("</tr>");
		//List 객체에 저장된 요소(StudentDTO 객체)를 차례대로 제공받아 변수에 저장하는 반복문
		for(StudentDTO student : studentList) {
			out.println("<tr>");
			out.println("<td align='center'>"+student.getNo()+"</td>");
			out.println("<td align='center'>"+student.getName()+"</td>");
			out.println("<td align='center'>"+student.getPhone()+"</td>");
			out.println("<td align='center'>"+student.getAddress()+"</td>");
			out.println("<td align='center'>"+student.getBirthday().substring(0, 10)+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
