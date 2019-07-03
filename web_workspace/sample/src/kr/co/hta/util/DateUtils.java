package kr.co.hta.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	/**
	 * 날짜를 지정된 형식의 문자열로 변환한다.
	 * @param date 날짜
	 * @return "년.월.일 시:분:초" 형식의 문자열
	 */
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		return sdf.format(date);
	}
}
