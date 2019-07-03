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
<c:set var="menu" value="board" scope="page"/>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>글 내용</h1>
	</div>
	
	<table class="table table-bordered">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="35%">
		</colgroup>
		<tr>
			<th>번호</th>
			<td>${board.no }</td>
			<th>등록일</th>
			<td><fmt:formatDate value="${board.createDate }" pattern="yyyy.MM.dd E HH:mm:ss"/> </td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${board.title }</td>
			<th>좋아요</th>
			<td>${board.likes }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${board.contents }</td>
		</tr>
	</table>
	
	<div>
		<a href="likes.hta?pno=${pno }&no=${board.no }&gubun=detail" class="btn btn-success">좋아요</a>
		<a href="detail.hta?pno=${pno }&no=${board.no }&gubun=modify" class="btn btn-warning">수정</a>
		<a href="del.hta?pno=${pno }&no=${board.no }" class="btn btn-danger">삭제</a>
		<a href="list.hta?pno=${pno }" class="btn btn-primary pull-right">목록</a>
	</div>
</div>
</body>
</html>