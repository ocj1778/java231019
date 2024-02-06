<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보를 입력 받거나 댓글 목록이 출력되도록 응답하는 JSP 문서 --%>
<%-- => AJAX 엔진으로 [comment_list.jsp] 문서를 요청하여 댓글 목록을 응답받아 출력 처리 --%>
<%-- => [댓글등록] 태그를 클릭한 경우 AJAX 엔진으로 [comment_add.jsp] 문서를 요청하여 댓글을 
삽입 처리하고 실행결과를 응답받아 처리 - 입력태그의 입력값 전달 --%>
<%-- => 댓글태그의 [댓글변경] 태그를 클릭한 경우 댓글변경태그를 댓글태그의 자식태그로 이동하여 출력 처리 --%>    
<%-- => 댓글태그의 [댓글삭제] 태그를 클릭한 경우 댓글삭제태그를 댓글태그의 자식태그로 이동하여 출력 처리 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

.comment_table {
	width: 500px;
	margin: 0 auto;
	border: 2px solid #cccccc;
	border-collapse: collapse;
}

.title {
	width: 100px;
	padding: 5px 10px;
	text-align: center;
	border: 1px solid #cccccc;
}

.input {
	width: 400px;
	padding: 5px 10px;
	border: 1px solid #cccccc;
}

.btn {
	text-align: center;
	border: 1px solid #cccccc;
}

#comment_add {
	margin-bottom: 5px;
}

#comment_modify, #comment_remove {
	margin: 10px;
	display: none;
}

#add_message, #modify_message {
	width: 500px;
	margin: 0 auto;
	margin-bottom: 20px;
	text-align: center;
	color: red;
}

#remove_message {
	padding: 3px;
	text-align: center;
	border: 1px solid #cccccc;
}

.comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	padding: 3px;
	border: 1px solid #cccccc;
}

