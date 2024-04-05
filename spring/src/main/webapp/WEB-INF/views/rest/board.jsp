<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
#btnDiv {
	margin: 10px;
}

#restBoardTable {
	border: 1px solid black;
	border-collapse: collapse; 
}

#restBoardTable td, #restBoardTable th {
	border: 1px solid black;
	padding: 3px;
}

.inputDiv {
	width: 240px;
	height: 80px;
	border: 2px solid black;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -40px;
	margin-left: -120px;
	padding: 5px;
	z-index: 100;
	display: none;
}
</style>
</head>
<body>
	<h1>RestBoard</h1>
	<hr>
	<div id="btnDiv">
		<button type="button" id="writeBtn">글쓰기</button>
	</div>
	
	<%-- 게시글 목록을 출력하는 태그 --%>
	<div id="restBoardListDiv"></div>

	<%-- 페이지 번호를 출력하는 태그 --%>
	<div id="pageNumDiv"></div>
	
	<%-- 신규 게시글을 입력받기 위한 태그 --%>
	<div id="insertDiv" class="inputDiv">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="insertWriter" class="insert"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="insertContent" class="insert"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="insertBtn">저장</button>
					<button type="button" id="cancelInsertBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<%-- 변경 게시글을 입력받기 위한 태그 --%>
	<div id="updateDiv" class="inputDiv">
		<input type="hidden" id="updateIdx">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" id="updateWriter" class="update"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" id="updateContent" class="update"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="updateBtn">변경</button>
					<button type="button" id="cancelUpdateBtn">취소</button>
				</td>
			</tr>
		</table>
	</div>
	
	<script type="text/javascript">
	//요청 페이지 번호를 저장하기 위한 전역변수 
	// => 프로그램 종료시까지 값을 유지하여 모든 Javascript 함수에 제공하기 위한 전역변수 선언
	var page=1;
	
	//비동기식 방식으로 페이지를 요청하여 게시글 목록을 제공받아 출력하는 함수 호출
	boardListDisplay(page);
	
	//매개변수로 요청 페이지 번호를 전달받아 페이지 번호에 대한 게시글 목록을 JSON 형식의
	//문자열로 제공받아 HTML 태그로 변환하는 출력하는 함수
	// => 페이지 번호에 대한 게시글 목록을 제공받기 위해 비동기식 방식으로 페이지 요청
	function boardListDisplay(pageNum) {
		page=pageNum;
		$.ajax({
			type: "get",
			url: "<c:url value="/rest/board_list"/>",
			data: {"pageNum":pageNum},
			dataType: "json",
			//JSON 형식의 문자열을 제공받아 Javascipt 객체로 변환하여 매개변수에 저장
			success: function(result) {
				//alert(result);//[object Object]
				
				//응답받은 Javascipt 객체를 HTML 태그로 변환하여 출력 처리
				if(result.restBoardList.length == 0) {//검색된 게시글이 없는 경우
					var html="<table id='restBoardTable'>";
					html+="<tr>";
					html+="<th width='800'>검색된 게시글이 없습니다.</th>";
					html+="</tr>";
					html+="</table>"
					$("#restBoardListDiv").html(html);
					return;
				}
			},
			error: function(xhr) {
				alert("에러코드(게시글 목록 검색) = "+xhr.status);
			}
		});
	}

	
	</script>
</body>
</html>



















