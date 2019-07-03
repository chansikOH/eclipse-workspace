<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core 태그 연습</title>
</head>
<body>
	<h1>Core 태그 연습</h1>
	
	<h1>if 태그</h1>
	<p>if 태그는 자바의 if문을 흉내낼 수 있다.
	   if 태그를 활용하면 제시된 조건에 따라서 적절한 컨텐츠를 출력하는 것이 가능하다.
	   else태그는 적용되지 않는다.</p>
	   
	<%
		int orderPrice = 250000;
		request.setAttribute("orderPrice", orderPrice);
	%>
	
	<c:if test="${orderPrice lt 500000 }">
		<p>구매금액 : ${orderPrice }원</p>
	</c:if>
	<c:if test="${orderPrice ge 500000 }">
		<p>구매금액 : ${orderPrice }원 <strong>사은품 지급대상</strong></p>
	</c:if>
	
	<%
		ArrayList<String> bookCart = new ArrayList<>();
		bookCart.add("이것이 자바다.");
		
		session.setAttribute("cart", bookCart);
	%>
	<h3>나의 장바구니</h3>
	<c:if test="${empty cart }">
		<p>장바구니가 비어있습니다.</p>
	</c:if>
	<c:if test="${not empty cart }">
		<p>장바구니의 책 : ... ... ... ...</p>
	</c:if>
</body>
</html>