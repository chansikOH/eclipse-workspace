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
<nav class="navbar navbar-default">
	<div class="container">
    	<div class="navbar-header">
    		<a class="navbar-brand" href="/hta/main.jsp">중앙HTA</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li><a href="/hta/main.jsp">홈</a></li>
      		<li><a href="#">개설과정</a></li>
      		<li><a href="/hta/board/list.jsp">자유게시판</a></li>
      		<li class="active"><a href="/hta/qna/list.jsp">문의게시판</a></li>
    	</ul>
    	<ul class="nav navbar-nav navbar-right">
      		<li><a href="#">회원가입</a></li>
      		<li><a href="#">로그인</a></li>
    	</ul>
  	</div>
</nav>
<div class="container">
	<div class="page-header">
		<h1>질문 및 답변보기</h1>
	</div>
	
	<table class="table table-bordered">
		<colgroup>
			<col width="10%">
			<col width="23%">
			<col width="10%">
			<col width="24%">
			<col width="10%">
			<col width="23%">
		</colgroup>
		<tr>
			<th>번호</th>
			<td>100</td>
			<th>등록일</th>
			<td colspan="3">2019.05.19</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>홍길동</td>
			<th>구분</th>
			<td>수강신청</td>
			<th>진행상태</th>
			<td><span class="label label-success">답변완료</span></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5">문의 게시판 연습용 글입니다.</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5">
				LG전자가 국내 스마트폰 생산공장 철수를 공식 발표하면서 생산 라인에서 일하던 인력들의 근무지 재배치도 함께 진행된다. 
				LG전자는 인위적인 구조조정 없이 생활가전 생산공장으로 이들을 전환 배치한다는 계획이지만 적잖은 후유증이 예상된다. 
				직원들이 주거지를 옮겨야 하는 상황인데다 이들이 주로 투입되는 검수작업은 스마트폰과 생활가전 제품의 특성상 차이가 많아 업무 적응 문제가 발생할 수 있기 때문이다. 
				이런 이유로 직원들이 퇴직할 경우 보상금 지급 등 처리해야 할 과제가 많다.
			</td>
		</tr>
	</table>
	
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
				<td>2019.05.19</td>
				<th>답변자</th>
				<td>2019.05.19</td>
			</tr>
			<tr>
				<th>답변내용</th>
				<td colspan="3">
					LG전자가 국내 스마트폰 생산공장 철수를 공식 발표하면서 생산 라인에서 일하던 인력들의 근무지 재배치도 함께 진행된다. 
					LG전자는 인위적인 구조조정 없이 생활가전 생산공장으로 이들을 전환 배치한다는 계획이지만 적잖은 후유증이 예상된다. 
					직원들이 주거지를 옮겨야 하는 상황인데다 이들이 주로 투입되는 검수작업은 스마트폰과 생활가전 제품의 특성상 차이가 많아 업무 적응 문제가 발생할 수 있기 때문이다. 
					이런 이유로 직원들이 퇴직할 경우 보상금 지급 등 처리해야 할 과제가 많다.
				</td>
			</tr>
		</table>
	</div>
	
	<div>
		<a href="#" class="btn btn-primary pull-right">목록</a>
	</div>
</div>
</body>
</html>