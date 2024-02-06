<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보(작성자와 내용)을 전달받아 AJAX_COMMENT 테이블의 행으로 삽입하고 실행결과를
JSON 데이타로 응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	request.setCharacterEncoding("utf-8");
	
	String writer=Utility.escapeTag(request.getParameter("writer"));
	String content=Utility.escapeTag(request.getParameter("content"));
	
	AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
	ajaxComment.setWriter(writer);
	ajaxComment.setContent(content);
	
	int rows=AjaxCommentDAO.getDAO().insertAjaxComment(ajaxComment);
%>
<% if(rows>0) {//삽입행이 있는 경우 %>
{"code":"success"}
<% } else {//삽입행이 없는 경우 %>
{"code":"error"}
<% } %>
