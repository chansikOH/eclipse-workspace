<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");

	// 세션객체에 속성(값, 객체 담기)
	
	session.setAttribute("user-name", name);
	session.setAttribute("USER_ADDRESS", addr);
	
	response.sendRedirect("demo7.jsp");
	
%>