<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 템플릿 페이지를 구현하기 위한 JSP 문서 --%>
<%-- => 클라이언트의 모든 요청에 대한 실행결과를 응답하기 위한 JSP 문서 --%>
<%-- => 전달값을 이용하여 페이지 몸체부에 JSP 문서의 실행결과를 포함되도록 작성 --%>
<%
	//페이지 몸체부에 포함될 JSP 문서의 작업 폴더명을 반환받아 저장
	String group=request.getParameter("group");
	if(group==null) {
		group="main";
	}
	
	//페이지 몸체부에 포함될 JSP 문서의 파일명을 반환받아 저장
	String worker=request.getParameter("worker");
	if(worker==null) {
		worker="main_page";
	}
	
	//전달값을 사용하여 페이지 몸체부에 포함될 JSP 문서의 컨텍스트 경로를 생성하여 저장
	String contentFilePath="/"+group+"/"+worker+".jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="header">
		<jsp:include page="/header_main.jsp"/>
	</div>
	
	<div id="content">
		<jsp:include page="<%=contentFilePath%>"/>
	</div>
	
	<div id="footer">
		<jsp:include page="/footer.jsp"/>
	</div>
</body>
</html>
