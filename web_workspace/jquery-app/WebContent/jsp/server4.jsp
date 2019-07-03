<%@page import="com.google.gson.Gson"%>
<%@page import="ajax.Employee"%>
<%@page import="java.util.List"%>
<%@page import="ajax.EmployeeDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	int deptId = Integer.parseInt(request.getParameter("id"));
	
	EmployeeDao dao = new EmployeeDao();
	List<Employee> employees = dao.getEmployees(deptId);
	
	Gson gson = new Gson();
	String jsonText = gson.toJson(employees);
	
	out.write(jsonText);
%>