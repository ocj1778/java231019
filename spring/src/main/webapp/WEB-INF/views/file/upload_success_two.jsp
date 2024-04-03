<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>파일 업로드 성공</h1>
	<hr>
	<h2>업로더 이름 = ${uploaderName }</h2>
	<c:forEach var="filename" items="${filenameList}">
		<h2>업로드 파일명 = ${filename }</h2>
	</c:forEach>
	<hr>
	
	<c:forEach var="filename" items="${filenameList}">
		<img src="<c:url value="/images/upload/${filename}"/>" width="200">
	</c:forEach>
</body>
</html>