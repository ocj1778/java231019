<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<form action="same" method="post">
		취미 : 
		<input type="checkbox" name="hobby" value="독서">독서&nbsp;&nbsp;
		<input type="checkbox" name="hobby" value="게임">게임&nbsp;&nbsp;
		<input type="checkbox" name="hobby" value="등산">등산&nbsp;&nbsp;
		<input type="checkbox" name="hobby" value="낚시">낚시&nbsp;&nbsp;
		<button type="submit">제출</button>
	</form>
</body>
</html>