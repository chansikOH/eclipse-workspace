<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트의 객체</h1>
	
	<pre>
		* 자바스크립트는 객체지향프로그래밍 언어다.
		* 자바스크립트는 클래스없이 객체를 생성한다.
		* 자바스크립트의 객체는 속성과 기능을 가질 수 있다.
		* 자바스크립트의 객체는 기능을 key, value의 형태로 저장한다.
		  (자바스크립트의 객체는 자바의 HashMap과 유사하다.)
		* 생성하기
			var x = {};		// 비어있는 객체 만들기
			var x = {
				name: "홍길동",
				age: 30,
				height: 182.4,
				weight: 76
			};
		* 객체에 구성요소(속성, 기능) 추가하기
			var x = {};
			x["name"] = "홍길동";		// 객체에 name이라는 이름으로 "홍길동" 추가하기
			x.email = "hong@gamil.com";	// 객체에 email이라는 이름으로 "hong@gmail.com" 추가하기
			x.age = 10;
			x["height"] = 182.4;
			x["weight"] = 76;
			
		* 기능을 포함하고 있는 객체 생성하기
			var x = {
				plus: function(a, b) {
					console.log(a + b)
				},
				minus: function(a, b) {
					console.log(a - b);
				}
			}
			
		* 객체에 기능 추가하기
			var x = {}
			x["plus"] = function(a ,b) {
				console.lgo(a + b);
			};
			x.minus = function(a, b) {
				console.log(a - b);
			}
			
		* 객체의 속성과 기능 사용하기
			var x = {
				name: "홍길동";
				age: 10
			}
			console.log(x.name);
			console.log(x["age"]);
			
			var x = {
				plus: function(a, b) {
					console.log(a + b);
				},
				minus: function(a, b) {
					console.log(a - b);
				}
			}
			x.plus(2, 5);
			x.minus(6, 3);
	</pre>
	
	<script type="text/javascript">
		var person = {
			name: "홍길동",
			age: 40,
			height: 183.5,
			weight: 81.2
		};
		
		console.log("이름", person.name);
		console.log("나이", person["age"]);
		console.log("키", person.height);
		console.log("몸무게", person["weight"]);
		
		var calculator = {
			plus: function (a, b) {
				var result = a + b;
				console.log(result);
			},
			minus: function(a, b) {
				var result = a - b;
				console.log(result);
			}
		}
		
		calculator.plus(10, 2);
		calculator.minus(10, 2);
	</script>
</body>
</html>