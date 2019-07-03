<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<h1>EL의 요청파라미터값 조회하기</h1>
	
	<dl>
		<dt>기사번호</dt><dd>${param.no }</dd>
		<dt>페이지번호</dt><dd>${param.pno }</dd>
		<dt>카테고리</dt><dd>${param.cat }</dd>
	</dl>
	
	<p><a href="demo7-1.jsp">이전</a></p>
</body>
</html>