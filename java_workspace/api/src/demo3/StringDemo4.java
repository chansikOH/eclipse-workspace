package demo3;

import java.util.Scanner;

public class StringDemo4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름,국어,영어,수학 정보 입력> ");
		String text = sc.next();	// ex. 홍길동,60,80,50
		
		String[] values = text.split(",");
		System.out.println("이름: " + values[0]);
		System.out.println("국어: " + values[1]);
		System.out.println("영어: " + values[2]);
		System.out.println("수학: " + values[3]);
		
		sc.close();
	}
}
