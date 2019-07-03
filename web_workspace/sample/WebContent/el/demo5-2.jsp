<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 사용하기</h1>
	
	<h3>개봉영화 순위</h3>
	<ol>
		<li>${movies[0] }</li>
		<li>${movies[1] }</li>
		<li>${movies[2] }</li>
	</ol>
	
	<h3>보유 차량 정보</h3>
	<ul>
		<li>${cars[0].name } ${cars[0].price }</li>
		<li>${cars[1].name } ${cars[1].price }</li>
	</ul>
	
</body>
</html>