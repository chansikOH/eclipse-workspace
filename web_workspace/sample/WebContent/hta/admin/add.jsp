<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="kr.co.hta.course.dao.CourseDao"%>
<%@page import="kr.co.hta.course.vo.Course"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*  
		<form enctype="multipart/form-data">로 설정되어있는 경우(첨부파일 업로드 폼)
		첨부파일, 첨부파일정보, 입력값 정보를 서버로 제출하기 위한 적절한 컨텐츠 형태로
		만들어서 서버로 전송하게 된다.
		
		new MultipartRequest(request,		// 요청메세지정보를 담고 있는 요청객체 
							saveDirectory, 	// 첨부파일이 저장될 경로
							"utf-8"			// 한글처리를 위한 인코딩방식 지정
							);
		new MultipartRequest(request,
							saveDirectory,					// 첨부파일이 저장될 경로
							1024*1024*10,					// 최대업로드 파일 사이즈 10M
							"utf-8",						// 인코딩방식
							new DefaultFileRenamePolicy()	//중복파일이름회피정책객체
							);
	*/

	String saveDirectory = "C:\\projects\\web_workspace\\sample\\WebContent\\images";
	
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
	
	String title = mr.getParameter("title");
	String startDate = mr.getParameter("startDate");
	String endDate = mr.getParameter("endDate");
	String cost = mr.getParameter("cost");
	int quota = Integer.parseInt(mr.getParameter("quota"));
	String description = mr.getParameter("description");
	String imgName = mr.getFilesystemName("photo");
	
	Course course = new Course();
	course.setTitle(title);
	course.setStartDate(startDate);
	course.setEndDate(endDate);
	course.setCost(cost);
	course.setQuota(quota);
	course.setDescription(description);
	course.setImgName(imgName);
	
	CourseDao courseDao = new CourseDao();
	courseDao.insertCourse(course);
	
	response.sendRedirect("courselist.jsp");
%>