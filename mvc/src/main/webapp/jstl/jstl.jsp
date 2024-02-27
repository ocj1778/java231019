<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>JSTL(Java Standard Tag Library)</h1>
	<hr>
	<p>JSTL : JSP 문서에서 많이 사용되는 EL 함수와 커스텀 태그를 제공하기 위한 라이브러리</p>
	<p>JSP 문서에서 JSTL이 제공하는 EL 함수 또는 커스텀 태그를 사용하기 위해서는 라이브러리
	파일을 다운로드 받아 프로젝트에 빌드 처리 - https://tomcat.apache.org 사이트 참조</p>
	<%-- https://tomcat.apache.org >> Download >> Taglibs 메뉴 클릭 >> 
	taglibs-standard-impl-1.2.5.jar,taglibs-standard-spec-1.2.5.jar
	taglibs-standard-jstlel-1.2.5.jar,taglibs-standard-compat-1.2.5.jar 파일 다운로드
	>> /WEB-INF/lib 폴더에 jar 파일 붙여넣기 : 프로젝트에 라이브러리 빌드 처리 --%>
	<hr>
	<p>Core : EL 지원 태그, 프로그램의 흐름을 제어 태그, URL 주소 관리하는 태그등을 제공</p>
	<p>Formatter : 숫자 또는 날짜와 시간의 형식을 변경 태그, 국제화 태그, 다국어 지원 태그등을 제공</p>
	<p>SQL : 테이블에 대한 행 삽입,변경,삭제,검색 기능의 태그 제공</p>
	<p>XML : XML 문서에 대한 처리 기능의 태그 제공</p>
	<p>Functions : 문자열 처리 기능의 EL 함수 제공</p>
</body>
</html>
