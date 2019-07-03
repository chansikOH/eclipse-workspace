<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 연습</title>
<script type="text/javascript" src="../resources/jquery/jquery.min.js"></script>
</head>
<body>
	<h1>jQuery 연습</h1>
	
	<h3>실시간 이슈 검색어</h3>
	<ol>
		<li>류현진 중계</li>
		<li>mbc 스포츠 플러스</li>
		<li>수상한 장모</li>
		<li>스롱 피아비</li>
		<li>양선화</li>
		<li>손정혜</li>
		<li>복면가왕</li>
		<li>한승훈</li>
		<li>소지섭</li>
	</ol>
	
	<script type="text/javascript">
		$('li:contains(mbc)').css("background-color", 'yellow');
		
		$('li').filter(':contains(소지섭)').css('background-color', 'lightgreen');
		
		// filter(콜백함수(index, element) { ... })
		$('li').filter(function(index, el) {
			var keyword = $(el).text();
			if (keyword.includes('류현진')) {
				return true;		// 해당 엘리먼트는 jQuery 집합객체에서 유지된다.
			} else {
				return false;		// 해당 엘리먼트는 jQuery 집합객체에서 제거된다.
			}
		}).css('background-color', 'cyan');
		
		$('li').filter(function() {
			// 함수가 실행될 때마다 this에는 li엘리먼트가 순서대로 전달된다.
			// this는 li엘리먼트다.
			// $(this)는 li엘리먼트 하나가 포함된 jQuery 집합객체다.
			var keyword = $(this).text();
			if(keyword.includes('장모')) {
				return true;
			} else {
				return false;
			}
		}).css('background-color', 'red');
	</script>
</body>
</html>