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
		<input type="text" id="num-1"/> <input type="text" id="num-2"/>
		<button id="btn-1">+</button> 
		<button id="btn-2">-</button>
		<p>결과 : <input type="text" id="result" readonly/></p>
	</div>
	
	<script type="text/javascript">
		function process(cb) {
			// parseInt(문자) 문자를 정수로 변환한다.
			// parseDouble(문자) 문자를 실수로 변환한다.
			var num1 = parseInt(document.getElementById("num-1").value);
			var num2 = parseInt(document.getElementById("num-2").value);
			
			cb(num1, num2);	// 콜백함수 실행
		}
		
		// btn-1에서 클릭이벤트가 발생하면 process(함수)를 실행하는 함수를 등록한다.
		document.getElementById('btn-1').onclick = function() {
			process(function(x, y) {
				var result = x + y;
				document.getElementById("result").setAttribute("value", result);
			});
		}
		
		document.getElementById('btn-2').onclick = function() {
			process(function(x, y) {
				var result = x - y;
				document.getElementById("result").setAttribute("value", result);
			});
		}
	</script>
</body>
</html>