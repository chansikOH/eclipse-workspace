<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core 태그 라이브러리</title>
</head>
<body>
	<h1>Core 태그 라이브러리</h1>
	
	<h2>forEach 태그</h2>
	<p>
		forEach 태그를 사용하면 컨텐츠를 반복 출력할 수 있다.
	</p>
	
	<h3>영화 목록</h3>
	<%
		String[] movies = {"어벤져스", "걸캅스", "명탐정 피카츄", "나의 특별한 형제"};
	
		request.setAttribute("movies", movies);
	%>
	
	<ul>
	<c:forEach var="m" items="${movies }">
		<li>${m }</li>
	</c:forEach>
	</ul>
	
	<h4>회원 목록</h4>
	<%
		ArrayList<String> names = new ArrayList<>();
		names.add("김유신");
		names.add("이순신");
		names.add("강감찬");
		names.add("유관순");
		request.setAttribute("names", names);
	%>
	<ul>
	<c:forEach var="n" items="${names }">
		<li>${n }</li>
	</c:forEach>
	</ul>
</body>
</html>