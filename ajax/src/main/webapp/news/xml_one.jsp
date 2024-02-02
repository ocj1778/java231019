<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [xml_two.jsp] 문서를 요청해 실행결과를 XML 형식의 데이타로 응답받아
태그내용을 변경하여 응답하는 JSP 문서 --%>
<%-- => XML 형식의 데이타를 제공받아 HTML 태그로 변환하여 페이지 변경 - 파싱(Parsing) 처리 --%>
<%-- XML(eXtensible Markup Language) : 엘리먼트(태그)를 사용하여 값을 제공하는 구조적인 데이타 표현 방식 --%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#newsList {
	width: 50%;
	margin: 0 auto;
}

#newsHeader {
	padding: 5px;
	text-align: center;
	font-size: x-large;
	border: 2px solid black;
}

#newsContents {
	padding: 5px;
	font-size: medium;
	border: 2px dashed black;
	display: none;
}
</style>
</head>
<body>
	<h1>헤드라인 뉴스</h1>
	<hr>
	<div id="newsList">
		<div id="newsHeader">오늘의 뉴스</div>
		<div id="newsContents"></div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("newsList").onmouseover=function() {
		var xhr=new XMLHttpRequest();
		
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					//XMLHttpRequest 객체에 저장된 실행결과(XML)를 제공받아 변수에 저장
					//XMLHttpRequest.responseXML : 웹프로그램 요청에 대한 실행결과(XML 문서)를 
					//XMLDocument 객체로 저장한 객체 속성(Property)
					var xmlDoc=xhr.responseXML;
					//alert(xmlDoc);//[object XMLDocument]
					
					//Document.getElementsByTagName(tagName) : Document 객체(Element 객체)에서
					//태그명으로 DOM 객체를 검색하여 NodeList 객체(HTMLCollection 객체)로 반환하는 메소드
					var newsList=xmlDoc.getElementsByTagName("news");
					//alert(newsList);//[object HTMLCollection]
					//alert(newsList.length);
					
					var html="<ol>";
					for(i=0;i<newsList.length;i++) {
						//newsList.item(index) : newsList 객체에서 매개변수로 전달받은 첨자위치의
						//요소값(Element 객체)을 반환하는 메소드
						var news=newsList.item(i);
						
						var title=news.getElementsByTagName("title").item(0).firstChild.nodeValue;
						var publisher=news.getElementsByTagName("publisher").item(0).firstChild.nodeValue;
						
						html+="<li>"+title+"["+publisher+"]</li>";
					}
					html+="</ol>";
					
					document.getElementById("newsContents").innerHTML=html;
					document.getElementById("newsContents").style="display: block;";
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		xhr.open("get", "xml_two.jsp");
		xhr.send(null);
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContents").style="display: none;";
	}
	</script>
</body>
</html>