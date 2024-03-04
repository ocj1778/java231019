<%@page import="xyz.itwill.dao.MyMemberXMLDAO"%>
<%@page import="xyz.itwill.dto.MyMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=request.getParameter("id");

	MyMember member=MyMemberXMLDAO.getDAO().selectMember(id);
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
	<h1>회원정보</h1>
	<table>
		<tr>
			<th width="100">아이디</th>
			<td width="200"><%=member.getId() %></td>
		</tr>
		<tr>
			<th width="100">이름</th>
			<td width="200"><%=member.getName() %></td>
		</tr>
		<tr>
			<th width="100">전화번호</th>
			<td width="200"><%=member.getPhone() %></td>
		</tr>
		<tr>
			<th width="100">이메일</th>
			<td width="200"><%=member.getEmail() %></td>
		</tr>
		<tr style="text-align: right;">
			<td colspan="2">
				<button type="button" onclick="location.href='member_modify_form.jsp?id=<%=member.getId()%>';">회원변경</button>
				<button type="button" onclick="location.href='member_remove_action.jsp?id=<%=member.getId()%>';">회원삭제</button>
				<button type="button" onclick="location.href='member_display.jsp';">회원목록</button>
			</td>
		</tr>
	</table>
</body>
</html>
