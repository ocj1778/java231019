<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [books_two.jsp] 문서를 요청하여 실행결과 XML 형식의 데이타로 
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
	<div id="bookList"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "get",
		url: "books_two.jsp",
		//dataType 속성값으로 설정된 문서형태와 요청 웹프로그램의 응답결과의 문서형태가 맞지
		//않을 경우 200 에러코드 발생
		dataType: "xml",
		success: function(xmlDoc) {
			//alert(xmlDoc);//[object XMLDocument]
			
			var count=$(xmlDoc).find("book").length;
			if(count==0) {
				$("#bookList").html("<p>검색된 교재가 하나도 없습니다.</p>");
				return;
			}
			
			var html="<p>검색된 교재가 "+count+"권 있습니다.</p>";
			html+="<ol>";
			$(xmlDoc).find("book").each(function() {
				var title=$(this).find("title").text();
				var author=$(this).find("author").text();
			
				html+="<li><b>"+title+"</b>["+author+"]</li>";
			});
			html+="</ol>";
			
			$("#bookList").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>












