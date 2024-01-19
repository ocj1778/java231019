<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//문제점)스레드가 이동된 JSP 문서에서는 리퀘스트 메세지 몸체부에 저장된 전달값을 읽기 위한
	//문자형태(CharacterSet - Encoding)를 바꾸는 메소드를 호출해도 미동작 가능성 존재
	//해결법)요청 JSP 문서에서 리퀘스트 메세지 몸체부의 전달값을 읽기 위한 문자형태를 변경하는
	//메소드 호출 - 스레드가 이동된 JSP 문서에서는 문자형태를 변경하는 메소드 호출 생략 가능 
	//request.setCharacterEncoding("utf-8");

	String master=request.getParameter("master");
	
	//문제점)스레드가 이동된 JSP 문서에서는 response 객체로 sendError() 메소드 또는 sendRedirect()
	//메소드를 호출해도 클라이언트에게 에러코드 또는 URL 주소 미전달
	//해결법)request 내장객체에 에러코드 또는 URL 주소를 속성값으로 저장하여 요청 JSP 문서에 제공
	if(master.equals("홍길동(main@itwill.xyz)")) {
		//response.sendError(HttpServletResponse.SC_BAD_REQUEST);//요청 JSP 문서에게 에러코드 전달
		request.setAttribute("errorCode", HttpServletResponse.SC_BAD_REQUEST);//Request Scope
		return;
	}
%>    
<hr>
<p>Copyright © itwill Corp. All rights reserved.</p>
<%-- <p>관리자 : 홍길동(abc@itwill.xyz)</p> --%>
<p>관리자 : <%=master %></p>