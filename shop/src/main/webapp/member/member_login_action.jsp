<%@page import="xyz.itwill.dto.MemberDTO"%>
<%@page import="xyz.itwill.dao.MemberDAO"%>
<%@page import="xyz.itwill.util.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 인증정보를 전달받아 MEMBER 테이블에 저장된 회원정보와 비교하여 인증이 성공한 경우 로그인  
처리 후 [/main/main_page.jsp] 문서를 요청할 수 있는 URL 주소를 전달하여 응답하는 JSP 문서 --%>
<%-- => 인증이 실행한 경우 [/member/member_login.jsp] 문서를 요청할 수 있는 URL 주소를 전달 --%>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}	

	//전달값을 반환받아 저장
	String id=request.getParameter("id");
	String passwd=Utility.encrypt(request.getParameter("passwd"));

	//아이디를 전달받아 MEMBER 테이블에 저장된 단일행을 검색하여 MemberDTO 객체로 반환하는
	//MemberDAO 클래스의 메소드 호출
	MemberDTO member=MemberDAO.getDAO().selectMemberById(id);
	
	//검색된 회원정보가 없거나 탈퇴회원인 경우 또는 검색된 회원정보의 비밀번호가 전달된 
	//비밀번호와 같지 않은 경우 인증 실패
	if(member==null || member.getMemberStatus()==0 || !member.getPasswd().equals(passwd)) {
		session.setAttribute("message", "아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해 주세요.");
		session.setAttribute("id", id);
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=member&worker=member_login");
		return;
	}
	
	//회원번호를 전달받아 MEMBER 테이블에 저장된 행의 마지막 로그인 날짜(LAST_LOGIN 컬럼)를  
	//변경하고 변경행의 갯수를 반환하는 MemberDAO 클래스의 메소드 호출
	MemberDAO.getDAO().updateLastLogin(member.getMemberNum());
	
	//인증 성공 - 로그인 처리 : 권한 관련 정보가 저장된 객체를 session 객체의 속성값으로 저장
	//session.setAttribute("loginMemberNum", member.getMemberNum());
	session.setAttribute("loginMember", MemberDAO.getDAO().selectMemberByNum(member.getMemberNum()));
	
	request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=main&worker=main_page");
%>
