<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="xyz.itwill.dao.MyHewonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("id","xxx");
	map.put("name","홍경래");
	map.put("phone","010-3245-7891");
	map.put("email","xxx@itwill.xyz");
	map.put("status",4);
	
	MyHewonDAO.getDAO().insertMapHewon(map);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MYBATIS</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보가 성공적으로 삽입 되었습니다.</h3>
</body>
</html>