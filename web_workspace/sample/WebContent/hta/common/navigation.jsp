<%@page import="kr.co.hta.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member member = (Member) session.getAttribute("LOGINUSER");
%>
<nav class="navbar navbar-default">
	<div class="container">
    	<div class="navbar-header">
    		<a class="navbar-brand" href="/hta/main.jsp">중앙HTA</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="<%=menu.equals("home") ? "active" : ""%>"><a href="/hta/main.jsp">홈</a></li>
      		<li class="<%=menu.equals("course") ? "active" : ""%>"><a href="/hta/course/list.jsp">개설과정</a></li>
      		<li class="<%=menu.equals("board") ? "active" : ""%>"><a href="/hta/board/list.jsp?pno=1">자유게시판</a></li>
      		<li class="<%=menu.equals("qna") ? "active" : ""%>"><a href="/hta/qna/list.jsp?pno=1">문의게시판</a></li>
		<%
			if(member != null && member.getType().equals("ADMIN")) {
		%>
			<li class="dropdown; <%=menu.equals("admin") ? "active" : ""%>">
				<a class="dropdown-toggle" data-toggle="dropdown">관리자
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="/hta/admin/courselist.jsp">개설과정 관리</a></li>
					<li><a href="">상담신청 관리</a></li>
					<li><a href="">학생 관리</a></li>
				</ul>
			</li>
		<%
			}
		%>
		<%
 			if (member != null && member.getType().equals("USER")) {
 		%>
 			<li class="dropdown">
 				<a class="dropdown-toggle" data-toggle="dropdown">사용자
 					<span class="caret"></span>
 				</a>
 				<ul class="dropdown-menu">
 					<li><a href="/hta/member/courselist.jsp">수강신청현황 조회</a></li>
 					<li><a href="/hta/member/myinfo.jsp">내정보 조회</a></li>
 					<li><a href="/hta/member/passwordchangeform.jsp">비밀번호 변경</a></li>
 				</ul>
 			</li>
 		<%
 			}
 		%>	
    	</ul>

    	<%
    		if(member == null) {
    	%>
    	<ul class="nav navbar-nav navbar-right">
      		<li class="<%=menu.equals("member") ? "active" : ""%>"><a href="/hta/member/form.jsp?result=none">회원가입</a></li>
      		<li class="<%=menu.equals("login") ? "active" : ""%>"><a href="/hta/login/loginform.jsp?result=none">로그인</a></li>
    	</ul>
    	<%
    		} else {
    	%>
    	<ul class="nav navbar-nav navbar-right">
      		<li class="<%=menu.equals("member") ? "active" : ""%>"><a href="/hta/login/mypage.jsp">MyPage</a></li>
      		<li><a href="/hta/login/logout.jsp">로그아웃</a></li>
    	</ul>
    	<p class="navbar-text navbar-right"><strong><%=member.getName() %></strong>님 환영합니다.</p>
    	<%
    		}
    	%>
  	</div>
</nav>