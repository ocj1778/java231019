<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>객체의 사용범위(Scope)</h1>
	<hr>
	<p>JSP 문서에서 생성된 객체를 내장객체의 속성값으로 저장하여 다른 JSP 문서에서 속성값을 객체로
	반환받아 사용할 수 있는 범위 - 내장객체에 따라 저장된 속성값의 사용범위가 다르게 설정</p>
	<hr>
	<p>page Scope : pageContext 내장객체를 이용하여 객체를 속성값으로 저장
	- 객체를 속성값으로 저장한 JSP 문서에서만 속성값을 객체로 반환받아 사용 가능</p>
	<p>request Scope : request 내장객체를 이용하여 객체를 속성값으로 저장
	- 객체를 속성값으로 저장한 JSP 문서와 스레드가 이동된 JSP 문서에서 속성값을 객체로 
	반환받아 사용 가능</p>
	<p>session Scope : session 내장객체를 이용하여 객체를 속성값으로 저장
	- 같은 세션이 바인딩된 모든 JSP 문서에서 속성값을 객체로 반환받아 사용 가능</p>
	<p>application Scope : application 내장객체를 이용하여 객체를 속성값으로 저장
	- 모든 JSP 문서에서 속성값을 객체로 반환받아 사용 가능</p>
	<hr>
	<p>내장객체를 이용하여 객체를 속성값으로 저장하는 메소드
	- implicitObject.setAttribute(String attributeName, Object attributeValue)</p>
	<p>내장객체에 저장된 속성값을 객체로 반환하는 메소드
	- implicitObject.getAttribute(String attributeName)</p>
	<p>내장객체에 저장된 속성값을 삭제하는 메소드
	- implicitObject.removeAttribute(String attributeName)</p>
</body>
</html>
