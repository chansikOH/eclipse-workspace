<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
	<%
		Map<String, Object> map = new HashMap<>();
		map.put("title", "어벤져스: 엔드게임");
		map.put("genre", "액션/SF");
		map.put("director", "안소니 루소, 조 루소");
		map.put("runningtime", 181);
		map.put("actor", "로버트 다우니 주니어, 크리스 에반스");
		
		request.setAttribute("movie", map);
		
		request.getRequestDispatcher("demo4-2.jsp").forward(request, response);
	%>

</body>
</html>