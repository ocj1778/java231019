<%@page import="java.net.URLEncoder"%>
<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	//session 객체에 저장된 권한 관련 속성값을 MemberDTO 객체로 반환받아 저장
	MemberDTO loginMember=(MemberDTO)session.getAttribute("loginMember");

	if(loginMember==null) {
		//request.getRequestURI() : 요청 URL 주소에서 JSP 문서의 경로(URI)를 반환하는 메소드
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);//requestURI = /shop/index.jsp
				
		//request.getQueryString() : 요청 URL 주소에서 질의문자열(QueryString)을 반환하는 메소드
		String queryString=request.getQueryString();		
		//System.out.println("queryString = "+queryString);//queryString = group=cart&worker=cart_list
			
		//페이지를 요청한 URL 주소를 생성하여 저장		
		String url="";		
		if(queryString!=null) {
			url=requestURI+"?"+queryString;
		} else {
			url=requestURI;
		}
		//System.out.println("url = "+url);//url = /shop/index.jsp?group=cart&worker=cart_list
		
		//JSP 문서의 URL 주소를 부호화 처리하여 저장
		url=URLEncoder.encode(url, "utf-8");
				
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=member_login&url="+url);
		return;
	}
--%>
<%@include file="/security/login_url.jspf" %>
<h1>장바구니 목록 페이지</h1>









