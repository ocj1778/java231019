<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트가 JSP 문서를 요청하면 WAS 프로그램을 JSP 문서를 서블릿 클래스로 변환하여 생성하고
서블릿 클래스를 컴파일하여 객체로 생성한 후 요청 처리 메소드를 호출해 요청에 대한 응답파일을 
동적으로 생성하여 클라이언트에게 응답 --%>
<%-- => JSP 문서에 대한 서블릿 클래스가 이미 생성되어 있는 경우 서블릿 객체로 요청 처리 메소드 호출 --%>
<%-- => JSP 문서가 변경된 후 클라이언트가 JSP 문서를 다시 요청하면 서블릿 클래스로 새로 생성하여
컴파일 후 객체를 생성해 요청 처리 메소드 호출 --%>
<%
	//서버의 현재 날짜와 시간을 저장한 Date 객체 생성
	Date now=new Date();
	//날짜와 시간의 패턴정보를 저장한 SimpleDateFormat 객체 생성
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	//SimpleDateFormat 객체로 format() 메소드를 호출하여 매개변수로 전달받은 Date 객체를
	//SimpleDateFormat 객체에 저장된 날짜와 시간 패턴의 문자열로 변환하여 반환받아 저장 
	String displayNow=dateFormat.format(now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
#displayDiv {
	width: 600px;
	margin: 0 auto;
	padding: 30px 0;
	font-size: 2em;
	font-weight: bold;
	text-align: center;
	border: 2px solid black;
}
</style>
</head>
<body>
	<h1>Hello, JSP!!!</h1>
	<hr>
	<!-- HTML 주석문 : HTML 문서에 대한 설명을 제공하기 위해 사용 - 클라이언트에게 전달 : 웹디자이너 -->	
	<%-- JSP 주석문 : JSP 문서에 대한 설명을 제공하기 위해 사용 - 클라이언트에게 미전달 : 웹프로그래머 --%>
	<p>JSP(Java Server Page) : 서블릿보다 쉽게 웹프로그램을 작성하기 위한 기능
	- 스크립트 요소(Script Element), 지시어(Directive), 표준 액션 태그(Standard Action Tag)</p>
	<hr>
	<div id="displayDiv"><%=displayNow %></div>
 
	<%-- 자바스크립트 자동 완성 기능(Javascript Content Assist)을 제공받기 위해 이클립스에 
	Tern 플러그인 설치 --%>
	<%-- Help >> Install New Software... >> Work with : http://oss.opensagres.fr/tern.repository/1.2.1
	>> 플러그인 목록 전체 체크 >> Next >> Next >> 라이센스 동의 >> finish --%>
	
	<%-- Tern 플러그인을 프로젝트에서 사용하기 위해 웹프로젝트를 Tern 프로젝트로 변환 --%>
	<%-- => 프로젝트 >> 오른쪽 버튼 클릭(메뉴) >> Configure >> Convert to Tern Project
	>> Modules : Browser와 jQuery 선택 >> Apply And Close --%>	
	<script type="text/javascript">
	setInterval(function() {
		location.reload();
	}, 1000);
	</script>	
</body>
</html>
