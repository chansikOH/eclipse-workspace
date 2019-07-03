<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.hta.course.vo.RegistrationDetail"%>
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
	String menu = "member";
%>
<%@ include file="../common/navigation.jsp" %>
<%
	CourseDao courseDao = new CourseDao();
	List<RegistrationDetail> regDetails = courseDao.getRegistrationDetail(member.getId());
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
%>
<div class="container">
	<div class="page-header">
		<h1>수강신청 현황</h1>
	</div>
	
	<table class="table">
		<thead>
			<tr>
				<th></th>
				<th>과정명</th>
				<th>교육기간</th>
				<th>신청상태</th>
				<th>신청일</th>
			</tr>
		</thead>
		<tbody>
		<%
			for (RegistrationDetail regDetail : regDetails) {
		%>
			<tr>
				<td><img src="../../images/<%=regDetail.getCourseImgName() %>" class="img-rounded" width="160" height="100"/></td>
				<td><a href="/hta/course/detail.jsp?cno=<%=regDetail.getCourseNo() %>" style="color:black; text-decoration:none"><strong><%=regDetail.getCourseTitle() %></strong> </a></td>
				<td><%=regDetail.getCourseStartDate() %> ~ <%=regDetail.getCourseEndDate() %></td>
				<%
					if(regDetail.getRegStatus().equals("R")) {
				%>
				<td>
				신청 중
				</td>
				<%
					} else if (regDetail.getRegStatus().equals("S")) {
				%>
				<td>
				신청 완료
				</td>
				<%
					} else if (regDetail.getRegStatus().equals("C")) {
				%>
				<td>
				신청 취소
				</td>
				<%
					}
				%>
				<td><%=date.format(regDetail.getRegCreateDate()) %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
</div>
</body>
</html>








