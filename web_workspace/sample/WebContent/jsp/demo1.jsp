<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP구성 요소</title>
</head>
<body>
	<h1>JSP 구성요소 살펴보기</h1>
	
	<h2>스크립트릿</h2>
	<%
		// 스크립트릿 내의 주석은 자바코드를 적을 때와 같다.
		String name = "홍길동";
		int age = 10;
		String phone = "010-1234-5678";
	%>
	
	<h2>표현식</h2>
	<p>이름 : <%=name %></p>
	<p>나이 : <%=age %></p>
	<p>연락처 : <%=phone %></p>
	
	<h2>주석</h2>
	<%--
		<h2>표현식</h2>
		<p>이름 : <%=name %></p>
		<p>나이 : <%=age %></p>
		<p>연락처 : <%=phone %></p>
	 --%>
	 
	 <h2>HTML 주석</h2>
	 <!-- 
	 	<h2>표현식</h2>
		<p>이름 : <%=name %></p>
		<p>나이 : <%=age %></p>
		<p>연락처 : <%=phone %></p>
	 -->
	 
	 <p>
	 	<a href="../home.jsp">홈</a>
	 </p>
</body>
</html>