<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Request Scope 속성값을 객체로 반환받아 응답 처리하는 JSP 문서 - 응답 처리하는 웹프로그램(View) --%>
<%-- => 응답 처리하는 프로그램을 요청한 경우 Request Scope 속성값이 없으면 EL 미실행 - NullPointerException 미발생 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>	
	<h1>EL 사용</h1>
	<hr>
	<%-- <p>회원정보 = ${member }</p> --%>
	<p>회원의 이름 = ${member.name }</p>
	<%-- <p>회원의 자동차 = ${member.car }</p> --%>
	<p>회원의 자동차(모델명) = ${member.car.modelName }</p>
	<p>회원의 자동차(색상) = ${member.car.carColor }</p>
	<hr>
	<%-- EL 표현식에서 객체 필드를 . 연산자 대신 [] 연산자로 표현하여 출력 처리 가능 --%>
	<%-- => [] 연산자 안에 반드시 "" 기호('' 기호)를 사용하여 필드명을 작성 --%>
	<p>회원의 이름 = ${member["name"] }</p>
	<p>회원의 자동차(모델명) = ${member["car"]["modelName"] }</p>
	<p>회원의 자동차(색상) = ${member["car"]["carColor"] }</p>
</body>
</html>