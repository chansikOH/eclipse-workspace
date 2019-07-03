package demo4;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		
		int[] scores = {10, 30, 1, 7, 31, 46, 5};
		Arrays.sort(scores);
		
		System.out.println(Arrays.toString(scores));
		
		String[] names = {"홍길동", "이순신", "강감찬", "김유신", "유관순", "김구"};
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
	}
}
