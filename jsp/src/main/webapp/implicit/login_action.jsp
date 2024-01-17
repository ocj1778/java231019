<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 인증정보(아이디와 비밀번호)를 전달받아 인증 처리하기 위한 JSP 문서 --%>
<%-- => [login_form.jsp] 문서의 form 태그를 사용하여 POST 방식으로 요청하는 JSP 문서 --%>    
<%
	//request.getMethod() : JSP 문서를 요청한 요청방식(GET 또는 POST)을 반환하는 메소드
	if(request.getMethod().equals("GET")) {//JSP 문서를 GET 방식으로 요청한 경우 - 비정상적인 요청
		/*
		//response.sendError(int sc) : 클라이언트에게 에러코드(4XX or 5XX)를 전달하여 응답하는 메소드
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
		*/
		
		//response.sendRedirect(String url) : 클라이언트에게 URL 주소를 전달하영 응답하는 메소드
		// => URL 주소를 응답받은 클라이언트는 브라우저의 요청 URL 주소를 변경하여 JSP 문서를 
		//요청하고 실행결과를 응답받아 출력 - 리다이렉트를 사용한 페이지 이동(리다이렉트 이동)
		
		//[login_form.jsp] 문서를 요청하기 위한 URL 주소를 전달하여 응답
		// => 질의문자열(QueryString)을 사용하여 [login_form.jsp] 문서에 문자값(에러메세지) 전달
		//요청 URL 주소는 영문자, 숫자, 일부 특수문자를 제외한 문자 사용 불가능
		// => 질의문자열에 영문자, 숫자, 일부 특수문자외의 문자가 포함되어 있는 경우 에러(IllegalArgumentException) 발생
		// => 영문자, 숫자, 일부 특수문자외의 문자는 부호화 처리하여 URL 주소로 사용 가능
		//String message="비정상적인 방법으로 페이지를 요청 하였습니다.";
		
		//URLEncoder.encode(String s, String enc) : 매개변수로 전달받은 문자열을 원하는 문자형태의
		//유니코드로 부호화 처리하여 반환하는 메소드
		// => JavaScript의 encodeURIComponent() 함수와 동일한 기능 제공
		String message=URLEncoder.encode("비정상적인 방법으로 페이지를 요청 하였습니다.", "utf-8");
		//System.out.println("message = "+message);
		response.sendRedirect("login_form.jsp?msg="+message);
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

</body>
</html>