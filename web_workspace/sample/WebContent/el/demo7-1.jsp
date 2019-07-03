<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 사용하기</h1>

	<ul>
		<li><a href="demo7-2.jsp?no=23&pno=1&cat=ent">기사1</a></li>
		<li><a href="demo7-2.jsp?no=46&pno=2&cat=news">기사2</a></li>
		<li><a href="demo7-2.jsp?no=41&pno=3&cat=sports">기사3</a></li>
		<li><a href="demo7-2.jsp?no=54&pno=4&cat=eco">기사4</a></li>
	</ul>
	
	<form method="post" action="demo7-2.jsp">
		<p>번호 : <input type="text" name="no" /></p>
		<p>페이지 : <input type="text" name="pno" /></p>
		<p>카테고리 : <input type="text" name="cat" /></p>
		<p><input type="submit" /></p>
	</form>
</body>
</html>