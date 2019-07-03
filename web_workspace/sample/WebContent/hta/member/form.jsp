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
<div class="container">
	<div class="page-header">
		<h1>회원가입</h1>
	</div>
	
	 <%
	 	String result = null;
	 	try {
	 		result = request.getParameter("result");
	 	} catch (NullPointerException e) {
	 		response.sendRedirect("form.jsp?result=none");
	 		return;
	 	}
	 	
	 	if ("fail".equals(result)) {
	 %>
	<%--
		회원등록시 동일한 아이디로 가입된 사용자가 이미 존재하는 경우
		아래 태그가 노출되게 한다.
	 --%>
	<div class="alert alert-danger">
		<strong>회원가입 실패</strong> 동일한 아이디가 이미 존재합니다.
	</div>
	<%
	 	}
	%>
	
	<div class="well">
		<form method="post" action="add.jsp">
			<input type="hidden" name="result" value="<%=result %>"/>
			<div class="form-group">
				<label>이름</label>
				<input type="text" class="form-control" name="name" />
			</div>
			<div class="form-group">
				<label>아이디</label>
				<input type="text" class="form-control" name="id"/>
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" class="form-control" name="pwd" />
			</div>
			<div class="form-group">
				<label>이메일</label>
				<input type="text" class="form-control" name="email" />
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="등록">
				<input type="reset" class="btn btn-default" value="취소">
			</div>
		</form>
	</div>
</div>
</body>
</html>