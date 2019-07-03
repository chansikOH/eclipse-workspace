package demo.list;

import java.util.ArrayList;

public class ArrayListDemo1 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		
//		객체 저장하기
//		boolean add(E e)
		names.add("홍길동");	// 배열인 경우 -> name[0] = "홍길동";
		names.add("김유신");	// 배열인 경우 -> name[1] = "김유신";
		names.add("강감찬");	// 배열인 경우 -> name[2] = "강감찬";
		names.add("이순신");	// 배열인 경우 -> name[3] = "이순신";
		names.add("유관순");	// 배열인 경우 -> name[4] = "유관순";
		names.add("유관순");	// 배열인 경우 -> name[5] = "유관순";
		
		System.out.println(names);
		
//		지정된 위치의 객체 삭제
//		E remove(int index)
		names.remove(2);	// 강감찬 삭제
		
//		지정된 객체를 삭제
//		boolean remove(Object o)
		names.remove("유관순");
		
//		지정된 인덱스에 저장된 객체 꺼내기
//		E get(int index)
		String value1 = names.get(0);
		System.out.println("0번째 저장된 객체: " + value1);
		
//		ArrayList에 저장된 모든 객체 꺼내기
//		enhanced-for문 사용
		for(String x : names) {
			System.out.println(x);
		}
		
//		int size()
//		저장된 객체의 갯수를 반환
		int len = names.size();
		System.out.println("저장된 객체의 갯수: " + len);
		
//		void clear()
//		저장된 객체 전체 삭제
		names.clear();
		
//		boolean isEmpty()
		boolean empty = names.isEmpty();
		System.out.println("비어있는가? " + empty);
	}
}
