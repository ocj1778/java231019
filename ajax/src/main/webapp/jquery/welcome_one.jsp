<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- AJAX 엔진을 사용하여 [welcome_two.jsp] 문서를 요청하여 실행결과 HTML 태그(Text)로 
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
	<label for="name">이름 : </label>
	<input type="text" id="name">
	<button type="button" id="btn">입력완료</button>
	<hr>
	<div id="message"></div>
	
	<script type="text/javascript">
	$("#btn").click(function() {
		var name=$("#name").val();

		if(name=="") {
			$("#message").text("이름을 입력해 주세요.");
			return;
		}
		
		$("#name").val("");
		
		//$.ajax(settings) : AJAX 엔진을 사용하여 웹프로그램 요청해 응답결과를 제공받아 처리하기 위한 메소드
		// => 매개변수에는 AJAX 기능을 구현하기 위한 값을  Object 객체의 속성값으로 전달하여 실행
		// => 매개변수에 전달되는 Object 객체의 요소 이름은 정해져 있으며 값 또는 함수로 요소값으로 제공
		// => $.get() 메소드 또는 $.post() 메소드를 호출하여 AJAX 기능 구현 가능
		/*
		$.ajax({
			type: "post",//요청방식 설정 - 생략된 경우 GET 방식으로 요청
			url: "welcome_two.jsp",//요청 웹프로그램의 URL 주소 설정
			data: "name="+name,//요청 웹프로그램에게 전달할 값 설정
			dataType: "text",//응답결과에 대한 문서형식 - 요소값 : text, html, script, xml, json 등
			//정상적인 응답결과를 제공받은 경우 처리할 명령을 작성하는 함수 설정 - 상태코드 : 200
			// => 요소값으로 설정된 함수의 매개변수에는 자동으로 응답결과를 제공받아 저장
			success: function(result) {
				$("#message").text(result);	
			},
			//비정상적인 응답결과를 제공받은 경우 처리할 명령을 작성하는 함수 설정 - 상태코드 : 4XX or 5XX
			// => 요소값으로 설정된 함수의 매개변수에는 자동으로 XMLHttpRequest 객체를 제공받아 저장
			error: function(xhr) {
				alert("에러코드 = "+xhr.status);
			}
		});
		*/
		
		//$.post(url[, data][, success][, dataType]) : AJAX 엔진을 사용하여 웹프로그램을 POST
		//방식으로 요청하여 응답결과를 제공받아 처리하기 위한 메소드
		$.post("welcome_two.jsp", "name="+name, function(result) {
			$("#message").text(result);	
		}, "text");
	});	
	</script>
</body>
</html>
