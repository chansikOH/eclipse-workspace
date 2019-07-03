<%@page import="kr.co.hta.vo.Student"%>
<%@page import="kr.co.hta.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String dept = request.getParameter("dept");
	int grade = Integer.parseInt(request.getParameter("grade"));
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	
	StudentDao studentDao = new StudentDao();
	Student student = studentDao.getStudentById(id);
	if(student != null) {
		response.sendRedirect("form.jsp?result=fail");
		return;
	}
	
	student = new Student();
	student.setDept(dept);
	student.setGrade(grade);
	student.setId(id);
	student.setPassword(pwd);
	student.setName(name);
	student.setGender(gender);
	studentDao.insertStudent(student);
	
	response.sendRedirect("complete.jsp");	
%>