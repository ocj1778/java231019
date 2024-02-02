<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [songs_two.jsp] 문서를 요청하여 실행결과 JSON 형식의 데이타로 
응답받아 태그내용을 변경하는 JSP 문서 - jQuery 라이브러리의 AJAX 관련 메소드 사용 --%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>jQuery AJAX</h1>
	<hr>
	<h2>음원챠트(<span id="now"></span> 현재 기준)</h2>
	<div id="songList"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		url: "songs_two.jsp",
		dataType: "json",
		success: function(obj) {
			//alert(obj);//[object Object]
			
			$("#now").html(obj.now);
			
			var html="<ol>";
			$(obj.songs).each(function() {
				html+="<li><b>"+this.title+"</b>["+this.singer+"]</li>";
			});
			html+="</ol>";
			
			$("#songList").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>	
</body>
</html>
