<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		// 변수 선언하기
		
		// 변수를 초기화하지 않으면 undefined타입이 되고, 값도 undefined값을 가진다.
		var x;
		
		console.log("타입", typeof(x));
		console.log("값", x);
		
		x = 10;
		console.log("타입", typeof(x));
		console.log("값", x);
		
		x = 3.15;
		console.log("타입", typeof(x));
		console.log("값", x);
		
		x = "홍길동"
		console.log("타입", typeof(x));
		console.log("값", x);
	</script>
</body>
</html>