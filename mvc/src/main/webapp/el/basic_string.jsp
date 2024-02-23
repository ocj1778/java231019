<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String attributeName, Object attributeValue)
	// => pageContext 내장객체에 속성명(문자열)과 속성값(객체)를 전달받아 저장하는 메소드 - Page Scope
	//Page Scope : 속성값을 저장한 웹프로그램에서만 속성값을 객체로 제공받아 사용 가능
	pageContext.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>스코프(Scope) 객체의 속성값으로 저장된 객체를 제공받아 출력 처리하기 위한 언어</p>
	<p>스코프 객체 : 객체를 속성값으로 저장할 수 있는 JSP 내장객체 - pageContext, request, session, application</p> 
</body>
</html>