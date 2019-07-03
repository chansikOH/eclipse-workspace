<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<p><strong>${username }</strong>님 방문을 환영합니다.</p>
	
	<h3>속보</h3>
	<ul>
		<c:forEach var="text" items="${news }">
			<li>${text }</li>
		</c:forEach>
	</ul>
</body>
</html>