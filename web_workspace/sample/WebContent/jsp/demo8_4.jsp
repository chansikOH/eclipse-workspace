<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 속성과 스코프 살펴보기</title>
</head>
<body>
	<h1>JSP 내장객체에 저장된 속성 조회하기</h1>
		
	<%
		String value1 = (String) pageContext.getAttribute("p");
		String value2 = (String) request.getAttribute("r");
		String value3 = (String) session.getAttribute("s");
		String value4 = (String) application.getAttribute("a");
	%>
	
	<h3>주요 내장객체의 속성값</h3>
	<dl>
		<dt>PageContext의 속성값</dt><dd><%=value1 %></dd>
		<dt>HttpServletRequest의 속성값</dt><dd><%=value2 %></dd>
		<dt>HttpSession의 속성값</dt><dd><%=value3 %></dd>
		<dt>ServletContext</dt><dd><%=value4 %></dd>
	</dl>

</body>
</html>