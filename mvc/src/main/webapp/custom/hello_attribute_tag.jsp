<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.xyz/mvc/custom"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - AnyAttribute And NoBody</h1>
	<hr>
	<%-- 커스텀 태그의 속성을 생략한 경우 태그 클래스의 생성자에서 설정한 기본값을 태그의 속성값으로 사용 --%>
	<%-- => 커스텀 태그의 속성이 필수 속성인 경우 속성과 속성값이 생략되면 에러 발생 --%>
	<%-- <simple:helloAttribute/> --%>

	<%-- 커스텀 태그의 속성을 사용한 경우 경우 태그 클래스의 Setter 메소드를 자동 호출하여 
	태그 속성값으로 태그 클래스의 필드값을 변경하여 사용 --%>
	<%-- => 태그 클래스의 필드에 대한 Setter 메소드가 없는 경우 에러 발생 --%>
	<simple:helloAttribute name="홍길동"/>
	<simple:helloAttribute name="임꺽정"/>
</body>
</html>