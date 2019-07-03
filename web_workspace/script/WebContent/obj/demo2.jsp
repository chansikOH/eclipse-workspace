<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		function Contact(name, phone) {
			this.name = name;
			this.phone = phone;
			this.display = function() {
				console.log("이름", this.name);
				console.log("연락처", this.phone);
			}
		}
		
		var c1 = new Contact("홍길동", "010-1111-1111");
		var c2 = new Contact("김유신", "010-2222-2222");
		
		console.log(c1);
		console.log(c2);
		
		c1.display();
		c2.display();
	</script>
</body>
</html>