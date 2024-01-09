package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션(Annotation) : 프로그램 실행에 보조적인 기능을 제공하기 위한 자료형(Interface)

//@WebServlet : 서블릿 클래스를 서블릿으로 등록하고 URL 패턴을 매핑하기 위한 어노테이션
// => [web.xml] 파일의 servlet 엘리먼트와 servlet-mapping 엘리먼트로 제공되는 기능과 동일
//@WebServlet 어노테이션 속성을 사용하여 서블릿의 이름과 URL 패턴을 매핑 설정
// => name 속성 : 서블릿의 이름을 속성값으로 설정 - 속성을 생략을 생략하면 클래스의 이름을 서블릿의 이름으로 자동 설정
// => value 속성 : 서블릿을 요청하기 위한 URL 패턴을 속성값으로 설정 - 속성 생략 불가능
// => value 속성외에 다른 속성이 없는 경우 속성값만 설정 가능
//@WebServlet(name = "first", value = "/first.itwill")
@WebServlet("/first.itwill")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//클라이언트 요청에 의해 자동 호출되는 메소드 - 요청 처리 메소드
	// => 클라이언트 요청에 대한 처리 명령과 처리결과를 저장한 응답파일을 생성하는 명령 작성 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트 요청에 대한 처리결과를 저장하기 위한 파일형태 변경 및 응답파일을 생성하기
		//위한 출력스트림을 반환받아 저장
		// => 클라이언트에게 응답파일 대신 URL 주소로 응답할 경우 생략 가능
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//요청에 대한 처리 명령 작성
		// => 서블릿은 모든 클라이언트에게 일관성 있는 처리 결과를 동적으로 생성하여 제공
		//서버 플렛폼의 현재 날짜와 시간이 저장된 Date 객체를 생성하여 저장
		Date now=new Date();
		
		//날짜와 시간의 패턴정보를 저장한 SimpleDateFormat 객체를 생성하여 저장
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		//SimpleDateFormat 객체로 format() 메소드를 호출하요 매개변수로 전달받은 Date 객체를
		//SimpleDateFormat 객체에 저장된 패턴의 문자열로 반환받아 저장
		String displayNow=dateFormat.format(now);
		
		//처리결과로 응답파일 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Servlet</title>");
		out.println("<style>");
		out.println("p {");
		out.println("width: 600px;");
		out.println("margin: 0 auto;");
		out.println("padding: 30px 0;");
		out.println("font-size: 2em;");
		out.println("font-weight: bold;");
		out.println("text-align: center;");
		out.println("border: 2px solid black;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>서블릿 시계</h1>");
		out.println("<hr>");
		out.println("<p>"+displayNow+"</p>");
		out.println("<script>");
		out.println("setInterval(function() {");
		out.println("location.reload();");
		out.println("}, 1000);");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}
}
