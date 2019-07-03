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
<c:set var="menu" value="board" />
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>자유게시판</h1>
	</div>
	
	<form class="form-inline" action="list.hta" id="list-form">
		<input type="hidden" name="pno" id="page-no" />
	<div class="row">
		<div class="col-sm-6">
			<select class="form-control" name="size" onchange="sendform(1);">
				<option value="10" ${param.size eq 10 ? 'selected' : '' }> 10개씩</option>
				<option value="20" ${param.size eq 20 ? 'selected' : '' }> 20개씩</option>
				<option value="50" ${param.size eq 50 ? 'selected' : '' }> 50개씩</option>
				<option value="100" ${param.size eq 100 ? 'selected' : '' }> 100개씩</option>
			</select>
		</div>
		<div class="col-sm-6">
			<select class="form-control pull-right" name="sort" onchange="sendform(1);">
				<option value="NEW" ${param.sort eq 'NEW' ? 'selected' : '' }> 최신순</option>
				<option value="OLD" ${param.sort eq 'OLD' ? 'selected' : '' }> 옛날순</option>
			</select>
		</div>
	</div>
	
	<table class="table table-condensed table-hover">
		<colgroup>
			<col width="10%">
			<col width="*">
			<col width="15%">
			<col width="10%">
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
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
						<td><a href="detail.hta?no=${board.no }">${board.title }</a></td>
						<td>${board.writer }</td>
						<td><fmt:formatDate value="${board.createDate }"/> </td>
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
	
	<div class="row">
		<div class="col-sm-6">
			<ul class="pagination">
				<c:choose>
					<c:when test="${not pagination.first }">
						<li><a href="#" onclick="goPage(event, ${pagination.page - 1})">&laquo;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#" onclick="goPage(event, ${pagination.begin})">&laquo;</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach var="no" begin="${pagination.begin }" end="${pagination.end }">
					<li class="${no eq pagination.page ? 'active' : '' }" ><a href="#" onclick="goPage(event, ${no })">${no }</a></li>
				</c:forEach>
				<c:choose>
					<c:when test="${not pagination.last }">
						<li><a href="#" onclick="goPage(event, ${pagination.page + 1})">&raquo;</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#" onclick="goPage(event, ${pagination.end})">&raquo;</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<div class="col-sm-6 text-right">
			<select class="form-control" name="opt" onchange="sendform(1);">
				<option value="title" ${param.opt eq 'title' ? 'selected' : '' }> 제목</option>
				<option value="writer"  ${param.opt eq 'writer' ? 'selected' : '' }> 작성자</option>
				<option value="content" ${param.opt eq 'content' ? 'selected' : '' }> 내용</option>
			</select>
			<input type="text" class="form-control" name="keyword" value="${param.keyword }">
			<button type="button" class="btn btn-default" onclick="sendform(1);">검색</button>
		</div>
	</div>
	</form>
	
	<div class="text-right">
		<a href="form.hta" class="btn btn-primary">새 글쓰기</a>
	</div>
	
	<script type="text/javascript">
		function sendform(pno) {
			document.getElementById("page-no").value = pno;
			document.getElementById("list-form").submit();
		}
		
		function goPage(event, pno) {
			event.preventDefault();	// a 태그 기본동작 발생 방지
			sendform(pno);
		}
	</script>
</div>
</body>
</html>