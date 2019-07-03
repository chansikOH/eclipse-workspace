package demo3;

public class StringUtils {

	public static int stringToInt(String text) {
		int value;
		try {
			value = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			value = 0;
		}
		return value;
	}
}
