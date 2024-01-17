<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<h1>내장객체(Implicit Object)</h1>
	<hr>
	<p>내장객체 : WAS 프로그램에 의해 JSP 문서에서 사용되도록 제공되는 Java 객체</p>
	<hr>
	<p>page(HttpJspPage) : JSP 문서를 제공하기 위한 객체</p>
	<p>config(ServletConfig) : WAS 프로그램에 등록된 환경설정 정보를 제공하기 위한 객체</p>
	<p>out(JspWriter) : 클라이언트에게 응답될 문서파일을 생성하기 위한 객체 - 출력스트림</p>
	<p>request(HttpServletResquest) : 클라이언트의 요청정보를 제공하기 위한 객체</p>    
	<p>response(HttpServletResponse) : 클라이언트의 응답정보를 제공하기 위한 객체</p>
	<p>session(HttpSession) : 서버와 클라이언트의 연결 지속성을 제공하기 위한 객체</p>
	<p>application(ServletContext) : 웹자원(WebContext)을 관리하는 정보를 제공하기 위한 객체 - WAS</p>
	<p>pageContext(PageContext) : 웹프로그램 작성에 필요한 객체를 제공하기 위한 객체</p>
	<p>exception(Exception) : 웹프로그램 실행시 발생된 예외를 제공하기 위한 객체 
	- page Directive에서 isErrorPage 속성값을 [true]로 설정한 경우에만 제공 : 에러페이지에서 사용</p>  
</body>
</html>
