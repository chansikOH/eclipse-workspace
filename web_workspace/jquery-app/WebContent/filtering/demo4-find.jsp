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
	
	<div id="keyword-box">
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
	</div>
	
	<div id="movie-box">
		<h3>영화</h3>
		<ul>
			<li>알라딘</li>
			<li>기생충</li>
			<li>맨인블랙</li>
			<li>엑스맨</li>
			<li>이웃집 토토로</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		$('#movie-box li').css('color', 'red');
		
		// #movie-box의 자손중에서 li를 찾는다.
		$('#movie-box').find('li').css('background-color', 'lightgreen');
	</script>
</body>
</html>