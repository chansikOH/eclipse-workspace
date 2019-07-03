package demo.etc;

import java.util.LinkedList;

public class QueueDemo {

	public static void main(String[] args) {
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("김유신");
		queue.offer("강감찬");
		queue.offer("이순신");
		
		String value1 = queue.poll();
		System.out.println(value1);
		System.out.println("현재 개수: " + queue.size());
		
		String value2 = queue.poll();
		System.out.println(value2);
		System.out.println("현재 개수: " + queue.size());
	}
}
