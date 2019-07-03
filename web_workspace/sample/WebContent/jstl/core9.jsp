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
	
	<h2>formatNumber 태그</h2>
	<p>
		숫자값을 원하는 형식의 패턴으로 출력한다.
	</p>
	
	<h3>숫자 출력</h3>
	<p><fmt:formatNumber value="<%=1000000000 %>"></fmt:formatNumber></p>

	<p><fmt:formatNumber value="<%=1000000000 %>" type="currency"></fmt:formatNumber></p>
	<p><fmt:formatNumber value="<%=1000000000 %>" type="number"></fmt:formatNumber></p>
	<p><fmt:formatNumber value="<%=1000000000 %>" type="percent"></fmt:formatNumber></p>

	<p><fmt:formatNumber value="<%=1000000000 %>" ></fmt:formatNumber>원</p>

	<p><fmt:formatNumber value="<%=123456.789 %>" pattern="#,###.##" ></fmt:formatNumber>원</p>
	<p><fmt:formatNumber value="<%=123.410 %>" pattern="#,###.###" ></fmt:formatNumber>원</p>
	<p><fmt:formatNumber value="<%=123.410 %>" pattern="#,###.000" ></fmt:formatNumber>원</p>
</body>
</html>