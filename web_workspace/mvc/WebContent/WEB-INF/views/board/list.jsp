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
		<h1>자유게시판</h1>
	</div>
	
	<table class="table table-condensed table-hover">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="15%">
			<col width="15%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목 <strong style="color:green">좋아요</strong> </th>
				<th>작성자</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty boards }">
				<c:forEach var="board" items="${boards }">
					<tr>
						<td>${board.no }</td>
						<td><a href="detail.hta?pno=${pno }&no=${board.no }&gubun=detail" style="color:black; text-decoration:none; display:block; hover;">${board.title } <strong style="color:green">${board.likes }</strong></a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.createDate }" pattern="yyyy.MM.dd E"/></td>
					</tr>
				</c:forEach>				
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4" class="text-center">조회된 글이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	
	<div class="text-right">
		<a href="form.hta?pno=${pno }" class="btn btn-primary">새 글쓰기</a>
	</div>
	
	<div class="text-center">
		<ul class="pagination">
		<c:forEach var="no" begin="1" end="${totalPCount }">
			<li class="${no eq pno ? 'active' : '' }"><a href="list.hta?pno=${no }">${no }</a></li>			
		</c:forEach>
		</ul>
	</div>
</div>
</body>
</html>