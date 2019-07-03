<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
	<div class="container">
    	<div class="navbar-header">
    		<a class="navbar-brand" href="/mvc/main.hta">중앙HTA</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="${menu eq 'main' ? 'active' : '' }"><a href="/mvc/main.hta">홈</a></li>
      		<li class="${menu eq 'course' ? 'active' : '' }"><a href="/mvc/course/list">개설과정</a></li>
      		<li class="${menu eq 'board' ? 'active' : '' }"><a href="/mvc/board/list.hta?pno=1">자유게시판</a></li>
    	</ul>
    	
    	<c:choose>
	    	<c:when test="${empty LOGINMEMBER }">
		    	<ul class="nav navbar-nav navbar-right">
		      		<li class="${menu eq 'member' ? 'active' : '' }"><a href="/mvc/member/form.hta">회원가입</a></li>
		      		<li class="${menu eq 'login' ? 'active' : '' }"><a href="/mvc/member/loginform.hta">로그인</a></li>
		    	</ul>
	    	</c:when>
	    	<c:otherwise>
	    		<c:set var="pn" value="${LOGINMEMBER.photoName }"></c:set>
		    	<ul class="nav navbar-nav navbar-right">
		      		<li><a href="/mvc/member/logout.hta">로그아웃</a></li>
		      		<li><a href="/mvc/admin/members.hta">관리자</a></li>
		    	</ul>
		    	<p class="navbar-text navbar-right">
		    		<img src="/mvc/photos/${pn != null ? pn : 'default.png'}" class="img-rounded" width="30" height="30" />
		    			<strong>${LOGINMEMBER.name }</strong>님</p>
	    	</c:otherwise>
    	</c:choose>   	
  	</div>
</nav>