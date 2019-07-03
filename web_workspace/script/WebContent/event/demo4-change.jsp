<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 이벤트</h1>
	
	<form action="">
		<input type="checkbox" id="tech-all-ck" onchange="allCheckOrRelease();"/>전체
		<input type="checkbox" id="tech-ck-1" name="tech" value="java"/>자바
		<input type="checkbox" id="tech-ck-2" name="tech" value="c"/>C
		<input type="checkbox" id="tech-ck-3" name="tech" value="python"/>파이썬
		<input type="checkbox" id="tech-ck-4" name="tech" value="oracle"/>오라클
		<input type="checkbox" id="tech-ck-5" name="tech" value="big"/>빅데이터
		<input type="checkbox" id="tech-ck-6" name="tech" value="spring"/>스프링
	</form>
	<script type="text/javascript">
		function allCheckOrRelease() {
			// "전체" 체크박스의 현재 체크여부를 조회한다.
			// true/false 값이 획득된다.
			var allCheckboxStatus = document.getElementById("tech-all-ck").checked;
			console.log("전체의 체크여부", allCheckboxStatus);
			
			// name속성이 tech가 모든 엘리먼트를 조회한 후 배열에 담아서 반환한다.
			var checkboxes = document.querySelectorAll("[name=tech]");
			console.log("모든 체크박스", checkboxes);
			
			// checkboxes에 들어있는 체크박스를 순서대로 하나씩 꺼낸다.
			for(var i=0; i<checkboxes.length; i++) {
				var checkbox = checkboxes[i];
				// 각 체크박스의 체크여부를 위에서 조회한 "전체" 체크박스의 체크여부와 
				// 같은 값이 되게 한다.
				checkbox.checked = allCheckboxStatus;
				console.log("각 체크박스", checkbox, checkbox.checked);
			}
		}
	</script>
</body>
</html>