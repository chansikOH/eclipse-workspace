<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 id="heading">자바스크립트 연습</h1>
	<div>
		<button onclick="myfunction();">클릭</button>
	</div>
	
	<script>
		function myfunction() {
			document.getElementById("heading").textContent = "클릭 연습";
		}
	</script>
</body>
</html>