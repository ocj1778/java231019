<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원정보변경</h1>
	<hr>
	<form action="hewon_update" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${hewon.id }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${hewon.name }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${hewon.email }"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">변경</button></td>
		</tr>
	</table>		
	</form>
</body>
</html>