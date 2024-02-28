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
	<ul>
		<li>${nameArray[0] }</li>
		<li>${nameArray[1] }</li>
		<li>${nameArray[2] }</li>
		<li>${nameArray[3] }</li>
		<li>${nameArray[4] }</li>
	</ul>
	<hr>
	
	<ul>
	<c:forEach var="i" begin="0" end="4" step="1">
		<li>${nameArray[i] }</li>	
	</c:forEach>
	</ul>
	<hr>

	<%-- forEach 태그를 사용하여 스코프 속성값으로 제공된 배열 또는 콜렉션 객체의 요소를 
	차례대로 제공받아 반복 처리 --%>
	<%-- var 속성 : 배열 또는 콜렉션 객체의 요소값을 제공받아 스코프 속성값으로 저장하기 위한
	이름(속성명)을 속성값으로 설정 --%>
	<%-- items 속성 : 반복 처리할 배열 또는 콜렉션 객체를 속성값으로 설정 --%>
	<%-- => EL을 사용하여 스코프 속성값(배열 또는 콜렉션 객체)을 제공받아 사용 가능 --%>	
	<ul>
	<c:forEach var="name" items="${nameArray }">
		<li>${name}</li>	
	</c:forEach>	
	</ul>
	<hr>
	
	<c:forEach var="student" items="${studentList }">
		<div>학번 = ${student.num }, 이름 = ${student.name }</div>
	</c:forEach>
</body>
</html>
