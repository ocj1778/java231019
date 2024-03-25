<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<form action="join" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${hewon.id }"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd" value="${hewon.passwd }"></td>
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
			<td colspan="2"><button type="submit">회원등록</button></td>
		</tr>
	</table>		
	</form>
	<p style="color: red;">${message}</p>
</body>
</html>