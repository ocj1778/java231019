<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>표준 액션 태그(Standard Action Tag)</h1>
	<hr>
	<p>Java 명령으로 구현해야 하는 기능을 표준 액션 태그로 제공
	- HTML 태그와 구분하기 위해 [jsp] 네임스페이스(NameSpace) 사용 : JSP 태그</p>
	<hr>
	<p>include 태그 : JSP 문서의 스레드를 다른 JSP 문서로 이동하여 실행된 결과(웹문서)를
	제공받아 태그를 사용한 위치에 포함하는 태그</p>
	<p>forward 태그 : JSP 문서의 스레드를 다른 JSP 문서로 이동하여 실행된 결과(웹문서)를
	클라이언트에게 전달하여 응답하는 태그</p>
	<p>param 태그 : JSP 문서에서 스레드가 이동된 JSP 문서로 값을 전달하기 위한 태그
	- include 태그와 forward 태그의 하위태그로 실행</p>
	<p>useBean 태그 : JSP 문서에서 사용할 수 있는 객체를 제공하기 위한 태그
	- 내장객체에 저장된 속성값을 반환받아 제공하거나 새로운 객체를 생성하여 제공</p>
	<p>setProperty 태그 : useBean 태그로 제공된 객체의 필드값을 변경하기 위한 태그
	(Setter 메소드 호출) - useBean 태그의 종속태그</p>
	<p>getProperty 태그 : useBean 태그로 제공된 객체의 필드값을 반환하기 위한 태그
	(Getter 메소드 호출) - useBean 태그의 종속태그</p> 
</body>
</html>
