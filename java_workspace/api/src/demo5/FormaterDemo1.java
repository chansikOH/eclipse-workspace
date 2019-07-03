package demo5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormaterDemo1 {

	public static void main(String[] args) {
		
		Date today = new Date();
		
		System.out.println(today);
		
		String pattern1 = "yyyy";
		String pattern2 = "yyyy-MM-dd";
		String pattern3 = "yyyy.MM.dd HH:mm:ss";
		String pattern4 = "yyyy년 M월 d일 EEEE a h시 m분 s초";
		
//		SimpleDateFormat
//		Date객체가 가지고 있는 날짜/시간정보를 원하는 형식의 문자열로 변환해주는 클래스
//		패턴문자를 사용해서 원하는 문자열 형태를 지정할 수 있다.
//			Date -> "2019"						패턴 : "yyyy"
//			Date -> "19"						패턴 : "yy"
//			Date -> "2019/03/19"				패턴 : "yyyy/MM/dd"			
//			Date -> "16:37:12"					패턴 : "HH:mm:ss"			
//			Date -> "2019년 3월 19일 화요일"	패턴 : "yyyy년 M월 d일 EEEE"			
//			Date -> "오후 4시 37분 12초"		패턴 : "a h시 m분 s초"
//		String format(Date date) : 전달받은 Date를 지정된 패턴 형식의 문자열로 변환해서 반환
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern4);
		String text1 = sdf.format(today);
		System.out.println(text1);
	}
}
