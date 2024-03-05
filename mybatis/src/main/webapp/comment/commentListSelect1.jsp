<%@page import="xyz.itwill.dao.MyCommentDAO"%>
<%@page import="xyz.itwill.dto.MyComment1"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyComment1> commentList=MyCommentDAO.getDAO().selectCommentList1();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse; 
}

td {
	border: 1px solid black;
	text-align: center;
	padding: 3px;	
}

.no { width: 100px; }
.name { width: 150px; }
.content { width: 250px; }
.date { width: 200px; }
</style>
</head>
<body>
	<h1>게시글 목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">게시글번호</td>
			<td class="name">게시글작성자</td>
			<td class="content">게시글내용</td>
			<td class="date">게시글작성일</td>
		</tr>
		<% for(MyComment1 comment : commentList) { %>
		<tr>
			<td><%=comment.getCommentNo() %></td>
			<td><%=comment.getCommentId() %></td>
			<td><%=comment.getCommentContent() %></td>
			<td><%=comment.getCommentDate() %></td>
		</tr>
		<% } %>
	</table>	
</body>
</html>
