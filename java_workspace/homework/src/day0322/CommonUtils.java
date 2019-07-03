package day0322;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	private static final DecimalFormat CURRENCY_PATTERN_FORMATER = new DecimalFormat("#,###");
	private static final SimpleDateFormat DATE_PATTERN_FORMATER = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static String numberWithComma(int number) {
		return CURRENCY_PATTERN_FORMATER.format(number);
	}
	
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		return DATE_PATTERN_FORMATER.format(date);
	}
}
