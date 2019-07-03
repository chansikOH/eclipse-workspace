package demo5;

import java.text.MessageFormat;

public class FormaterDemo3 {

	public static void main(String[] args) {
		String[] data = {"홍길동", "서울대학교", "전자공학과"};
		
		String text = "이름: " + data[0] + ", 학교: " + data[1] + ", 학과: " + data[2];
		System.out.println(text);
		
		String message = "이름: {0}, 학교: {1}, 학과: {2}";
		String result = MessageFormat.format(message, data);
		System.out.println(result);
		
		String message2 = "이름:{0}, 국어:{1}, 영어:{2}, 수학:{3}";
		String result2 = MessageFormat.format(message2, "홍길동", 100, 70, 60);
		System.out.println(result2);
	}
}
