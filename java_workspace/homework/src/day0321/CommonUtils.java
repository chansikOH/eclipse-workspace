package day0321;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

	private static final DecimalFormat CURRENCY_PATTERN_FORMATER = new DecimalFormat("#,###");
	
	public static String numberWithComma(int number) {
		return CURRENCY_PATTERN_FORMATER.format(number);
	}
}
