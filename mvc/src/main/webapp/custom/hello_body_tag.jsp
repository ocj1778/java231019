<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - AnyAttribute And AnyBody</h1>
	<hr>
	<simple:helloBody test="true">홍길동</simple:helloBody>
	<simple:helloBody test="false">임꺽정</simple:helloBody>
	<hr>
	<%
		String name="전우치";
		request.setAttribute("name", "일지매");
	%>
	<simple:helloBody test="true"><%=name %></simple:helloBody>
	<simple:helloBody test="false">${name }</simple:helloBody>
	<hr>
	<%
		boolean result=true;
		request.setAttribute("result", false);
	%>
	<simple:helloBody test="<%=result %>">장길산</simple:helloBody>
	<simple:helloBody test="${result }">홍경래</simple:helloBody>
</body>
</html>
