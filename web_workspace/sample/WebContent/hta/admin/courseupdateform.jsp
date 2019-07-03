<%@page import="kr.co.hta.course.vo.Course"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
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
<%
	CourseDao courseDao = new CourseDao();
	Course course = courseDao.getCourseByNo(Integer.parseInt(request.getParameter("cno")));
	
%>
<div class="container">
	<div class="page-header">
		<h1>개설 과정 수정</h1>
	</div>
	
	<div class="well">
		<form method="post" action="courseupdate.jsp" enctype="multipart/form-data">
			<input type="hidden" name="no" value="<%=course.getNo() %>" />
			<input type="hidden" name="dis" value="<%=course.getDisplayYn() %>"/>
			<div class="form-group">
				<label>과정명</label>
				<input type="text" class="form-control" name="title" value="<%=course.getTitle() %>"/>
			</div>
			<div class="form-group">
				<label>시작일</label>
				<input type="date" class="form-control" name="startDate" value="<%=course.getStartDate() %>"/>
			</div>
			<div class="form-group">
				<label>종료일</label>
				<input type="date" class="form-control" name="endDate" value="<%=course.getEndDate() %>"/>
			</div>
			<div class="form-group">
				<label>교육비용</label>
				<input type="text" class="form-control" name="cost" value="<%=course.getCost() %>"/>
			</div>
			<div class="form-group">
				<label>교육인원</label>
				<input type="number" class="form-control" name="quota" min="20" value="<%=course.getQuota() %>"/>
			</div>
			<div class="form-group">
				<label>이미지</label>
				<input type="file" class="form-control" name="photo" />
			</div>
			<div class="form-group">
				<label>설명</label>
				<textarea rows="6" class="form-control" name="description"><%=course.getDescription() %></textarea>
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="수정" />
			</div>
		</form>
	</div>
</div>
</body>
</html>