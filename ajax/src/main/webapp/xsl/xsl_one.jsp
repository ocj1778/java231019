<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [xsl_two.jsp] 문서를 요청하여 실행결과를 XML 데이타를 응답받아
태그내용을 변경하여 응답하는 JSP 문서 - 동기식 통신을 이용하여 요청과 응답 --%>
<%-- AJAX 엔진을 사용하여 XSL 문서(books.xsl)를 요청해 응답받은 XSLT 데이타로 XML 데이타를 
HTML 태그로 변경 - 비동기식 통신을 이용하여 요청과 응답 --%>
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
	
	/*
	$.ajax({
		type: "get",
		url: "xsl_two.jsp",
		dataType: "xml",
		success: function(result) {
			xmlDoc=result;
			doXSLT();
		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	$.ajax({
		type: "get",
		url: "books.xsl",
		dataType: "xml",
		success: function(result) {
			xslDoc=result;
			doXSLT();
		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	//XSLT 데이타를 사용하여 XML 데이타를 HTML 태그로 변환하는 함수
	function doXSLT() {
		if(xmlDoc==null || xslDoc==null) return;
		
		//XSLT 데이타로 XML 데이타를 변환하기 위한 XSLTProcessor 객체 생성 
		var xsltProcessor=new XSLTProcessor();
		
		//XSLTProcessor.importStylesheet(xslt) : XSLTProcessor 객체에 변환정보가 저장된 XSLT
		//데이타를 전달받아 저장하기 위한 메소드
		xsltProcessor.importStylesheet(xslDoc);
		
		//XSLTProcessor.transformToFragment(xml, docuement) : XSLTProcessor 객체로 XML 데이타를
		//변환하여 DOM 객체(Element 객체)로 변환하여 반환하는 메소드
		var fragmenet=xsltProcessor.transformToFragment(xmlDoc, document);
		
		$("#books").append(fragmenet);
	}
	*/
	
	$.ajax({
		type: "get",
		url: "xsl_two.jsp",
		dataType: "xml",
		//asyns : 동기식 통신 또는 비동기식 통신을 구분하기 위한 속성
		// => false : 동기식 통신, true : 비동기식 통신(기본)
		asyns: false,
		success: function(result) {
			xmlDoc=result;
		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	
	$.ajax({
		type: "get",
		url: "books.xsl",
		dataType: "xml",
		success: function(result) {
			xslDoc=result;
			doXSLT();
		}, 
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});


	function doXSLT() {
		var xsltProcessor=new XSLTProcessor();
		xsltProcessor.importStylesheet(xslDoc);
		var fragmenet=xsltProcessor.transformToFragment(xmlDoc, document);
		$("#books").append(fragmenet);
	}
	
	</script>
</body>
</html>




