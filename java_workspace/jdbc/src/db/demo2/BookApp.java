package db.demo2;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		BookService service = new BookService();
		
		while (true) {
			System.out.println("1.전체조회 2.제목검색 3.책등록 4.책삭제 5.책정보변경 0.종료");
			
			System.out.print("메뉴선택> ");
			int selNo = sc.nextInt();
			
			if(selNo == 1) {
				// 모든 책 정보를 조회해서 출력한다.
				service.selectAllBooks();
				
			} else if (selNo == 2) {
				// 제목을 입력받아서 제목을 포함하고 있는 책 정보를 조회해서 출력한다.
				System.out.print("키워드 입력> ");
				String keyword = sc.next();
				
				service.selectBooksByTitle(keyword);
				
			} else if (selNo == 3) {
				// 번호, 제목, 저자, 출판사, 가격, 출판일을 입력받아서 DB에 저장한다.
				System.out.print("책번호 입력> ");
				int no = sc.nextInt();
				System.out.print("책제목 입력> ");
				String title = sc.next();
				System.out.print("책저자 입력> ");
				String author = sc.next();
				System.out.print("출판사 입력> ");
				String publisher = sc.next();
				System.out.print("책가격 입력> ");
				int price = sc.nextInt();
				System.out.print("출판일 입력> ");
				String pubdate = sc.next();
				
				service.insertNewBook(no, title, author, publisher, price, pubdate);
				
			} else if (selNo == 4) {
				// 책번호를 입력받아서 책정보를 삭제한다.
				System.out.print("책번호 입력> ");
				int no = sc.nextInt();
				
				service.deleteBooksByNo(no);
			} else if (selNo == 5) {
				// 수정할 책번호, 변경할 정보(제목, 저자, 출판사, 가격, 출판일)을 입력받아서 
				// 책번호에 해당하는 책 정보를 변경한다.
				System.out.print("수정할 책번호 입력> ");
				int no = sc.nextInt();
				System.out.print("변경할 책제목 입력> ");
				String title = sc.next();
				System.out.print("변경할 책저자 입력> ");
				String author = sc.next();
				System.out.print("변경할 출판사 입력> ");
				String publisher = sc.next();
				System.out.print("변경할 책가격 입력> ");
				int price = sc.nextInt();
				System.out.print("변경할 출판일 입력> ");
				String pubdate = sc.next();
				
				service.updateBook(no, title, author, publisher, price, pubdate);
				
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		}
		sc.close();
	}
}
