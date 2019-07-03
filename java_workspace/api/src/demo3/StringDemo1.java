package demo3;

public class StringDemo1 {

	public static void main(String[] args) {
		String str1 = "hallo world";
		// String str1 = new String("hello world");
		
		// String toUpperCase() : 소문자를 대문자로 변환해서 반환한다.
		// String toLowerCase() : 대문자를 소문자로 변환해서 반환한다.
		String result1 = str1.toUpperCase();
		System.out.println("원본1 : " + str1);
		System.out.println("결과1 : " + result1);
		
		String result2 = result1.toLowerCase();
		System.out.println("결과2 : " + result2);
		
		// String replace(String target, String new) : target에 지정된 문자를 새문자로 바꾼 새로운 문자열을 만들어서 반환한다.
		String str2 = "이것이 자바(이)다. 자바 초급자를 위한 안내서";
		String result3 = str2.replace("자바", "파이썬");
		System.out.println("원본2 : "+ str2);
		System.out.println("결과3 : "+ result3);
		
		// int length() : 문자열의 길이를 반환한다.
		String str3 = "오늘 점심은 어떤거 먹지?";
		int len = str3.length();
		System.out.println("문자열의 길이 : " + len);
		
		// boolean equals(Object other) : 다른 문자열과 내용을 비교해서 동일한지 여부를 반환한다.
		//									Object의 equals(Oject other)을 재정의한 것
		String name1 = new String("이순신");
		String name2 = new String("이순신");
		String name3 = "이순신";
		String name4 = "이순신";
		/*
		 * 1. ==		주소값 비교
		 * 2. equals()	내용 비교
		 * 
		 * equals() 메소드는 String객체를 생성하는 방법에 상관없이 문자열의 내용이 동일하면
		 * true값을 반환한다. 따라서 문자열의 비교는 반드시 equals() 메소드를 사용해야 한다.
		 */
		System.out.println(name1 == name2);			// false
		System.out.println(name1.equals(name2));	// true
		
		System.out.println(name3 == name4);			// true
		System.out.println(name3.equals(name4));	// true
		
		// String substring(int beginIndex)	: 시작위치에서 끝까지 잘라낸 새로운 문자열을 반환한다.
		// String substring(int beginIndex, int endIndex) : beginIndex에서 endIndex 앞까지 잘라낸 새로운 문자열을 반환한다.
		
		String str4 ="이것이 자바다";
		String result5 = str4.substring(1);
		System.out.println("결과5 : " + result5);
		
		String result6 = str4.substring(2, 6);
		System.out.println("결과6 : " + result6);
		
		// boolean contains(String str) : 지정된 문자열이 포함되어 있는지 여부를 반환한다.
		String str5 = "이것이 자바다";
		boolean result7 = str5.contains("자바");
		System.out.println("결과7 : " + result7);
		
		// boolean startsWith(String str) : 지정된 문자열로 시작하는지 여부를 반환한다.
		// boolean endsWith(String str) : 지정된 문자열로 끝나는지 여부를 반환한다.
		String str6 = "http://www.daum.net";
		String str7 = "www.google.com";
		String str8 = "www.naver.com";
		System.out.println("결과8 : " + str6.startsWith("http"));
		System.out.println("결과9 : " + str7.startsWith("http"));
		System.out.println("결과10 : " + str8.startsWith("http"));
		System.out.println("결과11 : " + str6.endsWith("com"));
		System.out.println("결과12 : " + str7.endsWith("com"));
		System.out.println("결과13 : " + str8.endsWith("com"));
		
		// boolean isEmpty() : 문자열이 비어있으면 true를 반환한다.
		String str9 = "자바다";
		String str10 = "    ";
		String str11 = "";
		System.out.println("결과14 : " + str9.isEmpty());
		System.out.println("결과15 : " + str10.isEmpty());
		System.out.println("결과16 : " + str11.isEmpty());
		
		// String trim() : 문자열의 불필요한 좌우공백을 제거한 새로운 문자열을 반환한다.
		String str12 = "    이것이      자바다        ";
		String result8 = str12.trim();
		System.out.println("결과17 : ["+result8+"]");
		
		// int indexOf(String str) : 지정된 문자열이 처음으로 등장하는 위치를 반환한다.
		String str13 = "이것이 자바다. 자바 입무용 추천 도서";
		int result9 = str13.indexOf("자바");
		int result10 = str13.indexOf("파이썬");
		System.out.println("결과18 : " + result9);
		System.out.println("결과19 : " + result10);
		
		// char charAt(int index) : 지정된 위치의 글자를 반환한다.
		String str14 = "이것이 자바다";
		char result11 = str14.charAt(1);
		System.out.println("결과20 : " + result11);
		
		// String[] split(String str) : 지정된 문자로 문자열을 자르고 배열에 담아서 반환한다.
		String str15 = "이순신,김유신,강감찬,홍길동,유관순";
		String[] result12 = str15.split(",");
		System.out.println("결과21 : " + result12[0]);
		System.out.println("결과21 : " + result12[1]);
		System.out.println("결과21 : " + result12[2]);
		System.out.println("결과21 : " + result12[3]);
		System.out.println("결과21 : " + result12[4]);
		
		// static String valueOf(int number)
		// static String valueOf(double number)
		// static String valueOf(boolean b)
		// 문자열로 변환해서 반환한다.
		String result13 = String.valueOf(3.14);
		System.out.println("결과22 : " + result13);
	}
}
