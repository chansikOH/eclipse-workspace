<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 각각의 내장객체에 속성 저장하기
	
	// PageContext객체에 속성 저장하기
	pageContext.setAttribute("A", "pageContext의 속성이야");
	// HttpServletRequest객체에 속성 저장하기
	request.setAttribute("B", "request의 속성이야");
	// HttpSession객체에 속성 저장하기
	session.setAttribute("C", "session의 속성이야");
	// ServletContext객체에 속성 저장하기
	application.setAttribute("D", "application의 속성이야");
	
	response.sendRedirect("demo8.jsp");
%>