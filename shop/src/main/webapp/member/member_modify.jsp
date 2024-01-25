<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비밀번호를 전달받아 MEMBER 테이블에 저장된 회원정보의 비밀번호와 비교하여 같은 경우 회원정보를
입력태그의 입력값으로 출력하고 사용자로부터 변경값을 입력받기 위한 JSP 문서 --%>
<%-- => MEMBER 테이블에서 회원정보를 검색하지 않고 session 객체에 저장된 속성값을 반환받아 사용  --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => [우편번호 검색] 태그를 클릭한 경우 [다음 우편번호 서비스]를 사용하여 입력태그(우편번호와 기본주소)의 입력값 변경 --%>    
<%-- => [회원변경] 태그를 클릭한 경우 [/member/member_modify_action.jsp] 문서를 요청하여 페이지 이동 - 입력값 전달 --%>
<%@include file="/security/login_check.jspf" %>  
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}	

	//전달값을 반환받아 저장
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//로그인 상태의 사용자 비밀번호와 전달받은 비밀번호를 비교하여 같지 않은 경우에 대한 응답 처리
	if(!loginMember.getPasswd().equals(passwd)) {
		session.setAttribute("message", "입력하신 비밀번호가 맞지 않습니다.");	
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=password_confirm&action=modify");
		return;
	}
%>    
<style type="text/css">
fieldset {
	text-align: left;
	margin: 10px auto;
	width: 1100px;
}

legend {
	font-size: 1.2em;
}

#join label {
	width: 150px;
	text-align: right;
	float: left;
	margin-right: 10px;
}

#join ul li {
	list-style-type: none;
	margin: 15px 0;
}

#fs {
	text-align: center;
}

.error {
	color: red;
	position: relative;
	left: 160px;
	display: none;
}

#idCheck, #postSearch {
	font-size: 12px;
	font-weight: bold;
	cursor: pointer;
	margin-left: 10px;
	padding: 2px 10px;
	border: 1px solid black;
}

#idCheck:hover, #postSearch:hover {
	background: black;
	color: white;
}
</style>
<form id="join" action="<%=request.getContextPath() %>/index.jsp?group=member&worker=member_modify_action" method="post">
<input type="hidden" name="memberNum" value="<%=loginMember.getMemberNum()%>">
<fieldset>
	<legend>회원정보</legend>
	<ul>
		<li>
			<label for="id">아이디</label>
			<input type="text" name="id" id="id" value="<%=loginMember.getId() %>" readonly="readonly">
		</li>
		<li>
			<label for="passwd">비밀번호</label>
			<input type="password" name="passwd" id="passwd">
			<span style="color: red;">비밀번호를 변경하지 않을 경우 입력하지 마세요.</span>
			<div id="passwdRegMsg" class="error">비밀번호는 영문자,숫자,특수문자가 반드시 하나이상 포함된 6~20 범위의 문자로만 작성 가능합니다.</div>
		</li>
		<li>
			<label for="name">이름</label>
			<input type="text" name="name" id="name"  value="<%=loginMember.getName()%>">
			<div id="nameMsg" class="error">이름을 입력해 주세요.</div>
		</li>
		<li>
			<label for="email">이메일</label>
			<input type="text" name="email" id="email" value="<%=loginMember.getEmail()%>">
			<div id="emailMsg" class="error">이메일을 입력해 주세요.</div>
			<div id="emailRegMsg" class="error">입력한 이메일이 형식에 맞지 않습니다.</div>
		</li>
		<li>
			<% String[] mobile=loginMember.getMobile().split("-"); %>
			<label for="mobile2">전화번호</label>
			<select name="mobile1">
				<option value="010" <% if(mobile[0].equals("010")) { %> selected <% } %>>&nbsp;010&nbsp;</option>
				<option value="011" <% if(mobile[0].equals("011")) { %> selected <% } %>>&nbsp;011&nbsp;</option>
				<option value="016" <% if(mobile[0].equals("016")) { %> selected <% } %>>&nbsp;016&nbsp;</option>
				<option value="017" <% if(mobile[0].equals("017")) { %> selected <% } %>>&nbsp;017&nbsp;</option>
				<option value="018" <% if(mobile[0].equals("018")) { %> selected <% } %>>&nbsp;018&nbsp;</option>
				<option value="019" <% if(mobile[0].equals("019")) { %> selected <% } %>>&nbsp;019&nbsp;</option>
			</select>
			- <input type="text" name="mobile2" id="mobile2" value="<%=mobile[1]%>" size="4" maxlength="4">
			- <input type="text" name="mobile3" id="mobile3" value="<%=mobile[2]%>" size="4" maxlength="4">
			<div id="mobileMsg" class="error">전화번호를 입력해 입력해 주세요.</div>
			<div id="mobileRegMsg" class="error">전화번호는 3~4 자리의 숫자로만 입력해 주세요.</div>
		</li>
		<li>
			<label>우편번호</label>
			<input type="text" name="zipcode" id="zipcode" value="<%=loginMember.getZipcode()%>" size="7" readonly="readonly">
			<span id="postSearch">우편번호 검색</span>
			<div id="zipcodeMsg" class="error">우편번호를 입력해 주세요.</div>
		</li>
		<li>
			<label for="address1">기본주소</label>
			<input type="text" name="address1" id="address1" value="<%=loginMember.getAddress1()%>" size="50" readonly="readonly">
			<div id="address1Msg" class="error">기본주소를 입력해 주세요.</div>
		</li>
		<li>
			<label for="address2">상세주소</label>
			<input type="text" name="address2" id="address2"  value="<%=loginMember.getAddress2()%>" size="50">
			<div id="address2Msg" class="error">상세주소를 입력해 주세요.</div>
		</li>
	</ul>
</fieldset>
<div id="fs">
	<button type="submit">회원변경</button>
	<button type="reset">다시입력</button>
</div>
</form>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$("#id").focus();

$("#join").submit(function() {
	var submitResult=true;
	
	$(".error").css("display","none");

	var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
	if($("#passwd").val()!="" && !passwdReg.test($("#passwd").val())) {
		$("#passwdRegMsg").css("display","block");
		submitResult=false;
	} 
	
	if($("#name").val()=="") {
		$("#nameMsg").css("display","block");
		submitResult=false;
	}
	
	var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
	if($("#email").val()=="") {
		$("#emailMsg").css("display","block");
		submitResult=false;
	} else if(!emailReg.test($("#email").val())) {
		$("#emailRegMsg").css("display","block");
		submitResult=false;
	}

	var mobile2Reg=/\d{3,4}/;
	var mobile3Reg=/\d{4}/;
	if($("#mobile2").val()=="" || $("#mobile3").val()=="") {
		$("#mobileMsg").css("display","block");
		submitResult=false;
	} else if(!mobile2Reg.test($("#mobile2").val()) || !mobile3Reg.test($("#mobile3").val())) {
		$("#mobileRegMsg").css("display","block");
		submitResult=false;
	}
	
	if($("#zipcode").val()=="") {
		$("#zipcodeMsg").css("display","block");
		submitResult=false;
	}
	
	if($("#address1").val()=="") {
		$("#address1Msg").css("display","block");
		submitResult=false;
	}
	
	if($("#address2").val()=="") {
		$("#address2Msg").css("display","block");
		submitResult=false;
	}
	
	return submitResult;
});

$("#postSearch").click(function() {
	new daum.Postcode({
		oncomplete: function(data) {
			$("#zipcode").val(data.zonecode);
			$("#address1").val(data.address);
		} 
	}).open();
});
</script>