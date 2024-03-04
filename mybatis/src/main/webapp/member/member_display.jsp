<%@page import="xyz.itwill.dao.MyMemberXMLDAO"%>
<%@page import="xyz.itwill.dto.MyMember"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MyMember> memberList=MyMemberXMLDAO.getDAO().selectMemberList();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
<style type="text/css">
h1 {
	text-align: center;
}

table {
	border: 1px solid black;
	border-collapse: collapse; 
	margin: 0 auto;
}

td, th {
	border: 1px solid black;
	text-align: center;	
}
</style>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<table>
		<tr>
			<th width="140">아이디</th>
			<th width="160">이름</th>
		</tr>	
		
		<% if(memberList.isEmpty()) { %>
		<tr>
			<td colspan="2">검색된 회원정보가 없습니다.</td>
		</tr>
		<% } else { %>
			<% for(MyMember member : memberList) { %>
			<tr>
				<td width="140"><%=member.getId() %></td>
				<td width="160"><%=member.getName() %></td>
			</tr>
			<% } %>
		<% } %>
		<tr>
			<td colspan="2">
				<button type="button" onclick="location.href='member_register_form.jsp';">회원등록</button>
			</td>
		</tr>
	</table>
</body>
</html>










