<%@page import="xyz.itwill.dto.MyUser"%>
<%@page import="xyz.itwill.dao.MyUserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MyUserDAO.getDAO().insertUser(new MyUser("abc123","홍길동"));
	MyUserDAO.getDAO().insertUser(new MyUser("opq456","임꺽정"));
	MyUserDAO.getDAO().insertUser(new MyUser("xyz789","전우치"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보가 성공적으로 삽입 되었습니다.</h3>
</body>
</html>