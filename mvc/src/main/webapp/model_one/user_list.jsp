<%@page import="xyz.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="java.util.List"%>
<%@page import="xyz.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- USERINFO 테이블에 저장된 모든 행을 검색하여 회원목록을 응답하는 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => 회원정보에서 [회원이름] 태그를 클릭한 경우 [user_view.jsp] 문서를 요청하여 페이지 이동 - 아이디 전달 --%>
<%-- => [로그아웃] 태그를 클릭한 경우 [user_logout_action.jsp] 문서를 요청하여 페이지 이동 --%>
<%-- => [회원등록] 태그를 클릭한 경우 [user_write.jsp] 문서를 요청하여 페이지 이동 - 관리자에게만 태그 제공 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	//비로그인 상태의 사용자인 경우 - 비정상적인 요청
	if(loginUserinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	List<UserinfoDTO> userinfoList=UserinfoModelOneDAO.getDAO().selectUserinfoList();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
<tr>
	<td width="20"></td>
	<td>
	  	<table width=590 border=0 cellpadding=0 cellspacing=0>
		  	<tr>
				<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 회원목록</b></td>
		  	</tr>
	  	</table>  
	  	<br>
	  
	  	<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  	<tr>
				<td width=190 align=center bgcolor="E6ECDE" height="22">아이디</td>
				<td width=200 align=center bgcolor="E6ECDE">이름</td>
				<td width=200 align=center bgcolor="E6ECDE">이메일</td>
		  	</tr>

			<% for(UserinfoDTO userinfo : userinfoList) { %>		  	
		  	<tr>
				<td width=190 align=center bgcolor="ffffff" height="20">
					<%=userinfo.getUserid() %>
				</td>
				<td width=200 align=center bgcolor="ffffff">
					<a href="user_view.jsp?userid=<%=userinfo.getUserid() %>" class="user">
						<%=userinfo.getName() %>
					</a>
				</td>
				<td width=200 align=center bgcolor="ffffff">
					<% if(userinfo.getEmail()!=null) { %>
						<%=userinfo.getEmail() %>
					<% } %>
				</td>
		  	</tr>
		  	<% } %>
	  	</table>

		<br>
	  	<table border="0" cellpadding="0" cellspacing="1" width="590">
			<tr>
				<td align="right">
					<% if(loginUserinfo.getStatus()==9) { %>
						<button type="button" onclick="location.href='user_write.jsp';">회원등록</button>
					<% } %>
					<input type="button" value="로그아웃" onclick="location.href='user_logout_action.jsp';"/>
				</td>
			</tr>
		</table>		
	</td>
</tr>
</table>  
</body>
</html>