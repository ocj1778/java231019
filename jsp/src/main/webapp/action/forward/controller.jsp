<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값을 이용하여 다른 JSP 문서로 포워드 이동하는 JSP 문서 --%>
<%
	//전달값을 반환받아 저장
	String pageName=request.getParameter("pageName");

	if(pageName==null) {//전달값이 없는 경우
		//클라이언트에게 URL 주소를 전달하여 응답 처리
		// => URL 주소로 응답받은 클라이언트는 브라우저의 요청 URL 주소를 변경하여 JSP 문서를
		//요청해 실행결과(HTML 문서)를 응답받아 출력 - 리다이렉트 이동
		response.sendRedirect("index.jsp");
		return;
	}
	
	//전달값을 사용하여 JSP 문서의 컨텍스트 경로를 변수에 저장
	String contextPath=pageName+".jsp";
	//System.out.println("contextPath = "+contextPath);
%>   
<%-- forward 태그 : 요청 JSP 문서에서 다른 JSP 문서로 스레드를 이용하여 스레드가 이동된 JSP
문서로 클라이언트에게 응답하기 위한 기능을 제공하는 태그 - 포워드 이동 --%>
<%-- => 요청 JSP 문서가 아닌 스레드가 이동된 JSP 문서가 클라이언트에게 응답 처리 --%>
<%-- => 요청 JSP 문서에서 다른 JSP 문서로 스레드가 이동될 때 요청 JSP 문서의 request 객체와
response 객체가 스레드가 이동되는 JSP 문서로 전달되어 사용 --%>
<%-- => 클라이언트는 상관없이 서버에서 JSP 문서간의 스레드를 이동하여 처리하므로 클라이언트의
요청 URL 주소 미변경 --%> 
<%-- 형식) <jsp:forward page="JSP 문서의 컨텍스트 경로"></jsp:forward> --%>
<%-- => page 속성값으로 표현식(Expression) 사용 가능 --%>
<%-- => page 속성값으로 설정된 JSP 문서가 없는 경우 에러 발생 --%>
<jsp:forward page="<%=contextPath %>"/>
