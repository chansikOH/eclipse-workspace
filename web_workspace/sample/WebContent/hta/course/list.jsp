<%@page import="kr.co.hta.course.vo.Course"%>
<%@page import="java.util.List"%>
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
	String menu = "course";
%>
<%@ include file="../common/navigation.jsp" %>
<%
	CourseDao courseDao = new CourseDao();
	List<Course> courses = courseDao.getAvailableCourses();
%>
<div class="container">
	<div class="page-header">
		<h1>개설 과정 리스트</h1>
	</div>
	
	<table class="table">
		<thead>
			<tr>
				<th></th>
				<th>과정명</th>
				<th>교육기간</th>
				<th>정원</th>
				<th>교육비</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (Course course : courses) {
		%>
			<tr>
				<td><a href="detail.jsp?cno=<%=course.getNo() %>"><img src="../../images/<%=course.getImgName() %>" class="img-rounded" width="160" height="100" /></a></td>
				<td><a href="detail.jsp?cno=<%=course.getNo() %>" style="color:black; text-decoration:none"><strong><%=course.getTitle() %></strong></a></td>
				<td><%=course.getStartDate() %> ~ <%=course.getEndDate() %></td>
				<td><%=course.getQuota() %></td>
				<td><%=course.getCost() %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</div>
</body>
</html>








