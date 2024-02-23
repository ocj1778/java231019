<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArray={"홍길동","임꺽정","전우치","일지매","장길산"};

	request.setAttribute("nameArray", nameArray);
	
	request.getRequestDispatcher("string_array_el.jsp").forward(request, response);
%>