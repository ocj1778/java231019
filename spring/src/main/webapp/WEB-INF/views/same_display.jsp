<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>출력페이지</h1>
	<hr>
	<%-- forEach 태그에 varStatus 속성으로 반복문의 상태를 저장한 속성명을 속성값으로 설정 --%>
	<%-- => 속성명.index : 반복 처리하는 요소의 첨자(Index - 0부터 시작)를 제공 --%>
	<%-- => 속성명.count : 반복 처리하는 요소의 순서값(1부터 시작)를 제공 --%>
	<c:forEach var="hobby" items="${hobbyList }" varStatus="status">
		<%-- <h2>취미-${status.index+1} : ${hobby }</h2> --%>	
		<h2>취미-${status.count} : ${hobby }</h2>	
	</c:forEach>
</body>
</html>