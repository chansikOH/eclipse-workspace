<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 구성요소</title>
</head>
<body>
	<h1>JSP 구성요소 살펴보기</h1>
	
	<h2>스크립트릿</h2>
	<%
		int x = 100;
		// 변수로 만들어질 것이어서 접근제한자를 붙일 수 없다.
		// private int x = 100;
	%>
	<p>스크립트릿의 변수값 : <%=x %></p>
	
	<h2>선언식</h2>
	<%!
		// 필드로 만들어질 것이어서 접근제한자를 붙일 수 있다.
		private int y = 200;
	
		public String myName() {
			return "홍길동";
		}
	%>
	<p>선언식의 변수값 : <%=y %></p>
	<p>선언식의 메소드 실행결과 : <%=myName() %></p>
	<%--
		위의 표현식은 아래와 같이 변경된다.
		out.print(myName());
		
		표현식에서 메소드 호출시 ;을 붙이면 에러가 발생한다.
		<p>선언식의 메소드 실행결과 : <%=myName(); %></p>
		out.print(myName(););
	--%>

	
	<p>
		<a href="../home.jsp">홈</a>
	</p>
</body>
</html>