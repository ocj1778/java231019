<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 입력받아 아이디를 검색하여 결과가 출력되도록 응답하는 JSP 문서 --%>
<%-- => 아이디는 [search_id_two.jsp] 문서를 AJAX 엔진으로 요청하여 실행결과를 XML 데이타로
응답받아 출력 처리 - 이름과 이메일 전달 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h1>아이디 찾기</h1>
	<hr>
	<table>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" id="email"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="btn">아이디 찾기</button>
		</tr>
	</table>
	<hr>
	<div id="result"><%-- 홍길동님의 아이디는 [abc123]입니다. --%></div>
	
	<script type="text/javascript">
	$("#btn").click(function() {
		var name=$("#name").val();
		if(name=="") {
			$("#result").html("이름을 입력해 주세요.");
			$("#name").focus();
			return;
		}
		
		var email=$("#email").val();
		if(email=="") {
			$("#result").html("이메일을 입력해 주세요.");
			$("#email").focus();
			return;
		}
		
		$("#name").val("");
		$("#email").val("");
		
		//AJAX 엔진을 사용하여 [search_id_two.jsp] 문서를 요청하여 실행결과를 XML 데이타로 
		//받아 태그내용을 변경하여 출력 처리
		$.ajax({
			type: "post",
			url: "<%=request.getContextPath()%>/jdbc/search_id_two.jsp",
			data: "name="+name+"&email="+email,
			dataType: "xml",
			success: function(xmlDoc) {
				
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});
	</script>
</body>
</html>












