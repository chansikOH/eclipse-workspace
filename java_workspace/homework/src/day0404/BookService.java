package day0404;

import java.io.BufferedReader;import java.io.FileReader;
import java.util.ArrayList;

public class BookService {

	private ArrayList<Book> books = new ArrayList<Book>();
	
	/*
	 * c:/temp/books.txt파일을 읽어서 7라인에서 정의한
	 * ArrayList에 저장한다.
	 */
	public void load() throws Exception {
		/*
		 * 1. BufferedReader와 FileReader를 생성해서 books.txt파일을 읽어오는 스트림을 생성한다.
		 * 반복시작>>>
		 * 		2. BufferedReader를 활용해서 books.txt 파일의 내용을 한 줄씩 읽어온다.
		 * 		3. 책정보 하나를 담는 Book객체를 생성하고, 읽어온 내용을 잘라서 Book객체에 담는다.
		 * 		4. 책정보가 저장된 Book객체를 7번에서 생성한 ArrayList에 저장한다.
		 * 반복끝 >>>
		 */
		BufferedReader reader = new BufferedReader(new FileReader("c:/temp/books.txt"));
		String text = null;
		while ((text = reader.readLine()) != null) {
			Book book = new Book();
			String[] value = text.split(",");
			String val = value[0].replace("\uFEFF", "");
			
			int no = Integer.parseInt(val);
			String title = value[1];
			String publisher = value[2];
			int price = Integer.parseInt(value[3]);
			boolean isSell = false;
			if(value[4] == "Y") {
				isSell = true;
			} 
			book.setNo(no);
			book.setTitle(title);
			book.setPublisher(publisher);
			book.setPrice(price);
			book.setSell(isSell);
			
			books.add(book);
		}
		System.out.println("로드가 완료되었습니다.");
		reader.close();
	}
	
	/*
	 * 전달받은 책정보들을 출력한다.
	 */
	public void printBooks(ArrayList<Book> result) {
		for (Book book : result) {
			book.displayBook();
		}
	}
	
	/*
	 * 전달받은 키워드를 제목에 포함하고 있는 책 정보들을 제공한다.
	 */
	public ArrayList<Book> searchByTitle(String keyword) {
		// 검색된 책정보를 저장할 새로운 ArrayList 생성
		ArrayList<Book> results = new ArrayList<Book>();
		
		/*
		 * 1. 책정보를 저장하고 있는 7번의 ArrayList에서 책정보를 하나씩 꺼낸다.
		 * 반복시작>>>
		 * 		2. 전달받은 키워드를 제목에 포함하고 있는지 확인하고
		 * 		3. 28번에서 생성한 ArrayList에 저장한다.
		 * 반복끝  >>>
		 */
		
		// 검색된 책정보들 반환
		for(Book book : books) {
			if(book.getTitle().contains(keyword)) {
				results.add(book);
			}
		}
		return results;
	}
	
	/*
	 * 전달받은 출판사에서 출판한 책 정보들을 제공한다.
	 */
	public ArrayList<Book> searchByPublisher(String publisher) {
		// 검색된 책정보를 저장할 새로운 ArrayList 생성
		ArrayList<Book> results = new ArrayList<Book>();
		
		/*
		 * 1. 책정보를 저장하고 있는 7번의 ArrayList에서 책정보를 하나씩 꺼낸다.
		 * 반복시작>>>
		 * 		2. 전달받은 출판사와 일치하는 출판사에서 출판한 책인지 확인하고
		 * 		3. 28번에서 생성한 ArrayList에 저장한다.
		 * 반복끝  >>>
		 */
		for(Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				results.add(book);
			}
		}
		
		// 검색된 책정보들 반환
		return results;
	}
	
	/*
	 * 전달받은 가격범위에 속하는 책정보를 제공한다.
	 */
	public ArrayList<Book> searchByPrice(int min, int max) {
		// 검색된 책정보를 저장할 새로운 ArrayList 생성
		ArrayList<Book> results = new ArrayList<Book>();
		
		/*
		 * 1. 책정보를 저장하고 있는 7번의 ArrayList에서 책정보를 하나씩 꺼낸다.
		 * 반복시작>>>
		 * 		2. 전달받은 가격범위에 해당하는 가격을 가지고 있는지 확인하고
		 * 		3. 67번에서 생성한 ArrayList에 저장한다.
		 * 반복끝  >>>
		 */
		
		// 검색된 책정보들 반환
		for (Book book : books) {
			if(book.getPrice() >= min && book.getPrice() <= max) {
				results.add(book);
			}
		}
		return results;
	}
}
