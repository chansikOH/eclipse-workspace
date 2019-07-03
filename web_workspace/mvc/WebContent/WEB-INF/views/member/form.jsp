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
<c:set var="menu" value="member" scope="page"/>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>회원가입</h1>
	</div>
	
	<div class="well">
		<form method="post" action="register.hta" enctype="multipart/form-data">
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" name="username">
			</div>
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" name="userid">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="userpwd">
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="useremail">
			</div>
			<div class="form-group">
				<label>사진</label>
				<input type="file" class="form-control" name="userphoto">
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="가입" />
			</div>
		</form>
	</div>
</div>
</body>
</html>