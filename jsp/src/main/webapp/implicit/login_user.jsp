<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인 상태의 사용자에게 환영메세지를 전달하는 JSP 문서  --%>
<%-- => 비로그인 상태의 사용자가 JSP 문서를 요청한 경우 [login_form.jsp] 문서를 요청할 수 있는
URL 주소를 전달하여 응답 --%>
<%-- => [로그아웃] 태그를 클릭한 경우 [logout_action.jsp] 문서를 요청하여 페이지 이동 --%>
<%-- => [메인으로] 태그를 클릭한 경우 [login_form.jsp] 문서를 요청하여 페이지 이동 --%>
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
	<hr>
	<%-- 상대경로를 사용하여 웹자원을 제공받아 사용 --%>
	<%-- => 상대경로 : 요청 JSP 문서의 디렉토리를 기준으로 웹자원의 경로를 표현 --%>
	<%-- => 웹자원의 경로를 잘못 작성한 경우 404 에러코드 발생 가능 --%>
	<img alt="코알라" src="../images/Koala.jpg" width="200">
	
	<%-- 절대경로를 사용하여 웹자원을 제공받아 사용 - 권장 --%>
	<%-- => 절대경로 : 최상위 디렉토리를 기준으로 웹자원의 경로를 표현 --%>
	<%-- => URL 주소는 서버 디렉토리를 최상위 디렉토리로 인식하여 처리하고 컨텍스트 경로는
	컨텍스트 폴더를 최상위 디렉토리로 인식하여 처리 --%>
	<%-- 문제점)컨텍스트 폴더의 이름이 변경되면 URL 주소가 변경돼 404 에러코드 발생 --%>
	<img alt="코알라" src="/jsp/images/Koala.jpg" width="200">
	
	<%-- 해결법)컨텍스트 폴더의 경로를 반환하는 메소드를 호출하여 URL 주소 작성 --%>
	<%-- request.getContextPath() : JSP 문서의 컨텍스트 폴더의 경로를 반환하는 메소드 --%>
	<img alt="코알라" src="<%=request.getContextPath() %>/images/Koala.jpg" width="200">
	<% System.out.println("request.getContextPath() = "+request.getContextPath()); %>
</body>
</html>
