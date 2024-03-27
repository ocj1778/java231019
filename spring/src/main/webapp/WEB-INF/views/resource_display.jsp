<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<%-- <link href="/spring/css/style.css" type="text/css" rel="stylesheet"> --%>
<link href="<c:url value="/css/style.css"/>" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/js/jquery-3.7.1.min.js"/>"></script>
</head>
<body>
	<h1 class="text">Resource File</h1>
	<hr>
	<%-- 리소스 파일(Resource File) : 클라이언트에서 HTML 문서를 해석하여 실행하기 위해 필요한
	정보를 제공하기 위해 서버에 저장된 파일(웹자원) --%>
	<%-- => CSS 파일, JavaScript Source 파일, 멀티미디어 파일 등 --%>
	<%-- => 클라이언트에서 HTML 문서를 해석하여 실행할 때 리소스 파일이 서버에 없어 제공받지
	못할 경우 404 에러코드가 발생되어 비정상적인 출력 결과 발생 --%>

	<%-- 문제점)리소스 파일이 서버의 WEB-INF 폴더에 저장되어 있는 경우 클라이언트에서 요청 불가능 --%> 
	<%-- => WEB-INF 폴더는 서버의 서블릿으로만 접근 가능하고 클라이언트는 접근이 불가능한 은닉화 처리된 폴더 --%>
	<%-- 해결법)WEB-INF 폴더가 아닌 Context Root 폴더의 역활을 제공하는 webapp 폴더에 저장 --%>	
	<%-- <img src="/spring/WEB-INF/views/Koala.jpg" width="200"> --%>

	<%-- 문제점)SpringMVC 프로그램은 클라이언트의 모든 요청을 Front Controller를 이용하여 처리 --%>
	<%-- => 클라이언트가 필요로 하는 리소스 파일을 요청하면 Front Controller가 요청을 받아
	처리하지만 매핑된 요청 처리 메소드가 없어 404 에러코드 발생 --%>
	<%-- 해결법)클라이언트가 리소스 파일을 요청한 경우 Front Controller는 호출 처리 메소드를 
	이용하지 않고 직접 리소스 파일로 응답 처리되도록 설정 --%>
	<%-- => Spring Bean Configuration File(servlet-context.xml)에서 resources 엘리먼트 설정 --%>
	<%-- <img src="/spring/Koala.jpg" width="200"> --%>
	
	<%-- servlet-context.xml 파일의 resources 엘리먼트에 location 속성값으로 설정된 폴더 및
	하위폴더에 리소스 파일을 저장하여 클라이언트가 mapping 속성값으로 설정된 URL 주소의
	패턴으로 리소스 파일을 요청하여 Front Controller에 의해 직접 응답 처리되도록 설정 --%>
	<%-- <img src="/spring/resources/images/Koala.jpg" width="200"> --%>
	<img src="/spring/images/Koala.jpg" width="200">
	
	<%-- 리소스 파일의 경로는 절대경로로 표현하여 요청 --%>
	<%-- => 프로젝트에 대한 컨텍스트 폴더의 이름이 변경될 경우 컨텍스트 경로가 변경되어 404 에러코드 발생 가능 --%>
	<%-- 컨텍스트 폴더의 이름이 변경되도 웹자원의 경로가 변경되지 않도록 컨텍스트 경로를 제공받아 작성 --%>

	<%-- 1.EL의 pageContext 내장객체를 사용하여 컨텍스트 경로를 제공받아 작성 --%>
	<img src="${pageContext.request.contextPath}/images/Koala.jpg" width="200">
	
	<%-- 2.core 태그 라이브러리의 url 태그를 사용하여 컨텍스트 경로를 제공받아 작성 --%>
	<img src="<c:url value="/images/Koala.jpg"/>" width="200">

	<%-- 3.spring 태그 라이브러리의 url 태그를 사용하여 컨텍스트 경로를 제공받아 작성 --%>
	<img src="<spring:url value="/images/Koala.jpg"/>" width="200">
</body>
</html>
