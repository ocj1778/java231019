<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	String id="";
	if(name!=null && email!=null) {
		MyHewon hewon=new MyHewon();
		hewon.setName(name);
		hewon.setEmail(email);
		
		id=MyHewonDAO.getDAO().selectDtoHewonId(hewon);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NTBATIS</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<form method="post" name="searchForm" id="searchForm">
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">아이디 검색</button>
		</tr>
	</table>	
	</form>
	<hr>
	<% if(name!=null && email!=null) { %>
	<div style="font-weight: bold; color: red;">
		<% if(id==null || id.equals("")) { %>
			<%=name %>님의 아이디가 존재하지 않습니다.
		<% } else { %>
			<%=name %>님의 아이디는 [<%=id %>]입니다.
		<% } %>
	</div>	
	<% } %>
	
	<script type="text/javascript">
	document.getElementById("searchForm").onsubmit=function() {
		if(searchForm.name.value=="") {
			alert("이름을 입력해 주세요.");
			return false;
		}
		
		if(searchForm.email.value=="") {
			alert("이메일을 입력해 주세요.");
			return false;
		}
	}
	</script>	
</body>
</html>









