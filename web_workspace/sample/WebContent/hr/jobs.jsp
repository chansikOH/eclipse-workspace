<%@page import="kr.co.hta.hr.vo.Job"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.hta.hr.dao.JobDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직종조회</title>
</head>
<body>
	<h1>전체 직종 조회</h1>
	
	<%
		JobDao jobDao = new JobDao();
		ArrayList<Job> jobs = jobDao.selectAllJobs();
	%>
		
	<table border="1" style="width: 100%; border-collapse: collapse;">
		<thead style="background-color: yellow;">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>최소 급여</th>
				<th>최대 급여</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Job job : jobs) {
			%>
			<tr>
				<td><%=job.getId() %></td>
				<td><a href="searchJobs.jsp?jid=<%=job.getId() %>"><%=job.getTitle() %></a></td>
				<td><%=job.getMinSalary() %></td>
				<td><%=job.getMaxSalary() %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
	<p><a href="home.jsp">홈</a></p>
</body>
</html>