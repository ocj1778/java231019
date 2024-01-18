<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>include Directive</h1>
	<hr>
	<p>웹자원의 경로를 제공받아 웹자원의 소스코드를 JSP 문서에 포함하는 지시어 - 정적포함</p>
	<hr>
	<%--
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p> 
	<p>클라이언트에 응답될 아주 중요한 내용입니다.</p>
	--%> 
	
	<%-- include 디렉티브의 file 속성에 서버 자원의 컨텍스트 경로를 속성값으로 설정 --%>
	<%-- => file 속성값으로 설정된 파일의 소스코드를 현재 위치에 포함되도록 지시 --%>
	<%-- => file 속성값으로 설정된 파일이 없는 경우 에러 발생 --%>
	<%@include file="/directive/include_sub.jspf" %>
</body>
</html>
