package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//클라이언트에게 쿠키를 전달하여 저장하고 처리결과를 HTML 문서로 응답하는 서블릿
// => 서블릿에서 쿠키를 생성하여 클라이언트에게 전달하면 클라이언트는 전달된 쿠키를 저장
//쿠키(Cookie) : 서버(웹프로그램)와 클라이언트(브라우저)의 연결 지속성을 제공하기 위한 정보를
//클라이언트에 저장하는 문자값
// => 클라이언트에는 접속 서버의 정보를 식별자로 하여 다수의 쿠키 저장
@WebServlet("/create.itwill")
public class CookieCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//Cookie 클래스를 사용하여 객체 생성
		// => Cookie 객체 : 쿠키 관련 정보를 저장하기 위한 객체
		// => Cookie(String name, String value) 생성자를 사용하여 Cookie 객체 생성
		// => name : 쿠키명(쿠키값을 구분하기 위한 식별자), value : 쿠키값(연결 지속성을 제공하기 위한 문자값)
		Cookie idCookie=new Cookie("id", "abc123");
		Cookie countCookie=new Cookie("count", "0");
		
		//클라이언트에 전달되어 저장될 쿠키의 유지시간 변경
		//Cookie.setMaxAge(int expiry) : 매개변수로 전달된 시간(초)만큼 쿠키의 유지시간을 변경하는 메소드
		// => Cookie 객체의 유지시간을 변경하지 않은 경우 기본값은 [-1]로 설정
		countCookie.setMaxAge(24*60*60);//클라이언트에서 쿠키를 하루동안 유지되도록 설정
		
		//클라이언트에게 Cookie 객체를 전달하여 쿠키가 클라이언트에 저장되도록 설정
		// => Cookie 객체의 유지시간이 [-1]로 설정된 쿠키는 클라이언트 브라우저 메모리에 저장 - 브라우저가 종료되면 자동 소멸 
		// => Cookie 객체의 유지시간이 [-1]이 아닌 쿠키는 클라이언트에 파일로 저장 - 유지시간 경과후 자동 소멸 
		//HttpServletResponse.addCookie(Cookie cookie) : 매개변수로 전달받은 Cookie 객체를
		//클라이언트에 전달되어 저장되도록 리스폰즈 메세지에 저장하는 메소드
		response.addCookie(idCookie);
		response.addCookie(countCookie);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>쿠키 생성</h1>");
		out.println("<hr>");
		out.println("<p>네 안에 쿠키 있다.</p>");
		out.println("<hr>");
		out.println("<p><a href='use.itwill'>쿠키 사용</p>");
		out.println("</body>");
		out.println("</html>");
	}
}
