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
	
	<dl>
		<dt>제목</dt><dd>${movie.title }</dd>
		<dt>감독</dt><dd>${movie.director }</dd>
		<dt>장르</dt><dd>${movie.genre }</dd>
		<dt>배우</dt><dd>${movie.actor }</dd>
		<dt>상영시간</dt><dd>${movie.runningtime }</dd>
	</dl>
</body>
</html>