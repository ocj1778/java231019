<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<c:choose>
		<c:when test="${!empty(param.score) }">
			<p>입력점수 = ${param.score }점</p>
			<c:choose>
				<c:when test="${param.score le 100 and param.score ge 90}">
					<c:set var="grade" value="A"/>
				</c:when>
				<c:when test="${param.score le 89 and param.score ge 80}">
					<c:set var="grade" value="B"/>
				</c:when>
				<c:when test="${param.score le 79 and param.score ge 70}">
					<c:set var="grade" value="C"/>
				</c:when>
				<c:when test="${param.score le 69 and param.score ge 60}">
					<c:set var="grade" value="D"/>
				</c:when>
				<c:otherwise>
					<c:set var="grade" value="F"/>
				</c:otherwise>
			</c:choose>
			<p>${param.score }점은 ${grade } 학점입니다.</p>
		</c:when>
		<c:otherwise>
			<p style="color: red;">입력페이지에서 점수를 반드시 입력해 주세요.</p>
			<a href="core_choose_form.jsp">입력페이지 이동</a>
		</c:otherwise>
	</c:choose>
</body>
</html>


