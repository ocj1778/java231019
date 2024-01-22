<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생번호를 전달받아 STUDENT 테이블에 저장된 학생정보를 검색하여 입력태그의 초기값으로
출력하고 변경값 입력받기 위한 JSP 문서 --%>
<%-- => [학생변경] 태그를 클릭한 경우 [updateStudent.jsp] 문서를 요청하여 페이지 이동 - 입력값(학생정보) 전달 --%>
<%-- => [학생목록] 태그를 클릭한 경우 [displayStudent.jsp] 문서를 요청하여 페이지 이동 --%>
<%
	//전달값이 없는 경우에 대한 응답 처리 - 비정상적인 요청 
	if(request.getParameter("no")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
		
	//전달값을 반환받아 변수에 저장	
	int no=Integer.parseInt(request.getParameter("no"));
	
	//학생번호를 전달받아 STUDENT 테이블에 저장된 행을 검색하여 학생정보(StudentDTO 객체)를
	//반환하는 StudentDAO 클래스의 메소드 호출
	StudentDTO student=StudentDAO.getDAO().selectStudent(no);
	
	//검색된 학생정보가 없는 경우에 대한 응답 처리 - 비정상적인 요청
	if(student==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>   
</head>
<body>
	<h1 align="center">학생정보 변경</h1>
	<hr>
	<form name="studentForm">
	<%-- <input type="hidden" name="no" value="<%=student.getNo()%>"> --%>
	<table align="center" border="1" cellpadding="1" cellspacing="0" width="300">
		<tr height="40">
			<th bgcolor="yellow" width="100">학생번호</th>
			<td width="200" align="center">
				<input type="text" name="no" value="<%=student.getNo()%>" readonly="readonly">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">이름</th>
			<td width="200" align="center">
				<input type="text" name="name" value="<%=student.getName()%>">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">전화번호</th>
			<td width="200" align="center">
				<input type="text" name="phone" value="<%=student.getPhone()%>">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">주소</th>
			<td width="200" align="center">
				<input type="text" name="address" value="<%=student.getAddress()%>">
			</td>
		</tr>
		<tr height="40">
			<th bgcolor="yellow" width="100">생년월일</th>
			<td width="200" align="center">
				<input type="text" name="birthday" value="<%=student.getBirthday().substring(0, 10)%>">
			</td>
		</tr>
		<tr height="40">
			<td width="200" colspan="2" align="center">
				<input type="button" value="학생변경" onclick="submitCheck();">
				<input type="reset" value="초기화">
				<input type="button" value="학생목록" onclick="location.href='displayStudent.jsp';">
			</td>
		</tr>
	</table>
	</form>
	<script type="text/javascript">
	function submitCheck() {
		if(studentForm.name.value=="") {
			alert("이름을 입력해 주세요.");
			studentForm.name.focus();
			return;
		}

		if(studentForm.phone.value=="") {
			alert("전화번호를 입력해 주세요.");
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
			alert("주소를 입력해 주세요.");
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

		studentForm.method="post";
		studentForm.action="updateStudent.jsp";
		studentForm.submit();
	} 
	</script>
</body>
</html>