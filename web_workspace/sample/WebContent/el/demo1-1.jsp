<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL표현식</title>
</head>
<body>
	<h1>EL 표현식 사용하기</h1>
	<p>속성으로 저장하고, 표현하기</p>
	
	<%
		// 불린값 속성으로 담기
		request.setAttribute("isMarried", false);
		// 숫자값 담기
		request.setAttribute("point", 1000);
		request.setAttribute("discount_rate", 0.05);
		// 문자열 담기
		request.setAttribute("firstname", "길동");
		request.setAttribute("lastname", "홍");
		// null값 담기
		request.setAttribute("email", null);
		
		request.getRequestDispatcher("demo1-2.jsp").forward(request, response);
	%>

</body>
</html>