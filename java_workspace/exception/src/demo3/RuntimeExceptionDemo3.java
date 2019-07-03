package demo3;

public class RuntimeExceptionDemo3 {

	public static void main(String[] args) {
		
//		NumberFormatException : 문자열을 숫자로 바꿀 때 숫자로 변환할 수 없는 문자열이 포함되어 있으면 발생
//		int		Integer.parseInt(String numberText)
//		double	Double.parseDouble(String numberText)
		
		String text1 = "1234";
		int number1 = Integer.parseInt(text1);
		System.out.println(number1 * 3);
		
		String text2 = "1234a";
		String text3 = " 1234";
		String text4 = "";
		
		
		int number2 = Integer.parseInt(text4);
		System.out.println(number2 * 3);
	}

}
