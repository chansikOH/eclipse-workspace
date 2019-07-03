<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>HTA대학교</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<% String menu = "home"; %>
<%@ include file="common/header.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>HTA대학교 학사관리 시스템</h1>
		<p>학생 등록, 개설과정 조회, 수강신청 등의 서비스를 이용할 수 있습니다.</p>
	</div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>