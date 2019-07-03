package demo.set;

import java.util.HashSet;

public class HashSetDemo2 {

	public static void main(String[] args) {
		
//		Contact에서 hashCode() 와 equals() 메소드를 재정의해서
//		객체가 달라도 번호가 동일하면 동일한 객체로 간주하도록 만들었다.
		Contact contact1 = new Contact(10, "홍길동", "010-1111-1111");
		Contact contact2 = new Contact(20, "김유신", "010-2222-2222");
		Contact contact3 = new Contact(30, "홍길동", "010-1111-1111");
		Contact contact4 = new Contact(40, "이순신", "010-4444-4444");
		
		HashSet<Contact> contacts = new HashSet<Contact>();
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact1);
		contacts.add(contact2);
		
		System.out.println(contacts);
	}
}
