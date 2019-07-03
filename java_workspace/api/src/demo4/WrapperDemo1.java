package demo4;

public class WrapperDemo1 {

	public static void main(String[] args) {
		Integer num1 = new Integer(30);		// 박싱
		Integer num2 = new Integer("30");	// 박싱
		
		// 정수값 획득 : int intValue()
		int value1 = num1.intValue();		// 언박싱(Unboxing)
		int value2 = num2.intValue();
		System.out.println(value1);
		System.out.println(value2);
		
		Double num3 = new Double(3.14);		//박싱
		Double num4 = new Double("3.14");	//박싱
		
		// 실수값 획득 : double doubleValue()
		double value3 = num3.doubleValue();	//언박싱
		double value4 = num4.doubleValue();
		System.out.println(value3);
		System.out.println(value4);
	}
}
