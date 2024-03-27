<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Spring 프레임워크에서 제공하는 폼태그 라이브러리 --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SPRING</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>사원등록</h1>
	<hr>
	<c:url var="url" value="/valid/spring"/>
	<%-- Spring form 태그 : 페이지를 요청하여 입력값을 전달하는 태그 --%>
	<%-- modelAttribute 속성(필수) : 요청 처리 메소드의 매개변수에 저장된 Command 객체의 속성명을
	속성값으로 설정 --%>
	<%-- => 전달값에 대한 검증 실패시 사용자 입력값이 저장된 Command 객체를 제공받아 사용 --%>
	<form:form action="${url }" method="post" modelAttribute="employee" id="registerForm">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<%-- Spring input 태그 : 문자열을 입력받기 위한 태그 --%>
				<%-- => HTML input 태그의 type 속성값을 [text]로 설정한 것과 동일 --%>
				<%-- path 속성 : 값을 전달하기 위한 이름을 속성값으로 설정 --%>
				<%-- => HTML input 태그의 name 속성과 id 속성을 설정하는 것과 동일 --%>
				<%-- => 유효성 검증 실패시 value 속성으로 Command 객체의 필드값을 제공받아 초기값으로 사용 --%>
				<form:input path="id"/>
				
				<%-- Spring errors 태그 : 에러메세지를 제공받아 출력하기 위한 태그 --%>
				<%-- path 속성 : 에러메세지를 제공받아 출력하기 위한 식별자(전달값의 이름)을 속성값으로 설정 --%>
				<%-- cssClass 속성 : CSS 스타일의 클래스 선택자를 속성값으로 설정 --%>
				<%-- element 속성 : 에러메세지를 출력하기 위한 태그를 속성값으로 설정 --%>
				<%-- delimiter 속성 : 다수의 에러메세지가 전달된 경우 에러메세지를 구분하기 위한 식별자를 속성값으로 설정 --%>				
				<form:errors path="id" cssClass="error" element="span" delimiter=" "/>
				<span id="idMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<%-- Spring password 태그 : 문자열을 입력받기 위한 태그 --%>
				<%-- => HTML input 태그의 type 속성값을 [password]로 설정한 것과 동일 --%>
				<form:password path="passwd"/>
				<form:errors path="passwd" cssClass="error" element="span" delimiter=" "/>
				<span id="passwdMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<form:input path="name"/>
				<form:errors path="name" cssClass="error" element="span" delimiter=" "/>
				<span id="nameMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>
				<form:input path="email"/>
  				<form:errors path="email" cssClass="error" element="span" delimiter=" "/>
				<span id="emailMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<%-- Spring radiobutton 태그 : 목록 중 하나만 선택하여 값을 전달하기 위한 태그 --%>
				<%-- => HTML input 태그의 type 속성값을 [radio]로 설정한 것과 동일 --%>
				<%-- 
				남자<form:radiobutton path="gender" cssClass="gender" value="남자"/>&nbsp;&nbsp;
				여자<form:radiobutton path="gender" cssClass="gender" value="여자"/>
				--%>
				<%-- Spring radiobuttons 태그 : 목록 중 하나만 선택하여 값을 전달하기 위한 태그 --%>
				<%-- => 요청 처리 메소드로 제공받은 List 객체의 요소값을 선택 가능한 목록으로
				출력하여 값을 입력받기 위해 사용 --%>
				<%-- items 속성 : List 객체를 속성값으로 사용 - EL 사용 가능 --%>
				<form:radiobuttons path="gender" items="${genderList }"/>
								
  				<form:errors path="gender" cssClass="error" element="span" delimiter=" "/>
				<span id="genderMsg" class="error"></span>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<%-- Spring button 태그 : 제출 이벤트(Submit Event)를 발생하기 위한 태그 --%>
				<%-- => HTML button 태그의 type 속성값을 [submit]로 설정한 것과 동일 --%>
				<form:button>등록</form:button>
			</td>
		</tr>
	</table>		
	</form:form>
	
	<%-- 
	<script type="text/javascript">
	$("#registerForm").submit(function() {
		var validResult=true;
		
		$(".error").html("").hide();
		
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if($("#id").val()=="") {
			$("#idMsg").html("아이디를 입력해 주세요.");
			validResult=false;
		} else if(!idReg.test($("#id").val())) {
			$("#idMsg").html("아이디를 형식에 맞게 입력해 주세요.");
			validResult=false;
		}
		
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if($("#passwd").val()=="") {
			$("#passwdMsg").html("비밀번호를 입력해 주세요.");
			validResult=false;
		} else if(!passwdReg.test($("#passwd").val())) {
			$("#passwdMsg").html("비밀번호를 형식에 맞게 입력해 주세요.");
			validResult=false;
		} 
		
		if($("#name").val()=="") {
			$("#nameMsg").html("이름을 입력해 주세요.");
			validResult=false;
		}
		
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if($("#email").val()=="") {
			$("#emailMsg").html("이메일을 입력해 주세요.");
			validResult=false;
		} else if(!emailReg.test($("#email").val())) {
			$("#emailMsg").html("이메일을 형식에 맞게 입력해 주세요.");
			validResult=false;
		}

		if($(".gender").filter(":checked").length == 0) {
			$("#genderMsg").html("성별을 선택해 주세요.");
			validResult=false;
		}
 		
		$(".error").show();
		
		return validResult;
	});
	</script>
	--%>
</body>
</html>