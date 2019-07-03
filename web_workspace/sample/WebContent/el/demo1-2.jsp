<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 표현식으로 속성값 표현하기</h1>
	
	<dl>
		<dt>결혼여부</dt><dd>${isMarried }</dd>
		<dt>적립포인트</dt><dd>${point }</dd>
		<dt>할인율</dt><dd>${discount_rate }</dd>
		<dt>이름</dt><dd>${lastname } ${firstname }</dd>
		<dt>이메일</dt><dd>${email }</dd>
	</dl>

</body>
</html>