<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- functions 태그 라이브러리를 JSP 문서에 포함 - 접두사로 [fn] 사용 --%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Functions - EL 함수</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 = ${phone }</p>
	<hr>
	
	<%-- split 함수 : 매개변수로 전달받은 속성값(문자열)을 구분 문자열로 분리하여 배열로 반환하는 함수 --%>
	<c:set var="array" value="${fn:split(phone, '-') }"/>
	<c:forEach var="num" items="${array }">
		<div>${num }</div>
	</c:forEach>
	<hr>
	
	<%-- substring 함수 : 매개변수로 전달받은 속성값(문자열)을 시작첨자(첨자 위치의 문자 포함)와 
	종료첨자(첨자 위치의 문자 미포함)로 분리하여 문자열로 반환하는 함수 --%>
	<div>${fn:substring(phone, 0, 3) }</div>
	<div>${fn:substring(phone, 4, 8) }</div>
	<div>${fn:substring(phone, 9, 13) }</div>
	<hr>
	
	<c:set var="content" value="안녕하세요.\n반갑습니다."/>
	<div>${content }</div>
	<%-- replace 함수 : 매개변수로 전달받은 속성값(문자열)에서 검색 문자열을 찾아 치환 문자열로
	변경하여 변경된 문자열을 반환하는 메소드 --%>
	<div>${fn:replace(content, '\\n', '<br>') }</div>
	<hr>
	
	<c:set var="html" value="<font size='7' color='red'>안녕하세요.</font>"/>
	<%-- EL 표현식에서 HTML 태그가 포함된 문자열(속성값)을 제공받아 출력 처리하면 HTML 태그가
	동작되어 출력 처리 - XSS 공격에 취약 --%>
	<div>${html }</div>
	
	<%-- out 태그를 사용하여 HTML 태그가 포함된 문자열을 출력 처리하면 HTML 태그도 문자값으로
	출력 처리 - XSS 공격에 대한 방어 기술 --%>
	<div><c:out value="${html }"/></div>

	<%-- escapeXml 함수를 사용하면 HTML 태그가 포함된 문자열(속성값)을 제공받아 출력 처리하면 
	HTML 태그도 문자값으로 출력 처리 - XSS 공격에 대한 방어 기술 --%>
	<div>${fn:escapeXml(html) }</div>
</body>
</html>
