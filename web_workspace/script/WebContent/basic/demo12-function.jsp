<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#news-box, #ent-box, #sports-box {
		display: none;
	}
</style>
</head>
<body>
	<h1>자바스크립트 함수 연습</h1>
	
	<div>
		<button onmouseenter="showNewsbox();">뉴스</button>
		<button onmouseenter="showEntbox();">연예</button>
		<button onmouseenter="showSportsbox();">스포츠</button>
	</div>
	
	<div>
		 <div id="news-box">
		 	<h3>뉴스 목록</h3>
		 	<ul>
		 		<li>한국당, 5.18 진상규명위원 교체...</li>
		 		<li>한국당, 5.18 진상규명위원 교체...</li>
		 		<li>한국당, 5.18 진상규명위원 교체...</li>
		 	</ul>
		 </div>
		 <div id="ent-box">
		 	<h3>연예 목록</h3>
		 	<ul>
		 		<li>로이킴, 美조지타운대학교 우등 졸업했다.</li>
		 		<li>로이킴, 美조지타운대학교 우등 졸업했다.</li>
		 		<li>로이킴, 美조지타운대학교 우등 졸업했다.</li>
		 	</ul>
		 </div>
		 <div id="sports-box">
		 	<h3>스포츠 목록</h3>
		 	<ul>
		 		<li>류현진, 요즘 최고 투수.. 올스타전 선발기대</li>
		 		<li>류현진, 요즘 최고 투수.. 올스타전 선발기대</li>
		 		<li>류현진, 요즘 최고 투수.. 올스타전 선발기대</li>
		 	</ul>
		 </div>
	</div>
	
	<script type="text/javascript">
		(function() {
			document.getElementById("news-box").style.display = 'block';
		})();
		
		function showNewsbox() {
			document.getElementById("news-box").style.display = 'block';
			document.getElementById("ent-box").style.display = 'none';
			document.getElementById("sports-box").style.display = 'none';
		}
		
		function showEntbox() {
			document.getElementById("news-box").style.display = 'none';
			document.getElementById("ent-box").style.display = 'block';
			document.getElementById("sports-box").style.display = 'none';
		}
		
		function showSportsbox() {
			document.getElementById("news-box").style.display = 'none';
			document.getElementById("ent-box").style.display = 'none';
			document.getElementById("sports-box").style.display = 'block';
		}
	</script>
</body>
</html>