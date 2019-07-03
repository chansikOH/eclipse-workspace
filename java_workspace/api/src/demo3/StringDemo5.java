package demo3;

public class StringDemo5 {

	public static void main(String[] args) {
		
		String str = "이것이 자바다";
		System.out.println(str.length());
		
		System.out.println("이것이 자바다".length());
		
		String str2 = "       this is a java           ".trim().toUpperCase().substring(0, 5);
		System.out.println(str2);
	}
}
