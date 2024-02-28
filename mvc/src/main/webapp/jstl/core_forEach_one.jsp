<%@page import="java.util.ArrayList"%>
<%@page import="xyz.itwill.jstl.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] nameArray={"홍길동","임꺽정","전우치","일지매","장길산"};
	request.setAttribute("nameArray", nameArray);
	
	List<Student> studentList=new ArrayList<Student>();
	studentList.add(new Student(1000, "홍길동"));
	studentList.add(new Student(2000, "임꺽정"));
	studentList.add(new Student(3000, "전우치"));
	studentList.add(new Student(4000, "일지매"));
	studentList.add(new Student(5000, "장길산"));
	request.setAttribute("studentList", studentList);
	
	request.getRequestDispatcher("core_forEach_two.jsp").forward(request, response);
%>