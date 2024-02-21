<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리하고 [user_login.jsp] 문서를 요청하는 URL 주소를 응답하는 JSP 문서 --%>    
<%
	//session.removeAttribute("loginUserinfo");
	session.invalidate();
	
	response.sendRedirect("user_login.jsp");
%>