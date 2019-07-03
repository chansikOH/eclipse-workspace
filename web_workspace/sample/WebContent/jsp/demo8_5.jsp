<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 속성과 스코프 살펴보기</title>
</head>
<body>
	<h1>JSP 내장객체에 저장된 속성 EL로 조회하기</h1>
	
	<h3>속성값 표현</h3>
	<dl>
		<dt>pageContext의 속성값</dt><dd>${p }</dd>
		<dt>request의 속성값</dt><dd>${r }</dd>
		<dt>session의 속성값</dt><dd>${s }</dd>
		<dt>application의 속성값</dt><dd>${a }</dd>
	</dl>
	
	<h3>개봉영화</h3>
	<ol>
		<li>${movies[0] }</li>
		<li>${movies[1] }</li>
		<li>${movies[2] }</li>
	</ol>
	
	<h3>고객정보</h3>
	<dl>
		<dt>아이디</dt><dd>${customer.id }</dd>
		<dt>이름</dt><dd>${customer.name }</dd>
		<dt>이메일</dt><dd>${customer.email }</dd>
		<dt>비밀번호</dt><dd>${customer.pwd }</dd>
		<dt>사용여부</dt><dd>${customer.used }</dd>
		<dt>가입일</dt><dd>${customer.createDate }</dd>
	</dl>

</body>
</html>