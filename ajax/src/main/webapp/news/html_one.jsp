<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [html_two.jsp] 문서를 요청해 실행결과를 HTML 태그로 응답받아 태그내용을 
변경하는 변경하여 응답하는 JSP 문서 --%>    
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
		<div id="newsContents">
			<%-- 
			<ol>
				<li>박명수 "父 돈 없던 시절 용돈 60만 원 주셔, 지금 천배로 효도 중"[뉴스엔]</li>
				<li>'브랜딩인성수동' 김지은, 1인2역 도전 "영혼 체인지 매력적이라 출연"[뉴스1]</li>
				<li>"한국 치킨 먹고 싶어"…'아가일' 매튜 본 감독, '킹스맨' 시리즈 이어 韓 공략[OSEN]</li>
				<li>이희준 "배우-제작진 전화번호 '살인자'라 저장했다" 폭소[뉴스엔]</li>
				<li>살인자인가 단죄자인가… 제목처럼 아리송한 '살인자O난감'[일간스포츠]</li>
			</ol>
			--%>
		</div>
	</div>
	
	<script type="text/javascript">
	document.getElementById("newsList").onmouseover=function() {
		var xhr=new XMLHttpRequest();
		
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("newsContents").innerHTML=xhr.responseText;
					document.getElementById("newsContents").style="display: block;";
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}
		}
		
		xhr.open("get", "html_two.jsp");
		xhr.send(null);
	}
	
	document.getElementById("newsList").onmouseout=function() {
		document.getElementById("newsContents").style="display: none;";
	}
	</script>
</body>
</html>












