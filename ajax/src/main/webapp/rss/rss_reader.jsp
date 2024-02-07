<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- RSS 서비스를 제공하는 웹프로그램을 AJAX 엔진으로 요청하여 실행결과(XML)를 응답받아 HTML 
태그로 변환하여 응답하는 JSP 문서 - RSS Reader --%>    
<%-- RSS(Really Simple Syndication 또는 Rich Site Summary) : 블로그, 뉴스, 기업정보 등과 같이
자주 업데이트 되는 사이트의 컨텐츠를 보다 쉽게 사용자에게 제공하기 위한 만들어진 서비스 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		
		url: "https://www.yonhapnewstv.co.kr/category/news/culture/feed/",
		dataType: "xml",
		success: function(xmlDoc) {
			var channelTitle=$(xmlDoc).find("channel").children("title").text();
			
			var html="<h2>"+channelTitle+"</h2>";
			html+="<ul>";
			$(xmlDoc).find("item").each(function() {
				var title=$(this).find("title").text();//뉴스제목
				var link=$(this).find("link").text();//뉴스링크
				var date;//작성날짜
				if($(this).find("pubDate").length!=0) {
					date=$(this).find("pubDate").text();
				} else {
					date=$(this).find("dc\\:date").text();
				}
				html+="<li><a href='"+link+"' target='+blank'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>















