<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//session 객체에 저장된 권한 관련 속성값을 객체로 반환받아 저장
	// => null 반환 : 속성값이 없는 경우 - 비로그인 상태의 사용자
	// => MemberDTO 객체 반환 : 속성값이 있는 경우 - 로그인 상태의 사용자
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");
%>    
<div id="profile">
	<% if(loginMember==null) { %>
		<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_login">로그인</a>&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_join">회원가입</a>&nbsp;&nbsp;
	<% } else { %>
		<%=loginMember.getName() %>님, 환영합니다.&nbsp;&nbsp;	
		<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_logout_action">로그아웃</a>&nbsp;&nbsp;
		<% if(loginMember.getMemberStatus()==1) {//로그인 사용자가 일반 사용자인 경우 %>
			<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_mypage">내정보</a>&nbsp;&nbsp;
		<% } else if(loginMember.getMemberStatus()==9) {//로그인 사용자가 관리자인 경우 %>
			<a href="<%=request.getContextPath()%>/index.jsp?group=admin&worker=admin_main">관리자</a>&nbsp;&nbsp;
		<% } %>
	<% } %>
	<a href="<%=request.getContextPath()%>/index.jsp?group=cart&worker=cart_list">장바구니</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/index.jsp?group=review&worker=review_list">제품후기</a>&nbsp;&nbsp;
</div>

<div id="logo"><a href="<%=request.getContextPath()%>/index.jsp">쇼핑몰</a></div>

<div id="menu">
	<a href="#">컴퓨터</a>
	<a href="#">중앙처리장치</a>
	<a href="#">메인보드</a>
	<a href="#">메모리</a>
	<a href="#">기타부품</a>
</div>    
