<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리 후 [/main/main_page.jsp] 문서를 요청할 수 있는 URL 주소를 전달하여 응답하는 JSP 문서 --%>
<%
	//로그아웃 처리 => session 객체에 저장된 권한 관련 정보의 속성값 삭제
	session.removeAttribute("loginMember");
	//session.invalidate();
	
	request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=main&worker=main_page");
%>