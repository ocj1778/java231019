<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [csv_two.jsp] 문서를 요청해 실행결과를 CSV 형식의 데이타로 응답받아
태그내용을 변경하여 응답하는 JSP 문서 --%>
<%-- => CSV 형식의 데이타를 제공받아 HTML 태그로 변환하여 페이지 변경 - 파싱(Parsing) 처리 --%>
<%-- CSV(Comma Separated Values) : 콤마(,)를 사용하여 값을 구분하여 제공하는 비구조적인 데이타 표현 방식 --%>        
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
					//XMLHttpRequest 객체에 저장된 실행결과(CSV)를 제공받아 변수에 저장
					var csv=xhr.responseText;
					
					//CSV 형식의 데이타를 행(뉴스) 단위로 분리하여 Array 객체의 요소로 저장
					var newsArray=csv.split("*");
					//alert(newsArray.length);
					
					var html="<ol>";
					for(i=0;i<newsArray.length;i++) {
						//행(뉴스)을 열(값 - 뉴스제목과 언론사) 단위로 분리하여 Array 객체의 요소로 저장
						var news=newsArray[i].split("|");
						
						//Array 객체의 [0] 위치의 요소값(뉴스제목)을 변수에 저장
						var title=news[0].trim();
						//Array 객체의 [1] 위치의 요소값(언론사)을 변수에 저장
						var publisher=news[1].trim();
						
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
		
		xhr.open("get", "csv_two.jsp");
		xhr.send(null);
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContents").style="display: none;";
	}
	</script>
</body>
</html>