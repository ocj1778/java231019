package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//JNDI(Java Naming Directory Interface) : WAS 프로그램이 실행될 때 객체를 생성하여 WAS 프로그램에 
//의해 관리되는 객체를 웹프로그램에서 필요한 경우 객체의 이름으로 반환받아 사용하기 위한 서비스
// => WAS 프로그램에 의해 생성되어 저장될 객체의 정보는 [src/main/webapp/META-INF/context.xml] 
//파일의 엘리먼트(태그)를 이용하여 제공

//WAS 프로그램에 의해 생성된 DataSource 객체를 제공받아 DataSource 객체에 저장된 Connection 객체를
//반환받아 Connection 객체의 정보를 HTML 문서로 응답하는 서블릿
@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		try {
			//InitialContext 객체 : JNDI 서버스를 제공하기 위한 객체
			// => WAS 프로그램에 의해 생성되어 관리되는 객체를 제공받기 위한 메소드 제공
			//InitialContext.lookup(String name) : 매개변수로 전달받은 이름의 객체를 반환하는 메소드
			// => 반환되는 객체는 Object 객체이므로 반드시 명시적 객체 형변환하여 사용
			// => 매개변수로 전달받은 이름의 객체가 없는 경우 NamingException 발생 - 예외 처리
			DataSource dataSource=(DataSource)new InitialContext().lookup("java:comp/env/jdbc/oracle");
			
			Connection con=dataSource.getConnection();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>DBCP - JNDI</h1>");
			out.println("<hr>");
			out.println("<p>Connection = "+con+"</p>");
			out.println("</body>");
			out.println("</html>");

			con.close();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
