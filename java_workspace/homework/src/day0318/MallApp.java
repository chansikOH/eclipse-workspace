package day0318;

import java.util.Scanner;

public class MallApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		MallService service = new MallService();
		
		while(true) {
			if (service.getSession() == null) {
				System.out.println("1.가입 2.로그인 0.종료");
			} else {
				System.out.println("3.상품보기 4.장바구니담기 5.장바구니보기 6.장바구니 상품삭제 7.장바구니 상품주문");
				System.out.println("8.주문하기 9.주문내역보기 10.내정보보기 11.비밀번호변경 12.로그아웃 0.종료");
			}
			
			System.out.print("메뉴 선택> ");
			int selNo = sc.nextInt();
			
			if (selNo == 1) {
				System.out.println("[회원가입]");
				System.out.print("아이디 입력> ");
				String id = sc.next();
				System.out.print("비밀번호 입력> ");
				String password = sc.next();
				System.out.print("이름 입력> ");
				String name = sc.next();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				
				service.addUser(user);
			} else if (selNo == 2) {
				System.out.println("[로그인]");
				System.out.print("아이디 입력> ");
				String id = sc.next();
				System.out.print("비밀번호 입력> ");
				String password = sc.next();
				
				service.login(id, password);
			} else if (selNo == 3) {
				service.printAllProducts();
			} else if (selNo == 4) {
				System.out.println("[장바구니 담기]");
				System.out.print("상품번호 입력> ");
				int no = sc.nextInt();
				System.out.print("수량 입력> ");
				int amount = sc.nextInt();
				
				service.addItemToCart(no, amount);
			} else if (selNo == 5) {
				service.printCart();
			} else if (selNo == 6) {
				System.out.println("[장바구니 상품 삭제]");
				System.out.print("상품번호 입력> ");
				int productNo = sc.nextInt();
				
				service.deleteItemFromCartByNo(productNo);
			} else if (selNo == 7) {
				System.out.println("[장바구니 상품 주문]");
				System.out.println("[장바구니의 모든 상품을 주문하시겠습니까?]");
				System.out.print("[1.예] [2.아니오]");
				int no = sc.nextInt();
				
				service.addItemToOrdersFromCart(no);
			} else if (selNo == 8) {
				System.out.println("[주문하기]");
				System.out.print("상품번호 입력> ");
				int no = sc.nextInt();
				System.out.print("수량 입력> ");
				int amount = sc.nextInt();
				
				service.addItemToOrders(no, amount);
			} else if (selNo == 9) {
				service.printOrders();
			} else if (selNo == 10) {
				service.printMyInfo();
			} else if (selNo == 11) {
				System.out.println("[비밀번호 변경]");
				System.out.print("이전 비밀번호 입력> ");
				String oldPassword = sc.next();
				System.out.print("변경할 비밀번호 입력> ");
				String newPassword = sc.next();
				
				service.changePassword(oldPassword, newPassword);
			} else if (selNo == 12) {
				service.logout();
			} else if (selNo == 0) {
				System.out.println("시스템 종료");
				break;
			}
			System.out.println();
		}
		sc.close();
	}
}
