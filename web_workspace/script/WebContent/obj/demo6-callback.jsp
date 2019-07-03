<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 콜백</h1>
	
	<div>
		<button id="btn-1" onclick="fn1();">버튼1</button>
		<button id="btn-2">버튼2</button>
		<button id="btn-3">버튼3</button>
		<button id="btn-4">버튼4</button>
		<button id="btn-5">버튼5</button>
	</div>
	
	<script type="text/javascript">
		var btn1 = document.getElementById("btn-1");
		var btn2 = document.getElementById("btn-2");
		var btn3 = document.getElementById("btn-3");
		var btn4 = document.getElementById("btn-4");
		var btn5 = document.getElementById("btn-5");
	
		// 특정 시점이나 특정 이벤트 발생시 실행될 콜백함수 등록
		// 두번째 버튼에서 click 이벤트가 발생할 때 실행할 함수를 등록한다.
		btn2.onclick = fn2;	
		
		btn3.onclick = function() {
			alert("세번째 버튼이 클릭되었습니다.")
		}
		
		// addEventListener(이벤트명, 콜백함수)를 사용하면 지정된 이벤트에 콜백함수를 등록해준다.
		btn4.addEventListener('click', fn4);
		
		btn5.addEventListener('click', function() {
			alert("다섯번째 버튼이 클릭되었습니다.");
		})
		
		function fn1() {
			alert("첫번째 버튼이 클릭되었습니다.");
		}
		function fn2() {
			alert("두번째 버튼이 클릭되었습니다.");
		}
		function fn4() {
			alert("네번째 버튼이 클릭되었습니다.");	
		}
	</script>
</body>
</html>