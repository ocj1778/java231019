<%@page import="xyz.itwill.bean.HewonBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값(회원정보)을 반환받아 내장객체의 속성값으로 저장하고 [non_useBean_display.jsp] 문서로 
포워드 이동하는 JSP 문서 - 클라이언트 요청에 대한 데이타 처리 기능만 제공하는 JSP 문서 --%>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우 에러코드를 클라이언트에게 전달 - 비정상적인 요청에 대한 응답
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");

	//전달값을 반환받아 변수에 저장
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	
	/*
	request.setAttribute("name", name);
	request.setAttribute("phone", phone);
	request.setAttribute("address", address);
	*/
	
	//HewonBean 클래스로 객체 생성하여 전달값을 객체 필드에 저장
	HewonBean hewon=new HewonBean();
	hewon.setName(name);
	hewon.setPhone(phone);
	hewon.setAddress(address);
	
	//session 객체에 HewonBean 객체를 속성값으로 저장
	session.setAttribute("hewon", hewon);
	
	//리다이렉트 이동 : 클라이언트에게 요청 URL 주소를 전달하여 클라이언트가 URL 주소의 JSP 문서를
	//요청하여 실행결과를 응답받아 출력
	// => 클라이언트 브라우저의 요청 URL 주소 변경 - 클라이언트를 사용하여 JSP 문서 이동
	// => session 내장객체의 속성값을 저장하여 리다이렉트 이동되는 JSP 문서에서 반환받아 사용 가능
	// => 리다이렉트 이동되는 JSP 문서에서는 session 객체에 저장된 속성값을 반환받은 후 반드시 제거
	response.sendRedirect("non_useBean_display.jsp");
	
	/*
	//request 객체에 HewonBean 객체를 속성값으로 저장
	// => 스레드가 이동되는 JSP 문서에서 request 객체에 저장된 속성값을 반환받아 사용 가능 
	request.setAttribute("hewon", hewon);
	
	//포워드 이동 : 요청 JSP 문서에서 응답 JSP 문서로 스레드를 이동하여 응답 처리
	
	request.getRequestDispatcher("non_useBean_display.jsp").forward(request, response);
	*/
%>








