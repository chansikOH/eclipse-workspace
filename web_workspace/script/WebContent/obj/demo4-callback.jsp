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
	<pre>
		콜백함수란?
			- 명시적으로 호출되는 함수가 아니다.
			- 개발자가 함수를 등록해두면 특정 시점, 혹은 특정 이벤트가 발생하면 
			  시스템 혹은 브라우저가 실행시키는 함수다.
			- 다른 함수의 인자로 이용되는 함수다.
	</pre>
	
	<script type="text/javascript">
		function cb() {
			alert("콜백함수가 실행됨");
		}
		
		// setTimeout(콜백함수, 밀리초단위)
		// 지정된 밀리초시간이 지난 후에 콜백함수가 실행된다.
		// setTimeout(cb, 5000);
		
		// setInterval(콜백함수, 밀리초단위)
		// 지정된 밀리초시간이 경과될 때마다 콜백함수가 실행된다.
		// setInterval(cb, 5000);
	</script>
</body>
</html>