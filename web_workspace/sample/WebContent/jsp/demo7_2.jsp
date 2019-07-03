<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 다루기</title>
</head>
<body>
	<h1>세션의 속성값 조회하기</h1>
	
	<%
		String name = (String)session.getAttribute("user-name");
		String addr = (String)session.getAttribute("USER_ADDRESS");
	%>
	<h2>세션의 속성으로 저장된 값</h2>
	<dl>
		<dt>사용자 이름</dt><dd><%=name %></dd>
		<dt>사용자 거주지</dt><dd><%=addr %></dd>
	</dl>
	<div>
		<a href="demo7.jsp">돌아가기</a>
	</div>

</body>
</html>