<%@page import="kr.co.hta.hr.vo.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hta.hr.dao.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 조회</title>
</head>
<body>
	<h1>전체 사원 목록</h1>
	
	<%
		EmployeeDao empDao = new EmployeeDao();
		ArrayList<Employee> employees = empDao.selectAllEmployees();
	%>
	<table border="1" style="width: 100%; border-collapse: collapse;">
		<thead style="background-color: yellow;">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>입사일</th>
				<th>직종</th>
				<th>급여</th>
				<th>커미션</th>
				<th>관리자</th>
				<th>부서</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Employee employee : employees) {
			%>
			<tr>
				<td><%=employee.getId() %></td>
				<td><%=employee.getFirstName()%> <%=employee.getLastName() %></td>
				<td><%=employee.getEmail() %></td>
				<td><%=employee.getPhoneNumber() %></td>
				<td><%=employee.getHireDate() %></td>
				<td><%=employee.getJobId() %></td>
				<td><%=employee.getSalary() %></td>
				<td><%=employee.getCommissionPct() %></td>
				<td><%=employee.getManagerId() %></td>
				<td><%=employee.getDepartmentId() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<p><a href="home.jsp">홈</a></p>
</body>
</html>