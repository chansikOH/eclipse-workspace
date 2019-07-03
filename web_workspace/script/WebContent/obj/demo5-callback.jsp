<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#news-box div {display: none;}
</style>
</head>
<body>
	<h1>자바스크립트 콜백함수</h1>
	
	<div>
		<button onclick="showBox(0);">주요뉴스</button>
		<button onclick="showBox(1);">정치</button>
		<button onclick="showBox(2);">연예</button>
		<button onclick="showBox(3);">스포츠</button>
	</div>
	
	<div id="news-box">
		<div id="box-0" style="display: block;">
			<h3>주요 뉴스</h3>
		</div>
		<div id="box-1">
			<h3>정치 뉴스</h3>
		</div>
		<div id="box-2">
			<h3>연예 뉴스</h3>
		</div>
		<div id="box-3">
			<h3>스포츠 뉴스</h3>
		</div>
	</div>
	
	<script type="text/javascript">
		// 시작값을 1로 설정
		var count = 1;
		
		function displayBoxByNo(no) {
			// 뉴스 div를 전부 조회한다.
			var box0 = document.getElementById("box-0");
			var box1 = document.getElementById("box-1");
			var box2 = document.getElementById("box-2");
			var box3 = document.getElementById("box-3");
			
			// 모든 뉴스 div를 숨긴다.
			box0.style.display = 'none';
			box1.style.display = 'none';
			box2.style.display = 'none';
			box3.style.display = 'none';
			
			// value에 해당하는 뉴스박스만 화면에 표시한다.
			if (no == 0) {
				box0.style.display = "block";
				return;
			}
			if (no == 1) {
				box1.style.display = "block";
				return;
			}
			if (no == 2) {
				box2.style.display = "block";
				return;
			}
			if (no == 3) {
				box3.style.display = "block";
				return;
			}
		}
		
		// 특정 뉴스를 디스플레이 시키는 함수
		function displayBox() {
			// 4로 나눈 나머지 값을 계산한다. (0, 1, 2, 3 중에서 하나만 나온다.)
			var value = count%4;
			// 카운트값을 1증가 시킨다.
			displayBoxByNo(value);
			count++;
			
		}
		
		var timerId = setInterval(displayBox, 3000);
		
		// clearInterval(타이머 아이디);
		// setInterval() 메소드는 타이머 아이디를 반환한다.
		// clearInterval() 메소드는 전달받은 타이머 아이디에 해당하는 타이머를 중지시킨다.
		
		function showBox(no) {
			clearInterval(timerId);
			displayBoxByNo(no);
		}
	</script>
</body>
</html>