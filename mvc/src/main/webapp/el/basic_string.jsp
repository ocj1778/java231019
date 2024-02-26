<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String attributeName, Object attributeValue)
	// => pageContext 내장객체에 속성명(문자열)과 속성값(객체)를 전달받아 저장하는 메소드 - Page Scope
	//Page Scope : 속성값을 저장한 웹프로그램에서만 속성값을 객체로 제공받아 사용 가능
	pageContext.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>스코프의 속성값으로 저장된 객체를 제공받아 출력 처리하기 위한 언어</p>
	<p>스코프(Scope) : 객체를 속성값으로 저장하여 사용할 수 있는 범위 - JSP 내장객체에 따라 
	속성값의 사용범위가 다르게 설정 : pageContext(PageScope), request(RequestScope)
	, session(SessionScope), application(ApplicationScope)</p>
	<hr>
	<h2>EL 미사용</h2>
	<% 
		//pageContext.getAttribute(String attributeName) : pageContext 내장객체에 저장된 속성값을
		//속성명을 이용하여 객체로 반환하는 메소드
		// => Object 타입의 객체로 반환하므로 반드시 명시적 객체 형변환 사용
		String name=(String)pageContext.getAttribute("name");	

		//속성명에 대한 속성값이 없는 경우 [null] 반환
		String pageName=(String)pageContext.getAttribute("pageName");	
	%>
	<%-- 반환받은 객체를 JSP 표현식(Expression)를 이용하여 출력 처리 --%>
	<p>이름(name) = <%=name %></p>
	<%-- JSP 표현식에서는 참조변수에 저장된 [null]을 문자열로 변환하여 출력 처리 --%>
	<p>이름(pageName) = <%=pageName %></p>
	<%-- if 구문을 사용하여 참조변수에 [null]이 저장되어 있지 않은 경우에만 출력 처리 --%>
	<p>이름(pageName) = <% if(pageName!=null) { %><%=pageName %><% } %></p>
	<hr>
	<h2>EL 사용</h2>
	<%-- EL 사용방법 : ${표현식} - EL 표현식으로 값을 제공받아 출력 처리 --%>
	<%-- ${속성명} : EL 표현식으로 스코프의 속성명을 사용하여 속성값을 제공받아 출력 처리 --%>
	<%-- => getAttribute() 메소드를 사용하지 않아도 스코프 속성값을 제공받아 출력 처리 가능 --%>
	<p>이름(name) = ${name}</p>
	<%-- EL 표현식으로 제공받은 객체가 없는 경우 EL 미실행되어 어떠한 값도 출력되지 않도록 설정 --%>
	<p>이름(pageName) = ${pageName}</p>
</body>
</html>
