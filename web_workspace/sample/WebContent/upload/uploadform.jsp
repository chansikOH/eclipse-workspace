<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 폼</title>
</head>
<body>
	<h1>파일 업로드하기</h1>
	
	<!-- 
		enctype 속성
			- 폼에 입력된 값을 서버로 전달할 때 어떤 형식으로 값들을 변환해서 전달할 것인지를 지정하는 속성이다.
			- 지정하지 않으면 "application/x-www-form-urlencoded"가 기본값으로 설정된다.
			- enctype="application/x-www-form-urlencoded"은 폼의 입력값을 URL의 쿼리스트링과 같은 형태로 
				만들어서 서버로 전송한다.
			* username=홍길동&userid=hong&userpwd=zxcv1234&useremail=hong@gmail.com 
			- enctype="application/x-www-form-urlencoded"은 첨부파일을 서버로 전송할 수 없다.
			
			- 첨부파일이 업로드되는 경우에는 enctype="multipart/form-data"로 반드시 설정해야한다.
			- boundary에 지정되어 있는 문자열(브라우저가 자동으로 생성함)을 이용해서 폼의 입력값이나 
				파일 데이터를 구분지어서 서버로 전송한다.
			- 이런 형식으로 전달되는 요청을 "멀티파트요청"이라고 한다.
			* 멀티파트요청은 첨부파일이 서버로 업로드되는 요청을 말한다.
			* 멀티파트요청을 JSP나 서블릿에서 처리하기 위해서는 별도의 외부 라이브러리나 서블릿3.0 이상에서 
				지원하는 API가 필요하다.
			* cos.jar나 commons-fileupload library 등이 필요하다.
	 -->
	<form method="post" action="upload.jsp" enctype="multipart/form-data">
		<p>이름 <input type="text" name="username" /></p>
		<p>아이디 <input type="text" name="userid" /></p>
		<p>비밀번호 <input type="text" name="userpwd" /></p>
		<p>이메일 <input type="text" name="useremail" /></p>
		<p>사진 <input type="file" name="userphoto" /></p>
		<p><input type="submit" /></p>
	</form>

</body>
</html>