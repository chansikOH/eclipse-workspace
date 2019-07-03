package demo2;

import java.lang.reflect.Method;

public class ContactReflect {
	
	public static void main(String[] args) throws Exception {
		
		Contact c = new Contact(10, "홍길동", "010-1111-1111", "haong@gmail.com");
		
		Class<?> clazz = c.getClass();
		Method[] methods = clazz.getMethods();
		
		for(Method m : methods) {
			System.out.println(m.getName());
		}
	}

}
