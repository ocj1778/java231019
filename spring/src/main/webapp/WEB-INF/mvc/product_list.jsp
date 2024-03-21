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
	<h1>제품목록</h1>
	<hr>
	<c:forEach var="product" items="${productList }">
		<p>제품번호 = ${product.num }, 제품이름 = ${product.name }</p>
	</c:forEach>
</body>
</html>