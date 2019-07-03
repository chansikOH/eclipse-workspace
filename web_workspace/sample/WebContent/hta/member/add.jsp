<%@page import="kr.co.hta.member.vo.Member"%>
<%@page import="kr.co.hta.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String result = request.getParameter("result");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	MemberDao memberDao = new MemberDao();
	Member member = memberDao.getMemberById(id);
	if(member != null) {
		response.sendRedirect("form.jsp?result=fail");
		return;
	}
	member = new Member();
	member.setId(id);
	member.setName(name);
	member.setPwd(pwd);
	member.setEmail(email);
	
	memberDao.insertMember(member);
	
	response.sendRedirect("complete.jsp");
%>