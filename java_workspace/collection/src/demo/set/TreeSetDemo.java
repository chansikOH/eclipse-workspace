package demo.set;

import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {
		TreeSet<String> names = new TreeSet<String>();
		
		names.add("이순신");
		names.add("김유신");
		names.add("강감찬");
		names.add("홍길동");
		names.add("류관순");
		names.add("김구");
		
		for (String name : names) {
			System.out.println(name);
		}
	}
}
