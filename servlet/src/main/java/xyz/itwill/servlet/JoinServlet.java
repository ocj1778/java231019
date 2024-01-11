package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//입력페이지(form.html)로부터 전달받은 입력값(회원정보)을 반환받아 HTML 문서로 만들어 
//클라이언트에게 전달하여 응답하는 서블릿
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
			//[web.xml] 파일에서 error-page 엘리먼트를 사용해 에러코드에 따른 에러페이지를 
			//전달하여 출력하는 기능 제공
			// => 클라이언트의 요청 URL 주소는 변경되지 않고 에러페이지 출력
			//response.sendError(400);
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			//response.sendError(405);
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;//서블릿 종료
			*/
			
			/*
			//HttpServletResponse.sendRedirect(String url) : 클라이언트에게 301 상태코드와
			//URL 주소를 전달하는 메소드
			// => 301 상태코드를 전달받은 클라이언트는 응답받은 URL 주소로 브라우저의 요청
			//URL 주소를 변경하여 재요청해 실행결과를 응답받아 출력 - 페이지 이동(리다이렉트 이동)
			response.sendRedirect("error.html");
			return;
			*/
			
			//클라이언트에게 HTML 문서에 자바스트립트를 저장하여 응답 처리
			// => 경고창을 사용하여 메세지 출력 후 원하는 페이지로 이동 처리
			out.println("<script>");
			out.println("alert('비정상적인 방법으로 페이지를 요청 하였습니다.');");
			out.println("location.href='form.html';");
			out.println("</script>");
			return;
		}
		
		//서블릿을 POST 방식으로 요청한 경우 사용자 입력값을 리퀘스트 메세지의 몸체부에 
		//문서파일에 저장하여 전달
		// => 리퀘스트 메세지의 몸체부에 만들어진 문서파일은 기본적으로 서유럽어(ISO-8859-1)의
		//문자형태로 제공되어 반환
		// => 리퀘스트 메세지의 몸체부에 만들어진 문서파일에 저장된 전달값을 반환받기 전에
		//문서파일의 전달값을 제공받기 위한 문자형태를 변경
		//HttpServletRequest.setCharacterEncoding(String encoding) : 리퀘스트 메세지의 몸체부에 
		//만들어진 문서파일을 제공받기 위한 문자형태를 변경하는 메소드
		// => GET 방식으로 요청한 경우 리퀘스트 메세지의 몸체부를 사용하지 않아 메소드 호출 불필요
		request.setCharacterEncoding("utf-8");
		
		//서블릿을 요청할 때 전달된 값을 반환받아 저장
		//HttpServletRequest.getParameter(String name) : 매개변수로 전달받은 이름의 전달값을
		//문자열(String 객체)로 반환하는 메소드
		// => 매개변수로 전달받은 이름의 전달값이 없는 경우 [null] 반환
		String id=request.getParameter("id");
		/*
		//전달된 값에 대한 검증
		if(id==null || id.equals("")) {//전달값이 없는 경우 - 비정상적인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if(!Pattern.matches("^[a-zA-Z]\\w{5,19}$", id)) {//전달값이 정규표현식의 패턴과 다른 경우 - 비정상적인 요청
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		*/
		String passwd=request.getParameter("passwd");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		//동일한 이름으로 전달되는 값이 여러개 있는 경우 첫번째 전달값만 반환받아 저장
		//String hobby=request.getParameter("hobby");
		//HttpServletRequest.getParameterValues(String name) : 매개변수로 전달받은 이름의 
		//모든 전달값을 문자열(String[])로 반환하는 메소드
		String[] hobby=request.getParameterValues("hobby");
		String job=request.getParameter("job");
		String profile=request.getParameter("profile");
		
		//HTML 문서를 생성하여 클라이언트에게 전달하여 응답
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>"); 
		out.println("<h1>회원가입확인</h1>");
		out.println("<hr>");
		out.println("<p>아이디 = "+id+"</p>");
		out.println("<p>비밀번호 = "+passwd+"</p>");
		out.println("<p>이름 = "+name+"</p>");
		out.println("<p>이메일 = "+email+"</p>");
		out.println("<p>성별 = "+gender+"</p>");
		//out.println("<p>취미 = "+hobby+"</p>");
		out.println("<p>취미 = ");
		for(int i=0;i<hobby.length;i++) {
			out.println(hobby[i]);
			if(i < hobby.length-1) {
				out.println(",");
			}
		} 
		out.println("</p>");
		out.println("<p>직업 = "+job+"</p>");
		//전달값의 엔터(Enter)를 <br> 태그로 변환해야만 줄바꿈 처리되어 출력
		out.println("<p>자기소개 = <br>"+profile.replace("\n", "<br>")+"</p>");
		out.println("</body>");
		out.println("</html>");	
	}

}
