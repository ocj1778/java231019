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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
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
	<h1>회원변경</h1>
	<form id="modifyForm">
	<table>
		<tr>
			<th width="100">아이디</th>
			<td width="200"><input type="text" name="id" id="id" value="<%=member.getId()%>" readonly></td>
		</tr>
		<tr>
			<th width="100">이름</th>
			<td width="200"><input type="text" name="name" id="name" value="<%=member.getName()%>"></td>
		</tr>
		<tr>
			<th width="100">전화번호</th>
			<td width="200"><input type="text" name="phone" id="phone" value="<%=member.getPhone()%>"></td>
		</tr>
		<tr>
			<th width="100">이메일</th>
			<td width="200"><input type="text" name="email" id="email" value="<%=member.getEmail()%>"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="submitBtn">입력제출</button>
				<button type="button" id="resetBtn">다시입력</button>
				<button type="button" id="displayBtn">회원목록</button>
			</td>	
		</tr>
	</table>
	</form>	
	
	<script type="text/javascript">
	$("#submitBtn").click(function() {
		if($("#name").val()=="") {
			alert("이름을 입력해 주세요.");
			$("#name").focus();
			return;
		}
		
		if($("#phone").val()=="") {
			alert("전화번호를 입력해 주세요.");
			$("#phone").focus();
			return;
		}
		
		if($("#email").val()=="") {
			alert("이메일을 입력해 주세요.");
			$("#email").focus();
			return;
		}
		
		$("#modifyForm").attr("method", "post").attr("action", "member_modify_action.jsp").submit();
	});
	
	$("#resetBtn").click(function() {
		$("#modifyForm").each(function() {
			this.reset();
		});	
	});
		
	$("#displayBtn").click(function() {
		location.href="member_display.jsp";	
	});
	</script>
</body>
</html>
