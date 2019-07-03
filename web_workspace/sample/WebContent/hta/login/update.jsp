<%@page import="kr.co.hta.member.dao.MemberDao"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	MemberDao memberDao = new MemberDao();	
	Member member = memberDao.getMemberById(id);
	member.setPwd(pwd);
	member.setEmail(email);
	
	memberDao.updateMember(member);
	session.setAttribute("LOGINUSER", member);
	
	response.sendRedirect("mypage.jsp");

%>