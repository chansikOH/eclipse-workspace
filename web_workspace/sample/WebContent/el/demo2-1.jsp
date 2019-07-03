<%@page import="java.util.Date"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 표현식 사용하기</h1>
	
	<%
		// 객체를 속성으로 저장하기
		Member member = new Member();
		member.setId("hong");
		member.setName("홍길동");
		member.setPwd("zxcv1234");
		member.setEmail("hong@gmail.com");
		member.setUsed("Y");
		member.setCreateDate(new Date());
		
		request.setAttribute("customer", member);
		
		request.getRequestDispatcher("demo2-2.jsp").forward(request, response);
	%>

</body>
</html>