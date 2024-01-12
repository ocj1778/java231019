package xyz.itwill.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//JNDI(Java Naming Directory Interface) : WAS 프로그램에 실행될 때 생성되어 WAS 디렉토리에 저장 
//되는 객체를 웹프로그램에서 필요한 경우 WAS 프로그램에 의해 관리되는 객체의 이름을 사용하여  
//객체를 반환받아 사용하기 위한 서비스
// => WAS 프로그램에 의해 생성되어 WAS 디렉토리에 저장될 객체의 정보는 [src/main/webapp/META-INF/context.xml] 
//파일의 엘리먼트(태그)를 이용하여 제공

@WebServlet("/jndi.itwill")
public class JndiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
