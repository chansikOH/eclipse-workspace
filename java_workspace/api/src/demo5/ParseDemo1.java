package demo5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDemo1 {

	public static void main(String[] args) throws ParseException {
		
//		오늘
		Date now = new Date();
		
		String text = "1990.12.16";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
//		결혼한 날
		Date weddingDay = sdf.parse(text);
		
		long nowTime = now.getTime();
		long weddingDayTime = weddingDay.getTime();
		System.out.println("오늘 : " + nowTime);
		System.out.println("결혼한 날 : " + weddingDayTime);
		
		long date = (nowTime - weddingDayTime)/(60*60*24*1000);
		System.out.println("경과일 : " + date);
	}
}
