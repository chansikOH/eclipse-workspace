<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청객체 연습하기</title>
</head>
<body>
	<h1>요청객체 주요 메소드 연습하기</h1>
	
	<%
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		
		String ipAddress = request.getRemoteAddr();
		Locale locale = request.getLocale();
	%>
	
	<h2>요청정보</h2>
	<dl>
		<dt>요청방식</dt><dd><%=method %></dd>
		<dt>요청URI</dt><dd><%=uri %></dd>
		<dt>퀴리스트링</dt><dd><%=queryString %></dd>
		<dt>클라이언트 ip 주소</dt><dd><%=ipAddress %></dd>
		<dt>지역화정보</dt><dd><%=locale.getCountry() %> <%=locale.getLanguage() %></dd>
	</dl>
</body>
</html>