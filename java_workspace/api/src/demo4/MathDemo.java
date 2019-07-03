package demo4;

public class MathDemo {

	public static void main(String[] args) {
		
		double result1 = Math.ceil(3.1);
		double result2 = Math.ceil(4.0);
		double result3 = Math.ceil(3.9);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		double result4 = Math.floor(3.1);
		double result5 = Math.floor(3.0);
		double result6 = Math.floor(3.9);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
		
		double result7 = Math.round(3.1);
		double result8 = Math.round(3.0);
		double result9 = Math.round(3.9);
		System.out.println(result7);
		System.out.println(result8);
		System.out.println(result9);
	}
}
