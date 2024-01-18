<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- 페이지 머릿부(Header) --%>
	<h1><a href="<%=request.getContextPath() %>/action/include/index.jsp">메인 페이지</a></h1>
	<a href="<%=request.getContextPath() %>/action/include/mail.jsp">메일(Mail)</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/action/include/blog.jsp">블로그(Blog)</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/action/include/cafe.jsp">카페(Cafe)</a>&nbsp;&nbsp;
	<hr>
	
	<%-- 페이지 몸체부(Content) --%>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	
	<%-- 페이지 꼬릿부(Footer) --%>
	<hr>
	<p>Copyright © itwill Corp. All rights reserved.</p>
</body>
</html>






