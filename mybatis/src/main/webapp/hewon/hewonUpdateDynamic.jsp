<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//MYHEWON 테이블에 저장된 회원정보 중 아이디가 [xxx]인 회원의 이름을 [홍경래]으로 변경 처리
	MyHewon hewon=new MyHewon();//기본 생성자로 생성된 객체 필드에는 기본값 저장
	hewon.setId("xxx");//필드값을 변경하는 메소드
	hewon.setName("홍경래");
	
	MyHewonDAO.getDAO().updateDynamicHewon(hewon);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원변경</h1>
	<hr>
	<h3>회원정보가 성공적으로 변경 되었습니다.</h3>
</body>
</html>