package day0404;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		BookService service = new BookService();
		
		while (true) {
			System.out.println("1.책정보 로드 2.제목검색 3.출판사검색 4.가격검색 0.종료");
			
			System.out.print("메뉴선택> ");
			int selectNo = scanner.nextInt();
			
			if (selectNo == 1) {
				service.load();
				
			} else if (selectNo == 2) {
				// TODO : 제목으로 검색하기 구현, 
				//        검색결과로 전달받은 ArrayList는 BookService의 printBooks메소드로 출력하기
				System.out.print("제목 입력> ");
				String keyword = scanner.next();
				
				service.printBooks(service.searchByTitle(keyword));
				
			} else if (selectNo == 3) {
				// TODO : 출판사로 검색하기 구현, 
				//        검색결과로 전달받은 ArrayList는 BookService의 printBooks메소드로 출력하기
				System.out.print("출판사 입력> ");
				String publisher = scanner.next();
				
				service.printBooks(service.searchByPublisher(publisher));
				
			} else if (selectNo == 4) {
				// TODO : 가격으로 검색하기 구현, 
				//        검색결과로 전달받은 ArrayList는 BookService의 printBooks메소드로 출력하기
				System.out.print("최소가격 입력> ");
				int min = scanner.nextInt();
				System.out.print("최대가격 입력> ");
				int max = scanner.nextInt();
				
				service.printBooks(service.searchByPrice(min, max));
				
			} else if (selectNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		scanner.close();
	}
}
