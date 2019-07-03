package day0411;

import java.util.ArrayList;
import java.util.Scanner;

public class MallApp {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		MallService service = new MallService();
		
		while(true) {
			System.out.println("1.전체 카테고리 2.전체 상품 3.카테고리별 상품보기 4.상품상세보기 5.카테고리 등록하기 "
					+ "6.상품등록하기 7.상품삭제하기 0.종료");
			
			System.out.print("메뉴선택> ");
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				System.out.println("[전체 카테고리 조회]");
				
				ArrayList<CategoryVO> cat = service.searchAllCategories();
				for(CategoryVO c1 : cat) {
					System.out.println("코드 : " + c1.getCode());
					System.out.println("이름 : " + c1.getName());
					System.out.println();
				}
				
			} else if (selectNo == 2) {
				System.out.println("[전체 상품 조회]");
				
				ArrayList<ProductVO> pro = service.searchAllProducts();
				for (ProductVO p1 : pro) {
					System.out.println("상품번호 : " + p1.getNo());
					System.out.println("상품이름 : " + p1.getName());
					System.out.println("제 조 사 : " + p1.getMaker());
					System.out.println("가    격 : " + p1.getPrice());
					System.out.println("재    고 : " + p1.getStock());
					System.out.println("판매여부 : " + p1.getSell());
					System.out.println("카테고리 : " + p1.getCategory());
					System.out.println("생 성 일 : " + p1.getCreateDate());
					System.out.println();
				}
				
			} else if (selectNo == 3) {
				System.out.println("[카테고리별 상품 조회]");
				
				System.out.print("카테고리 이름 입력> ");
				String category = sc.next();
				
				ArrayList<ProductVO> pro = service.searchProductsByCategory(category);
				for (ProductVO p1 : pro) {
					System.out.println("상품번호 : " + p1.getNo());
					System.out.println("상품이름 : " + p1.getName());
					System.out.println("제 조 사 : " + p1.getMaker());
					System.out.println("가    격 : " + p1.getPrice());
					System.out.println("재    고 : " + p1.getStock());
					System.out.println("판매여부 : " + p1.getSell());
					System.out.println("카테고리 : " + p1.getCategory());
					System.out.println("생 성 일 : " + p1.getCreateDate());
					System.out.println();
				}
				
			} else if (selectNo == 4) {
				System.out.println("[상품정보 상세보기]");
				
				System.out.print("상품번호 입력> ");
				int productNo = sc.nextInt();
				
				ProductVO pro = service.getProductByNo(productNo);
				System.out.println("상품번호 : " + pro.getNo());
				System.out.println("상품이름 : " + pro.getName());
				System.out.println("제 조 사 : " + pro.getMaker());
				System.out.println("가    격 : " + pro.getPrice());
				System.out.println("재    고 : " + pro.getStock());
				System.out.println("판매여부 : " + pro.getSell());
				System.out.println("카테고리 : " + pro.getCategory());
				System.out.println("생 성 일 : " + pro.getCreateDate());
				System.out.println();
			
			} else if (selectNo == 5) {
				System.out.println("[카테고리 등록하기]");
				
				System.out.print("카테고리 코드> ");
				String code = sc.next();
				System.out.print("카테고리 이름> ");
				String name = sc.next();
				
				CategoryVO cat = new CategoryVO();
				cat.setCode(code);
				cat.setName(name);
				
				service.addCategory(cat);
				
			} else if (selectNo == 6) {
				System.out.println("[상품 등록하기]");
				
				System.out.print("상품이름 입력> ");
				String name = sc.next();
				System.out.print("제 조 사 입력> ");
				String maker = sc.next();
				System.out.print("상품가격 입력> ");
				int price = sc.nextInt();
				System.out.print("상품재고 입력> ");
				int stock = sc.nextInt();
				System.out.print("판매여부 입력> ");
				String sell = sc.next();
				System.out.print("카테고리 입력> ");
				String category = sc.next();
				
				ProductVO pro = new ProductVO();
				pro.setName(name);
				pro.setMaker(maker);
				pro.setPrice(price);
				pro.setStock(stock);
				pro.setSell(sell);
				pro.setCategory(category);
				
				service.addProduct(pro);
		
			} else if (selectNo == 7) {
				System.out.println("[상품 삭제하기]");
				
				System.out.print("삭제할 상품번호 입력> ");
				int productNo = sc.nextInt();
				
				service.deleteProductByNo(productNo);
			
			} else if (selectNo == 0) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		sc.close();
	}
}
