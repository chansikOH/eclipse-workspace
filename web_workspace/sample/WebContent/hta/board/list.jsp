<%@page import="kr.co.hta.util.DateUtils"%>
<%@page import="kr.co.hta.board.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hta.board.dao.BoardDao"%>
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
		<h1>자유게시판</h1>
	</div>
	
	<table class="table table-condensed table-hover">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="15%">
			<col width="10%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>좋아요</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		<%
			BoardDao boardDao = new BoardDao();
			int begin = (pno - 1)*10 + 1;
			int end = pno*10;
			
			ArrayList<Board> boards = boardDao.getBoardsByRange(begin, end);
			// ArrayList<Board> boards = boardDao.getAllBoards();
			
			for(Board board : boards) {
		%>
			<tr>
				<td><%=board.getNo() %></td>
				<td><a href="detail.jsp?no=<%=board.getNo() %>&pno=<%=pno %>" style="color:black; text-decoration:none; 
										display:block; hover;"><%=board.getTitle() %></a></td>
				<td><%=board.getWriter() %></td>
				<td><%=board.getLikes() %></td>
				<td><%=DateUtils.dateToString(board.getCreateDate()) %></td>
			</tr>
		<%
			}
		%>
		</tbody>
	</table>
	
	<%
		if(member != null) {
	%>
	<div class="text-right">
		<a href="form.jsp?pno=<%=pno %>" class="btn btn-primary">새 글쓰기</a>
	</div>
	<%
		}
	%>
	
	<%
		int totalRecordsCount = boardDao.getBoardsCount();
		int totalPagesCount = (int)Math.ceil((double)totalRecordsCount/10);
	%>
	<div class="text-center">
		<ul class="pagination">
		<%
			for(int i=1; i<=totalPagesCount; i++) {
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