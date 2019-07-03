<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 사용하기</h1>
	
	<h2>초기화 파라미터값 조회</h2>
	<p>회사명 : ${initParam.company_name }</p>
	<p>회사번호 : ${initParam.company_tel }</p>
	<p>관리자 이메일 : ${initParam.admin_email }</p>
</body>
</html>