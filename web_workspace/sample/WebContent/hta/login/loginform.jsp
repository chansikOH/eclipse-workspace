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
	String menu = "login";
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<%
		String result = null;
		try {
			result = request.getParameter("result");
		} catch (NullPointerException e) {
			response.sendRedirect("loginform.jsp?result=none");
		}
		String pageName = request.getParameter("page");
		
	%>
	<%--
		로그인처리시 아이디 혹은 비밀번호가 올바르지 않는 경우
		아래 내용이 노출된다.
	 --%>
	 <div class="row">
		<div class="col-md-offset-4 col-md-4">
		<%		
			if(result != null && "fail".equals(result)) {
		%>
			<div class="alert alert-danger">
				<strong>로그인 실패</strong> 아이디 혹은 비밀번호가 올바르지 않습니다.
			</div>
		<%
			}
		%>
		
		<%		
			if(result != null && result.equals("deny")) {
		%>
			<div class="alert alert-danger">
				<strong>서비스 거부</strong> <%=pageName %> 서비스 로그인 후 사용가능한 서비스입니다.
			</div>
		<%
			}
		%>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">로그인</div>
				<div class="panel-body">
					<form method="post" action="login.jsp">
						<div class="form-group">
							<label>아이디</label>
							<input type="text" class="form-control" name="userid" />
						</div>
						<div class="form-group">
							<label>비밀번호</label>
							<input type="password" class="form-control" name="userpwd" />
						</div>
						<div class="text-right">
							<input type="submit" class="btn btn-primary" value="로그인">
							<input type="reset" class="btn btn-default" value="취소">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>