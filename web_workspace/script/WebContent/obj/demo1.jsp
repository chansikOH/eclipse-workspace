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
		// 생성자 함수
		function Contact() {
			// 생성자함수의 this에는 new 키워드로 생성한 빈 객체가 전달된다.
			
			// this가 가르키는 빈 객체에 새로운 속성을 추가한다.
			this.name = "홍길동";
			this.phone = "010-1111-1111";
			
			// this가 가르키는 빈 객체에 새로운 기능을 추가한다.
			this.display = function() {
				console.log("이름:", this.name, "연락처:", this.phone);
			}
		}
		
		// 객체 생성
		var c1 = new Contact();
		// var username = c1.name;
		// var userphone = c1.phone;
		
		//
		console.log(c1.name);
		console.log(c1.phone);
		// c1에 저장된 객체의 기능 실행하기
		c1.display();
	</script>
</body>
</html>