<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- 페이지 머릿부 : 로고, 메뉴 등 --%>
	<div id="header">
		<h1><a href="index.jsp">쇼핑몰</a></h1>
		<div id="menu">
			<a href="login.jsp">로그인</a>&nbsp;&nbsp;
			<a href="join.jsp">회원가입</a>&nbsp;&nbsp;
			<a href="cart.jsp">장바구니</a>&nbsp;&nbsp;
			<a href="review.jsp">리뷰게시판</a>&nbsp;&nbsp;
		</div>
	</div>
	
	<%-- 페이지 몸체부 : 요청에 대한 실행 결과 --%>
	<div id="content">
		<h2>메인페이지 - 제품목록</h2>	
	</div>
	
	<%-- 페이지 꼬릿부 : 저작권, 약관, 개인정보 보호정책 등 --%>
	<div id="footer">
		<p>Copyright © Itwill Corp. All rights reserved.</p>
	</div>
</body>
</html>






