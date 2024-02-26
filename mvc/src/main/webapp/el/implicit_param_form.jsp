<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<form action="implicit_param_action.jsp" method="post">
		<div><b>개인정보</b></div>
		<div>이름 : <input type="text" name="name"></div>	
		<div>주소 : <input type="text" name="address"></div>
		<br>
		<div><b>좋아하는 음식</b></div>
		<div>음식-1 : <input type="text" name="food"></div>	
		<div>음식-2 : <input type="text" name="food"></div>	
		<br>
		<button type="submit">제출</button>	
	</form>
</body>
</html>
