<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 세션객체에 저장된 속성 삭제하기
	if("이름삭제".equals(request.getParameter("name"))) {
		session.removeAttribute("user-name");
	} else if ("주소삭제".equals(request.getParameter("addr"))) {
		session.removeAttribute("USER_ADDRESS");		
	}

	response.sendRedirect("demo7.jsp");
%>