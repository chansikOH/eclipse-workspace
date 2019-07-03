package day0322;

import java.util.Scanner;

public class MallApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StoreService service = new StoreService();
		
		while (true) {

			if (service.getSession() == null) {
//				로그인 전
				System.out.println("1.로그인 0.종료");				
			} else {
//				로그인 후
				System.out.println("2.상품조회 3.장바구니담기 4.바로구매 5.장바구니조회 6.장바구니삭제 7.장바구니에서주문 "
						+ "8.주문조회 9.주문취소 10.로그아웃 0.종료");				
			}
			
			System.out.print("메뉴 선택> ");
			int selNo = scanner.nextInt();
			
			if (selNo == 1) {
				System.out.println("[로그인]");
				
				System.out.print("아이디입력> ");
				String id = scanner.next();
				System.out.print("비밀번호입력> ");
				String password = scanner.next();
				
				service.login(id, password);
			} else if (selNo == 2) {
				System.out.println("[전체 상품 조회]");
				
				service.printAllProducts();
			} else if (selNo == 3) {
				System.out.println("[장바구니 담기]");
				
				System.out.print("상품번호입력> ");
				int productNo = scanner.nextInt();
				System.out.print("수량입력> ");
				int amount = scanner.nextInt();
				
				service.addCart(productNo, amount);
			} else if (selNo == 4) {
				System.out.println("[바로 구매]");
				
				System.out.print("상품번호입력> ");
				int productNo = scanner.nextInt();
				System.out.print("수량입력> ");
				int amount = scanner.nextInt();
				
				service.order(productNo, amount);
			} else if (selNo == 5) {
				System.out.println("[장바구니 조회]");
				
				service.printCarts();
			} else if (selNo == 6) {
				System.out.println("[장바구니 삭제]");
				
				System.out.println("(입력예: 101,102,...)");
				System.out.print("상품번호입력>");
				String str = scanner.next();
				
				service.deleteGoodsInCarts(str);
			} else if (selNo == 7) {
				System.out.println("[장바구니에서 구매]");
				
				System.out.println("(입력예: 101,102,...)");
				System.out.print("상품번호입력>");
				String str = scanner.next();
				
				service.orderInCarts(str);
			} else if (selNo == 8) {
				System.out.println("[주문조회]");
				
				service.printOrders();
			} else if (selNo == 9) {
				System.out.println("[주문취소]");
				
				System.out.println("(입력예: 101,102,...)");
				System.out.print("상품번호입력>");
				String str = scanner.next();
				
				service.cancelOrders(str);
			} else if (selNo == 10) {
				service.logout();
			} else if (selNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
		
		}
		
		scanner.close();
	}
}
