<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="application/msword; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	text-align: center;
	width: 200px;
	padding: 2px;
}
</style>
</head>
<body>
	<h1>page Directive - contentType 속성</h1>
	<hr>
	<p>page Directive의 contentType 속성에는 JSP 문서를 요청하여 응답받을 수 있는 파일의
	형태(MimeType)와 파일의 문자형태(CharacterSet - Encoding)를 속성값으로 설정</p> 
	<hr>
	<table>
		<tr>
			<th>학번</th><th>이름</th><th>주소</th>
		</tr>
		<tr>
			<td>1000</td><td>홍길동</td><td>서울시 강남구 역삼동</td>
		</tr>
		<tr>
			<td>2000</td><td>임꺽정</td><td>인천시 월미구 상당동</td>
		</tr>
		<tr>
			<td>3000</td><td>전우치</td><td>수원시 팔달구 구래동</td>
		</tr>
	</table>
</body>
</html>