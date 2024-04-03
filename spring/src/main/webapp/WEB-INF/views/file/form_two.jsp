<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<hr>
	<form action="<c:url value="/file/upload2"/>" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>업로더 이름</td>
			<td><input type="text" name="uploaderName"></td>
		</tr>
		<tr>
			<td>업로더 파일</td>
			<td>
				<!-- multiple 속성 : 파일을 여러개 입력받아 전달하기 위한 기능을 제공하는 속성 -->
				<input type="file" name="uploaderFileList" multiple="multiple">
				<span style="color: red;">* 파일을 여러개 입력할 수 있습니다.</span>
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">제출</button>
		</tr>
	</table>
	</form>
</body>
</html>

