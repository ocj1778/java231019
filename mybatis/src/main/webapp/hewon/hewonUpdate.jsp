<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@page import="xyz.itwill.dto.MyHewon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	//MYHEWON 테이블에 저장된 회원정보 중 아이디가 [xxx]인 회원의 이름을 [로빈훗]으로 변경 처리
	MyHewon hewon=new MyHewon();//기본 생성자로 생성된 객체 필드에는 기본값 저장
	hewon.setId("xxx");//필드값을 변경하는 메소드
	hewon.setName("로빈훗");
	
	//DTO 객체를 전달받아 DAO 클래스의 메소드로 회원정보를 변경 처리
	// => DTO 객체(MyHewon 객체)에는 아이디와 이름만 필드에 저장되어 있고 나머지 필드에는 기본값 저장
	// => MYHEWON 테이블에 저장된 행에서 이름을 제외한 컬럼값이 비정상적으로 변경
	MyHewonDAO.getDAO().updateHewon(hewon);
	*/ 
	
	MyHewon hewon=new MyHewon();//기본 생성자로 생성된 객체 필드에는 기본값 저장
	hewon.setId("xxx");//필드값을 변경하는 메소드
	hewon.setName("로빈훗");
	//MyHewon 테이블에 저장된 행의 컬럼값(기존값)을 이용하여 필드값 변경
	hewon.setPhone("010-2134-7841");
	hewon.setEmail("xxx@itwill.xyz");
	hewon.setStatus(4);

	MyHewonDAO.getDAO().updateHewon(hewon);
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