<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib 디렉티브를 사용하여 TLD 파일을 제공받아 TLD 파일에 등록된 EL 함수 또는 커스텀 
태그를 JSP 문서에서 사용하도록 설정 --%>
<%-- taglib Directive : TLD 파일을 제공받아 TLD 파일에 등록된 EL 함수 또는 커스텀 태그를
JSP 문서에서 사용할 수 있도록 제공하는 지시어 --%>
<%-- prefix 속성 : EL 함수 또는 커스텀 태그를 사용하기 위한 접두사(NameSpace)를 속성값으로 설정 --%>
<%-- uri 속성 : TLD 파일을 구분하기 위한 식별자(uri 엘리먼트의 값)을 속성값으로 설정 - 자동 완성 기능 사용 가능 --%>    
<%@taglib prefix="elfun" uri="http://www.itwill.xyz/mvc/el"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL Function</h1>
	<hr>
	<p>EL 함수 : EL 표현식에서 호출하여 사용하기 위한 함수</p>
	<p>EL 표현식에서 EL 함수를 호출하여 사용할 경우 EL 함수 관련 클래스로 객체로 생성하여 
	메소드를 자동 호출해 명령 실행</p>
	<p>EL 함수 관련 클래스(메소드) 선언하고 TLD 파일에 클래스의 메소드를 EL 함수로 등록하고
	JSP 문서에서 taglib 디렉티브를 사용하여 TLD 파일을 제공받아 EL 표현식에서 EL 함수 사용</p>
	<hr>
	<p>${elfun:hello("홍길동") }</p>
	<p>${elfun:hello("임꺽정") }</p>
	<p>${elfun:hello("전우치") }</p>
</body>
</html>









