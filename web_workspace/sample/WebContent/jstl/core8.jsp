<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포맷팅 태그 라이브러리</title>
</head>
<body>
	<h1>포맷팅 태그 라이브러리</h1>
	
	<h2>formatDate 태그</h2>
	<p>
		formatDate 태그를 사용하면 java.util.Date타입의 정보(날짜와 시간)를 원하는 형태로 출력할 수 있다.
	</p>
	
	<%
		Date now = new Date();
		request.setAttribute("now", now);
	%>
	<h3>날짜와 시간</h3>
	<p>${now }</p>
	<p><fmt:formatDate value="${now }"/></p>
	<p><fmt:formatDate value="${now }" type="date"/></p>
	<p><fmt:formatDate value="${now }" type="time"/></p>
	<p><fmt:formatDate value="${now }" type="both"/></p>
	
	<p><fmt:formatDate value="${now }" pattern="yyyy/MM/dd"/></p>
	<p><fmt:formatDate value="${now }" pattern="yyyy년 M월 d일"/><p>
	<p><fmt:formatDate value="${now }" pattern="yyyy년 M월 d일 EEEE a h시 m분 s초"/></p>
</body>
</html>