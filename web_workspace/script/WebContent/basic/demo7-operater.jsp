<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트의 연산자</h1>
	
	<script type="text/javascript">
		// 자바 스크립트 연산자.
		// 사칙연산자	+ - * / %
		// 대입연산자	= += -= *= /= %=
		// 증감연산자	++ --
		// 비교연산자	> >= < <= == === != !==(타입이 다르거나 값이 다르면 true)
		// 논리연산자	&& || !
		
		var v1 = 10;
		var v2 = 3;
		var v3 = "3";
		
		console.log(v1/v2);
		
		console.log(v2 == v3);	// true		== 값이 같으면 true
		console.log(v2 === v3);	// false	=== 타입도 같고, 값도 같으면 true
	</script>
</body>
</html>