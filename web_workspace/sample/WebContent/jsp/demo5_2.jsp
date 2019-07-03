<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String username = request.getParameter("username");
	String city = request.getParameter("city");
	String gender = request.getParameter("gender");
	String school = request.getParameter("school");
	String[] teches = request.getParameterValues("tech");
	
	/*
	해당 요청정보를 담는 클래스의 형태
	
	public class User{
		private String username;
		private String city;
		private String gender;
		private String school;
		private String[] tech;
	}
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청 파라미터값 확인</title>
</head>
<body>
	<h1>요청 파라미터값 확인</h1>
	<dl>
		<dt>이름</dt><dd><%=username %></dd>
		<dt>거주지역</dt><dd><%=city %></dd>
		<dt>성별</dt><dd><%=gender %></dd>
		<dt>학력</dt><dd><%=school %></dd>
		<dt>보유기술</dt><%--<dd><%=Arrays.toString(teches) %></dd> --%>
		<%
			for (String tech : teches) {
		%>
		<dd><%=tech %></dd>
		<%
			}
		%>
	</dl>

</body>
</html>