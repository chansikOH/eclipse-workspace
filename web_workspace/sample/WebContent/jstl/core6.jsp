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
	
	<div>
	<c:forEach var="a" begin="1" end="10">
		<a href="../hta/board/list.jsp?pno=${a }">${a }</a>
	</c:forEach>
	</div>
</body>
</html>