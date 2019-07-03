<%@page import="kr.co.hta.hr.vo.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hta.hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리</title>
</head>
<body>
	<h1>직종별 사원목록</h1>
	
	<%
		EmployeeDao empDao = new EmployeeDao();
		ArrayList<Employee> employees = empDao.selectEmployeesByjobId(request.getParameter("jid")); 
	%>
	
	<table border="1" style="width: 100%; border-collapse: collapse;">
		<thead style="background-color: cyan;">
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>연락처</th>
				<th>부서</th>
				<th>입사일</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Employee employee : employees) {
			%>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getFirstName() %> <%=employee.getLastName() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getPhoneNumber() %></td>
				<td><%=employee.getDepartmentId() %></td>
				<td><%=employee.getHireDate() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
	<p><a href="jobs.jsp">뒤로가기</a></p>
</body>
</html>