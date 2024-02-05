<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [xsl_two.jsp] 문서를 요청하여 실행결과를 XML 데이타를 응답받아
태그내용을 변경하여 응답하는 JSP 문서 --%>
<%-- AJAX 엔진을 사용하여 XSL 문서(books.xsl)를 요청해 응답받은 XSLT 데이타로 XML 데이타를 
HTML 태그로 변경 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>교재목록</h1>
	<hr>
	<div id="books"></div>
	
	<script type="text/javascript">
	var xmlDoc=null;//XML 데이타를 저장하기 위한 전역변수
	var xslDoc=null;//XSLT 데이타를 저장하기 위한 전역변수
	
	$.ajax({
		type: "get",
		url: "xsl_two.jsp",
		dataType: "xml",
		success: function(result) {
			xmlDoc=result;
		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	
	</script>
</body>
</html>


















