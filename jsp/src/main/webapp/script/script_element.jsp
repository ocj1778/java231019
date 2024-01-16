<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>스크립트 요소(Script Element)</h1>
	<hr>
	<p>스크립틀릿(Scriptlet) : JSP 문서에서 Java 명령을 작성하는 영역을 표현하기 위한 스크립트
	요소(요청 처리 메소드의 명령) - &lt;% Java 명령; Java 명령; ... %&gt;</p>
	<p>선언문(Declaration) : JSP 문서에서 필드 또는 메소드를 선언하는 영역을 표현하기 위한 
	스크립트 요소(서블릿 클래스의 필드 또는 메소드) - &lt;%! 필드 또는 메소드 선언 %&gt;</p>
	<p>표현식(Expression) : JSP 문서에서 Java 명령으로 발생되는 결과값을 출력하는 영역을
	표현하기 위한 스크립트 요소(요청 처리 메소드의 명령) - &lt;%={변수명|연산식|메소드호출}%&gt;
</body>
</html>