<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 입력태그에 검색어를 입력한 경우 검색어가 포함된 제시어를 전달하여 응답하는 JSP 문서 --%>
<%-- => AJAX 엔진을 사용하여 [suggest_two.jsp] 문서를 요청하여 제시어 관련 정보를 XML 데이타로
응답받아 출력 처리 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
#keyword {
	position: absolute;
	top: 100px;
	left: 10px;
	width: 300px;
	font-size: 16px;
}

#suggestDiv {
	position: absolute;
	top: 120px;
	left: 10px;
	width: 300px;
	padding: 3px;
	border: 1px solid black;
	cursor: pointer;
	font-size: 16px;
	background: rgba(255, 255, 255, 1);
	z-index: 999;
}

#choice {
	position: absolute;
	top: 150px; 
	left: 10px;
}
</style>
</head>
<body>
	<h1>제시어 기능</h1>
	<hr>
	<div>
		<%-- 검색어를 입력받기 위한 태그 --%>
		<input type="text" id="keyword">
		
		<%-- 제시어를 제공받아 출력하기 위한 태그 --%>
		<div id="suggestDiv">
			<div id="suggectList"></div>
		</div>
	</div>
	
</body>
</html>













