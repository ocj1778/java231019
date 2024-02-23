<%@page import="xyz.itwill.el.Car"%>
<%@page import="xyz.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Member 객체를 생성하여 Request Scope 속성값으로 저장하고 출력 기능을 제공하는 JSP 문서로
포워드 이동하는 JSP 문서 - 요청을 처리하는 웹프로그램(Model) --%>    
<%
	Member member=new Member("홍길동", new Car("싼타페", "하얀색"));

	//request 내장객체에 Member 객체를 속성값으로 저장 - Request Scope
	//Request Scope : 속성값을 저장한 웹프로그램과 스레드가 이동된 웹프로그램에서 속성값을
	//객체로 반환받아 사용 가능
	request.setAttribute("member", member);
	
	//포워드 이동 : 현재 웹프로그램의 명령을 읽어 실행하는 스레드를 다른 웹프로그램으로 이동하여
	//명령을 실행해 응답 처리하기 위한 기능을 제공
	// => 스레드가 이동되는 웹프로그램에게 현재 웹프로그램의 request 객체와 response 객체 전달
	//request.getRequestDispatcher("member_non_el.jsp").forward(request, response);
	request.getRequestDispatcher("member_el.jsp").forward(request, response);
%>