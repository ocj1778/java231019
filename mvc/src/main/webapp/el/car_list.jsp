<%@page import="java.util.ArrayList"%>
<%@page import="xyz.itwill.el.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Car> carList=new ArrayList<Car>();

	carList.add(new Car("싼타페", "하얀색"));
	carList.add(new Car("쏘렌토", "검정색"));
	carList.add(new Car("쏘나타", "빨강색"));
	carList.add(new Car("페라리", "파란색"));
	carList.add(new Car("티볼리", "초록색"));
	
	request.setAttribute("carList", carList);
	
	request.getRequestDispatcher("car_list_el.jsp").forward(request, response);
%>