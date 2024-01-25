<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="profile">
	<span style="font-weight: bold;">[관리자님, 환영합니다.]</span>&nbsp;&nbsp;	
	<a href="<%=request.getContextPath()%>/index.jsp?group=member&worker=member_logout_action">로그아웃</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath()%>/index.jsp?group=main&worker=main_page">쇼핑몰</a>&nbsp;&nbsp;
</div>

<div id="logo"><a href="<%=request.getContextPath()%>/index.jsp?group=admin&worker=admin_main">관리자</a></div>

<div id="menu">
	<a href="#">회원관리</a>
	<a href="#">게시글관리</a>
	<a href="#">제품관리</a>
	<a href="#">주문관리</a>
</div>  