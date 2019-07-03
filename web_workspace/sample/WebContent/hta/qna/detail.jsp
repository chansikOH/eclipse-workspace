<%@page import="kr.co.hta.util.DateUtils"%>
<%@page import="kr.co.hta.qna.vo.Answer"%>
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
	int pno = Integer.parseInt(request.getParameter("pno"));
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>질문 및 답변보기</h1>
	</div>
	<%
		int no = Integer.parseInt(request.getParameter("no"));
		QuestionAnswerDao qnaDao = new QuestionAnswerDao();
		Question question = qnaDao.getQuestionByNo(no);
		
		if("답변완료".equals(question.getStatus())) {
			Answer answer = qnaDao.getAnswerByQuesNo(question.getNo());
			question.setAnswer(answer);
		}
		
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
	<%
		if (question.getAnswer() == null && "답변대기중".equals(question.getStatus())) {
	%>
	<div>
		<a href="cancel.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" class="btn btn-danger">질문취소</a>
		<a href="answerform.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" class="btn btn-success">답변달기</a>
		<a href="delete.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" class="btn btn-warning">게시글삭제</a>
		<a href="list.jsp?pno=<%=pno %>" class="btn btn-primary pull-right">목록</a>
	</div>
	<%
		} else if (question.getAnswer() == null && "질문취소".equals(question.getStatus())) {
	%>
	<div>
		<a href="delete.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" class="btn btn-warning">게시글삭제</a>
		<a href="list.jsp?pno=<%=pno %>" class="btn btn-primary pull-right">목록</a>
	</div>
	<%
		} else if (question.getAnswer() != null) {
	%>
	<hr />
	
	<div class="panel panel-danger panel-body">
		<table class="table">
			<colgroup>
				<col width="11%">
				<col width="40%">
				<col width="9%">
				<col width="40%">
			</colgroup>
			<tr>
				<th>답변일</th>
				<td><%=DateUtils.dateToString(question.getAnswer().getCreateDate()) %></td>
				<th>답변자</th>
				<td><%=question.getAnswer().getWriter() %></td>
			</tr>
			<tr>
				<th>답변내용</th>
				<td colspan="3">
					<%=question.getAnswer().getContents() %>
				</td>
			</tr>
		</table>
	</div>
	
	<div>
		<a href="delete.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" class="btn btn-warning">게시글삭제</a>
		<a href="list.jsp?pno=<%=pno %>" class="btn btn-primary pull-right">목록</a>
	</div>
	<%
		}
	%>
</div>
</body>
</html>