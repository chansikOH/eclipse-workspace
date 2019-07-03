<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#thumbnail-box img {opacity: 0.5;}
	#thumbnail-box img:hover {opacity: 1;}
</style>
</head>
<body>
	<h1>자바스크립트 함수</h1>
	
	<div id="image-box">
		<img alt="" src="../images/1.jpg" style="width: 400px;" id="big-img-box">
	</div>
	
	<div id="thumbnail-box">
		<img alt="" src="../images/1.jpg" style="width: 120px" onmouseenter="showImage('1.jpg');">
		<img alt="" src="../images/2.png" style="width: 120px" onmouseenter="showImage('2.png');">
		<img alt="" src="../images/3.jpg" style="width: 120px" onmouseenter="showImage('3.jpg');">
		<img alt="" src="../images/4.jpg" style="width: 120px" onmouseenter="showImage('4.jpg');">
		<img alt="" src="../images/5.jpg" style="width: 120px" onmouseenter="showImage('5.jpg');">
		<img alt="" src="../images/6.jpg" style="width: 120px" onmouseenter="showImage('6.jpg');">
	</div>
	
	<script type="text/javascript">
		function showImage(imageName) {
			document.getElementById("big-img-box").setAttribute("src", "../images/"+ imageName);
		}
	</script>
</body>
</html>