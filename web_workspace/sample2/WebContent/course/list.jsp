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
<% String menu = "course"; %>
<%@ include file="../common/header.jsp" %>
<div class="container">
	<div class="panel panel-info">
		<div class="panel-heading">
			<h4>개설과목 목록</h4>
		</div>
		<div class="panel-body">
			<table class="table">
				<colgroup>
					<col width="15%">
					<col width="*">
					<col width="15%">
					<col width="10%">
					<col width="10%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th>과목아이디</th>
						<th>과목명</th>
						<th>학과</th>
						<th>타입</th>
						<th>정원</th>
						<th>신청자수</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>100</td>
						<td>동역학 이론 및 실험</td>
						<td>기계공하과</td>
						<td>전공필수</td>
						<td>50</td>
						<td>14</td>
					</tr>
					<tr>
						<td>100</td>
						<td>동역학 이론 및 실험</td>
						<td>기계공하과</td>
						<td>전공필수</td>
						<td>50</td>
						<td>14</td>
					</tr>
					<tr>
						<td>100</td>
						<td>동역학 이론 및 실험</td>
						<td>기계공하과</td>
						<td>전공필수</td>
						<td>50</td>
						<td>14</td>
					</tr>
					<tr>
						<td>100</td>
						<td>동역학 이론 및 실험</td>
						<td>기계공하과</td>
						<td>전공필수</td>
						<td>50</td>
						<td>14</td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="panel-footer text-center">
			<ul class="pagination">
				<li class="active"><a href="list.jsp?no=1">1</a></li>
				<li><a href="list.jsp?no=1">2</a></li>
				<li><a href="list.jsp?no=1">3</a></li>
				<li><a href="list.jsp?no=1">4</a></li>
				<li><a href="list.jsp?no=1">5</a></li>
			</ul>
		</div>
	</div>
</div>
<%@ include file="../common/footer.jsp" %>
</body>
</html>