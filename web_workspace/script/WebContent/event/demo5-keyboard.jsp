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
		아이디<br/>
		<input type="text" id="user-id" name="userid" onkeyup="checkId();"><br/>
		<small>9글자 이상 12글자 이하로 입력하세요</small><br/>
		<p id="msg-id"></p>
		
		비밀번호<br/>
		<input type="password" id="user-pwd" name="userpwd" onkeyup="checkPwd();"><br/>
		<small>9글자 이상 입력하세요.</small><br/>
		<p id="msg-pwd"></p>
		
		자기소개<br/>
		<textarea rows="10" cols="80" id="user-profile" name="userprofile" onkeyup="checkProfile();"></textarea><br/>
		<small>100글자 이내로 작성하세요.</small>
		<p id="msg-profile"></p>
	</form>
	
	<script type="text/javascript">
		function checkId() {
			// 아이디가 uesr-id인 입력필드의 입력값을 조회한다.
			var userid = document.getElementById("user-id").value;
			if(userid.length < 9) {
				document.getElementById("msg-id").style.color = "red";
				document.getElementById("msg-id").textContent = "길이가 짧습니다.";
				return;
			} 
			if(userid.length > 12) {
				document.getElementById("msg-id").style.color = "red";
				document.getElementById("msg-id").textContent = "길이가 너무 깁니다.";
				return;
			} 
			document.getElementById("msg-id").style.color = "green";
			document.getElementById("msg-id").textContent = "길이가 적절합니다.";
		}
		function checkPwd() {
			var userpwd = document.getElementById("user-pwd").value;
			if(userpwd.length < 9) {
				document.getElementById("msg-pwd").style.color = "red";
				document.getElementById("msg-pwd").textContent = "길이가 짧습니다.";
				return;
			}
			document.getElementById("msg-pwd").style.color = "green";
			document.getElementById("msg-pwd").textContent = "길이가 적절합니다.";
		}
		function checkProfile() {
			var userprofile = document.getElementById("user-profile").value;
			if(userprofile > 100) {
				document.getElementById("msg-profile").style.color = "red";
				document.getElementById("msg-profile").textContent = "길이가 너무 깁니다.";
				return;
			}
			document.getElementById("msg-profile").style.color = "green";
			document.getElementById("msg-profile").textContent = "길이가 적절합니다.";
		}
	</script>
</body>
</html>