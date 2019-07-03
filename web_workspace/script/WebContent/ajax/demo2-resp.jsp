<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	List<String> db = Arrays.asList("test123", "test1234", "test1111", "test12345", "test1212", "text2222", "test3333", "test4444", "test4343", "test1133");	

	String userid = request.getParameter("id");
	
	boolean isExist = db.contains(userid);
	if (isExist) {
		out.write("Yes");	// 가입여부
	} else {
		out.write("No");	// 가입여부
	}

	/* 
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(userid);
		if(user != null) {
			// 아이디가 존재함
			out.write("Yes");
		} else {
			// 아이디가 존재하지 않음
			out.write("No");
		}
	*/
%>