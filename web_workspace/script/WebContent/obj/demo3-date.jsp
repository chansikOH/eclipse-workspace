<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 내장객체 사용하기</h1>
	
	<p>Date 객체 사용하기</p>
	
	<div>
		<p>연 : <span id="s-1"></span></p>
		<p>월 : <span id="s-2"></span></p>
		<p>일 : <span id="s-3"></span></p>
		<p>시 : <span id="s-4"></span></p>
		<p>분 : <span id="s-5"></span></p>
		<p>초 : <span id="s-6"></span></p>
	</div>
	
	<div>
		검색기간 : <input type="date" id="start-date" /> ~ <input type="date" id="end-date" />
		<button>조회</button>
	</div>
	
	<script type="text/javascript">
		var x = new Date();
		
		var year = x.getFullYear();
		var month = x.getMonth() + 1;
		var date = x.getDate();
		var hours = x.getHours();
		var minutes = x.getMinutes();
		var seconds = x.getSeconds();
		
		document.getElementById("s-1").textContent = year;
		document.getElementById("s-2").textContent = month;
		document.getElementById("s-3").textContent = date;
		document.getElementById("s-4").textContent = hours;
		document.getElementById("s-5").textContent = minutes;
		document.getElementById("s-6").textContent = seconds;
		
		function getToday() {
			// 현재 시간정보를 가진 Date 객체 생성
			var now = new Date();
			
			// 년, 월, 일을 조회
			var year = now.getFullYear();
			var month = now.getMonth() + 1;
			var date = now.getDate();
			
			// 년, 월, 일을 "년-월-일" 형식의 텍스트로 만든다.
			var text = year + "-" + (month >= 10 ? month : "0"+month) + "-" + (date >= 10 ? date : "0" + date); 
			
			// 텍스트 반환
			return text;
		}
		
		function getOneWeekBefore() {
			// 현재 시간을 가진 Date객체 생성
			var now = new Date();
			// 일주일전 시간정보를 담을 Date객체 생성
			var oneWeekBefore = new Date();
			// 현재시간에서 7일 뺀 시간정보를 설정한다.
			oneWeekBefore.setDate(now.getDate() - 7);
			
			var year = oneWeekBefore.getFullYear();
			var month = oneWeekBefore.getMonth() + 1;
			var date = oneWeekBefore.getDate();
			
			var text = year + "-" + (month >= 10 ? month : "0"+month) + "-" + (date >= 10 ? date : "0" + date);
			
			return text;
		}
		
		// 검색 시작일과 종료일을 설정한다.
		document.getElementById("end-date").value = getToday();
		document.getElementById("start-date").value = getOneWeekBefore();
	</script>
</body>
</html>