<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 연산자</h1>
	
	<h2>자바스크립트의 참/거짓</h2>
	
	<h3>참</h3>
	<p>true, 100, -3.14, "안녕", "false"</p>
	
	<h3>거짓</h3>
	<p>false, 0, "", undefined, null, NaN</p>
	
	<script type="text/javascript">
		var v1 = "안녕";
		var v2 = "잘가";
		var v3 = 10;
		var v4 = 20;
		var v5 = 30;
		var v6 = 0;
		
		console.log(v1 && v2);	// "잘가" --> true
		console.log(v3 > v4);
		console.log(v6 && v5);	// 0	  --> false
	</script>
</body>
</html>