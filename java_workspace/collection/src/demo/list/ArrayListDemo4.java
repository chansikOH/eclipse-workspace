package demo.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo4 {

	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("이순신");
		names.add("이성계");
		names.add("김구");
		names.add("김좌진");
		
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
		
		for (int i=0; i<names.size(); i++) {
			String name = names.get(i);
			System.out.println(name);
		}
		System.out.println();
		
		/*
		 * Iterator<E>
		 * 		콜렉션(List 및 Set)의 요소를 추출, 삭제할 때 사용되는 객체다.
		 * 		주요 메소드
		 * 			boolean hasnNext()		- 추출할 객체가 남아있으면 true를 반환
		 * 			E		next()			- 객체를 하나 꺼내서 반환
		 * 			void	remove()		- 객체를 삭제한다.
		 */
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String name = it.next();
			System.out.println(name);
			if(name.startsWith("김")) {
			it.remove();
			}
		}
		System.out.println();
		
		System.out.println(names);
	}
}
