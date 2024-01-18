<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	//String header="/action/include/header.jspf";
	String header="/action/include/header.jsp";

	String category=request.getParameter("category");
	
	if(category==null) {
		category="main";
	}
	
	//전달값을 이용하여 페이지 몸체부에 포함될 JSP 문서의 경로를 생성하여 저장
	String contentPath="/action/include/"+category+".jsp";
	
	String master="";
	if(category.equals("main")) {
		master="홍길동(main@itwill.xyz)";
	} else if(category.equals("mail")) {
		master="임꺽정(mail@itwill.xyz)";
	} else if(category.equals("blog")) {
		master="전우치(blog@itwill.xyz)";
	} else if(category.equals("cafe")) {
		master="일지매(cafe@itwill.xyz)";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%-- 페이지 머릿부(Header) --%>
	<%-- 
	<h1><a href="<%=request.getContextPath() %>/action/include/index.jsp">메인 페이지</a></h1>
	<a href="<%=request.getContextPath() %>/action/include/mail.jsp">메일(Mail)</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/action/include/blog.jsp">블로그(Blog)</a>&nbsp;&nbsp;
	<a href="<%=request.getContextPath() %>/action/include/cafe.jsp">카페(Cafe)</a>&nbsp;&nbsp;
	<hr>
	--%>
	<%-- include Directive : 외부파일(JSPF)의 소스코드를 JSP 문서에 포함하는 지시어 --%>
	<%-- => CSL(HTML, CSS, JavaScript) 및 SSL(Java - Script Element)로 구성된 소스코드 포함 - 정적포함 --%>
	<%-- => JSP 문서를 요청한 경우 include Directive의 file 속성값으로 설정된 외부파일의 
	소스코드를 요청 JSP 문서에 포함하고 실행된 결과를 클라이언트에게 전달하여 응답 --%>
	<%-- => include Directive의 file 속성값으로 설정된 외부파일의 내용이 변경될 경우 JSP 문서가
	변경되는 것과 동일하므로 JSP 문서를 서블릿으로 다시 생성하여 실행 --%>
	<%-- include Directive의 file 속성값으로 표현식(Expression) 사용 불가능 --%>
	<%-- => include Directive의 file 속성값으로 설정된 외부파일의 소스코드만 포함 가능 --%>
	<%-- <%@include file="/action/include/header.jspf" %> --%>
	
	<%-- include Tag : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이동하여 실행하고 실행결과를
	가져와 요청 JSP 문서에 포함하는 태그 --%>
	<%-- => 요청 JSP 문서에서 다른 JSP 문서로 스레드가 이동될 때 요청 JSP 문서의 request 객체와
	response 객체가 스레드가 이동되는 JSP 문서로 전달되어 사용 --%>
	<%-- => JSP 문서의 실행결과(CSL - HTML, CSS, JavaScript)를 요청 JSP 문서에 포함 - 동적 포함 --%>
	<%-- 형식) <jsp:include page="JSP 문서의 컨텍스트 경로"></jsp:include> --%>
	<%-- => page 속성값으로 설정된 JSP 문서가 없는 경우 에러 발생 --%>
	<%-- => page 속성값으로 설정된 JSP 문서가 변경돼도 요청 JSP 문서는 미영향 --%>
	<%-- include tag의 page 속성값으로 표현식(Expression) 사용 가능 --%>
	<%-- => JSP의 표현식(Expression)으로 제공되는 JSP 문서의 실행 결과 포함 --%>
	<%-- <jsp:include page="/action/include/header.jsp"></jsp:include> --%>
	<%-- <jsp:include page="/action/include/header.jsp"/> --%>
	<jsp:include page="<%=header %>"/>
	
	<%-- 페이지 몸체부(Content) --%>
	<%-- 
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	<p>메인 페이지의 내용이 출력됩니다.</p>
	--%>
	<%-- JSP 문서를 요청할 때 전달되는 값에 따라 서버 다른 JSP 문서의 실행결과 포함 --%>
	<jsp:include page="<%=contentPath %>"/>
	
	<%-- 페이지 꼬릿부(Footer) --%>
	<%-- 
	<hr>
	<p>Copyright © itwill Corp. All rights reserved.</p>
	<p>관리자 : 홍길동(abc@itwill.xyz)</p>
	--%>
	<%-- <%@include file="/action/include/footer.jspf" %> --%>

	<%-- param Tag : 스레드가 이동되는 JSP 문서에게 값을 전달하기 위한 태그 --%>
	<%-- => 리퀘스트 메세지 몸체부에 값을 저장하여 전달 --%>
	<%-- => include 태그와 forward 태그의 하위태그로 사용 --%>
	<%-- 주의점) include 태그와 forward 태그의 하위태그로 param 태그를 제외한 문장이 존재할 경우 에러 발생 --%>
	<jsp:include page="/action/include/footer.jsp">
		<jsp:param value="<%=master%>" name="master"/>
	</jsp:include>
</body>
</html>