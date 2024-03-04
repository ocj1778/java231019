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

	try {
		//SqlSession 객체를 사용하여 매퍼에 등록된 SQL 명령을 DBMS 서버에 전달하여 실행할 때
		//문제가 발생되면 PersistenceException 발생 - 예외처리
		MyMemberXMLDAO.getDAO().insertMember(member);
		
		response.sendRedirect("member_display.jsp");
	} catch(Exception e) {
		//SQL 명령(INSERT)에 문제가 없는 경우 PK 제약조건을 위반하면 예외 발생 - 아이디 중복
		//response.sendRedirect("member_register_form.jsp");
		
		out.println("<script type='text/javascript'>");
		out.println("alert('이미 사용중인 아이디를 입력해 회원등록이 실패 하였습니다.')");
		out.println("history.go(-1);");
		out.println("</script>");
	}
	
%>
