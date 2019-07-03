<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ajax 연습</h1>
	
	<form action="">
		<p>
			아이디<br/>
			<input type="text" id="user-id" name="userid" onkeyup="checkId()">
			<span id="msg-box"></span>
		</p>
		<p>
			비밀번호<br/>
			<input type="text" id="user-pwd" name="userpwd">
		</p>
	</form>
	
	<script type="text/javascript">
		function checkId() {
			var userid = document.getElementById("user-id").value;
			
			var msgbox = document.getElementById("msg-box");
			if(userid.length <= 6) {
				msgbox.textContent = "아이디는 6글자 이상 입력해야 합니다.";
				msgbox.style.color = 'red';
				msgbox.style.fontStyle = 'italic';
				return;
			}
			
			var xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if(xhr.readyState == 4 && xhr.status == 200) {
					var result = xhr.responseText;	// "Yes" or "No"
					if (result == "Yes") {
						msgbox.textContent = "아이디가 이미 사용중입니다."
						msgbox.style.color = 'red';
						msgbox.style.fontStyle = 'italic';
					} else if (result == "No") {
						msgbox.textContent = "사용가능한 아이디 입니다.";
						msgbox.style.color = 'green';
						msgbox.style.fontStyle = 'italic';
					}
				}
			}
			xhr.open("GET", "demo2-resp.jsp?id=" + userid);
			xhr.send();
		}
	</script>
</body>
</html>