<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP 내장객체에 따라 속성값을 저장하여 사용할 수 있는 범위를 다르게 설정 가능
	// => 속성값 사용범위 : Page Scope, Request Scope, Session Scope, Application Scope
	pageContext.setAttribute("pageName", "홍길동");//Page Scope
	request.setAttribute("requestName", "임꺽정");//Request Scope
	session.setAttribute("sessionName", "전우치");//Session Scope
	application.setAttribute("applicationName", "일지매");//Application Scope
	
	//JSP 내장객체가 다른 경우 동일한 속성명으로 속성값 저장 가능
	// => JSP 내장객체가 같은 경우 동일한 속성명으로 속성값을 저장할 경우 기존 속성값 대신
	//새로운 속성값으로 저장 - 변경 처리
	pageContext.setAttribute("name", "홍길동");//Page Scope
	request.setAttribute("name", "임꺽정");//Request Scope
	session.setAttribute("name", "전우치");//Session Scope
	application.setAttribute("name", "일지매");//Application Scope
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Scope Attribute</h1>
	<hr>
	<%-- EL 내장객체 : EL 표현식에서 사용할 수 있도록 기본적으로 제공되는 객체 --%>
	<%-- => pageContext 내장객체를 제외한 나머지 내장객체는 Map 객체 --%>
	<ul>
		<%-- JSP 내장객체에 저장된 속성명이 서로 다른 경우 EL 표현식에서 속성명을 사용해 
		속성값을 제공받아 출력 처리 가능 --%>
		<li>pageName 속성값(Page Scope) = ${pageName }</li>
		<li>requestName 속성값(Request Scope) = ${requestName }</li>
		<li>sessionName 속성값(Session Scope) = ${sessionName }</li>
		<li>applicationName 속성값(Application Scope) = ${applicationName }</li>
	</ul>
	<hr>
	<ul>
		<%-- EL 표현식에서는 속성명에 대한 속성값을 순차적으로 검색하여 출력 처리 --%>
		<%-- => Page Scope >> Request Scope >> Session Scope >> Application Scope --%>
		<%-- JSP 내장객체에 저장된 속성명이 서로 같은 경우 EL 표현식에서 속성명을 사용하면 
		순차적으로 속성값을 제공받아 출력 처리 --%>
		<%-- => JSP 내장객체가 다른 경우에도 속성명을 다르게 설정하는 것을 권장 --%>
		<%-- 
		<li>name 속성값(Page Scope) = ${name }</li>
		<li>name 속성값(Request Scope) = ${name }</li>
		<li>name 속성값(Session Scope) = ${name }</li>
		<li>name 속성값(Application Scope) = ${name }</li>
		--%>
		
		<%-- JSP 내장객체에 저장된 속성명이 서로 같은 경우 EL 내장객체를 사용하여 스코프를
		구분해 속성값을 제공받아 출력 처리 가능 --%>
		<%-- => pageScope, requestScope, sessionScope, applicationScope --%>
		<%-- => 스코프 관련 EL 내장객체는 Map 객체로 맵키 대신 속성명을 사용하여 속성값을 제공받아 출력 처리 --%>
		<li>name 속성값(Page Scope) = ${pageScope.name }</li>
		<li>name 속성값(Request Scope) = ${requestScope.name }</li>
		<li>name 속성값(Session Scope) = ${sessionScope.name }</li>
		<li>name 속성값(Application Scope) = ${applicationScope.name }</li>
	</ul>
</body>
</html>
