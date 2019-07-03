package day0321;

import java.util.Scanner;

public class BookApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BookService service = new BookService();
		
		while(true) {
			System.out.println("1.카테고리출력 2.도서현황출력 3.가격검색 4.제목검색 0.종료");
			
			System.out.print("메뉴선택> ");
			int selNo = sc.nextInt();
			
			if(selNo == 1) {
				System.out.println("[카테고리]");
				
				service.printAllCategory();
			} else if (selNo == 2) {
				System.out.println("[도서현황]");
				
				service.printStockByCategory();
			} else if (selNo == 3) {
				System.out.println("[가격검색]");
				
				System.out.print("최소값 입력> ");
				int minPrice = sc.nextInt();
				System.out.print("최대값 입력> ");
				int maxPrice = sc.nextInt();
				
				service.printBooksByPrice(minPrice, maxPrice);
			} else if (selNo == 4) {
				System.out.println("[제목검색]");
				
				System.out.print("단어 입력> ");
				String title = sc.next();
				
				service.printBooksByTitle(title);
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println();
		}
		
		sc.close();
	}
}
