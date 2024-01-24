<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 검색하기 위해 사용자로부터 이름과 이메일을 입력받기 위한 JSP 문서 --%>
<style type="text/css">
.search_tag {
	margin: 5px auto;
	width: 300px;
}

#searchForm label {
	text-align: right;
	width: 100px;
	float: left;
}

#searchForm ul li {
	list-style-type: none;
	margin-bottom: 10px;
}

#searchForm input:focus {
	border: 2px solid aqua;
}

#search_btn {
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

#message {
	color: red;
	font-weight: bold;
}
</style>
<h1>아이디 찾기</h1>
<form action="<%=request.getContextPath()%>/index.jsp?group=member&worker=search_id_action"
	method="post" name="searchForm" id="searchForm">
	<ul class="search_tag">
		<li>
			<label for="name">이름</label>
			<input type="text" name="name" id="name">	
		</li>
		<li>
			<label for="email">이메일</label>
			<input type="text" name="email" id="email">	
		</li>
	</ul>	
	<div id="search_btn">아이디 검색</div>
</form>
<div id="message"></div>

<script type="text/javascript">
$("#name").focus();

$("#search_btn").click(function() {
	if($("#name").val()=="") {
		$("#message").text("이름을 입력해 주세요.");
		$("#name").focus();
		return;
	}	
	
	if($("#email").val()=="") {
		$("#message").text("이메일을 입력해 주세요.");
		$("#email").focus();
		return;
	}	
	
	$("#searchForm").submit();
});
</script>