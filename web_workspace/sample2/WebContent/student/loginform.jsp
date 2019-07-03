<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>HTA대학교</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<% String menu = "login"; %>
<%@ include file="../common/header.jsp" %>
<div class="container">
	<div class="col-xs-6 col-xs-offset-3">
		<form class="form-horizontal" method="post" action="login.jsp">
			<div class="panel panel-success">
				<%
					String result = null;
					try {
						result = request.getParameter("result");
					} catch (NullPointerException e) {
						response.sendRedirect("loginform.jsp");
					}
					if ("fail".equals(result)) {
				%>
				<div class="alert alert-danger">
					<strong>로그인실패</strong> 아이디 혹은 비밀번호가 잘못되었습니다.
				</div>
				<%
					}
				%>
				<div class="panel-heading">
					<h4>로그인 폼</h4>
				</div>
				<div class="panel-body">
					<div class="form-group">
						<label class="col-sm-3 control-label">아이디</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="id" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="pwd" />
						</div>
					</div>
				</div>
				<div class="panel-footer text-right">
					<input type="submit" class="btn btn-success" value="로그인" />
				</div>
			</div>
		</form>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>