<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>중앙HTA</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<%
	String menu = "member";
	String result = null;
	try {
		result = request.getParameter("result");
	} catch (NullPointerException e) {
		response.sendRedirect("complete.jsp?result=none");
	}
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="jumbotron text-center">
		<h1>회원가입 완료</h1>
	</div>	
	<div class="text-center">
		<a href="../login/loginform.jsp" class="btn btn-primary btn-lg">로그인 하기</a>	
		<a href="../main.jsp" class="btn btn-default btn-lg">홈으로 가기</a>	
	</div>
</div>
</body>
</html>