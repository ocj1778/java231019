<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 비밀번호를 전달받아 MEMBER 테이블에 저장된 회원정보의 비밀번호와 비교하여 같은 경우 MEMBER
테이블에 저장된 행의 회원상태를 [0]으로 변경하고 탈퇴 처리하고 [/member/member_logout_action.jsp]
문서를 요청할 수 있는 URL 주소를 전달하여 응답하는 JSP 문서 --%>
<%-- => MEMBER 테이블에서 회원정보를 검색하지 않고 session 객체에 저장된 속성값을 반환받아 사용  --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%@include file="/security/login_check.jspf" %>  
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}	
	
	//전달값을 반환받아 저장
	String passwd=Utility.encrypt(request.getParameter("passwd"));
	
	//로그인 상태의 사용자 비밀번호와 전달받은 비밀번호를 비교하여 같지 않은 경우에 대한 응답 처리
	if(!loginMember.getPasswd().equals(passwd)) {
		session.setAttribute("message", "입력하신 비밀번호가 맞지 않습니다.");	
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=password_confirm&action=remove");
		return;
	}	
	
	//MemberDTO 객체를 생성하여 필드값 변경
	MemberDTO member=new MemberDTO();
	member.setMemberNum(loginMember.getMemberNum());
	member.setMemberStatus(0);//회원정보의 회원상태를 [0]으로 변경 - 탈퇴회원
	
	//회원정보를 전달받아 MEMBER 테이블에 저장된 회원정보의 회원상태를 변경하고 변경행의 갯수를
	//반환하는 MemberDAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateMemberStatus(member);
	
	//페이지 이동
	request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=member_logout_action");	
%>
