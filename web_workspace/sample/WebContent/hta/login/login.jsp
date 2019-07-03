<%@page import="kr.co.hta.member.dao.MemberDao"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("userid");
	String pwd = request.getParameter("userpwd");
	
	// 인증과정 구현
	MemberDao memberDao = new MemberDao();
	Member member = memberDao.getMemberById(id);
	
	if(member == null) {
		// 아이디에 해당하는 사용자 없음
		response.sendRedirect("loginform.jsp?result=fail");	
		return;
	}
	
	if("N".equals(member.getUsed())) {
		// 삭제된 사용자
		response.sendRedirect("loginform.jsp?result=fail");
		return;
	}
	
	if(!member.getPwd().equals(pwd)) {
		// 비밀번호가 일치하지 않음
		response.sendRedirect("loginform.jsp?result=fail");
		return;
	}
	
	// 위의 세가지에 모두 해당하지 않음 --> 인증된 사용자임 --> 세션에 사용자정보 저장
	session.setAttribute("LOGINUSER", member);
	
	response.sendRedirect("/hta/main.jsp");
%>