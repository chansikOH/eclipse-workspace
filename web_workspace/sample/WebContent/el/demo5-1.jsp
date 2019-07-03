<%@page import="kr.co.hta.member.vo.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 사용하기</h1>
	
	<%
		String[] movies = {"어벤져스: 엔드게임", "나의 특별한 형제", "뽀로로 보물섬 대모험"};
	
		ArrayList<Car> cars = new ArrayList<Car>();
		Car car1 = new Car();
		car1.setName("제네시스");
		car1.setPrice(100000000);
		
		Car car2 = new Car();
		car2.setName("포르쉐");
		car2.setPrice(230000000);
		
		cars.add(car1);
		cars.add(car2);
		
		request.setAttribute("movies", movies);
		request.setAttribute("cars", cars);
		
		request.getRequestDispatcher("demo5-2.jsp").forward(request, response);
	%>
	
</body>
</html>