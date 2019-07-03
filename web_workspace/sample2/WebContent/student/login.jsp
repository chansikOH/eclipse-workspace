<%@page import="kr.co.hta.dao.StudentDao"%>
<%@page import="kr.co.hta.vo.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	StudentDao studentDao = new StudentDao();
	Student student = studentDao.getStudentById(id);
	
	if (student == null) {
		response.sendRedirect("loginform.jsp?result=fail");
		return;
	}
	
	if (!student.getPassword().equals(pwd)) {
		response.sendRedirect("loginform.jsp?result=fail");
		return;
	}
	
	session.setAttribute("LOGIN_STUDENT", student);
	
	response.sendRedirect("../index.jsp");
%>