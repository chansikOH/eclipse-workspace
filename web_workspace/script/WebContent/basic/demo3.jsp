<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 연습</h1>
	
	<h3>자바스크립트의 값 표현하기</h3>
	<div>
		<button onclick="display1();">경고창으로 표시</button>
		<button onclick="display2();">태그사이에 표시</button>
		<button onclick="display3();">브라우저 콘솔창에 표시</button>
	</div>
	
	<div id="box">값이 표시될 곳</div>
	
	<script>
		function display1() {
			alert("경고창으로 값을 표시할 때 사용한다.");
		}
		function display2() {
			document.getElementById("box").textContent = "태그 사이에 값을 표시한다.";
		}
		function display3() {
			console.log("브라우저 콘솔창에 값을 표시한다.");
		}
	</script>
</body>
</html>