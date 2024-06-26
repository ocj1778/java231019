<%@page import="java.util.ArrayList"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ids=request.getParameter("ids");//aaa, bbb, ccc

	List<String> idList=null;
	if(ids!=null && !ids.equals("")) {
		idList=new ArrayList<String>();
		for(String id : ids.split(",")) {
			idList.add(id.trim());
		}
	}

	List<MyHewon> hewonList=MyHewonDAO.getDAO().selectMultiIdDynamicHewonList(idList);
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

.id { width: 150px; }
.name { width: 150px; }
.phone { width: 200px; }
.email { width: 200px; }
.status { width: 100px; }
</style>
</head>
<body>
	<h1>회원목록</h1>
	<hr>
	<table>
		<tr>
			<td class="id">아이디</td>
			<td class="name">이름</td>
			<td class="phone">전화번호</td>
			<td class="email">이메일</td>
			<td class="status">공개범위</td>
		</tr>
		<% if(hewonList.isEmpty()) { %>
			<tr>
				<td colspan="5">검색된 회원정보가 없습니다.</td>				
			<tr>		
		<% } else { %>
			<% for(MyHewon hewon : hewonList) { %>
			<tr>
				<td><%=hewon.getId() %></td>
				<td><%=hewon.getName() %></td>
				<td><%=hewon.getPhone() %></td>
				<td><%=hewon.getEmail() %></td>
				<td><%=hewon.getStatus() %></td>
			</tr>
			<% } %>
		<% } %>
	</table>	
	<br>
	
	<form method="post">
		아이디 : <input type="text" name="ids">
		<button type="submit">검색</button>
		<b>[검색하고자 하는 아이디가 여러개인 경우 ,로 구분하여 입력해 주세요.]</b>
	</form>
</body>
</html>
