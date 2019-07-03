<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구성요소</title>
</head>
<body>
	<h1>JSP 구성요소 연습하기</h1>
	
	<%
		ArrayList<String> movies = new ArrayList<String>();
		movies.add("어벤져스: 엔드게임");
		movies.add("뽀로로 극장판 보물섬 대모험");
		movies.add("생일");
		movies.add("캡틴 마블");
		movies.add("안도 타다오");
	%>
	
	<h2>개봉영화 리스트</h2>
	<ol>
	<%
		for(String title : movies) {
	%>
		<li><%=title %></li>
	<%
		}
	%>		
	</ol>
	
	<p>
		<a href="../home.jsp">홈</a>
	</p>
</body>
</html>