<%@page import="kr.co.hta.util.DateUtils"%>
<%@page import="kr.co.hta.qna.vo.Question"%>
<%@page import="java.util.ArrayList"%>
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
	int pno = 0;
	try{
		pno = Integer.parseInt(request.getParameter("pno"));
	} catch (NumberFormatException e) {
		response.sendRedirect("list.jsp?pno=1");
		return;
	}
%>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>문의 게시판</h1>
	</div>
	<%
		QuestionAnswerDao qnaDao = new QuestionAnswerDao();
		
		int begin = (pno - 1)*10 + 1;
		int end = pno*10;
		ArrayList<Question> questions = qnaDao.getQuestionsByRange(begin, end);
		// ArrayList<Question> questions = qnaDao.getAllQuestions();
	%>
	
	<table class="table table-condensed table-hover">
		<colgroup>
			<col width="6%">
			<col width="14%">
			<col width="*">
			<col width="12%">
			<col width="10%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>구분</th>
				<th>제목</th>
				<th>작성자</th>
				<th>진행상태</th>
				<th>등록일</th>
			</tr>		
		</thead>
		<tbody>
		<%
			for(Question question : questions) {
				String status = null;
				if("답변완료".equals(question.getStatus())){
					status = "success";
				} else if ("답변대기중".equals(question.getStatus())){
					status = "default";
				} else if ("질문취소".equals(question.getStatus())) {
					status = "warning";
				} else if ("목록삭제".equals(question.getStatus())) {
					continue;
				}
		%>
			<tr>
				<td><%=question.getNo() %></td>
				<td><span class="text-primary">[<%=question.getGubun() %>]</span></td>
				<td><a href="detail.jsp?no=<%=question.getNo() %>&pno=<%=pno %>" style="color:black; text-decoration:none; 
											display:block; hover;"><%=question.getTitle() %></a></td>
				<td><%=question.getWriter() %></td>
				<td><span class="label label-<%=status %>"><%=question.getStatus() %></span></td>
				<td><%=DateUtils.dateToString(question.getCreateDate()) %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
	<div class="text-right">
		<a href="form.jsp?pno=<%=pno %>" class="btn btn-primary">질문쓰기</a>
	</div>
	<%
		int totalRecordsCount = qnaDao.getQuestionCount();
		int totalPagesCount = (int)Math.ceil((double)totalRecordsCount/10);
	%>
	<div class="text-center">
		<ul class="pagination">
		<%
			for (int i=1; i<=totalPagesCount; i++) {
		%>
			<li class="<%=pno==i ? "active" : "" %>"><a href="list.jsp?pno=<%=i %>"><%=i %></a></li>
		<%
			}
		%>
		</ul>
	</div>
</div>
</body>
</html>