<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- fmt(Formatter) 태그 라이브러리의 커스텀 태그를 JSP 문서에서 사용할 수 있도록 설정 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- request.setCharacterEncoding("utf-8"); --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - URL 관리 태그</h1>
	<hr>
	<%-- requestEncoding 태그 : POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋을 변경하는 태그 --%>
	<%-- value 속성 : 변경할 문자형태(CharacterSet)에 대한 인코딩 방식을 속성값으로 설정 --%>
	<fmt:requestEncoding value="utf-8"/>
	
	<c:choose>
		<c:when test="${!empty(param.name) }">
			<p>${param.name }님, 안녕하세요.</p>
		</c:when>
		<c:otherwise>
			<%-- redirect 태그 : 클라이언트에게 URL 주소를 전달하여 재요청하도록 설정하는 태그 --%>
			<%-- => 리다이렉트 이동 --%>
			<%-- url 속성 : 클라이언트에게 전달하여 재요청하기 위한 URL 주소를 속성값으로 설정 --%>
			<c:redirect url="core_redirect_form.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>









