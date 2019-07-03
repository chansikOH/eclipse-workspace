package demo.list;

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
//		기본자료형을 저장하는 ArrayList
//		기본자료형을 저장할 때는 제네릭타입을 Wrapper 클래스 타입으로 지정한다.
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(20));
		numbers.add(40);			// 오토박싱 -> numbers.add(new Integer(40))
		numbers.add(38);
		
		for (Integer x : numbers) {
			System.out.println(x);
		}
		
		for(int x : numbers) {		// 자동으로 언박싱해서 참조변수에 넣는다.
			System.out.println(x);	
		}
		
		ArrayList<Double> scores = new ArrayList<Double>();
		scores.add(3.8);			// 오토박싱 -> numbers.add(new Double(3.8))
		scores.add(2.1);
		scores.add(4.3);
		
		
	}
}
