<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div	{margin: 20px; padding: 20px; border: 1px solid black;}
</style>
</head>
<body>
	<h1>자바스크립트 이벤트</h1>
	
	<div>
		<button onclick="f1()">버튼1</button>
		<button onclick="f2()">버튼2</button>
	</div>
	
	<div>
		<span onclick="f3()">span1</span>
		<span onclick="f4()">span2</span>
	</div>
	
	<script type="text/javascript">
		// 이벤트 핸들러 함수 정의하기
		function f1() {
			alert("첫번째 버튼이 클릭되었습니다.");
		}
		function f2() {
			alert("두번째 버튼이 클릭되었습니다.");
		}
		function f3() {
			alert("첫번째 span이 클릭되었습니다.");
		}
		function f4() {
			alert("두번째 span이 클릭되었습니다.");
		}
	</script>
</body>
</html>