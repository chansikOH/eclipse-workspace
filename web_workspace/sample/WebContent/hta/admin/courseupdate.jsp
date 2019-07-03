<%@page import="kr.co.hta.course.vo.Course"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String saveDirectory = "C:\\projects\\web_workspace\\sample\\WebContent\\images";

	MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
	
	int courseNo = Integer.parseInt(mr.getParameter("no"));
	String title = mr.getParameter("title");
	String startDate = mr.getParameter("startDate");
	String endDate = mr.getParameter("endDate");
	String cost = mr.getParameter("cost");
	int quota = Integer.parseInt(mr.getParameter("quota"));
	String description = mr.getParameter("description");
	String imgName = mr.getFilesystemName("photo");
	String displayYn = mr.getParameter("dis");
	
	CourseDao courseDao = new CourseDao();
	Course course = courseDao.getCourseByNo(courseNo);
	course.setTitle(title);
	course.setStartDate(startDate);
	course.setEndDate(endDate);
	course.setCost(cost);
	course.setQuota(quota);
	course.setDescription(description);
	course.setImgName(imgName);
	course.setDisplayYn(displayYn);
	
	courseDao.updateCourse(course);
	
	response.sendRedirect("coursedetail.jsp?cno=" + courseNo);
%>