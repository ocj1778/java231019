package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)로부터 전달받은 입력값(회원정보)을 반환받아 클라이언트에게 HTML 문서를
//전달하여 응답하는 서블릿
// => 입력페이지의 form 태그를 사용하여 POST 방식으로 요청해야 실행되는 서블릿
@WebServlet("/join.itwill")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//서블릿을 GET 방식으로 요청한 경우 비정상적인 요청으로 클라이언트에게 에러코드(4XX or 5XX)를
		//전달하여 응답하거나 에러페이지로 이동되도록 URL 주소를 전달하여 응답
		//HttpServletRequest.getMethod() : 서블릿을 요청한 요청방식(GET or POST)을 반환하는 메소드
		//System.out.println("요청방식 = "+request.getMethod());
		if(request.getMethod().equals("GET")) {//서블릿을 GET 방식으로 요청한 경우 - 비정상적인 요청
			/*
			//HttpServletResponse.sendError(int sc) : 클라이언트에게 에러코드를 전달하여 응답하는 메소드
			// => 상태코드(StatusCode)는 HttpServletResponse 인터페이스에 상수로 선언되어 제공
			//response.sendError(400);
			//response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			//response.sendError(405);
			response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;//서블릿 종료
			*/
			
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301 상태코드와
			//URL 주소를 전달하는 메소드
			// => 301 상태코드를 전달받은 클라이언트는 응답받은 URL 주소로 브라우저의 요청
			//URL 주소를 변경하여 재요청하여 실행결과를 응답받아 출력 - 페이지 이동(리다이렉트 이동)
			response.sendRedirect("error.html");
			return;
		}
	}

}









