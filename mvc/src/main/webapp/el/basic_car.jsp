<%@page import="xyz.itwill.el.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext 내장객체에 [car] 속성명을 사용하여 Car 객체를 속성값으로 저장  
	pageContext.setAttribute("car", new Car("싼타페","하얀색"));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext 내장객체에 저장된 속성값을 [car] 속성명으로 Car 객체로 반환받아 저장  
		Car car=(Car)pageContext.getAttribute("car");
	
		//속성명에 대한 속성값이 없는 경우 [null]이 반환되어 참조변수에 저장
		//Car car=(Car)pageContext.getAttribute("pageCar");
	%>	
	<p>자동차 = <%=car %></p>
	<%-- 객체의 Getter 메소드를 사용하여 객체 필드값을 반환받아 JSP 표현식으로 출력 처리 --%>
	<%-- => [null]이 저장된 참조변수로 메소드를 호출한 경우 NullPointerException 발생 --%>
	<p>자동차(모델명) = <%=car.getModelName() %></p>
	<p>자동차(색상) = <%=car.getCarColor() %></p>
	<hr>
	<h2>EL 사용</h2>
	<p>자동차 = ${car}</p>
	<%-- EL 표현식에서 속성명에 대한 속성값을 객체로 제공받아 메소드 호출 가능 --%>
	<p>자동차(모델명) = ${car.getModelName()}</p>
	<p>자동차(색상) = ${car.getCarColor()}</p>
	<hr>
	<%-- ${속성명.필드명} 형식으로 EL 표현식을 사용하여 속성명에 대한 속성값을 객체로 제공받아
	. 연산자로 필드명을 사용해 필드값을 Getter 메소드로 반환하여 출력 처리 가능 --%>
	<%-- => 객체의 Getter 메소드를 호출하지 않아도 객체 필드값을 제공받아 출력 처리 가능 --%>
	<%-- => Getter 메소드의 작성 규칙에 맞지 않게 선언한 경우 또는 Getter 메소드가 없는 경우 에러 발생 --%>
	<p>자동차(모델명) = ${car.modelName}</p>
	<p>자동차(색상) = ${car.carColor}</p>
	<hr>
	<%-- . 연산자 대신 [] 연산자를 사용하여 객체의 필드값을 제공받아 출력 처리 가능 --%>
	<%-- => [] 연산자에는 문자값으로 필드명을 명시하여 Getter 메소드로 필드값을 제공받아 출력 처리 --%> 
	<p>자동차(모델명) = ${car["modelName"]}</p>
	<p>자동차(색상) = ${car["carColor"]}</p>
	<hr>
	<%-- EL 표현식의 속성명으로 제공되는 속성값이 없는 경우 EL 미실행 - NullPointerException 미발생 --%>
	<p>자동차(모델명) = ${pageCar.modelName}</p>
</body>
</html>
