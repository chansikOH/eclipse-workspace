<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL로 속성값 표현하기</h1>
	
	<dl>
		<dt>아이디</dt><dd>${customer.id }</dd>
		<dt>이름</dt><dd>${customer.name }</dd>
		<dt>비밀번호</dt><dd>${customer.pwd }</dd>
		<dt>사용여부</dt><dd>${customer.used }</dd>
		<dt>이메일</dt><dd>${customer.email }</dd>
		<dt>가입일</dt><dd>${customer.createDate }</dd>
	</dl>

</body>
</html>