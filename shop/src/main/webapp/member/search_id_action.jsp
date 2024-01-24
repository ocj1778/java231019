<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이름과 이메일을 전달받아 MEMBER 테이블에 저장된 행의 아이디를 검색하여 검색 결과를 전달하여 응답하는 JSP 문서 --%>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}

	//전달값을 반환받아 저장
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	//MemberDTO 객체를 생성하여 전달값으로 필드값 변경
	MemberDTO member=new MemberDTO();
	member.setName(name);
	member.setEmail(email);
	
	//회원정보를 전달받아 MEMBER 테이블에 저장된 행의 아이디를 검색하여 문자열로 반환하는 
	//MemberDAO 클래스의 메소드 호출
	String id=MemberDAO.getDAO().selectMemberId(member);
%>
<h1>아이디 검색 결과</h1>
<% if(id!=null) {//검색결과가 있는 경우 %>
	<p style="font-size: 1.5em;"><%=name %>님의 아이디는 [<%=id %>]입니다.</p>
<% } else {//검색결과가 없는 경우 %>
	<p style="font-size: 1.5em;"><%=name %>님의 아이디의 아이디를 찾을 수 없습니다.</p>
<% } %>