.no_comment {
	width: 550px;
	margin: 0 auto;
	margin-bottom: 5px;
	border: 2px solid #cccccc;
	text-align: center;
}
</style>
</head>
<body>
	<h1>AJAX 댓글</h1>
	<hr>
	<%-- 댓글등록태그 --%>
	<div id="comment_add">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="add_writer"></td>
			</tr>
			<tr>
				<td class="title">내용</td>
				<td class="input">
					<textarea rows="3" cols="50" id="add_content"></textarea>
				</td>
			</tr>
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="add_btn">댓글등록</button>
				</td>
			</tr>
		</table>
		<div id="add_message">&nbsp;</div>
	</div>

	<%-- 댓글목록태그 --%>
	<div id="comment_list"></div>

	<%-- 댓글변경태그 --%>
	<div id="comment_modify">
		<input type="hidden" id="modify_num">
		<table class="comment_table">
			<tr>
				<td class="title">작성자</td>
				<td class="input"><input type="text" id="modify_writer"></td>
			</tr>
			<tr>
				<td class="title">내용</td>
				<td class="input">
					<textarea rows="3" cols="50" id="modify_content"></textarea>
				</td>
			</tr>
			<tr>
				<td class="btn" colspan="2">
					<button type="button" id="modify_btn">변경</button>
					<button type="button" id="modify_cancel_btn">취소</button>
				</td>
			</tr>
		</table>
		<div id="modify_message">&nbsp;</div>
	</div>

	<%-- 댓글삭제태그 --%>
	<div id="comment_remove">
		<input type="hidden" id="remove_num">
		<div id="remove_message">
			<b>정말로 삭제 하시겠습니까?</b>
			<button type="button" id="remove_btn">삭제</button>
			<button type="button" id="remove_cancel_btn">취소</button>
		</div>
	</div>
	
	<script type="text/javascript">
	displayComment();
	
	//AJAX 엔진으로 [comment_list.jsp] 문서를 요청하여 실행결과를 JSON 데이타로 응답받아
	//HTML 태그로 변환하여 댓글목록태그의 태그내용을 변경하는 함수
	function displayComment() {
		$.ajax({
			type: "get",
			url: "<%=request.getContextPath()%>/comment/comment_list.jsp",
			dataType: "json",
			success: function(result) {
				//댓글목록태그에 출력된 기존 댓글들을 삭제 처리 - 초기화
				$("#comment_list").children().remove();
				
				if(result.code=="success") {//검색된 댓글정보가 있는 경우
					//Array 객체의 요소값를 차례대로 제공받아 반복 처리
					$(result.data).each(function() {
						//Array 객체의 요소값(Object 객체)를 HTML 태그(div)로 변환
						var html="<div class='comment' id='comment_"+this.num+"'>";//댓글태그
						html+="<b>["+this.writer+"]</b><br>";//댓글태그에 작성자 포함
						html+=this.content.replace(/\n/g,"<br>")+"<br>";//댓글태그에 내용 포함
						html+="("+this.regdate+")<br>";//댓글태그에 작성날짜 포함
						html+="<button type='button' onclick='modifyComment("+this.num+");'>댓글변경</button>&nbsp;";//댓글태그에 댓글변경 버튼 포함
						html+="<button type='button'>댓글삭제</button>&nbsp;";//댓글태그에 댓글변경 버튼 포함
						html+="</div>";
						
						//댓글목록태그의 댓글태그를 마지막 자식태그로 추가하여 출력 처리
						$("#comment_list").append(html);
					});
				} else {//검색된 댓글정보가 없는 경우
					$("#comment_list").html("<div class='no_comment'>"+result.message+"</div>");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	
	//[댓글등록] 태그를 클릭한 경우 호출되는 이벤트 처리 함수 등록
	// => AJAX 엔진으로 [comment_add.jsp] 문서를 요청하여 실행결과를 JSON 데이타로 응답받아 
	//처리 - 입력태그의 입력값(작성자와 내용) 전달
	$("#add_btn").click(function() {
		var writer=$("#add_writer").val();
		if(writer=="") {
			$("#add_message").html("작성자를 입력해 주세요.");
			$("#add_writer").focus();
			return;
		}
		
		var content=$("#add_content").val();
		if(content=="") {
			$("#add_message").html("내용을 입력해 주세요.");
			$("#add_content").focus();
			return;
		}
		
		$("#add_writer").val("");
		$("#add_content").val("");
		$("#add_message").html("");
		
		$.ajax({
			type: "post",
			url: "<%=request.getContextPath()%>/comment/comment_add.jsp",
			data: {"writer":writer, "content":content},
			dataType: "json",
			success: function(result) {
				if(result.code=="success") {
					displayComment();//댓글목록을 검색하여 출력
				} else {
					alert("댓글 삽입 실패");
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	});

	//댓글변경태그와 댓글삭제태그를 초기화 처리하기 위한 함수
	function init() {
		//댓글변경태그를 숨김 처리하고 document 객체의 마지막 자식태그로 이동 처리
		$("#comment_modify").hide().appendTo(document.documentElement);
		
		//댓글변경태그의 입력태그 초기화
		$("#modify_num").val("");
		$("#modify_writer").val("");
		$("#modify_content").val("");
		//댓글변경태그의 메세지태그 초기화
		$("#modify_message").html("");
		
		//댓글삭제태그를 숨김 처리하고 document 객체의 마지막 자식태그로 이동 처리
		$("#comment_remove").hide().appendTo(document.documentElement);
		
		//댓글삭제태그의 입력태그 초기화
		$("#remove_num").val("");
	}
	
	//댓글태그의 [댓글변경] 태그를 클릭한 경우 호출되는 이벤트 처리 함수
	// => 댓글변경태그를 댓글태그의 자식태그로 이동하여 출력하고 AJAX 엔진을 사용하여 
	//[comment_get.jsp] 문서를 요청하여 실행결과를 JSON 데이타로 응답받아 입력태그의 
	//입력값으로 출력 처리 - 댓글번호 전달
	function modifyComment(num) {
		//alert(num);
		
		init();
		
		$("#comment_modify").show().appendTo("#comment_"+num);
		
		$.ajax({
			type: "get",
			url: "<%=request.getContextPath()%>/comment/comment_get.jsp",
			data: {"num":num},
			dataType: "json",
			success: function(result) {
				if(result.code=="success") {
					$("#modify_num").val(result.data.num)
					$("#modify_writer").val(result.data.writer)
					$("#modify_content").val(result.data.content)
				} else {
					init();
				}
			},
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
	}
	</script>
</body>
</html>













