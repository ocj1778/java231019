<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<style type="text/css">
#display {
	width: 50%;
	padding: 5px;
	margin: 10px;
	font-size: 30px;
	border: 1px solid red;
}
</style>
</head>
<body>
	<h1>AJAX - 입력값 전달</h1>
	<hr>
	<div id="display">요청 웹프로그램의 응답결과 출력</div>
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="id"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" id="name"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="button" id="getBtn">입력완료(GET)</button>
				<button type="button" id="postBtn">입력완료(POST)</button>
			</td>
		</tr>
	</table>
	
	<script type="text/javascript">
	//[입력완료(GET)] 태그를 클릭한 경우 AJAX 엔진을 사용하여 [data_two.jsp] 문서를 GET 방식으로 
	//요청하여 응답결과를 제공받아 태그내용 변경
	// => [data_two.jsp] 문서를 요청할 때 입력태그의 입력값 전달
	document.getElementById("getBtn").onclick=function() {
		//입력태그의 입력값을 반환받아 저장
		var id=document.getElementById("id").value;
		//입력값 검증
		if(id=="") {
			document.getElementById("display").innerHTML="아이디를 입력해 주세요.";
			return;
		}
		
		var name=document.getElementById("name").value;
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		//입력태그 초기화
		document.getElementById("id").value="";
		document.getElementById("name").value="";
		
		//XMLHttpRequest 객체 생성
		var xhr=new XMLHttpRequest();
		
		//XMLHttpRequest 객체의 준비상태가 변경되는 이벤트가 발생될 경우 호출할 이벤트 처리 함수 등록
		xhr.onreadystatechange=function() {
			//XMLHttpRequest 객체에 요청 웹프로그램의 응답결과를 전달받아 저장한 경우
			if(xhr.readyState==4) {
				//XMLHttpRequest 객체에 저장된 응답결과가 정상적인 경우
				if(xhr.status==200) {
					//XMLHttpRequest 객체에 저장된 응답결과로 태그내용 변경
					document.getElementById("display").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}	
		}
		
		//XMLHttpRequest 객체로 [data_two.jsp] 문서를 [GET] 방식으로 요청하도록 설정
		// => GET 방식으로 웹프로그램을 요청한 경우 질의문자열(QueryString)을 이용하여 값 전달
		//문제점)일부 브라우저에서는 질의문자열에 URL 주소로 표현 불가능한 문자가 존재할 경우 400 에러코드 발생
		//해결법)입력값을 부호화 처리하여 질의문자열로 전달
		name=encodeURIComponent(name);
		xhr.open("get", "data_two.jsp?id="+id+"&name="+name);
		
		//XMLHttpRequest 객체로 open() 메소드로 설정된 웹프로그램 요청
		// => GET 방식으로 요청한 경우 send() 메소드의 매개변수에는 [null]을 전달하여 호출
		xhr.send(null);
	}
	
	//[입력완료(POST)] 태그를 클릭한 경우 AJAX 엔진을 사용하여 [data_two.jsp] 문서를 POST 방식으로 
	//요청하여 응답결과를 제공받아 태그내용 변경
	// => [data_two.jsp] 문서를 요청할 때 입력태그의 입력값 전달
	document.getElementById("postBtn").onclick=function() {
		var id=document.getElementById("id").value;
		if(id=="") {
			document.getElementById("display").innerHTML="아이디를 입력해 주세요.";
			return;
		}
		
		var name=document.getElementById("name").value;
		if(name=="") {
			document.getElementById("display").innerHTML="이름을 입력해 주세요.";
			return;
		}
		
		document.getElementById("id").value="";
		document.getElementById("name").value="";
		
		var xhr=new XMLHttpRequest();
		
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				if(xhr.status==200) {
					document.getElementById("display").innerHTML=xhr.responseText;
				} else {
					alert("에러코드 = "+xhr.status);
				}
			}	
		}
		
		//XMLHttpRequest 객체로 [data_two.jsp] 문서를 [POST] 방식으로 요청하도록 설정
		xhr.open("post", "data_two.jsp");

		//XMLHttpRequest 객체로 open() 메소드로 설정된 웹프로그램 요청
		// => POST 방식으로 요청한 경우 send() 메소드의 매개변수에 [이름=값&이름=값&...]
		//형식의 문자값으로 입력값을 전달하여 메소드 호출
		//문제점)전달값이 [multipart/form-data] 형식으로 전달되므로 AJAX 엔진으로 요청한
		//웹프로그램에서 request 객체로 전달값을 반환받아 사용 불가능
		//해결법)전달값이 [application/x-www-form-urlencoded] 형식으로 전달되도록 리퀘스트
		//머릿부(Header)의 정보 변경
		//XMLHttpRequest.setRequestHeader(header,value) : XMLHttpRequest 객체로 웹프로그램을
		//요청하기 전에 리퀘스트 메세지 머릿부의 정보를 변경하는 메소드
		// => 리퀘스트 메세지 몸체부에 저장되어 전달되는 값을 문자데이타로 전달되도록 변경
		// => XMLHttpRequest 객체로 open() 메소드 호출 후 변경 가능
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		
		xhr.send("id="+id+"&name="+name);//리퀘스트 메세지 몸체부에 입력값을 저장하여 전달
	}
	</script>
</body>
</html>