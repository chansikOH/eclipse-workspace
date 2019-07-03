<%@page import="kr.co.hta.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Student student = (Student) session.getAttribute("LOGIN_STUDENT");
%>
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/sample2/index.jsp">HTA대학교</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="<%=menu.equals("home") ? "active" : ""  %>"><a href="/sample2/index.jsp">홈</a></li>
			<li class="<%=menu.equals("course") ? "active" : ""  %>"><a href="/sample2/course/list.jsp">개설과정</a></li>
		</ul>
		<%
			if (student == null) {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li class="<%=menu.equals("login") ? "active" : ""  %>"><a href="/sample2/student/loginform.jsp">로그인</a></li>
			<li class="<%=menu.equals("student") ? "active" : ""  %>"><a href="/sample2/student/form.jsp">회원가입</a></li>
		</ul>		
		<%
			} else {
		%>
		<ul class="nav navbar-nav navbar-right">
			<li class="<%=menu.equals("student") ? "active" : ""  %>"><a href="/sample2/student/mypage.jsp">MyPage</a></li>
			<li><a href="/sample2/student/logout.jsp">로그아웃</a></li>	
		</ul>
		<p class="navbar-text navbar-right"><strong><%=student.getName() %></strong>님 환영합니다.</p>
		<%
			}
		%>
		
		
		
		
	</div>
</nav>
