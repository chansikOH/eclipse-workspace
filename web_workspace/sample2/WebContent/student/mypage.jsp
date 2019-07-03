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
<% String menu = "student"; %>
<%@ include file="../common/header.jsp" %>
<div class="container">
	<form class="form-horizontal" method="post" action="update.jsp">
		<div class="panel panel-primary">
		<%
			String result = null;
			try {
				result = request.getParameter("result");
			} catch (NullPointerException e) {
				response.sendRedirect("mypage.jsp");
			}
			String dept = student.getDept();
			int grade = student.getGrade();
			String gender = student.getGender();
		%>



			<div class="panel-heading">
				<h4>개인 정보 조회 및 수정</h4>
			</div>			
			<div class="panel-body">
				<div class="form-group">
					<label class="col-sm-1 control-label">학과</label>
					<div class="col-sm-11">
						<select class="form-control" name="dept">
							<option value="기계공학과" <%="기계공학과".equals(dept) ? "selected" : "" %>> 기계공학과</option>
							<option value="전자공학과" <%="전자공학과".equals(dept) ? "selected" : "" %>> 전자공학과</option>
							<option value="컴퓨터공학과" <%="컴퓨터공학과".equals(dept) ? "selected" : "" %>> 컴퓨터공학과</option>
							<option value="국어국문학과" <%="국어국문학과".equals(dept) ? "selected" : "" %>> 국어국문학과</option>
							<option value="영어영문학과" <%="영어영문학과".equals(dept) ? "selected" : "" %>> 영어영문학과</option>
							<option value="심리학과" <%="심리학과".equals(dept) ? "selected" : "" %>> 심리학과</option>
							<option value="수학과" <%="수학과".equals(dept) ? "selected" : "" %>> 수학과</option>
							<option value="물리학과" <%="물리학과".equals(dept) ? "selected" : "" %>> 물리학과</option>
							<option value="화학과" <%="화학과".equals(dept) ? "selected" : "" %>>화학과</option>
							<option value="생물학과" <%="생물학과".equals(dept) ? "selected" : "" %>> 생물학과</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">학년</label>
					<div class="col-sm-11">
						<select class="form-control" name="grade">
							<option value="1" <%=1==grade ? "selected" : "" %>> 1학년</option>
							<option value="2" <%=2==grade ? "selected" : "" %>> 2학년</option>
							<option value="3" <%=3==grade ? "selected" : "" %>> 3학년</option>
							<option value="4" <%=4==grade ? "selected" : "" %>> 4학년</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">아이디</label>
					<div class="col-sm-11">
						<input type="text" class="form-control" name="id" value="<%=student.getId() %>" readonly="readonly"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">비밀번호</label>
					<div class="col-sm-11">
						<input type="password" class="form-control" name="pwd" value="<%=student.getPassword() %>"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">학생이름</label>
					<div class="col-sm-11">
						<input type="text" class="form-control" name="name" value="<%=student.getName() %>"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-1 control-label">성별</label>
					<div class="col-sm-11">
						<label class="radio-inline">
  							<input type="radio" name="gender" value="남자" <%="남자".equals(gender) ? "checked" : "" %>> 남자
  						</label>
						<label class="radio-inline">
  							<input type="radio" name="gender" value="여자" <%="여자".equals(gender) ? "checked" : "" %>> 여자
  						</label>
					</div>
				</div>
			</div>
			<div class="panel-footer text-right">
				<input type="submit" class="btn btn-primary" value="수정" />
				<a href="../index.jsp" class="btn btn-success">홈</a>
			</div>
		</div>
	</form>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>