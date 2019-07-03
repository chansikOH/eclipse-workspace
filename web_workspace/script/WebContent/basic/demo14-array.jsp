<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 배열</h1>
	
	<p>
		* 자바스크립트의 배열의 가변길이 배열이다.
			(자바의 ArrayList와 유사하다.)
		* 배열의 요소는 인덱스로 조작할 수 있다.
		* 배열의 생성
			var x = [];				// 길이가 0인 배열이 생성된다.
			var x = [10, 74, 62];	// 요소를 3개 가진 배열이 생성된다.
		* 배열의 값 조회
			var x = [10, 74, 62];
			console.log(x[0]);
	</p>
	
	<script type="text/javascript">
		// 크기가 0인 배열을 생성하고, 순서대로 값을 저장하기
		var names = [];
		names[0] = "홍길동";
		names[1] = "김유신";
		names[2] = "강감찬";
		names[3] = "이순신";
		
		// 값을 포함하고 있는 배열을 생성하기
		var movies = ["어벤져스", "포켓몬", "명탐정 코난", "걸캅스"];
		
		for (var i=0; i<names.length; i++){
			console.log(names[i]);
		}
	</script>
</body>
</html>