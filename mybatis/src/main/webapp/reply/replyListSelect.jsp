<%@page import="xyz.itwill.dao.MyReplyDAO"%>
<%@page import="xyz.itwill.dto.MyReply"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyReply> replyList=MyReplyDAO.getDAO().selectReplyList();
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
.content { width: 300px; }
.date { width: 200px; }
.comment { width: 100px; }
</style>
</head>
<body>
	<h1>댓글목록</h1>
	<hr>
	<table>
		<tr>
			<td class="no">댓글번호</td>
			<td class="name">댓글작성자</td>
			<td class="content">댓글내용</td>
			<td class="date">댓글작성일</td>
			<td class="comment">게시글번호</td>
		</tr>
		<% for(MyReply reply : replyList) { %>
		<tr>
			<td><%=reply.getReplyNo() %></td>
			<td><%=reply.getReplyId() %></td>
			<td><%=reply.getReplyContent() %></td>
			<td><%=reply.getReplyDate() %></td>
			<td><%=reply.getReplyCommentNo() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>