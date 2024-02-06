<%@page import="xyz.itwill.util.Utility"%>
<%@page import="xyz.itwill.dao.AjaxCommentDAO"%>
<%@page import="xyz.itwill.dto.AjaxCommentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 댓글번호를 전달받아 AJAX_COMMENT 테이블에 저장된 행을 검색하여 JSON 데이타로 응답하는 JSP 문서 --%>    
<%
	if(request.getParameter("num")==null) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	int num=Integer.parseInt(request.getParameter("num"));
	
	AjaxCommentDTO ajaxComment=AjaxCommentDAO.getDAO().selectAjaxComment(num);
%>
<% if(ajaxComment!=null) {//검색된 댓글정보가 있는 경우 %>
	{
		"code":"success", "data":{"num":<%=ajaxComment.getNum() %>
			,"writer":"<%=Utility.toJSON(ajaxComment.getWriter()) %>"
			,"content":"<%=Utility.toJSON(ajaxComment.getContent()) %>"
			,"regdate":"<%=ajaxComment.getRegdate() %>"}
	}
<% } else {//검색된 댓글정보가 없는 경우 %>
	{"code":"empty"}
<% } %>