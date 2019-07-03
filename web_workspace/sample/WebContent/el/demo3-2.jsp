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
		<dt>자동차명</dt><dd>${myCar.name }</dd>
		<dt>가격</dt><dd>${myCar.price }</dd>
		<dt>생산년도</dt><dd>${myCar.year }</dd>
		<dt>제조사명</dt><dd>${myCar.company.name }</dd>
		<dt>제조사 주소</dt><dd>${myCar.company.address }</dd>
		<dt>제조사 연락처</dt><dd>${myCar.company.tel }</dd>
	</dl>

</body>
</html>