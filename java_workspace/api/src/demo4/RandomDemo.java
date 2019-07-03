package demo4;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		
		// 난수를 발생시키는 Random객체 생성
		Random random = new Random();
		
		// int 범위의 최소값과 최대값 사이의 임의의 정수를 제공
		int num1 = random.nextInt();
		System.out.println(num1);
		
		// int nextInt(int max) : 0 <= 난수 < 100 범위의 난수를 제공
		int num2 = random.nextInt(100);
		System.out.println(num2);
		
		int num3 = random.nextInt(6) + 1;
		System.out.println(num3);
	}
}
