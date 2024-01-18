<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//문제점)스레드가 이동된 JSP 문서에서는 리퀘스트 메세지 몸체부에 저장된 전달값을 읽기 위한
	//문자형태(CharacterSet - Encoding)를 바꾸는 메소드를 호출해도 미동작
	//해결법)요청 JSP 문서에서 리퀘스트 메세지 몸체부의 전달값을 읽기 위한 문자형태를 변경하는
	//메소드 호출
	//request.setCharacterEncoding("utf-8");

	String master=request.getParameter("master");
	
	//문제점)스레드가 이동된 JSP 문서에서는 response 객체로 sendError() 메소드 또는 sendRedirect()
	//메소드를 호출해도 클라이언트에게 에러코드 또는 URL 주소 미전달
	//해결법)sendRedirect() 메소드 대신 자바스크립트를 사용하여 페이지 이동
	/*
	if(master.equals("홍길동(main@itwill.xyz)")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	*/
%>    
<hr>
<p>Copyright © itwill Corp. All rights reserved.</p>
<%-- <p>관리자 : 홍길동(abc@itwill.xyz)</p> --%>
<p>관리자 : <%=master %></p>