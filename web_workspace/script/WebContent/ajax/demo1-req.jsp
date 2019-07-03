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
	
	<h3>메뉴</h3>
	<div>
		카테고리 : 
		<select id="cat-box" onchange="refreshMenu()">
			<option value="" selected="selected" disabled="disabled"> -- 선택하세요 --</option>
			<option value="k"> 한국음식</option>
			<option value="c"> 중국음식</option>
			<option value="j"> 일본음식</option>
		</select>
	</div>
	
	<div>
		<h3>상세 메뉴</h3>
		<p id="menu-box"></p>
	</div>
	
	<script type="text/javascript">
		function refreshMenu() {
			var nation = document.querySelector("#cat-box").value;
			
			// ajax 코딩
			// 서버에 요청보내고, 응답데이터 받아오기
			
			// 1. XMLHttpRequest 객체 생성
			var xhr = new XMLHttpRequest();
			
			// xhr에 이벤트 핸들러 함수 등록하기
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) { 				// 서버로부터 응답을 받은 경우
					var content = xhr.responseText;		// 서버가 보낸 컨텐츠 조회하기
					document.getElementById("menu-box").textContent = content;	// 화면 갱신
				}
			}
			
			// 2. xhr 객체 초기화(요청방식, 요청url 정의)
			xhr.open("GET", "demo1-resp.jsp?nc=" + nation);
			
			// 3. 서버로 요청 보내기
			xhr.send();
		}
	</script>
</body>
</html>