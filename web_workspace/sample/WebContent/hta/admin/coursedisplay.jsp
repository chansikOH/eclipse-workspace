<%@page import="kr.co.hta.course.vo.Course"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int courseNo = Integer.parseInt(request.getParameter("cno"));
	String displayYn = request.getParameter("yn");
	
	CourseDao courseDao = new CourseDao();
	Course course = courseDao.getCourseByNo(courseNo);
	
	course.setDisplayYn(displayYn);
	
	courseDao.updateCourse(course);
	
	response.sendRedirect("courselist.jsp");
%>