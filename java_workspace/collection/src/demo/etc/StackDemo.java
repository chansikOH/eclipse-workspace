package demo.etc;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("홍길동");
		stack.push("김유신");
		stack.push("강감찬");
		stack.push("이순신");
		
		String value1 = stack.pop();
		System.out.println(value1);
		System.out.println("현재 개수 : " + stack.size());
		
		String value2 = stack.pop();
		System.out.println(value2);
		System.out.println("현재 개수 : " + stack.size());
	}
}
