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
<c:set var="menu" value="main" scope="page"/>
<%@ include file="../common/navigation.jsp" %>
<div class="container">
	<div class="page-header">
		<h1>관리자 페이지</h1>
	</div>
	
	<div class="row">
		<div class="col-sm-3">
			<ul class="list-group">
			<c:forEach var="member" items="${members }">
				<li class="list-group-item" id="item-${member.id }" onclick="showDetail('${member.id}')">${member.name }</li>
			</c:forEach>
			</ul>
		</div>
		<div class="col-sm-9">
			<div class="panel panel-info">
				<div class="panel-heading">
					회원 상세 정보
				</div>
				<div class="panel-body">
					<table class="table">
						<colgroup>
							<col width="15%">
							<col width="35%">
							<col width="15%">
							<col width="35%">
						</colgroup>
						<tbody id="member-body"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function showDetail(memberId) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			if(xhr.readyState == 4 && xhr.status == 200) {
				// JSON.parse(jsonText)
				// json표기법으로 작성된 텍스트를 자바스크립트 객체나 배열로 변환한다.
				var member = JSON.parse(xhr.responseText);
				
				var htmlContent = "";
				htmlContent += "<tr>";
				htmlContent += "<th>아이디</th><td>"+member.id+"</td>";
				htmlContent += "<th>비밀번호</th><td>"+member.pwd+"</td>";
				htmlContent += "</tr>";
				htmlContent += "<tr>";
				htmlContent += "<th>이름</th><td>"+member.name+"</td>";
				htmlContent += "<th>이메일</th><td>"+member.email+"</td>";
				htmlContent += "</tr>";
				htmlContent += "<tr>";
				htmlContent += "<th>사용자구분</th><td>"+member.type+"</td>";
				htmlContent += "<th>사용여부</th><td>"+member.usedYn+"</td>";
				htmlContent += "</tr>";
				
				document.getElementById("member-body").innerHTML = htmlContent;
			}
		}
		xhr.open("GET", "memberdetail.hta?memid=" + memberId);
		xhr.send();
	}
</script>
</body>
</html>