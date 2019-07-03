<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@page import="kr.co.hta.course.vo.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int courseNo = Integer.parseInt(request.getParameter("cno"));
	String contents = request.getParameter("contents");
	Member member = (Member) session.getAttribute("LOGINUSER");
	
	Comment comment = new Comment();
	comment.setCourseNo(courseNo);
	comment.setContents(contents);
	comment.setMemberName(member.getName());
	
	CourseDao courseDao = new CourseDao();
	courseDao.insertComment(comment);
	
	response.sendRedirect("detail.jsp?cno=" + courseNo);
%>