<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사용자 정보</h1>

	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>프로필사진</th>
			</tr>
		</thead>
		<tbody>
			<%-- 
			<tr>
				<td><%=user.getId() %></td>
				<td><%=user.getName() %></td>
				<td><img src="../images/<%=user.getProfile() %>" width="200" height="200" /></td>
			</tr> 
			--%>
			<tr>
				<td>hong</td>
				<td>홍길동</td>
				<td><img src="../images/Chrysanthemum.jpg" width="200" height="200" /></td>
			</tr>
		</tbody>
	</table>
</body>
</html>