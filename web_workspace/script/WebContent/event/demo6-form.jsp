<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 연습</h1>
	
	<form method="post" action="login.jsp" onsubmit="checkField(event);">
		아이디<br/>
		<input type="text" id="user-id" name="userid"/><br/>
		비밀번호<br/>
		<input type="password" id="user-pwd" name="userpwd"/><br/>
		<input type="submit" value="로그인"/>
	</form>
	
	<script type="text/javascript">
		function checkField(e) {
			// 특정 태그가 특정 이벤트 발생시 수행되는 기본 동작의 발현을 방해한다.
			// e.preventDefault();
			var userid = document.getElementById("user-id").value;
			var userpwd = document.getElementById("user-pwd").value;
			
			if (userid == ""){
				alert("아이디는 필수입력값입니다.");
				e.preventDefault();
				return;
			}
			if (userpwd == ""){
				alert("비밀번호는 필수입력값입니다.");
				e.preventDefault();
				return;
			}
		}
	</script>
</body>
</html>