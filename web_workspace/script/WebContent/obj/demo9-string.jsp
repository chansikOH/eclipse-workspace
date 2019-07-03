<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바스크립트 문자열</h1>
	
	<script type="text/javascript">
		var text = "JavaScript String Reference";
		
		// length	: 문자열의 길이를 반환한다.
		console.log("문자열의 길이", text.length);
		
		// substr(시작위치, 길이) : 시작위치부터 길이만큼 부분문자열을 반환한다.
		// substring(시작위치, 끝위치)	: 시작위치부터 끝위치까지 부분문자열을 반환한다.
		var s1 = text.substr(6, 8);
		var s2 = text.substring(6, 9);
		console.log("첫번째 부분문자열", s1);
		console.log("두번째 부분문자열", s2);
		
		// toLowerCase(), toUpperCase()	: 소문자/대문자로 변환된 문자열을 반환한다.
		var s3 = text.toLowerCase();
		var s4 = text.toUpperCase();
		console.log("원본", text);		// 자바스크립트의 문자열은 불변객체다.
		console.log("소문자로", s3);
		console.log("대문자로", s4);
		
		// startsWith(키워드), endsWith(키워드) : 문자열이 해당 키워드로 시작하거나 
		//							해당 키워드로 끝나는지 여부를 반환한다.
		console.log("Java로 시작되는가?", text.startsWith('Java'));
		
		// split(), split(구분문자)	: 문자열을 공백이나 구분문자로 잘라서 배열에 담아 반환한다.
		console.log("문자열 자르기", text.split(' '));
		
		// trim()	: 불필요한 좌우 공백이 제거된 문자열을 반환한다.
		
		// indexOf(키워드), lastIndexOf(키워드)
		// 문자열에서 지정된 키워드가 처음, 혹은 마지막으로 등장하는 위치를 반환한다.
		console.log("e가 언제 처음 나오나?", text.indexOf('e'));
		
		// replace(키워드, 교체할문자)
		// 키워드에 해당하는 문자를 찾아서 새문자로 바꾼 새로운 문자열을 반환한다.
		var s5 = text.replace('e', 'E');
		console.log('교체된 문자열', s5);
		
		var message = "Mr Blue has a blue house and a blue car";
		
		var s6 = message.replace(/blue/, 'red');
		console.log("교체된 문자열", s6);
		
		// 정규 표현식
		var s7 = message.replace(/blue/g, 'red');		// g:global
		console.log("교체된 문자열", s7);
		var s8 = message.replace(/blue/gi, 'red');		// i: case-insensitive
		console.log("교체된 문자열", s8);
	</script>
</body>
</html>