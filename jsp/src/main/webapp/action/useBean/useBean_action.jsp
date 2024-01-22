<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 전달값(회원정보)을 반환받아 내장객체의 속성값으로 저장하고 [useBean_display.jsp] 문서로 
포워드 이동하는 JSP 문서 - 클라이언트 요청에 대한 데이타 처리 기능만 제공하는 JSP 문서 --%>    
<%
	//JSP 문서를 GET 방식으로 요청한 경우 에러코드를 클라이언트에게 전달 - 비정상적인 요청에 대한 응답
	if(request.getMethod().equals("GET")) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		return;
	}

	//POST 방식으로 요청하여 전달된 값에 대한 캐릭터셋 변경
	request.setCharacterEncoding("utf-8");	
%>
<%-- useBean Tag : JSP 문서에 Java 객체(JavaBean)를 제공하기 위한 태그 --%>
<%-- 형식) <jsp:useBean id="식별자" class="JavaBean 클래스" scope="객체사용범위"></jsp:useBean>--%>
<%-- => 내장객체에 저장된 속성값을 객체로 반환받아 제공하거나 속성값이 없는 경우 객체를 생성하여
내장객체의 속성값으로 저장하여 제공 --%>
<%-- id 속성 : useBean 태그로 제공되는 객체를 구분하기 위한 식별자를 속성값으로 설정 --%>
<%-- => 내장객체에 저장된 속성값에 대한 속성명으로 사용 --%>
<%-- class 속성 : useBean 태그로 제공되는 객체의 자료형(클래스)을 속성값으로 설정 --%>
<%-- scope 속성 : useBean 태그로 제공되는 객체의 사용범위(Scope)을 속성값으로 설정 --%>
<%-- => page, request, session, application 중 하나를 속성값으로 설정 --%>
<%-- => scope 속성을 생략하면 [page] 속성값으로 기본값으로 사용 --%>
<jsp:useBean id="hewon" class="xyz.itwill.bean.HewonBean" scope="request"/>
<%--
	//useBean 태그와 동일한 기능을 제공하는 명령
	// => HewonBean 객체를 생성하여 request 내장객체의 속성값으로 저장
	HewonBean hewon=new HewonBean();
	request.setAttribute("hewon", hewon);
--%>

<%-- setProperty Tag : useBean 태그로 제공된 객체의 필드에 필드값을 변경하는 태그 --%>
<%-- => useBean 태그에 종속된 태그 --%>
<%-- => 객체 필드에 대한 Setter 메소드를 호출하여 필드값을 변경하는 기능과 동일 --%>
<%-- 형식) <jsp:setProperty name="식별자" property="필드명" value="변경값"></jsp:setProperty> --%>
<%-- name 속성 : useBean 태그로 제공되는 객체의 식별자(id 속성값)를 속성값을 설정 --%>
<%-- property 속성 : 필드값을 변경하기 위한 필드명을 속성값으로 설정 --%>
<%-- => 속성값으로 설정된 필드명으로 작성된 Setter 메소드를 자동 호출 - 필드명으로 작성된 
Setter 메소드가 없는 경우 에러 발생 --%>
<%-- value 속성 : 필드에 저장될 필드값을 속성값으로 설정 --%>
<%-- <jsp:setProperty name="hewon" property="name" value="홍길동"/> --%>
<%-- hewon.setName("홍길동"); --%>

<%-- setProperty 태그에 value 속성을 생략하면 JSP 문서 요청시 전달값을 반환받아 필드값으로 변경 --%>
<%-- => JSP 문서 요청시 전달되는 값의 이름과 setProperty 태그의 property 속성값(필드명)이 
반드시 동일해야만 전달값을 반환받아 필드값으로 변경 가능 --%>
<%-- 
<jsp:setProperty name="hewon" property="name"/>
<jsp:setProperty name="hewon" property="phone"/>
<jsp:setProperty name="hewon" property="address"/>
--%>

<%-- setProperty 태그의 property 속성값을 [*] 기호로 설정 --%>
<%-- => 모든 전달값을 useBean 태그로 제공된 객체의 필드값으로 변경 --%>
<jsp:setProperty name="hewon" property="*"/>
<%--
	hewon.setName(request.getParameter("name"));
	hewon.setPhone(request.getParameter("phone"));
	hewon.setAddress(request.getParameter("address"));
--%>

<jsp:forward page="useBean_display.jsp"/>
<%--
	request.getRequestDispatcher("useBean_display.jsp").forward(request, response);
--%>
