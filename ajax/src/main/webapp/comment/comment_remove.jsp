<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 행을 삭제하고 실행결과를 JSON 데이타로 응답하는 JSP 문서 --%>
<%
	if(request.getParameter("num")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	int num=Integer.parseInt(request.getParameter("num"));
	
	int rows=AjaxCommentDAO.getDAO().deleteAjaxComment(num);
%>
<% if(rows>0) {//삭제행이 있는 경우 %>
{"code":"success"}
<% } else {//삭제행이 없는 경우 %>
{"code":"error"}
<% } %>