<?xml version="1.0" encoding="utf-8"?>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 검색어를 전달받아 SUGGEST 테이블에 저장된 행(제시어 관련 정보)를 검색하여 XML 데이타로 응답하는 JSP 문서 --%>
<%
	request.setCharacterEncoding("utf-8");

	String keyword=request.getParameter("keyword");
	
	//검색어를 전달받아 SUGGEST 테이블에 저장된 행을 검색하여 List 객체로 반환하는 SuggestDAO 클래스의 메소드 호출
%>    