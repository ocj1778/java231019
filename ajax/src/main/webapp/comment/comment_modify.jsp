<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글정보(댓글번호, 작성자, 내용)을 전달받아 AJAX_COMMENT 테이블에 저장된 행으로 변경하고 
실행결과를 JSON 데이타로 응답하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	request.setCharacterEncoding("utf-8");
	
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=Utility.escapeTag(request.getParameter("writer"));
	String content=Utility.escapeTag(request.getParameter("content"));
	
	AjaxCommentDTO ajaxComment=new AjaxCommentDTO();
	ajaxComment.setNum(num);
	ajaxComment.setWriter(writer);
	ajaxComment.setContent(content);
	
	int rows=AjaxCommentDAO.getDAO().updateAjaxComment(ajaxComment);	
%>
<% if(rows>0) {//변경행이 있는 경우 %>
{"code":"success"}
<% } else {//변경행이 없는 경우 %>
{"code":"error"}
<% } %>
