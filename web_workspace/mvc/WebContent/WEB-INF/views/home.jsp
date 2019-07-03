<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중앙 HTA</title>
</head>
<body>
	<h1>홈 페이지</h1>

	<p>${message }</p>
	<p>현재 날짜는 <fmt:formatDate value="${currentTime }"/> 입니다.</p>
</body>
</html>