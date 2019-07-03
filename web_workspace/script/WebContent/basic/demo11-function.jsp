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
	<p>자동 실행함수는 브라우저가 HTML문서를 전달받아서 
		화면에 로딩하자마자 실행할 함수를 정의할 때 사용한다.
		* 사용자와 상호작용하는 이벤트 처리용 함수와 버튼을 연결짓기
		* 화면에 표시할 초기 데이터를 서버로부터 받아오는 작업
		* 화면의 요소를 감추거나 보이도록 하는 작업</p>
	
	<script type="text/javascript">
		// 자동실행함수
		(function() {
			console.log("실행된다");
		})();
		
		// 값을 전달받는 자동실행함수
		(function(x, y) {
			console.log("x값", x, "y값", y);
		})(10, 20)
	</script>
</body>
</html>