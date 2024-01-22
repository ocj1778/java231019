<%@page import="xyz.itwill.dao.StudentDAO"%>
<%@page import="xyz.itwill.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 학생정보를 전달받아 STUDENT 테이블에 저장된 행을 변경하고 [displayStudent.jsp] 문서를 
요청할수 있는 URL 주소를 클라이언트에게 전달하여 응답하는 JSP 문서 --%> 
<%
	//JSP 문서를 GET 방식으로 요청한 경우에 대한 응답 처리 - 비정상적인 요청
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}
	
	//POST 방식으로 요청하여 전달된 값에 대한 문자형태(CharacterSet - Encoding) 변경
	request.setCharacterEncoding("utf-8");
	
	//전달값을 반환받아 변수에 저장
	int no=Integer.parseInt(request.getParameter("no"));
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String address=request.getParameter("address");
	String birthday=request.getParameter("birthday");
	
	//StudentDTO 객체를 생성하여 전달값으로 필드값 변경
	StudentDTO student=new StudentDTO();
	student.setNo(no);
	student.setName(name);
	student.setPhone(phone);
	student.setAddress(address);
	student.setBirthday(birthday);
	
	//학생정보를 전달받아 STUDENT 테이블에 저장된 행을 변경하고 변경행의 갯수를 반환하는 
	//StudentDAO 클래스의 메소드 호출
	StudentDAO.getDAO().updateStudent(student);
	
	//클라이언트에게 URL 주소를 전달하여 응답
	response.sendRedirect("displayStudent.jsp");	
%>
