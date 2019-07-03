package day0321;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookService {

	private ArrayList<Book> books = new ArrayList<Book>();
	
	public BookService() {
		books.add(new Book("비즈니스를 위한 데이터과학", "IT", "강권덕", "한빛미디어", 25000));
		books.add(new Book("공부머리 독서법", "육아", "최승필", "책구루", 15000));
		books.add(new Book("한국사 대모험", "역사", "설민석", "아이휴먼", 10000));
		books.add(new Book("아이의 고집을 다루다", "육아", "정유진", "책구루", 15000));
		books.add(new Book("김수미 요리레시피", "요리", "김수미", "지혜", 35000));
		books.add(new Book("대한민국 주택지도", "경제", "정지영", "다산북스", 18000));
		books.add(new Book("이것이 JAVA다", "IT", "신용권", "한빛미디어", 30000));
		books.add(new Book("스프링 3.0", "IT", "이일민", "한빛미디어", 75000));
		books.add(new Book("삼국유사", "역사", "일연", "아이휴먼", 35000));
	}
	
	
//	전체 카테고리를 보여주는 기능
	public void printAllCategory() {
		HashSet<String> categories = new HashSet<String>();	// 카테고리를 중복되지 않게 담는 콜렉션
		for (Book book : books) {
			String category = book.getCategory();
			categories.add(category);
		}
		System.out.println("전체 카테고리 목록");
		for (String category : categories) {
			System.out.println(category);
		}
//		System.out.println(categories);
	}
	
//	카테고리별 도서현황(갯수)을 보여주는 기능 containsKey 메소드 사용
	/*
	 *  books 객체에서 containKey를 사용해서 해당 category가 있는지 확인
	 *  없으면 category에 1을 담음
	 *  있으면 해당 category의 수를 1 증가
	 */
	public void printStockByCategory() {
//		key --> 카테고리 value --> 그 카테고리에 속하는 책 권수
		HashMap<String, Integer> map = new HashMap<String, Integer>();	// 카테고리별 갯수를 담은 객체
		
		/*
		 *  enhanced-for문을 사용해서 책정보를 하나씩 꺼내는 반복작업 수행
		 *  		책정보에서 카테고리 알아내기
		 *  		map에 해당 카테고리가 존재한다면	boolean containsKey(Object key) 활용
		 *  			map에서 해당 카테고리에 해당하는 값(개수)를 조회하고, 1증가시켜서 다시 저장
		 *  		map에 해당 카테고리가 존재하지 않으면
		 *  			map에서 카테고리를 key로 1을 value로 저장하기
		 *  
		 *  map의 정보 출력하기 System.out.println(map) 실행해서 출력
		 */
		for (Book book : books) {
			String category = book.getCategory();
			if(!map.containsKey(category)) {
				map.put(category, 1);
			} else {
				map.put(category, map.get(category) + 1);
			}
		}
		Set<String> keys = map.keySet();
		for (String key : keys) {
			int stock = map.get(key);
			System.out.println("카테고리    권수");
			System.out.println("    "+key+" --> "+stock);
		}
//		System.out.println(map);
	}
	
//	전달받은 최소가격~최대가격 범위내의 도서 정보 출력기능
	public void printBooksByPrice(int minPrice, int maxPrice) {
		boolean check = false;
		for(Book book : books) {
			if(minPrice <= book.getPrice() && book.getPrice() <= maxPrice) {
				book.displayInfo();
				check = true;
			}
		}
		if (!check) {
			System.out.println("해당 범위의 책이 존재하지 않습니다.");
		}
	}
	
//	전달받은 키워드를 제목에 포함하고 있는 도서 정보 출력기능
	public void printBooksByTitle(String keyword) {
		boolean check = false;
		for (Book book : books) {
			String title = book.getTitle();
			if(title.toUpperCase().contains(keyword.toUpperCase())) {
				book.displayInfo();
				check = true;
			}
		}
		if (!check) {
			System.out.println("해당 제목이 포함되는 책이 존재하지 않습니다.");
		}
	}
	
	
}
