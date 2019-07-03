<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="box">
		<h1 id="heading">DOM 연습하기</h1>
		
		<div id="chap-1" class="section">
			<h3 class="section-heading">Document 객체</h3>
			<p id="doc-summary" class="desc">Document객체는 HTML문서를 표현하는 객체다.</p>
			<p class="desc">Document 객체는 트리형태로 HTML문서를 저장한다.</p>
			<p class="desc">Document 객체는 다양한 속성과 메소드를 제공한다.</p>
		</div>
		
		<div id="chap-2" class="section">
			<h3 class="section-heading">Element 객체</h3>
			<p id="el-summary" class="desc">Element객체는 태그를 표현하는 객체다.</p>
			<p class="desc">Element 객체는 태그의 모든 정보를 포함하고 있다.</p>
			<p class="desc">Element 객체는 다양한 속성과 메소드를 제공한다.</p>
		</div>
		
		<div id="chap-3" class="section"></div>
		
		<div>
			이름 : <input type="text" name="username" /><br />
			나이 : <input type="text" name="userage" />
		</div>
	</div>
	
	<script type="text/javascript">
		////////////// HTML문서에서 엘리먼트 찾기
		// id로 찾기
		var el1 = document.getElementById("doc-summary");
		var el2 = document.querySelector("#el-summary");
		
		// 클래스로 찾기
		var elList1 = document.querySelectorAll(".desc");	// 콜렉션(NodeList)이 반환된다.
		
		// 태그 이름으로 찾기
		var elList2 = document.getElementsByTagName("p");	// 콜렉션(NodeList)이 반환된다.
		var elList3 = document.querySelectorAll("p");		// 콜렉션(NodeList)이 반환된다.
		
		// NodeList는 유사배열객체다.
		// 배열처럼 index를 사용해서 하나씩 추출할 수 있다.(for문을 사용해서 반복처리해야 함.)
		// 단, 배열이 제공하는 여러 편리메소드는 사용할 수 없다.
		
		//////////////// 특정 엘리먼트 안에서 엘리먼트 찾기
		var el3 = document.getElementById("chap-2");
		
		// chap-2엘리먼트 안에서 id로 찾기
		var el5 = el3.querySelector("#el-summary");
		// chap-2엘리먼트 안에서 클래스 찾기
		var elList4 = el3.querySelectorAll(".desc");
		// chap-2엘리먼트 안에서 태그로 찾기
		var elList5 = el3.getElementsByTagName("p");
		var elList6 = el3.querySelectorAll("p");
		
		//////////////// 특정 엘리먼트 조작하기
		// 엘리먼트의 텍스트컨텐츠 읽어오기
		var c1 = document.getElementById("doc-summary").textContent;
		console.log("텍스트 컨텐츠", c1);
		var c2 = document.querySelector("#el-summary").textContent;
		console.log("텍스트 컨텐츠", c2);
		
		// 엘리먼트의 텍스트 컨텐츠 변경하기
		document.getElementById("heading").textContent = "문서객체 연습하기";
		document.querySelector("#heading").textContent = "문서객체 연습하기";
		
		// 엘리먼트의 HTML 컨텐츠 읽어오기
		var c3 = document.getElementById("chap-1").innerHTML;
		console.log("html 컨텐츠", c3);
		var c4 = document.querySelector("#chap-1").innerHTML;
		
		// 엘리먼트의 HTML 컨텐츠 변경하기
		document.getElementById("chap-3").innerHTML = "<h3>종합연습</h3><p>종합연습문제입니다.</p>";
		
		document.querySelector("[name=username]").value = "홍길동";
		document.querySelector("[name=userage]").value = 100;
	</script>
</body>
</html>