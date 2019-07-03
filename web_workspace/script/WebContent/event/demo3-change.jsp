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
		이름<br>
		<input type="text" id="user-name" name="username" value="홍길동" onchange="f1()"/><br/>
		성별<br>
		<input type="radio" id="user-gender-male" name="usergender" value="남" checked="checked" onchange="f2()"/>남자
		<input type="radio" id="user-gender-female" name="usergender" value="여" onchange="f2()"//>여자<br/>
		출신지역<br/>
		<select id="user-home" name="userhome" onchange="f3()">
			<option value="S">서울</option>
			<option value="K">경기</option>
			<option value="I">인천</option>
		</select><br/>
		보유기술<br/>
		<input type="checkbox" id="user-tech-1" name="usertech" value="java" onchange="f4()"/> 자바
		<input type="checkbox" id="user-tech-2" name="usertech" value="python" onchange="f4()" > 파이썬<br/>
		결혼여부<br/>
		<input type="radio" id="user-married-yes" name="usermarried" value="Yes" checked="checked" onchange="f5('Y');" /> 기혼
		<input type="radio" id="user-married-no" name="usermarried" value="No" onchange="f5('N');" /> 미혼<br/>
		결혼기념일<br/>
		<input type="text" id="user-wedding-day" name="userweddingday"><br/>
	</form>
	
	<script type="text/javascript">
		function f1() {
			console.log("이름이 변경되었습니다.");
		}
		function f2() {
			console.log("성별이 변경되었습니다.");
		}
		function f3() {
			console.log("출신지역이 변경되었습니다.");
		}
		function f4() {
			console.log("보유기술이 변경되었습니다.");
		}
		function f5(married) {
			if (married == 'Y'){
				document.getElementById("user-wedding-day").removeAttribute("disabled");
			} else {
				document.getElementById("user-wedding-day").setAttribute("disabled", "disabled");
			}
		}
	</script>
</body>
</html>