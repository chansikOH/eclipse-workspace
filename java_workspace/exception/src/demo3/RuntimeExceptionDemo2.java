package demo3;

public class RuntimeExceptionDemo2 {

	public static void main(String[] args) {
		
//		ArrayIndexOutOfBoundsException		: 배열의 인덱스범위를 벗어났을 때 발생
//		StringIndexOutOfBoundsException		: 문자열의 인덱스범위를 벗어났을 때 발생
		
		String[] names = {"김유신", "강감찬", "이순신"};
//		System.out.println(names[3]);	// 배열의 인덱스범위초과
		
		String text = "adc";
		String subText = text.substring(2, 4);
	}
}
