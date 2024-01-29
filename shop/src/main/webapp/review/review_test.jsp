<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- REVIEW 테이블에 게시글(새글)을 500개 삽입하는 JSP 문서 - 테스트 프로그램 --%>
<%
	ReviewDTO review=new ReviewDTO();
	for(int i=1;i<=500;i++) {
		int nextNum=ReviewDAO.getDAO().selectReivewNextNum();
		review.setReviewNum(nextNum);//글번호 변경
		review.setReviewMember(1);//회원번호 변경
		review.setReviewSubject("테스트-"+i);//제목 변경
		review.setReviewContent("게시글 테스트 - "+i);//내용 변경
		review.setReviewRef(nextNum);//답글그룹 변경
		review.setReviewIp("192.168.13.31");//IP 주소 변경
		review.setReviewStatus(1);//글상태 변경
		
		
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>