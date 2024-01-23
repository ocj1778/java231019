<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 MEMBER 테이블의 저장된 행의 아이디와 비교하여 중복 결과값을 응답하는 JSP 문서 --%>
<%-- => 아이디 미중복 : 아이디 사용 가능 메세지 출력하고 [아이디 사용] 태그를 클릭하면 부모창의
입력태그에 입력값을 변경하고 팝업창 종료 --%>
<%-- => 아이디 중복 : 아이디 사용 불가능 메세지 출력하고 아이디를 입력받아 현재 JSP 문서(id_check.jsp) 요청 - 입력값 전달 --%>
<%
	//전달값을 반환받아 저장
	String id=request.getParameter("id");

	//전달값이 없는 경우에 대한 응답 처리 - 비정상적인 요청
	if(id==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//아이디를 전달받아 MEMBER 테이블에 저장된 행을 검색하여 회원정보로 반환하는 MemberDAO 클래스의 메소드 호출
	// => null 반환 : 회원정보 미검색 - 아이디 미중복(아이디 사용 가능)
	// => MemberDTO 객체 반환 : 회원정보 검색 - 아이디 중복(아이디 사용 불가능)
	MemberDTO member=MemberDAO.getDAO().selectMemberById(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style type="text/css">
div {
	text-align: center;
	margin: 10px;
}

.id {
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
	<% if(member==null) {//전달받은 아이디가 중복되지 않은 경우 %>
		<div>입력된 <span class="id">[<%=id %>]</span>는 사용 가능한 아이디입니다.</div>
		<div>
			<button type="button" onclick="selectId();">아이디 사용</button>
		</div>
		
		<script type="text/javascript">
		function selectId() {
			//opener 객체 : 팝업창을 실행한 부모창을 표현하기 위한 자바스트립트 객체
			opener.join.id.value="<%=id%>";//부모창에 입력태그(아이디)의 입력값 변경
			opener.join.idCheckResult.value="1";//부모창에 입력태그(아이디 중복 검사 실행 여부)의 입력값 변경
			window.close();//창닫기 - 팝업창 종료
		}
		</script>
	<% } else {//전달받은 아이디가 중복된 경우 %>
		<div>입력된 <span class="id">[<%=id %>]</span>는 이미 사용중인 아이디입니다.<br>
		새로운 아이디를 입력하고 [확인] 버튼을 눌러주세요.</div>
		<div>
			<%-- form 태그의 action 속성이 생략되면 현재 JSP 문서 요청 --%>
			<%-- form 태그의 method 속성이 생략되면 [GET] 방식으로 JSP 문서 요청 --%>
			<form name="checkForm">
				<input type="text" name="id">
				<button type="button" onclick="idCheck();">확인</button>
			</form>
		</div>
		<div id="message" style="color: red;"></div>
		
		<script type="text/javascript">
		function idCheck() {
			var id=checkForm.id.value;
			if(id=="") {
				document.getElementById("message").innerHTML="아이디를 입력해 주세요.";
				return;
			}
			
			var idReg=/^[a-zA-Z]\w{5,19}$/g;
			if(!idReg.test(id)) {
				document.getElementById("message").innerHTML="아이디를 형식에 맞게 입력해 주세요.";
				return;
			}
			
			checkForm.submit();
		}
		</script>
	<% } %>		
</body>
</html>
