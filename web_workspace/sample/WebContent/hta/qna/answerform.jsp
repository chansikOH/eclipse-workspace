<%@page import="kr.co.hta.util.DateUtils"%>
<%@page import="kr.co.hta.qna.vo.Question"%>
<%@page import="kr.co.hta.qna.dao.QuestionAnswerDao"%>
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
	String menu = "qna";
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>답변 등록</h1>
	</div>
	<%
		int questionNo = Integer.parseInt(request.getParameter("no"));
		int pno = Integer.parseInt(request.getParameter("pno"));
		QuestionAnswerDao qnaDao = new QuestionAnswerDao();
		Question question = qnaDao.getQuestionByNo(questionNo);
		
		String status = null;
		if("답변완료".equals(question.getStatus())){
			status = "success";
		} else if ("답변대기중".equals(question.getStatus())){
			status = "default";
		} else if ("질문취소".equals(question.getStatus())) {
			status = "warning";
		}
	%>
	
	<table class="table table-bordered">
		<colgroup>
			<col width="10%">
			<col width="23%">
			<col width="10%">
			<col width="22%">
			<col width="12%">
			<col width="23%">
		</colgroup>
		<tr>
			<th>번호</th>
			<td><%=question.getNo() %></td>
			<th>등록일</th>
			<td colspan="3"><%=DateUtils.dateToString(question.getCreateDate()) %></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=question.getWriter() %></td>
			<th>구분</th>
			<td><%=question.getGubun() %></td>
			<th>진행상태</th>
			<td><span class="label label-<%=status %>"><%=question.getStatus() %></span></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5"><%=question.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5">
				<%=question.getContents() %>
			</td>
		</tr>
	</table>
	
	<hr />
	
	<div class="well">
		<form method="post" action="answeradd.jsp">
			<div class="form-group">
				<input type="hidden" name="pno" value="<%=pno %>"/>
				<input type="hidden" name="ques_no" value="<%=question.getNo() %>"/>
				<label>답변자</label>
				<input type="text" class="form-control" name="writer"/>
			</div>
			<div class="form-group">
				<label>답변내용</label>
				<textarea rows="7" class="form-control" name="contents"></textarea>
			</div>
			<div class="text-right">
				<input type="submit" class="btn btn-primary" value="답변등록">
				<input type="reset" class="btn btn-default" value="취소">
			</div>
		</form>
	</div>
</div>
</body>
</html>