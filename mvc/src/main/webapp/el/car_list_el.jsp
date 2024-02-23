<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - List</h1>
	<hr>
	<%-- 스코프 속성값이 List 객체인 경우 EL 표현식에서 요소를 구분하기 위해 . 연산자로 첨자를
	표현하면 ELExcption 발생 - . 연산자 대신 [] 연산자를 사용하여 List 객체의 요소를 구분 --%>
	<%-- <p>모델명 = ${carList[0]["modelName"] }, 색상 = ${carList[0]["carColor"] }</p> --%>
	<p>모델명 = ${carList[0].modelName }, 색상 = ${carList[0].carColor }</p>
	<p>모델명 = ${carList[1].modelName }, 색상 = ${carList[1].carColor }</p>
	<p>모델명 = ${carList[2].modelName }, 색상 = ${carList[2].carColor }</p>
	<p>모델명 = ${carList[3].modelName }, 색상 = ${carList[3].carColor }</p>
	<p>모델명 = ${carList[4].modelName }, 색상 = ${carList[4].carColor }</p>
</body>
</html>