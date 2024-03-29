<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SPRING</title>
</head>
<body>
	<h1 align="center">학생정보 입력</h1>
	<hr>
	<form action="<c:url value="/student/add"/>" method="post" name="studentForm">
	<table align="center" border="1" cellpadding="1" cellspacing="0" width="300">
		<tr height="40">
			<th bgcolor="yellow" width="100">학생번호</th>
			<td width="200" align="center">
				<input type="text" name="no" value="${student.no }">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">이름</th>
			<td width="200" align="center">
				<input type="text" name="name" value="${student.name }">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">전화번호</th>
			<td width="200" align="center">
				<input type="text" name="phone" value="${student.phone }">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">주소</th>
			<td width="200" align="center">
				<input type="text" name="address" value="${student.address }">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">생년월일</th>
			<td width="200" align="center">
				<input type="text" name="birthday" value="${student.birthday}">
			</td>
		</tr>
		<tr height="40">
			<td width="200" colspan="2" align="center">
				<input type="button" value="학생추가" onclick="submitCheck();">
				<input type="reset" value="초기화">
				<input type="button" value="학생목록" onclick="location.href='${pageContext.request.contextPath}/student/display';">
			</td>
		</tr>
	</table>
	</form>
	
	<p align="center" style="color: red;">${message }</p>
	
	<script type="text/javascript">
	studentForm.no.focus();

	function submitCheck() {
		if(studentForm.no.value=="") {
			alert("학생번호를 입력해 주세요.");
			studentForm.no.focus();
			return;
		}
		
		var noReg=/\d{4}/g;
		if(!noReg.test(studentForm.no.value)) {
			alert("학생번호는 정수 4자리로 입력해주세요.");
			studentForm.no.focus();
			return;
		}
		
		if(studentForm.name.value=="") {
			alert("이름을 입력해 주세요.");
			studentForm.name.focus();
			return;
		}

		if(studentForm.phone.value=="") {
			alert("전화번호을 입력해 주세요.");
			studentForm.phone.focus();
			return;
		}

		var phoneReg=/(01[016789])-\d{3,4}-\d{4}/g;
		if(!phoneReg.test(studentForm.phone.value)) {
			alert("전화번호를 형식에 맞게 입력해주세요.");
			studentForm.phone.focus();
			return;
		}
		
		if(studentForm.address.value=="") {
			alert("주소을 입력해 주세요.");
			studentForm.address.focus();
			return;
		}

		if(studentForm.birthday.value=="") {
			alert("생년월일을 입력해 주세요.");
			studentForm.birthday.focus();
			return;
		}
		
		var birthdayReg=/(18|19|20)\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])/g;
		if(!birthdayReg.test(studentForm.birthday.value)) {
			alert("생년월일을 형식에 맞게 입력해주세요.");
			studentForm.birthday.focus();
			return;
		}

		studentForm.submit();
	} 
	</script>
</body>
</html>