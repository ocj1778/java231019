<%@page import="xyz.itwill.dto.ReviewDTO"%>
<%@page import="xyz.itwill.dao.ReviewDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 게시글(새글 또는 답글)을 전달받아 REVIEW 테이블의 행으로 삽입하고 [/review/review_list.jsp]
문서를 요청하기 위한 URL 주소를 전달하여 응답하기 위한 JSP 문서 - 페이징 처리 관련 값 전달 --%>
<%-- => 로그인 상태의 사용자만 요청 가능한 JSP 문서 --%>
<%-- => 게시글이 [multipart/form-data] 타입으로 전달되므로 COS 라이브러리의 MultipartRequest 객체를 사용하여 처리 --%>
<%-- => 전달받은 파일은 [/review_images] 서버 디렉터리에 저장되도록 업로드 처리 --%>
<%@include file="/security/login_check.jspf"%>
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=error&worker=error_400");
		return;
	}

	//전달파일을 저장할 서버 디렉토리의 파일 시스템 경로를 반환받아 저장
	//String saveDirectory=application.getRealPath("/review_images");
	String saveDirectory=request.getServletContext().getRealPath("/review_images");
	//System.out.println("saveDirectory = "+saveDirectory);
	
	//MultipartRequest 객체 생성 - 모든 전달파일을 서버 디렉터리에 저장되도록 자동 업로드 처리
	// => cos.jar 라이브러리 파일을 프로젝트에 빌드 처리해야만 MultipartRequest 클래스 사용 가능
	MultipartRequest multipartRequest=new MultipartRequest(request, saveDirectory
			, 20*1024*1024, "utf-8", new DefaultFileRenamePolicy());
	
	//전달값을 반환받아 저장
	int ref=Integer.parseInt(multipartRequest.getParameter("ref"));
	int restep=Integer.parseInt(multipartRequest.getParameter("restep"));
	int relevel=Integer.parseInt(multipartRequest.getParameter("relevel"));
	String pageNum=multipartRequest.getParameter("pageNum");
	String pageSize=multipartRequest.getParameter("pageSize");
	String search=multipartRequest.getParameter("search");
	String keyword=multipartRequest.getParameter("keyword");
	
	String reviewSubject=multipartRequest.getParameter("reviewSubject");
	int reviewStatus=1;//전달값이 없는 경우 - 일반글
	if(multipartRequest.getParameter("reviewSecret")!=null) {//전달값이 있는 경우 - 비밀글
		reviewStatus=Integer.parseInt(multipartRequest.getParameter("reviewSecret"));
	}
	String reviewContent=multipartRequest.getParameter("reviewContent");
	//서버 디렉토리에 업로드되어 저장된 파일명을 반환받아 컨텍스트 경로를 저장
	String reviewImage=null;
	if(multipartRequest.getFilesystemName("reviewImage")!=null) {//업로드 파일이 있는 경우	
		reviewImage="/review_images/"+multipartRequest.getFilesystemName("reviewImage");
	}
	
	//REVIEW_SEQ 시퀸스의 다음값을 검색하여 반환하는 ReviewDAO 클래스의 메소드 호출
	int nextNum=ReviewDAO.getDAO().selectReivewNextNum();
	
	//게시글을 작성한 클라이언트의 IP 주소를 반환받아 저장
	//request.getRemoteAddr() : JSP 문서를 요청한 클라이언트의 IP 주소를 반환하는 메소드
	// => 이클립스에 등록된 WAS 프로그램은 기본적으로 128Bit 형식(IPV6)의 IP 주소 제공
	//32Bit 형식(IPV4)의 IP 주소를 제공받을 수 있도록 이클립스에 등록된 WAS 프로그램의 환경 설정 변경
	// => Run >> Run Configurations... >> Apache Tomcat >> 사용중인 Apache Tomcat 선택
	// >> Arguments >> VM Arguments >> [-Djava.net.preferIPv4Stack=true] 추가 >> Apply 
	String reviewIp=request.getRemoteAddr();
	//System.out.println("reviewIp = "+reviewIp);
	
	//새글과 답글을 구분하여 REVIEW 테이블의 컬럼값으로 저장될 변수값 변경
	// => [review_write.jsp] 문서에서 hidden 타입의 전달값을 저장한 ref, restep, relevel 변수값 변경
	// => 새글인 경우 변수에 [0]이 저장되어 있고 답글인 경우 변수에 부모글의 전달값이 저장
	if(ref==0) {//새글인 경우
		//REVIEW 테이블의 REVIEW_REF 컬럼에는 시퀸스의 다음값(nextNum 변수값)을 저장하고
		//REVIEW_RESTEP 컬럼과 REVIEW_RELEVEL 컬럼에는 restep 변수값(0)과 relevel 변수값(0) 저장  
		ref=nextNum;
	} else {//답글인 경우
		//REVIEW 테이블에 저장된 게시글 중에서 REVIEW_REF 컬럼값이 ref 변수값(부모글)과 같은
		//게시글에서 REVIEW_RESTEP 컬럼값이 restep 변수값(부모글)보다 큰 게시글의 REVIEW_RESTEP 
		//컬럼값 1 증가되도록 변경 처리
		// => 새로운 답글이 기존 답글보다 먼저 검색되도록 기존 답글순서를 증가
		//부모글 관련 정보를 전달받아 REVIEW 테이블에 저장된 행에서 REVIEW_REF 컬럼값과 REVIEW_RESTEP 
		//컬럼값을 비교하여 REVIEW_RESTEP 컬럼값이 1 증가되도록 변경하는 ReviewDAO 클래스의 메소드 호출
		ReviewDAO.getDAO().updateReviewReStep(ref, restep);
		
		//REVIEW 테이블의 REVIEW_REF 컬럼에는 ref 변수값(부모글)을 저장하고 REVIEW_RESTEP 컬럼과
		//REVIEW_RELEVEL 컬럼에는 restep 변수값(부모글)과 relevel 변수값(부모글)을 1 증가하여 저장
		restep++;
		relevel++;
	}
	
	//ReviewDTO 객체를 생성하여 변수값(전달값)으로 필드값 변경
	ReviewDTO review=new ReviewDTO();
	review.setReviewNum(nextNum);//시퀸스 객체의 다음값으로 필드값 변경
	review.setReviewMember(loginMember.getMemberNum());//로그인 회원정보의 회원번호로 필드값 변경
	review.setReviewSubject(reviewSubject);
	review.setReviewContent(reviewContent);
	review.setReviewImage(reviewImage);
	review.setReviewRef(ref);
	review.setReviewRestep(restep);
	review.setReviewRelevel(relevel);
	review.setReviewIp(reviewIp);
	review.setReviewStatus(reviewStatus);
	
	//게시글을 전달받아 REVIEW 테이블의 행으로 삽입하고 삽입행의 갯수를 반환하는 ReviewDAO 클래스의 메소드 호출
	ReviewDAO.getDAO().insertReview(review);
	
	//페이지 이동 - 검색 및 페이징 처리 관련 값 전달
	request.setAttribute("returnUrl", request.getContextPath()+"/index.jsp?group=review&worker=review_list"
		+"&pageNum="+pageNum+"&pageSize="+pageSize+"&search="+search+"&keyword="+keyword);
%>
