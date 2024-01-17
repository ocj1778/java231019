<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>지시어(Directive)</h1>
	<hr>
	<p>page Directive : JSP 문서에 필요한 정보가 제공되도록 지시
	- &lt;%@page 속성="속성값" 속성="속성값" ... %&gt;</p>
	<p>include Directive : JSP 문서에 외부파일의 소스코드(SourceCode)을 제공받아 포함되도록 지시
	- &lt;%@include file="URL" %&gt;</p>
	<p>taglib Directive : JSP 문서에 태그 라이브러리 파일을 제공받아 커스텀태그를 사용할 수 있도록 지시
	- &lt;%@tablib prefix="namespace" uri="tldId" %&gt;</p>
</body>
</html>