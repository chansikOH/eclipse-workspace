package demo.store;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StoreClient {

	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("192.168.10.101", 444);		// 서버에 연결요청을 보낸다.
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);	// 서버로 메세지 보낼 때 사용
																			// 생성자 true를 붙이면 flush()를 자동으로 붙여준다.
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		Scanner scanner = new Scanner(System.in);	// 사용자의 입력을 받는다.
		
		boolean islogin = false;
		
		while (true) {
			if(!islogin) {
				System.out.println("1.가입 2.로그인 0.종료");
			} else {
				System.out.println("3.목록조회 4.상세조회 5.장바구니조회 "
					+ "6.장바구니담기 7.내정보 보기 8.비밀번호 변경하기 9.로그아웃 0.종료");
			}
			
			System.out.print("메뉴 선택> ");
			int selectNo = scanner.nextInt();
			
			if (selectNo == 0) {
				System.out.println("프로그램 종료");
				break;				
			} else if (selectNo == 1) {
				System.out.println("[회원가입]");
				
				System.out.print("아이디입력> ");
				String id = scanner.next();
				System.out.print("비밀번호입력> ");
				String password = scanner.next();
				System.out.print("이름입력> ");
				String name = scanner.next();
				
				out.println("add_user:" + id + ":" + password +":"+ name);
				
				String message = in.readLine();
				System.out.println("응답메세지 : " + message);
			} else if (selectNo == 2) {
				System.out.println("[로그인]");
				
				System.out.print("아이디입력> ");
				String id = scanner.next();
				System.out.print("비밀번호입력> ");
				String password = scanner.next();
				
				out.println("login_user:" + id + ":" + password);
				
				String message = in.readLine();
				System.out.println("응답메세지 : " + message);
				
				String[] items = message.split(":");
				if(items[1].equals("success")) {
					islogin = true;
				}
			} else if (selectNo == 3) {
				System.out.println("[목록조회]");
				
				out.println("view_products");
				
				String message = in.readLine();
				
				String items = message.substring(18);
				if(items.startsWith("fail")) {
					System.out.println("정보가 존재하지 않습니다.");
				} else {
					String[] products = items.split(":");
					for(String product : products) {
						String[] fields = product.split(",");
						System.out.println("상품번호 : " + fields[0]);
						System.out.println("상품이름 : " + fields[1]);
						System.out.println("상품가격 : " + fields[2]);
						System.out.println();		
					}
				}
				

			} else if (selectNo == 4) {
				System.out.println("[상세조회]");
				
				System.out.print("상품번호입력> ");
				int productNo = scanner.nextInt();
				
				out.println("detail_product:" + productNo);
				
				String message = in.readLine();
				
				String items = message.substring(19);
				if(items.startsWith("fail")) {
					System.out.println("정보가 존재하지 않습니다.");
				} else {
					String[] products = items.split(",");
					System.out.println("상품번호 : " + products[0]);
					System.out.println("상품이름 : " + products[1]);
					System.out.println("상품가격 : " + products[2]);
					System.out.println();
					
				}
				

			} else if (selectNo == 5) {
				System.out.println("[장바구니 조회]");

				out.println("view_cart");
				
				String message = in.readLine();
				String items = message.substring(14);
				if(items.startsWith("fail")) {
					System.out.println("정보가 존재하지 않습니다.");
				} else {
					String[] products = items.split(":");
					for(String product : products) {
						String[] fields = product.split(",");
						System.out.println("상품번호 : " + fields[0]);
						System.out.println("상품이름 : " + fields[1]);
						System.out.println("상품가격 : " + fields[2]);
						System.out.println("상품수량 : " + fields[3]);
						System.out.println();		
					}
					
				}
			
			} else if (selectNo == 6) {
				System.out.println("[장바구니 담기]");
				
				System.out.print("상품번호입력> ");
				int productNo = scanner.nextInt();
				System.out.print("구매수량입력> ");
				int amount = scanner.nextInt();
				
				out.println("add_cart:" + productNo + ":" + amount);
				
				String message = in.readLine();
				System.out.println("응답메세지 : " + message);
			} else if (selectNo == 7) {
				System.out.println("[내정보 보기]");
				
				out.println("view_user");
				
				String message = in.readLine();
				
				String items = message.substring(14);
				if(items.startsWith("fail")) {
					System.out.println("정보가 존재하지 않습니다.");
				} else {
					String[] fields = items.split(",");
					System.out.println("아이디 : " + fields[0]);
					System.out.println("이  름 : " + fields[1]);
					System.out.println();		
				}
				
			} else if (selectNo == 8) {
				System.out.println("[비밀번호 변경하기]");
				
				System.out.print("현재 비밀번호 입력> ");
				String oldPassword = scanner.next();
				System.out.print("변경할 비밀번호 입력> ");
				String newPassword = scanner.next();
				
				out.println("change_pwd:" + oldPassword + ":" + newPassword);
				
				String message = in.readLine();
				System.out.println("응답메세지 : " + message);
			} else if (selectNo == 9) {
				System.out.println("[로그아웃]");
				
				out.println("logout_user");
				
				String message = in.readLine();
				String items = message.substring(7);
				if(items.startsWith("success")) {
					islogin = false;
				}
			}
			
		}
		
		scanner.close();
		socket.close();
	}
}
