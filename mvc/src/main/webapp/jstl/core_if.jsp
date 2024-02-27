<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - 흐름 제어 태그</h1>
	<hr>
	<%-- if 태그 : 조건에 대한 결과로 태그내용의 포함 유무를 선택하기 위한 태그 --%>
	<%-- test 속성 : false 또는 true 중 하나를 속성값으로 설정 --%>
	<%-- => test 속성값이 [false]인 경우 태그내용을 포함하지 않고 [true]인 경우에만 태그내용 포함하여 처리 --%>
	<c:if test="true">
		<p>test 속성값이 [true]인 경우 태그내용 출력-1</p>
	</c:if>
	<c:if test="false">
		<p>test 속성값이 [true]인 경우 태그내용 출력-2</p>
	</c:if>
	
	<c:set var="result" value="true"/>
	<%-- test 속성값으로 EL를 사용해 스코프 속성값을 제공받아 설정 가능 --%>
	<c:if test="${result }">
		<p>test 속성값이 [true]인 경우 태그내용 출력-3</p>
	</c:if>
	<hr>
	
	<c:set var="num" value="10"/>
	<%-- test 속성값으로 EL 사용시 EL 표현식에서 EL 연산자를 사용해 [false] 또는 [true] 중
	하나를 제공받아 설정 가능 --%>
	<c:if test="${num % 2 != 0}">${num } = 홀수</c:if>
	<c:if test="${num % 2 == 0}">${num } = 짝수</c:if>
	<br>
	<c:set var="num" value="11"/>
	<c:if test="${num mod 2 ne 0}">${num } = 홀수</c:if>
	<c:if test="${num mod 2 eq 0}">${num } = 짝수</c:if>
	<hr>
	
	<c:set var="score" value="80"/>
	<c:if test="${score <= 100 && score >= 0}">${score }점은 정상적인 점수입니다.</c:if>
	<c:if test="${score > 100 || score < 0}">${score }점은 비정상적인 점수입니다.</c:if>
	<br>
	<c:set var="score" value="800"/>
	<c:if test="${score le 100 and score ge 0}">${score }점은 정상적인 점수입니다.</c:if>
	<c:if test="${score gt 100 or score lt 0}">${score }점은 비정상적인 점수입니다.</c:if>
	<hr>
	
	<c:set var="name" value="홍길동"/>
	<c:if test="${empty(name) }">
		<p>name 속성명으로 저장된 속성값이 없거나 비어 있습니다.</p>
	</c:if>
		
	<c:if test="${!empty(name) }">
		<p>name 속성명으로 저장된 속성값은 [${name }] 입니다.</p>
	</c:if>
</body>
</html>
