package demo4;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		
		// 컴퓨터 현재 날자 및 시간정보를 갖고 있는 Date객체가 생성된다.
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.toString());	// Date의 toString()은 날짜와 시간정보를 문자열로
											// 제공하도록 재정의되어 있다.
		
		long value = now.getTime();			// System.currentTimeInMillis()와 동일한 값을 제공한다.
		System.out.println(value);
		
		now.setTime(1000000000000L);
		System.out.println(now);
	}
}
