<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청헤더 정보 조회하기</title>
</head>
<body>
	<h1>요청헤더 정보 조회하기</h1>
	
	<%
		String host = request.getHeader("host");
		String agent = request.getHeader("user-agent");
		String accept = request.getHeader("accept");
		String acceptEncoding = request.getHeader("accept-encoding");
		String acceptLanguage = request.getHeader("accept-language");
	%>
	
	<h2>요청헤더 정보</h2>
	<dl>
		<dt>host</dt><dd><%=host %></dd>
		<dt>브라우저 정보</dt><dd><%= agent%></dd>
		<dt>브라우저가 지원하는 컨텐츠타입</dt><dd><%= accept%></dd>
		<dt>브라우저가 지원하는 압축형식</dt><dd><%= acceptEncoding%></dd>
		<dt>브라우저가 지원하는 언어</dt><dd><%= acceptLanguage%></dd>
	</dl>

</body>
</html>