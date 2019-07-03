<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코어 태그 라이브러리</title>
</head>
<body>
	<h1>코어 태그 라이브러리</h1>
	
	<h2>out 태그</h2>
	<p>표현식에 해당하는 값을 출력으로 보낸다(표현한다).</p>

	<%
		request.setAttribute("username", "홍길동");
		
		String content = "<button>클릭하세요</button>";
		request.setAttribute("content", content);
	%>
	
	<p>이름 : ${username }</p>
	<p>이름 : <c:out value="${username }"></c:out></p>

	<p>내용 : ${content }</p>
	<p>내용 : <c:out value="${content }"></c:out></p>
	<p>내용 false : <c:out value="${content }" escapeXml="false"></c:out></p>
	<p>내용 true : <c:out value="${content }" escapeXml="true"></c:out></p>
</body>
</html>