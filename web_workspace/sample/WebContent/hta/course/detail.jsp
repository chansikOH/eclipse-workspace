<%@page import="kr.co.hta.course.vo.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	String menu = "course";
%>
<%@ include file="../common/navigation.jsp" %>
<%
	CourseDao courseDao = new CourseDao();
	int courseNo = Integer.parseInt(request.getParameter("cno"));
	String result = request.getParameter("result");
	
	Course course = courseDao.getCourseByNo(courseNo);
	List<Comment> comments = courseDao.getCommentsByCourseNo(courseNo);
	
	int regNo = courseDao.getRegCountByCourseNo(course.getNo());
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
%>
<div class="container">
	<div class="page-header">
		<h1>개설 과정 정보</h1>
		<%
		if (member != null && "fail".equals(result)) {
		%>
			<div class="alert alert-danger">
			<strong>수강신청 실패</strong> 이미 신청한 과정입니다.		
			</div>
		<%
			} else if (member != null && "success".equals(result)) {
		%>
			<div class="alert alert-success">
			<strong>수강신청 성공</strong> 수강신청이 완료되었습니다.		
			</div>
		<%
			}
		%>
	</div>
	
	<table class="table table-bordered">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="35%">
		</colgroup>
		<tr>
			<th>과정번호</th>
			<td><%=course.getNo() %></td>
			<th>등록일</th>
			<td><%=date.format(course.getCreateDate()) %></td>
		</tr>
		<tr>
			<th>과정명</th>
			<td colspan="3"><%=course.getTitle() %></td>
		</tr>
		<tr>
			<th>과정 시작일</th>
			<td><%=course.getStartDate() %></td>
			<th>과정 종료일</th>
			<td><%=course.getEndDate() %></td>
		</tr>
		<tr>
			<th>교육비용</th>
			<td><%=course.getCost() %></td>
			<th>모집여부</th>
			<td>
			<%
				if (course.getDisplayYn().equals("Y")) {
			%>
			모집중
			<%
				} else if (course.getDisplayYn().equals("N")) {
			%>
			모집종료
			<%
				}
			%>
			</td>
		</tr>
		<tr>
			<th>모집정원</th>
			<td><%=course.getQuota() %></td>
			<th>현재 신청자수</th>
			<td><%=regNo %></td>
		</tr>
		<tr>
			<th>상세설명</th>
			<td colspan="3"><%=course.getDescription() %></td>
		</tr>
		<tr>
			<td colspan="4"><img src="../../images/<%=course.getImgName() %>" class="img-rounded" 
			width="400" height="300" style="display:block; margin-left:auto; margin-right:auto;"/></td>
		</tr>
	</table>
	
	<div class="text-right">
	<%
		if(member != null && member.getType().equals("USER")) {
	%>
		<a href="request.jsp?cno=<%=course.getNo() %>" class="btn btn-primary">수강신청</a>
	<%
		} 
	%>
		<a href="list.jsp" class="btn btn-primary">목록</a>
	</div>
	
	<hr>
	
	<div class="row well">
		<form method="post" action="addcomment.jsp">
			<input type="hidden" name="cno" value="<%=course.getNo() %>" />
			<div class="form-group">
				<textarea rows="3" class="form-control" name="contents"></textarea>
			</div>
			<%
				if (member != null) {
			%>
			<div class="text-right">
				<input type="submit" class="btn btn-success btn-sm" value="등록"/>
			</div>
			<%
				}
			%>
		</form>
	</div>
	
	
	<div class="row">
		<ul class="list-group">
		<%
			for (Comment comment : comments) {
		%>
			<li class="list-group-item">
				<p><strong><%=comment.getMemberName() %></strong> <small><%=date.format(comment.getCreateDate()) %></small></p>
				<p><%=comment.getContents() %></p>
			</li>
			
		<%
			}
		%>
		</ul>
	</div>
</div>
</body>
</html>








