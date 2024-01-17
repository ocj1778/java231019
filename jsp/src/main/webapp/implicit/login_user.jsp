<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 상태의 사용자에게 환영메세지를 전달하는 JSP 문서  --%>
<%-- => 비로그인 상태의 사용자가 JSP 문서를 요청한 경우 [login_form.jsp] 문서를 요청할 수 있는
URL 주소를 전달하여 응답 --%>
<%
	//세션에서 권한 관련 정보를 저장한 속성값을 객체로 반환받아 저장
	String loginId=(String)session.getAttribute("loginId");

	if(loginId==null) {//반환받은 속성값이 없는 경우 - 비로그인 상태의 사용자인 경우
		session.setAttribute("msg", "로그인 상태의 사용자만 접근 가능한 페이지입니다.");
		response.sendRedirect("login_form.jsp");
		return;
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>로그인 사용자 전용 페이지</h1>
	<hr>
	<p>
		<%=loginId %>님, 환영합니다.&nbsp;&nbsp;
		<a href="logout_action.jsp">[로그아웃]</a>
		<a href="login_form.jsp">[메인으로]</a>
	</p>
	<hr>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
	<p>로그인 사용자만 확인 가능한 내용입니다.</p>
</body>
</html>
















