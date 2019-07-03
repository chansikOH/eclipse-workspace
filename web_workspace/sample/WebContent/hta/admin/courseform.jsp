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
	String menu = "admin";
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>새 과정 등록</h1>
	</div>
	
	<div class="well">
		<form method="post" action="add.jsp" enctype="multipart/form-data">
			<div class="form-group">
				<label>과정명</label>
				<input type="text" class="form-control" name="title" />
			</div>
			<div class="form-group">
				<label>시작일</label>
				<input type="date" class="form-control" name="startDate" />
			</div>
			<div class="form-group">
				<label>종료일</label>
				<input type="date" class="form-control" name="endDate" />
			</div>
			<div class="form-group">
				<label>교육비용</label>
				<input type="text" class="form-control" name="cost" />
			</div>
			<div class="form-group">
				<label>교육인원</label>
				<input type="number" class="form-control" name="quota" min="20" />
			</div>
			<div class="form-group">
				<label>이미지</label>
				<input type="file" class="form-control" name="photo" />
			</div>
			<div class="form-group">
				<label>설명</label>
				<textarea rows="6" class="form-control" name="description"></textarea>
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="과정등록" />
			</div>
		</form>
	</div>
</div>
</body>
</html>