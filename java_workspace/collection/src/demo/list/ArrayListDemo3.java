package demo.list;

import java.util.ArrayList;

public class ArrayListDemo3 {

	public static void main(String[] args) {
		
//		객체를 저장하는 ArrayList
		ArrayList<Book> books = new ArrayList<Book>();
		
		Book book1 = new Book(100, "이것이 자바다", "신용권", "한빛미디어", 30000);
		Book book2 = new Book(200, "데이터베이스 개론", "홍길동", "한빛미디어", 28000);
		Book book3 = new Book(300, "자바 디자인 패턴", "켄트백", "인사이트", 32000);
		Book book4 = new Book(400, "인사이트 자바스크립트", "김유신", "한빛미디어", 27000);
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(new Book(500, "스프링 3.0", "이일민", "에이콘출판사", 75000));
		
		System.out.println(books);
		
		int total = 0;
		for(Book book : books) {
			System.out.println("제목: " + book.getTitle());
			System.out.println("가격: " + book.getPrice());
			
			total += book.getPrice();
		}
		
		System.out.println("전체가격: " + total);
	}
}
