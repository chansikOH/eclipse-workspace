package demo5;

import java.text.DecimalFormat;

public class FormaterDemo2 {

	public static void main(String[] args) {
		
//		Decimal Format
//		숫자를 원하는 형식의 문자열로 변환해주는 클래스
//		패턴문자를 사용해서 원하는 문자열 형태를 지정할 수 있다
//			10000000	-> 10,000,000		패턴 : "#,###"
//			10000000	-> 10,000,000		패턴 : "0,000"
		
		String pattern1 = "#,###";
		String pattern2 = "0,000";
		
		DecimalFormat df = new DecimalFormat(pattern2);
		String text = df.format(10000000);
		System.out.println(text);
		
		String pattern3 = "#,###.##";	
		String pattern4 = "0,000.00";
		
		DecimalFormat df2 = new DecimalFormat(pattern4);
		String text2 = df2.format(1234.3001);
		System.out.println(text2);
	}
}
