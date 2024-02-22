<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- request 객체의 속성값(회원정보)를 객체로 제공받아 응답하는 JSP 문서 --%>
<%-- => [수정] 태그를 클릭한 경우 [/modifyform.do] 문서를 요청하여 페이지 이동 - 아이디 전달 --%>    
<%-- => [삭제] 태그를 클릭한 경우 [/remove.do] 문서를 요청하여 페이지 이동 - 아이디 전달 --%>    
<%-- => [목록] 태그를 클릭한 경우 [/list.do] 문서를 요청하여 페이지 이동 --%>
<%-- => [수정] 태그와 [삭제] 태그는 관리자에게만 제공 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");

	UserinfoDTO userinfo=(UserinfoDTO)request.getAttribute("userinfo");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="<%=request.getContextPath() %>/model_two/css/user.css" type="text/css">
<script language="JavaScript">
function userRemove(userid) {
	if (confirm("정말로 삭제 하시겠습니까?") ) {
		location.href='<%=request.getContextPath() %>/remove.do?userid='+userid;
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원정보</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getUserid() %>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getName() %>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<% if(userinfo.getEmail()!=null) { %>
					<%=userinfo.getEmail() %>
				<% } %>
			</td>
		  </tr>		  
	  </table>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<% if(loginUserinfo.getStatus()==9) { %>
				<input type="button" value="수정" onClick="location.href='<%=request.getContextPath() %>/modifyform.do?userid=<%=userinfo.getUserid()%>';">
				<input type="button" value="삭제" onClick="userRemove('<%=userinfo.getUserid()%>');">
			<% } %>	
			<input type="button" value="목록" onClick="location.href='<%=request.getContextPath() %>/list.do';"> 
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
</body>
</html>