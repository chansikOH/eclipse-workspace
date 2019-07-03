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
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>개인 정보 조회 및 수정</h1>
	</div>
	
	<div class="well">
		<form method="post" action="update.jsp">
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" name="name" value="<%=member.getName() %>" disabled="disabled"/>
			</div>
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" name="id" value="<%=member.getId() %>" readonly="readonly"/>
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="pwd" value="<%=member.getPwd() %>" />
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="email" value="<%=member.getEmail() %>" />
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="수정">
				<input type="reset" class="btn btn-default" value="취소">
				<a href="/hta/main.jsp" class="btn btn-success">홈</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>