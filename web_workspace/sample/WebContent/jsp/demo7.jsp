<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 다루기</title>
</head>
<body>
	<h1>세션객체 다루기</h1>
	
	<%
		String name = (String) session.getAttribute("user-name");
		if(name == null) {
			name = "";
		}
	%>
	<h2>사용자 정보</h2>
	<p><%=name %>님 환영합니다.</p>
	
	<h3>세션의 주요 기능 사용해보기</h3>
	
	<ul>
		<li style="list-style:none">
			<form method="get" action="demo7_1.jsp">
				이름 : <input type="text" name="name"/><br/>
				주소 : <input type="text" name="addr"/><br/>
				<input type="submit"/>
			</form>
		</li>
		<li><a href="demo7_2.jsp">세션값 조회하기</a></li>
		<li>세션값 지우기</li>
		<li style="list-style:none">
			<form method="get" action="demo7_3.jsp">
				<input type="submit" value="이름삭제" name="name"/><br/>
				<input type="submit" value="주소삭제" name="addr"/><br/>
			</form>
		</li>
		<li><a href="demo7_4.jsp">세션 무효화시키기</a></li>
	</ul>

</body>
</html>