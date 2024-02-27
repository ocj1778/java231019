<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Context Init Parameter</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%-- application.getInitParameter(String name) : [web.xml] 파일의 context-param 엘리먼트로
	제공되는 값을 얻어와 반환하는 메소드 --%>
	<%-- => --%>
	<%-- <p>이름 = <%=application.getInitParameter("name") %></p> --%>
	<%-- application 이름의 JSP 내장객체에는 ServletContext 객체가 저장 --%>
	<p>이름 = <%=request.getServletContext().getInitParameter("name") %></p>
	<hr>
	<h2>EL 사용</h2>	
	<%-- EL 표현식에서 initParam 내장객체를 사용하여 [web.xml] 파일의 context-param 엘리먼트로
	제공되는 값을 반환받아 출력 처리 가능 --%>
	<%-- => initParam 내장객체는 Map 객체로 맵키 대신 param-name 엘리먼트의 이름을 사용하여 
	param-value 엘리먼트의 값을 제공받아 출력 처리 --%>
	<p>이름 = ${initParam.name}</p>
</body>
</html>