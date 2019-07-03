<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 함수</h1>
	
	<h2>형식</h2>
	<pre>
		var 변수 = function(매개변수1, 매개변수2, ...) {
			수행문;
			수행문;
		}
		
		var 변수 = function(매개변수1, 매개변수2, ...) {
			수행문;
			수행문;
			
			return 반환값;
		}
	</pre>
	
	<script type="text/javascript">
		var plus = function(a, b) {
			var result = a + b;
			console.log(result);
		}
		
		var minus = function(a, b) {
			var result = a - b;
			console.log(result);
		}
		
		// 실행하기
		plus(1000, 2030);
		plus(3983, 4642);
		
		minus(428569, 2331);
		minus(426672, 78710);
	</script>
</body>
</html>