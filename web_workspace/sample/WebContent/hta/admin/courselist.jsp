<%@page import="java.util.List"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@page import="kr.co.hta.course.vo.Course"%>
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
  <style>
  	td{vertical-align:middle !important}
  </style>
</head>
<body>
<%
	String menu = "admin";
%>
<%@ include file="../common/navigation.jsp" %>
<%
	CourseDao courseDao = new CourseDao();
	List<Course> courses = courseDao.getAllCourses();
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
				<th>모집여부</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%
			for (Course course : courses) {
		%>
			<tr>
				<td><a href="coursedetail.jsp?cno=<%=course.getNo() %>"><img src="../../images/<%=course.getImgName() %>" class="img-rounded" width="160" height="100" /></a></td>
				<td><a href="coursedetail.jsp?cno=<%=course.getNo() %>" style="color:black; text-decoration:none"><strong><%=course.getTitle() %></strong></a></td>
				<td><%=course.getStartDate() %> ~ <%=course.getEndDate() %></td>
				<td><%=course.getQuota() %></td>
				<%
					if (course.getDisplayYn().equals("Y")) {
				%>
				<td>
					<span class="label label-success">모집중</span>
				</td>
				<%
					} else if (course.getDisplayYn().equals("N")) {
				%>
				<td>
					<span class="label label-default">모집종료</span>
				</td>
				<%
					}
					
					if(member != null && member.getType().equals("ADMIN") && course.getDisplayYn().equals("Y")) {
				%> 
				<td>
					<a href="coursedisplay.jsp?cno=<%=course.getNo() %>&yn=N" class="btn btn-danger btn-sm">모집종료</a>					
				</td>
				<%
					} else if(member != null && member.getType().equals("ADMIN") && course.getDisplayYn().equals("N")) {
				%>
				<td>
					<a href="coursedisplay.jsp?cno=<%=course.getNo() %>&yn=Y" class="btn btn-primary btn-sm">모집시작</a>
				</td>
				<%
					}
				%>				
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
	<%
		if(member != null && member.getType().equals("ADMIN")) {
	%>
	<div class="text-right">
		<a href="courseform.jsp" class="btn btn-primary">새 과정</a>
	</div>
	<%
		}
	%>
</div>
</body>
</html>