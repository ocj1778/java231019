<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse; 
}	

th, td {
	border: 1px solid black;
	padding: 2px;
}
</style>
</head>
<body>
	<h1>자료실(출력페이지)</h1>
	<hr>
	<p>
		<button type="button" onclick="location.href='<c:url value="/file/write"/>';">업로드</button>
	</p>
	
	<table>
		<tr>
			<th width="50">번호</th>
			<th width="100">작성자</th>
			<th width="300">제목</th>
			<th width="350">파일명</th>
			<th width="100">삭제</th>
			<th width="100">다운로드</th>
		</tr>
		
		<%-- 게시글 목록 출력 --%>
		<c:forEach var="fileBoard" items="${fileBoardList }">
			<tr>
				<td align="center">${fileBoard.idx }</td>
				<td align="center">${fileBoard.writer }</td>
				<td>${fileBoard.subject }</td>
				<td>${fn:split(fileBoard.filename, "_")[1] }</td>
				<td align="center">
					<button type="button" onclick="fileDelete(${fileBoard.idx});">삭제</button>
				</td>
				<td align="center">
					<button type="button" onclick="fileDownload(${fileBoard.idx});">다운로드</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<%-- 페이지 번호 출력 --%>
	<c:choose>
		<c:when test="${pager.startPage > pager.blockSize }">
			<a href="<c:url value="/file/list"/>?pageNum=${pager.prevPage}">[이전]</a>
		</c:when>
		<c:otherwise>
			[이전]
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="${pager.startPage }" end="${pager.endPage }" step="1">
		<c:choose>
			<c:when test="${pager.pageNum != i }">
				<a href="<c:url value="/file/list"/>?pageNum=${i}">[${i}]</a>
			</c:when>
			<c:otherwise>
				[${i}]
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:choose>
		<c:when test="${pager.endPage != pager.totalPage }">
			<a href="<c:url value="/file/list"/>?pageNum=${pager.nextPage}">[다음]</a>
		</c:when>
		<c:otherwise>
			[다음]
		</c:otherwise>
	</c:choose>
	
	<script type="text/javascript">
	function fileDelete(idx) {
		if(confirm("자료를 정말로 삭제 하시겠습니까?")) {
			location.href="<c:url value="/file/delete"/>?idx="+idx;
		}
	}
	
	function fileDownload(idx) {
		location.href="<c:url value="/file/download"/>?idx="+idx;
	}
	</script>
</body>
</html>
