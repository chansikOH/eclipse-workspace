<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 배열의 주요 메소드</h1>
	
	<script type="text/javascript">
		var values = ['사과', '배', '오렌지', '레몬', '딸기'];
		
		// push(값)	: 배열에 새로운 값을 추가한다.
		// pop()	: 배열의 맨 마지막 값을 삭제하고, 그 값을 반환한다.
		// shift()	: 배열의 맨 처음값을 삭제하고, 그 값을 반환한다.
		// splice(인덱스, 개수) : 배열에서 지정된 인덱스부터 개수만큼 삭제한다.
		
		values.push('바나나');
		console.log("새로운 값 추가", values);
		
		var x = values.pop();
		console.log("맨 마지막 값", values, x);
		
		var y = values.shift();
		console.log("맨 처음값 삭제", values, y);
		
		values.splice(2, 2);
		console.log("2번째 것 삭제", values);
		
		var names = ["이순신", "김유신", "강감찬", '홍길동', '류관순'];
		
		// join(), join(구분자)	: 배열의 각 요소를 지정된 구분문자로 이어진 문자열을 만들어서 반환한다.
		//						  구분자를 지정하지 않으면 , 를 구분문자로 사용한다.
		
		var a = names.join();
		console.log("구분자 없을 때", a);
		
		var b = names.join('-');
		console.log("구분자 있을 때", b);
		
		// forEach(콜백함수(값, 인덱스) {})	: 배열의 요소개수만큼 콜백함수를 실행한다.
		//									  실행할 때마다 배열의 값과 인덱스를 순서대로 전달한다.
		names.forEach(function(value, index) {
			console.log('forEach사용', value, index);
		})
		
		var scores = [20, 40, 73, 93, 17, 28, 88];
		
		var total = 0;
		scores.forEach(function(score, index) {
			total += score;
		});
		console.log("합계", total);
		
		// filter(콜백함수(값, 인덱스) {})	: 배열의 요소 개수만큼 콜백함수가 실행된다.
		//						콜백함수가 ture를 반환하는 경우의 값만 모은 새로운 배열을 반환한다.
		var scores2 = scores.filter(function(score, index) {
			return score > 50;
		});
		console.log("새 배열", scores2);
		
		var numbers = [1, 2, 3, 4, 5];
		
		// map(콜백함수(값, 인덱스) {})	: 배열의 요소 개수만큼 콜백함수가 실행된다.
		// 배열의 모든 요소에 대해서 콜백함수를 실행해서 그 반환값을 모은 새로운 배열을 반환한다.
		// 배열의 각 요소의 값을 가공한 새로운 배열을 만들 때 사용한다.
		
		var numbers2 = numbers.map(function(value, index) {
			return value * value;
		});
		console.log("새 배열", numbers2);
		
		var numbers3 = numbers.filter(function(value, index) {
			return value >= 3;
		}).map(function(value, index) {
			return value*value;
		});
		console.log("새 배열", numbers3);
		
		var customers = [{name:"홍길동", phone:"010-1111-2222", age:49}, 
						 {name:"이순신", phone:"010-1231-4343", age:30},
						 {name:"강감찬", phone:"010-2151-6322", age:25}];
		
		var customersNames = customers.map(function(cust, index) {
			return cust.name;
		});
		console.log("고객이름 새 배열", customersNames);
		
		// find(콜백함수(값, 인덱스) {});	: 배열의 요소 개수만큼 콜백함수가 실행된다.
		// 			콜백함수가 true를 반환하는 첫번째 값을 제공한다.
		
		var cust = customers.find(function(cust, index) {
			return cust.name == "강감찬"
		});
		console.log("검색결과", cust);
		
		// sort(), sort(콜백(값1, 값2){}) : 배열의 요소를 정렬한다.
		// 		콜백함수를 정의하면 콜백함수가 반환하는 값을 기준으로 정렬된다.
		
		var points = [100, 200, 150, 120, 410, 270, 180, 300];
		
		points.sort();
		console.log("정렬결과", points);
		
		// reverse() : 배열의 순서를 역순으로 바꾼다.
		points.sort().reverse();
		console.log("뒤집기 후", points);
		
		var students = [{name:"홍길동", score:80},
						{name:"김유신", score:60},
						{name:"강감찬", score:60},
						{name:"이순신", score:55}];
		students.sort(function(st1, st2) {
			// 두 값에서 특정값의 비교결과를 기준으로 정렬한다.
			// 결과가 양수면 첫번째 값이 크다.
			// 결과가 음수면 두번째 값이 크다.
			// 결과가 0이면 두 값이 동일하다.
			var result = st1.score - st2.score;
			if (result == 0) {
				// 점수가 동일한 경우 다른 기준으로 정렬
				return st1.name.localeCompare(st2.name);
			} else {
				return result;
			}
		});
		console.log("점수기준 정렬 후", students);
	</script>
</body>
</html>