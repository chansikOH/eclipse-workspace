package demo1;
/**
 * 덧셈, 뺄셈기능이 구현된 클래스입니다.
 * @author JHTA
 *
 */
public class Calculator {
	
	/**
	 * 두 수를 전달받아서 더한 값을 반환합니다.
	 * @param x 숫자
	 * @param y 숫자
	 * @return 덧셈결과가 반환됨
	 */
	public int plus(int x, int y) {
		int z = x + y;
		return z;
	}
	/**
	 * 두 수를 전달받아서 뺀 값을 반환합니다.
	 * @param x 숫자
	 * @param y 숫자
	 * @return 뺄셈결과가 반환됨
	 */
	public int minus(int x, int y) {
		int z = x - y;
		return z;
	}
}
