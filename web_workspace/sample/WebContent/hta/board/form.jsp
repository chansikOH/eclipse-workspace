<%@page import="java.net.URLEncoder"%>
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
	String menu = "board";
%>
<%@ include file="../common/navigation.jsp" %>
<%
	if (member == null) {
		response.sendRedirect("/hta/login/loginform.jsp?result=deny&page=" + URLEncoder.encode("글쓰기", "utf-8"));
		return;
	}
%>
<div class="container">
	<div class="page-header">
		<h1>글 등록</h1>
	</div>
	
	<%
		int pno = 0;
		try{
			pno = Integer.parseInt(request.getParameter("pno"));
		} catch (NumberFormatException e) {
			response.sendRedirect("form.jsp?pno=1");
		}
	%>
	<div class="well">
		<form method="post" action="add.jsp">
			<div class="form-group">
				<label>제목</label>
				<input type="text" class="form-control" name="title"/>
			</div>

			<div class="form-group">
				<label>내용</label>
				<textarea rows="7" class="form-control" name="contents"></textarea>
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="등록">
				<input type="reset" class="btn btn-default" value="취소">
			</div>
		</form>
	</div>
	<div class="text-right">
		<a href="list.jsp?pno=<%=pno %>" class="btn btn-primary">목록보기</a>
	</div>
</div>
</body>
</html>

