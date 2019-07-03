package demo3;

public class RuntimeExceptionDemo1 {

	public static void stringToUpper(String str) {
		System.out.println(str.toUpperCase());
	}
	
	public static void main(String[] args) {
		
		// NullPointerException
		// 객체를 참조하지 않는 참조변수(null값을 가지는 참조변수)로
		// 객체의 속성이나 기능을 사용할 때 발생되는 예외다.
		
		String text = null;
//		System.out.println(text.length());		// NullPointerException 발생
		
		RuntimeExceptionDemo1.stringToUpper(text);
	}

}
