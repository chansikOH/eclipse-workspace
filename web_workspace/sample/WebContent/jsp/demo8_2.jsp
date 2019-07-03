<%@page import="kr.co.hta.member.dao.MemberDao"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// JSP의 내장객체에 속성 저장하기
	pageContext.setAttribute("p", "pageContext속성값");
	request.setAttribute("r", "request속성값");
	session.setAttribute("s", "session속성값");
	application.setAttribute("a", "application속성값");
	
	String[] movies = {"어벤져스:엔드게임", "생일", "뽀로로의 대모험"};
	request.setAttribute("movies", movies);
	
	MemberDao memberDao = new MemberDao();
	Member member = memberDao.getMemberById("admin");
	request.setAttribute("customer", member);
	
	// forward 이동하기
	// RequestDispatcher rd = request.getRequestDispatcher("demo8_4.jsp");
	RequestDispatcher rd = request.getRequestDispatcher("demo8_5.jsp");
	rd.forward(request, response);
%>