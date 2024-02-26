<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트로 전달받은 쿠키값을 클라이언트에게 전달하여 응답하는 JSP 문서 --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Cookie</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//클라이언트로부터 전달된 모든 쿠키를 Cookie 객체 배열로 반환받아 저장
		Cookie[] cookies=request.getCookies();
		String userName="";//쿠키값을 저장하기 위한 변수
		//Cookie 객체 배열의 요소값(Cookie 객체)를 차례대로 제공받아 변수에 저장하여 반복 처리
		for(Cookie cookie : cookies) {
			//Cookie 객체에 저장된 쿠키명을 반환받아 문자열과 비교하여 같은 경우
			if(cookie.getName().equals("userName")) {
				userName=cookie.getValue();//Cookie 객체에 저장된 쿠키값을 반환받아 저장
			}
		}
	%>
	<p>쿠키에 저장된 이름 = <%=userName %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- EL 표현식에서 cookie 내장객체를 사용하여 클라이언트에서 보내온 쿠키값을 제공받아 
	출력 처리 가능 --%>
	<%-- => cookie 내장객체는 Map 객체로 맵키 대신 쿠키명을 사용하여 Cookie	객체를 제공받아 
	value 이름으로 쿠키값 출력 처리 --%>
	<%-- <p>쿠키에 저장된 사용자 이름 = ${cookie.userName } --%>	
	<p>쿠키에 저장된 사용자 이름 = ${cookie.userName.value }	
</body>
</html>
