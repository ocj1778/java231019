<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 [login_form.jsp] 문서를 요청할 수 있는 URL 주소를 전달하여 응답하는 JSP 문서 --%>
<%-- => 로그아웃 : 세션에서 저장된 권한 관련 정보의 속성값을 삭제 처리 --%>    
<%
	//session.removeAttribute("loginId");

	//session.invalidate() : 세션을 언바인딩 처리한 후 삭제하는 메소드
	session.invalidate();

	response.sendRedirect("login_form.jsp");
%>