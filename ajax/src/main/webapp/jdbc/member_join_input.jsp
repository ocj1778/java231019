<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 입력받기 위한 JSP 문서 --%>
<%-- => [회원가입] 태그를 클릭한 경우 [member_join_action.jsp] 문서를 요청하여 페이지 이동 - 입력값 전달 --%>
<%-- => form 태그를 사용하여 [member_join_action.jsp] 문서를 요청하기 전에 입력값에 대한 검증 --%>
<%-- => 아이디에 대한 중복 검증은 AJAX 엔진을 사용하여 처리 --%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
.title {
	width: 100px;
	padding-right: 10px;
	text-align: center;
	font-weight: bold;
}

.input {
	width: 200px;
}

.message {
	width: 500px;
	color: red;
}

.msg {
	display: none;
}

#btn {
	text-align: center;
}
</style>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="<%=request.getContextPath()%>/jdbc/memeber_join_action.jsp" method="post" id="joinForm">
	<table>
		<tr>
			<td class="title">아이디</td>
			<td class="input"><input type="text" name="id" id="id"></td>
			<td class="message">
				<span id="idNullMsg" class="msg idMsg">아이디를 입력해 주세요.</span>
				<span id="idValidMsg" class="msg idMsg">아이디를 형식에 맞게 입력해 주세요.</span>
				<span id="idDuplMsg" class="msg idMsg">이미 사용중인 아이디입니다.</span>
			</td>
		</tr>
		<tr>
			<td class="title">비밀번호</td>
			<td class="input"><input type="password" name="passwd" id="passwd"></td>
			<td class="message">
				<span id="passwdNullMsg" class="msg">비밀번호를 입력해 주세요.</span>
				<span id="passwdValidMsg" class="msg">비밀번호를 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td class="title">이름</td>
			<td class="input"><input type="text" name="name" id="name"></td>
			<td class="message">
				<span id="nameNullMsg" class="msg">이름을 입력해 주세요.</span>
				<span id="nameValidMsg" class="msg">이름을 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td class="title">이메일</td>
			<td class="input"><input type="text" name="email" id="email"></td>
			<td class="message">
				<span id="emailNullMsg" class="msg">이메일을 입력해 주세요.</span>
				<span id="emailValidMsg" class="msg">이메일을 형식에 맞게 입력해 주세요.</span>
			</td>
		</tr>
		<tr>
			<td colspan="2" id="btn"><button type="submit">회원가입</button></td> 
		</tr>
	</table>	
	</form>

	<script type="text/javascript">
	//아이디 중복 검증에 대한 결과값을 저장하기 위한 전역변수
	// => false : 아이디 중복에 의한 사용 불가능, true : 아이디 미중복에 의한 사용 가능
	var idCheckResult=false;
	
	$("#id").focus();
	
	$("#joinForm").submit(function() {
		//메세지 관련 엘리먼트가 출력되지 않도록 숨김 처리
		$(".msg").hide();
		
		//검증 결과를 저장하기 위한 변수
		// => false : 검증 실패 - form 태그 실행 취소, true : 검증 성공 - form 태그 실행
		var validResult=true;
		
		var id=$("#id").val();
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(id=="") {
			$("#idNullMsg").show();
			validResult=false;
		} else if(!idReg.test(id)) {
			$("#idValidMsg").show();
			validResult=false;
		} else if(!idCheckResult) {//아이디가 중복된 경우
			$("#idDuplMsg").show();
			validResult=false;
		}
		
		var passwd=$("#passwd").val();
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(passwd=="") {
			$("#passwdNullMsg").show();
			validResult=false;
		} else if(!idReg.test(passwd)) {
			$("#passwdValidMsg").show();
			validResult=false;
		}
		
		var name=$("#name").val();
		var nameReg=/^[가-힣]{2,10}$/g;
		if(name=="") {
			$("#nameNullMsg").show();
			validResult=false;
		} else if(!nameReg.test(name)) {
			$("#nameValidMsg").show();
			validResult=false;
		}
		
		var email=$("#email").val();
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(email=="") {
			$("#emailNullMsg").show();
			validResult=false;
		} else if(!emailReg.test(email)) {
			$("#emailValidMsg").show();
			validResult=false;
		}
		
		return validResult;		
	});
	
	//입력태그(아이디)에서 키보드를 누르는 이벤트가 발생된 경우 호출된 이벤트 처리 함수 등록
	$("#id").keyup(function() {
		var id=$(this).val();
		if(id.length < 6) return;
		
		$.ajax({
			type: "get",
			url: "member_id_check.jsp",
			data: "id="+id,
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

















