package demo.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo1 {

	public static void main(String[] args) {
		HashSet<String> names = new HashSet<String>();
		
		names.add("홍길동");
		names.add("김유신");
		names.add("강감찬");
		names.add("홍길동");
		names.add("이순신");
		names.add("류관순");
		
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
		
		names.clear();
		
		System.out.println("비어있는가? " + names.isEmpty());
		
		System.out.println("저장된 갯수: " + names.size());

		for (String name : names) {
			System.out.println(name);
		}
		System.out.println();
	}
}