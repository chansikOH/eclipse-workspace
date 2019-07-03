<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");


	// cos.jar 라이브러리를 사용해서 멀티파트요청 처리하기
	/*
		cos.jar는 멀티파트요청을 처리하는 MultipartRequest 객체를 제공한다.
		MultipartRequest(HttpServletRequest request, String saveDirectory, String encoding)
	*/
	
	String saveDirectory = "C:\\projects\\web_workspace\\sample\\WebContent\\images";
	String encoding = "utf-8";
	
	// 멀티파트요청을 처리하는 MultipartRequest객체 생성
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, encoding);
	
	String name = mr.getParameter("username");
	String id = mr.getParameter("userid");
	String pwd = mr.getParameter("userpwd");
	String email = mr.getParameter("useremail");
	String filename = mr.getFilesystemName("userphoto");
	
	System.out.println("이름 : " + name);
	System.out.println("아이디 : " + id);
	System.out.println("비밀번호 : " + pwd);
	System.out.println("이메일 : " + email);
	System.out.println("파일명 : " + filename);
	
	/*
	멀티파트요청은 처리할 수 없음
	String name = request.getParameter("username");
	String id = request.getParameter("userid");
	String pwd = request.getParameter("userpwd");
	String email = request.getParameter("useremail");
	
	System.out.println(name);
	System.out.println(id);
	System.out.println(pwd);
	System.out.println(email); 
	*/
	
%>