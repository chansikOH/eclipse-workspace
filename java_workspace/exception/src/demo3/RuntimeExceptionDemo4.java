package demo3;

import java.util.Scanner;

public class RuntimeExceptionDemo4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("몸무게 입력> ");	// kg 단위
		String value1 = scanner.next();
		
		System.out.print("키 입력> ");	// m 단위
		String value2 = scanner.next();
		
		double weight = Double.parseDouble(value1);
		double height = Double.parseDouble(value2)/100.0;
		
		double bmi = weight/(height*height);
		
		System.out.println("bmi지수 : " + bmi);
		
		if (bmi > 35) {
			System.out.println("고도비만");
		} else if (bmi > 30) {
			System.out.println("중등도비만");
		} else if (bmi > 25) {
			System.out.println("경도비만");
		} else if (bmi > 23) {
			System.out.println("과체중");
		} else if (bmi > 18.5) {
			System.out.println("정상");
		} else {
			System.out.println("저체중");
		}
		
		scanner.close();
	}
}
