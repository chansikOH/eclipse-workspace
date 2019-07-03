package demo3;

import java.util.Scanner;

public class StringDemo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("비밀번호를 입력하세요: ");
		String pwd1 = sc.next();
		
		System.out.print("비밀번호를 다시 입력하세요: ");
		String pwd2 = sc.next();
		
		System.out.println(pwd1 == pwd2);
		System.out.println(pwd1.equals(pwd2));
		
		sc.close();
	}
}
