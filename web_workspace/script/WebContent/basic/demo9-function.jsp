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
	
	<p>자바스크립트 함수는 특정 작업을 수행하는 코드 블록이다.</p>
	
	<h2>형식</h2>
	<pre>
		function 함수명(매개변수1, 매개변수2, ...) {
			수행문;
			수행문;
		}
		
		function 함수명(매개변수1, 매개변수2, ...) {
			수행문;
			수행문;
		
			return 반환값;
		}
	</pre>
	
	<h2>실행하기</h2>
	<p>
		1. 코드에서 함수를 호출하기<br/>
		2. 사용자와 상호작용시 함수 호출하기 (버튼 클릭시, 마우스 오버시)<br/>
		3. 자동실행(self invoke)
	</p>
	
	<script type="text/javascript">
		function fn1() {
			var name = "홍길동";
			console.log(name + "님, 안녕하살법");
		}
		
		function fn2(name) {
			console.log(name + "님, 안녕하살법");
		}
		
		function fn3(name) {
			var message = name + "님, 안녕하살법";
			return message;
		}
		
		// 함수 실행하기
		fn1();					// 매개변수가 없는 함수 실행
		fn2("김유신");			// 매개변수가 있는 함수 실행
		fn2("강감찬");
		var x = fn3("이순신");	// 반환값이 있는 함수 실행하고, 반환값 담기
		var y = fn3("유관순");
	</script>
</body>
</html>