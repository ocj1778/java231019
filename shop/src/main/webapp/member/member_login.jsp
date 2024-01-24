<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 사용자로부터 인증정보(아이디와 비밀번호)를 입력받기 위한 JSP 문서 --%>
<%-- => [로그인] 태그를 클릭한 경우 [/member/member_login_action.jsp] 문서를 요청하여 페이지 이동 - 입력값 전달 --%>
<%
	String message=(String)session.getAttribute("message");
	if(message==null) {
		message="";
	} else {
		session.removeAttribute("message");
	}
	
	String id=(String)session.getAttribute("id");
	if(id==null) {
		id="";
	} else {
		session.removeAttribute("id");
	}
%>
<style type="text/css">
#space {
	height: 50px;
}

.login_tag {
	margin: 5px auto;
	width: 300px;
}

#loginForm label {
	text-align: right;
	width: 100px;
	float: left;
}

#loginForm ul li {
	list-style-type: none;
	margin-bottom: 10px;
}

#loginForm input:focus {
	border: 2px solid aqua;
}

#login_btn {
	margin: 0 auto;
	padding: 5px;
	width: 300px;
	background-color: black;
	color: white;
	font-size: 1.2em;
	cursor: pointer;
	letter-spacing: 20px;
	font-weight: bold;
}

#search {
	margin-top: 10px;
	margin-bottom: 20px;
}

#message {
	color: red;
	font-weight: bold;
}

a:hover {
	color: blue;
	text-decoration: underline;
}
</style>
<div id="space"></div>
<form  action="<%=request.getContextPath() %>/index.jsp?group=member&worker=member_login_action" 
	method="post" id="loginForm" name="loginForm">
	<ul class="login_tag">
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="<%=id%>">	
		</li>
		<li>
			<label for="passwd">비밀번호</label>
			<input type="password" name="passwd" id="passwd">	
		</li>
	</ul>	
	<div id="login_btn">로그인</div>
</form>
<div id="search">
	<a href="#">아이디 찾기</a> |
	<a href="#">비밀번호 찾기</a>
</div>
<div id="message"><%=message %></div>

<script type="text/javascript">
$("#id").focus();

$("#login_btn").click(function() {
	if($("#id").val()=="") {
		$("#message").text("아이디를 입력해 주세요.");
		$("#id").focus();
		return;
	}	
	
	if($("#passwd").val()=="") {
		$("#message").text("비밀번호를 입력해 주세요.");
		$("#passwd").focus();
		return;
	}	
	
	$("#loginForm").submit();
});
</script>
