<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<link href="/spring/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<h1 class="text">Resource File</h1>
	<hr>
	<%-- 리소스 파일(Resource File) : 클라이언트에서 HTML 문서를 해석하여 실행하기 위해 필요한
	정보를 제공하기 위해 서버에 저장된 파일(웹자원) --%>
	<%-- => CSS 파일, JavaScript Source 파일, 멀티미디어 파일 등 --%>
	<%-- => 클라이언트에서 HTML 문서를 해석하여 실행할 때 리소스 파일이 서버에 없어 제공받지
	못할 경우 404 에러코드가 발생되어 비정상적인 출력 처리 --%>

	<%-- 문제점)리소스 파일이 서버의 WEB-INF 폴더에 저장되어 있는 경우 클라이언트에서 요청 불가능 --%> 
	<%-- => WEB-INF 폴더는 서블릿으로만 접근 가능하고 클라이언트는 접근이 불가능한 은닉화 처리된 폴더 --%>
	<%-- 해결법)WEB-INF 폴더가 아닌 Context Root 폴더의 역활을 제공하는 webapp 폴더에 저장 --%>	
	<%-- <img src="/spring/WEB-INF/view/Koala.jpg" width="200"> --%>

	<%-- 문제점)SpringMVC 프로그램은 클라이언트의 모든 요청을 Front Controller를 이용하여 처리 --%>
	<!-- => 클라이언트가 필요로 하는 리소스 파일을 요청하면 Front Controller가 요청을 받아
	처리하지만 매핑된 요청 처리 메소드가 없어 404 에러코드 발생 -->
	<%-- 해결법)클라이언트가 리소스 파일을 요청한 경우 Front Controller의 호출 처리 메소드를 
	이용하지 않고 직접 리소스 파일로 응답 처리되도록 설정 --%>
	<%-- => Spring Bean Configuration File(servlet-context.xml)에서 resources 엘리먼트 설정 --%>
	<%-- <img src="/spring/Koala.jpg" width="200"> --%>
	
	<img src="/spring/images/Koala.jpg" width="200">
</body>
</html>
















