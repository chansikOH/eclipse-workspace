<%@page import="kr.co.hta.member.vo.Maker"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Core 태그 라이브러리</title>
</head>
<body>
	<h1>Core 태그 라이브러리</h1>
	
	<h3>제조사 목록</h3>
	<%
		ArrayList<Maker> makers = new ArrayList<>();
		Maker m1 = new Maker("현대자동차", "울산광역시", "010-1111-1111");
		Maker m2 = new Maker("삼성전자", "경기도 수원시", "010-2222-2222");
		Maker m3 = new Maker("LG전자", "경기도 판교", "010-3333-3333");
		Maker m4 = new Maker("샤오미", "중국 베이징", "010-4444-4444");
		Maker m5 = new Maker("기아자동차", "경기도 판교", "010-5555-5555");
		makers.add(m1);
		makers.add(m2);
		makers.add(m3);
		makers.add(m4);
		makers.add(m5);
		
		request.setAttribute("companies", makers);
	%>
	<table border="1" style="width:100%">
		<thead>
			<tr>
				<th>회사명</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="maker" items="${companies }">			
			<tr>
				<td>${maker.name }</td>
				<td>${maker.address }</td>
				<td>${maker.tel }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>