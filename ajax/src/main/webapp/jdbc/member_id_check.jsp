<?xml version="1.0" encoding="utf-8"?>
<%@page import="xyz.itwill.dto.AjaxMemberDTO"%>
<%@page import="xyz.itwill.dao.AjaxMemberDAO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 AJAX_MEMBER 테이블에 저장된 행을 검색하여 아이디 사용 가능 여부를
XML 데이타로 응답하는 JSP 문서 --%>    
<%
	String id=request.getParameter("id");

	//비정상적인 요청에 대한 응답 처리
	if(id==null || id.equals("")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//아이디를 전달받아 AJAX_MEMBER 테이블에 저장된 행을 검색하여 회원정보(AjaxMemberDTO 객체)를 
	//반환하는 AjaxMemberDAO 클래스의 메소드 호출
	AjaxMemberDTO ajaxMember=AjaxMemberDAO.getDAO().selectAjaxMember(id);
%>
<result>
	<% if(ajaxMember!=null) {//아이디로 검색된 회원정보가 있는 경우 - 아이디 중복(아이디 불가능) %>
	<code>impossible</code>
	<% } else {//아이디로 검색된 회원정보가 없는 경우 - 아이디 미중복(아이디 가능) %>
	<code>possible</code>
	<% } %>
</result>
