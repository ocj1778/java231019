<%@page import="xyz.itwill.dao.AjaxMemberDAO"%>
<%@page import="xyz.itwill.dto.AjaxMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 AJAX_MEMBER 테이블의 행으로 삽입하고 [member_join_result.jsp] 문서로
이동하기 위한 URL 주소를 전달하여 응답하는 JSP 문서 --%>    
<%
	//비정상적인 요청에 대한 응답 처리
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//POST 방식으로 요청하여 전달된 값을 읽기 위한 문자형태 변경
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=request.getParameter("passwd");
	String name=request.getParameter("name");
	String email=request.getParameter("email");

	//AjaxMemberDTO 객체를 생성하여 전달값으로 객체 필드값 변경
	AjaxMemberDTO ajaxMember=new AjaxMemberDTO();
	ajaxMember.setId(id);
	ajaxMember.setPasswd(passwd);
	ajaxMember.setName(name);
	ajaxMember.setEmail(email);
	
	//회원정보(AjaxMemberDTO 객체)를 전달받아 AJAX_MEMBER 테이블의 행으로 삽입하고 삽입행의
	//갯수를 반환하는 AjaxMemberDAO 클래스의 메소드 호출
	AjaxMemberDAO.getDAO().insertAjaxMember(ajaxMember);
	
	//페이지 이동 : 클라이언트에게 요청 URL 주소 전달 - 리다이렉트 이동
	response.sendRedirect(request.getContextPath()+"/jdbc/member_join_result.jsp");
%>
