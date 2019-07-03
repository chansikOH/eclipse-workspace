<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core 태그 라이브러리</title>
</head>
<body>
	<h1>Core 태그 라이브러리</h1>
	
	<h2>choose, when, otherwise 태그</h2>
	<p>
		choose, when, otherwise 태그를 사용하면 if ~ else if ~ else if ~ else 구문을 흉내낼 수 있다.
		when과 otherwise태그는 choose태그 내부에서만 사용할 수 있다.
		choose 태그 안에서 when 태그는 여러번 사용할 수 있다.
		choose 태그 안에서 otherwise 태그는 사용하지 않던지, 단 한번 사용할 수 있다.
		otherwise는 else에 해당한다.
	</p>
	
	<h3>나의 성적 조회</h3>
	<%
		request.setAttribute("score", 57);
	%>
	<c:choose>
		<c:when test="${score ge 90 }">
			<p>A학점 입니다.</p>
		</c:when>
		<c:when test="${score ge 80 }">
			<p>B학점 입니다.</p>
		</c:when>
		<c:when test="${score ge 70 }">
			<p>C학점 입니다.</p>
		</c:when>
		<c:when test="${score ge 60 }">
			<p>D학점 입니다.</p>
		</c:when>
		<c:otherwise>
			<p>F학점 입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<h3>주문 정보</h3>
	<%
		Map<String, Object> map = new HashMap<>();
		map.put("grade", "비회원");
		map.put("price", 300000);
		map.put("amount", 5);
		
		session.setAttribute("order", map);
	%>
	
	<c:choose>
		<c:when test="${order.grade eq '골드' }">
			<p>
			등급: ${order.grade } 
			구매금액: ${order.price * order.amount }
			포인트: ${order.price * order.amount * 0.03 } 점
			</p>
		</c:when>
		<c:when test="${order.grade eq '실버' }">
			<p>
			등급: ${order.grade } 
			구매금액: ${order.price * order.amount }
			포인트: ${order.price * order.amount * 0.02 } 점
			</p>
		</c:when>
		<c:when test="${order.grade eq '브론즈' }">
			<p>
			등급: ${order.grade } 
			구매금액: ${order.price * order.amount }
			포인트: ${order.price * order.amount * 0.01 } 점
			</p>
		</c:when>
		<c:when test="${order.grade eq '비회원' }">
			<p>
			등급: ${order.grade } 
			구매금액: ${order.price * order.amount }
			포인트: ${order.price * order.amount * 0.00 } 점
			</p>
		</c:when>
	</c:choose>
</body>
</html>