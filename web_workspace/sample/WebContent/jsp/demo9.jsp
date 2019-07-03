<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화 파라미터 사용하기</title>
</head>
<body>
	<h1>초기화 파라미터 사용하기</h1>
	
	<%
		String companyName = application.getInitParameter("company_name");
		String tel = application.getInitParameter("company_tel");
		String email = application.getInitParameter("admin_email");
	%>
	
	<h2>회사소개</h2>
	<dl>
		<dt>회사명</dt><dd><%=companyName %></dd>
		<dt>전화번호</dt><dd><%=tel %></dd>
		<dt>담당자 메일주소</dt><dd><%=email %></dd>
	</dl>
	
	<h2>회사소개</h2>
	<dl>
		<dt>회사명</dt><dd>${initParam.company_name }</dd>
		<dt>전화번호</dt><dd>${initParam.company_tel }</dd>
		<dt>담당자 메일주소</dt><dd>${initParam.admin_email }</dd>
	</dl>
	

</body>
</html>