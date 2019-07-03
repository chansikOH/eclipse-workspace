<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="kr.co.hta.member.vo.Member"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@page import="kr.co.hta.course.vo.Registration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	CourseDao courseDao = new CourseDao();

	int courseNo = Integer.parseInt(request.getParameter("cno"));
	Member member = (Member) session.getAttribute("LOGINUSER");
	
	Map<String, Object> searchMap = new HashMap<String, Object>();
	searchMap.put("courseNo", courseNo);
	searchMap.put("memberId", member.getId());
	
	Registration registration = courseDao.getRegByCourseNoAndMemberId(searchMap);
	
	if (registration != null && (registration.getStatus().equals("R") || registration.getStatus().equals("S"))) {
		response.sendRedirect("detail.jsp?cno=" + courseNo + "&result=fail");
	} else if (registration == null || registration.getStatus().equals("C")) {
		registration = new Registration();
		registration.setCourseNo(courseNo);
		registration.setMemberId(member.getId());
		
		courseDao.insertRegistration(registration);
		
		response.sendRedirect("detail.jsp?cno=" + courseNo + "&result=success");
	} 
%>