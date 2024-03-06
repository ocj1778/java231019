<%@page import="xyz.itwill.dao.MyReplyDAO"%>
<%@page import="xyz.itwill.dto.MyReply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//첫번째 게시글에 대한 3개의 댓글 삽입 처리
	MyReply reply1=new MyReply();
	reply1.setReplyCommentNo(1);
	reply1.setReplyId("opq456");
	reply1.setReplyContent("첫번째 게시글에 대한 [댓글-1]입니다.");
	MyReplyDAO.getDAO().insertReply(reply1);
	
	MyReply reply2=new MyReply();
	reply2.setReplyCommentNo(1);
	reply2.setReplyId("xyz789");
	reply2.setReplyContent("첫번째 게시글에 대한 [댓글-2]입니다.");
	MyReplyDAO.getDAO().insertReply(reply2);
	
	MyReply reply3=new MyReply();
	reply3.setReplyCommentNo(1);
	reply3.setReplyId("opq456");
	reply3.setReplyContent("첫번째 게시글에 대한 [댓글-3]입니다.");
	MyReplyDAO.getDAO().insertReply(reply3);
	
	//세번째 게시글에 대한 1개의 댓글 삽입 처리
	MyReply reply4=new MyReply();
	reply4.setReplyCommentNo(3);
	reply4.setReplyId("abc123");
	reply4.setReplyContent("세번째 게시글에 대한 [댓글-1]입니다.");
	MyReplyDAO.getDAO().insertReply(reply4);
	
	//네번째 게시글에 대한 2개의 댓글 삽입 처리
	MyReply reply5=new MyReply();
	reply5.setReplyCommentNo(4);
	reply5.setReplyId("opq456");
	reply5.setReplyContent("네번째 게시글에 대한 [댓글-1]입니다.");
	MyReplyDAO.getDAO().insertReply(reply5);

	MyReply reply6=new MyReply();
	reply6.setReplyCommentNo(4);
	reply6.setReplyId("xyz789");
	reply6.setReplyContent("네번째 게시글에 대한 [댓글-2]입니다.");
	MyReplyDAO.getDAO().insertReply(reply6);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>댓글 등록</h1>
	<hr>
	<h3>댓글이 성공적으로 삽입 되었습니다.</h3>
</body>
</html>