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
	<h1>EL의 연산자 사용하기</h1>
	
	<%
		pageContext.setAttribute("price", 300000);
		pageContext.setAttribute("quantity", 3);
	%>
	
	<h2>EL의 사칙연산자 사용하기</h2>
	<p>덧셈 : ${price + quantity }</p>
	<p>뺄셈 : ${price - quantity }</p>
	<p>곱셈 : ${price * quantity }</p>
	<p>나눗셈 : ${price / quantity } ${price div quantity }</p>
	<p>모듈러연산 : ${price % quantity } ${price mod quantity }</p>
	
	<h2>EL의 비교연산자 사용하기</h2>
	<p>크다			${price > quantity } ${price gt quantity }</p>
	<p>크거나 같다	${price >= quantity } ${price ge quantity }</p>
	<p>작다			${price < quantity } ${price lt quantity }</p>
	<p>작거나 같다	${price <= quantity } ${price le quantity }</p>
	<p>같다			${price == quantity } ${price eq quantity }</p>
	<p>같지않다		${price != quantity } ${price ne quantity }</p>
	
	<h2>EL의 논리연산자 사용하기</h2>
	<!-- 
		구매금액이 50만원 이상이거나 구매수량이 100개 이상이면 사은품 지급
	 -->
	<p>사은품 지급여부 : ${((price * quantity) ge 500000) or (quantity ge 100) }</p>
	<!-- 
		구매금액이 100만원 이상이고 구매수량이 10개 이상이면 상품권 지급
	-->
	<p>상품권 지급여부 : ${((price * quantity) ge 1000000) and (quantity ge 10) }</p>
	
	<%
		ArrayList<String> values = new ArrayList<String>();
		values.add("어벤져스");
		
		pageContext.setAttribute("movies", values);
	%>
	<h2>EL의 기타연산자 사용하기</h2>
	<!-- 
		empty 연산자
			- 표현식에 해당하는 값이 존재하지 않으면 true
			- 표현식에 해당하는 값이 존재하지만 비어있으면 true
			- 표현식에 해당하는 값이 존재하고 비어있지 않으면 false를 반환
	 -->
	<p>값이 존재하지 않는지 여부 : ${empty movies }</p>
	<p>값이 존재하는지 여부 : ${not empty movies }</p>
</body>
</html>