<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 내장객체에 저장된 속성값을 반환받아 클라이언트에게 응답하는 JSP 문서 --%>
<%
	//request 내장객체에 [hewon] 이름의 속성값이 없는 경우 - 비정상적인 요청
	if(request.getAttribute("hewon")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>회원정보확인</h1>
	<hr>
	<jsp:useBean id="hewon" class="xyz.itwill.bean.HewonBean" scope="request"/>
	<%--
		//useBean 태그와 동일한 기능을 제공하는 명령
		// => request 내장객체의 속성값을 HewonBean 객체로 반환받아 저장 
		HewonBean hewon=(HewonBean)request.getAttribute("hewon");
	--%>

	<%-- getProperty Tag : useBean 태그로 제공된 객체의 필드값을 반환하기 위한 태그 --%>
	<%-- => useBean 태그에 종속된 태그 --%>
	<%-- => 객체 필드에 대한 Getter 메소드를 호출하여 필드값을 반환하는 기능과 동일 --%>
	<%-- 형식) <jsp:getProperty name="식별자" property="필드명"></jsp:setProperty> --%>
	<%-- name 속성 : useBean 태그로 제공되는 객체의 식별자(id 속성값)를 속성값을 설정 --%>
	<%-- property 속성 : 필드값을 반환하기 위한 필드명을 속성값으로 설정 --%>
	<%-- => 속성값으로 설정된 필드명으로 작성된 Getter 메소드를 자동 호출 - 필드명으로 작성된 
	Getter 메소드가 없는 경우 에러 발생 --%>
	<p>이름 = <jsp:getProperty name="hewon" property="name"/></p>
	<p>전화번호 = <jsp:getProperty name="hewon" property="phone"/></p>
	<p>주소 = <jsp:getProperty name="hewon" property="address"/></p>
	<%-- 
		<p>이름 = <%=hewon.getName() %></p>
		<p>전화번호 = <%=hewon.getPhone() %></p>
		<p>주소 = <%=hewon.getAddress() %></p>
	--%>	
</body>
</html>
