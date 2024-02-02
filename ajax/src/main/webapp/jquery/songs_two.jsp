<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 서버 플렛폼의 현재 날짜와 시간 및 음원목록을 JSON 형태의 데이타로 응답하는 JSP 문서 --%>
<%
	String now=new SimpleDateFormat("yyyy년 MM월 dd일 HH시").format(new Date());
%>
{
	"now":"<%=now %>",
	"songs":[
		{"title":"Love wins all", "singer":"아이유"}
		,{"title":"To. X", "singer":"태연(TAEYEON)"}
		,{"title":"비의 랩소디", "singer":"임재현"}
		,{"title":"Love 119", "singer":"RIIZE"}
		,{"title":"Perfect Night", "singer":"LE SSERAFIM(르세라핌)"}
	]
}