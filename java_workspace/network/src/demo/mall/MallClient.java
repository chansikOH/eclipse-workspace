package demo.mall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MallClient {

	public static void main(String[] args) throws Exception{
		
		Socket socket = new Socket("192.168.10.254", 8000);
		
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.전체조회 2.상세조회 3.등록 0.종료");
			
			System.out.print("메뉴 선택> ");
			int selectNo = scanner.nextInt();
			
			if(selectNo == 1) {
				out.println("ALL_REQ");	
				out.flush();
				
			} else if (selectNo == 2) {
				System.out.print("상품번호 입력> ");
				int productNo = scanner.nextInt();
				
				out.println("DETAIL_REQ:" + productNo);
				out.flush();
			} else if (selectNo == 3) {
				System.out.print("상품명 입력> ");
				String name = scanner.next();
				System.out.print("제조사 입력> ");
				String maker = scanner.next();
				System.out.print("상품종류 입력> ");
				String type = scanner.next();
				System.out.print("상품가격 입력> ");
				int price = scanner.nextInt();
				
				out.println("ADD_REQ:" + name + "," + maker + "," + type + "," + price);
				out.flush();
			} else if (selectNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			String message = in.readLine();
			System.out.println("응답메세지: " + message);
		}
		
		socket.close();
		scanner.close();
	}
}
