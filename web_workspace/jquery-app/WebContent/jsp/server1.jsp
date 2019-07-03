<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	Random random = new Random();
	int number = random.nextInt(10000);
	out.write(String.valueOf(number));
%>