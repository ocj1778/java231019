<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 상태의 사용자 정보(회원정보)를 전달하여 응답하는 JSP 문서 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%--
	//session 객체에 저장된 권한 관련 속성값을 MemberDTO 객체로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
	
	//비로그인 상태의 사용자가 JSP 문서를 요청한 경우에 대한 응답 - 비정상적인 요청
	if(loginMember==null) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}
--%>
<%@include file="/security/login_check.jspf" %>
<style type="text/css">
#detail {
	width: 500px;
	margin: 0 auto;
	text-align: left;
}

#link {
	font-size: 1.em;
}

#link a:hover {
	color: white;
	background: black;
}
</style>    
<h1>내정보</h1>
<div id="detail">
	<p>아이디 = <%=loginMember.getId() %></p>	
	<p>이름 = <%=loginMember.getName() %></p>	
	<p>이메일 = <%=loginMember.getEmail() %></p>	
	<p>전화번호 = <%=loginMember.getMobile() %></p>	
	<p>주소 = [<%=loginMember.getZipcode() %>]<%=loginMember.getAddress1() %> <%=loginMember.getAddress2() %></p>	
	<p>회원가입날짜 = <%=loginMember.getJoinDate() %></p>	
	<p>마지막 로그인 날짜 = <%=loginMember.getLastLogin() %></p>	
</div>

<div id="link">
	<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=password_confirm&action=modify">[회원정보변경]</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=password_confirm&action=remove">[회원탈퇴]</a>&nbsp;&nbsp;
</div>
