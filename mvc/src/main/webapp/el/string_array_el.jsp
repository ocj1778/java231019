<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Array</h1>
	<hr>
	<%-- <p>${nameArray }</p> --%>
	<ul>
		<%-- 스코프 속성값이 배열인 경우 배열 요소값을 제공받아 출력하기 위해 첨자 사용 --%>
		<%-- => EL 표현식에서 . 연산자로 배열의 첨자를 표현하면 ELException 발생 --%>
		<%-- <li>${nameArray.0 }</li> --%>
		
		<%-- 배열의 요소값을 제공받아 출력하기 위해 EL 표현식으로 [] 연산자를 사용 --%>
		<%-- <li>${nameArray["0"] }</li> --%>
		<%-- EL 표현식에서 배열의 첨자를 표현할 때 "" 기호 생략 가능 --%>
		<li>${nameArray[0] }</li>
		<li>${nameArray[1] }</li>
		<li>${nameArray[2] }</li>
		<li>${nameArray[3] }</li>
		<li>${nameArray[4] }</li>
	</ul>
</body>
</html>
