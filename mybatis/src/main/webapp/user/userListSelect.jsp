<%@page import="xyz.itwill.dao.MyUserDAO"%>
<%@page import="xyz.itwill.dto.MyUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyUser> userList=MyUserDAO.getDAO().selectUserList();
	//System.out.println("userList.size() = "+userList.size());
	//System.out.println("userList.get(0) = "+userList.get(0));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<ul>
	<% for(MyUser user : userList) { %>
		<li>아이디 = <%=user.getUserId() %>, 이름 = <%=user.getUserName() %></li>
	<% } %>
	</ul>
</body>
</html>