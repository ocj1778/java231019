<%@page import="xyz.itwill.dao.MyMemberXMLDAO"%>
<%@page import="xyz.itwill.dto.MyMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	
	MyMember member=new MyMember();
	member.setId(id);
	member.setName(name);
	member.setPhone(phone);
	member.setEmail(email);

	MyMemberXMLDAO.getDAO().updateMember(member);
		
	response.sendRedirect("member_view.jsp?id="+id);
%>
