<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과정안내</title>
</head>
<body>
	<h1>개설 과정 안내</h1>
	<%
		String[] names = {"풀스택 개발자 과정", "웹 모바일 개발자 과정"};
	%>
	
	
	<h3>모집중인 과정</h3>
	<ul>
		<li><%=names[0] %></li>
		<li><%=names[1] %></li>
	</ul>
	
	<p>
		<a href="home.jsp">홈</a>
	</p>
</body>
</html>