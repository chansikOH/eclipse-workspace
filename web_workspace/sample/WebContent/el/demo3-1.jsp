<%@page import="kr.co.hta.member.vo.Maker"%>
<%@page import="kr.co.hta.member.vo.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL표현식 사용하기</h1>
	
	<%
		Car car = new Car();
		car.setName("제네시스");
		car.setPrice(100000000);
		car.setYear(2019);
		
		Maker maker = new Maker();
		maker.setName("현대자동차");
		maker.setAddress("울산광역시 ......");
		maker.setTel("054-1234-5678");
		car.setCompany(maker);
		
		request.setAttribute("myCar", car);
		
		request.getRequestDispatcher("demo3-2.jsp").forward(request, response);
	%>

</body>
</html>