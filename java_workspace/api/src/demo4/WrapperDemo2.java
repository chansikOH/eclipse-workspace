package demo4;

public class WrapperDemo2 {

	public static void main(String[] args) {
		
		// 오토박싱
		Integer num1 = 10;		// 컴파일된 실행파일 : Integer num1 = new Integer(10);
		Double num2 = 3.14;		// 컴파일된 실행파일 : Double num2 = new Double(3.14);
		
		Integer num3 = new Integer(100);
		Double num4 = new Double(2.4);
		// 오토언박싱
		int value3 = num3;		// 컴파일된 실행파일 : int value3 = num3.intValue();
		double value4 = num4;	// 컴파일된 실행파일 : double value4 = num4.intValue();
	}
}
