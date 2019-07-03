package day0418.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import day0418.service.StoreService;
import day0418.vo.Category;
import day0418.vo.Customer;
import day0418.vo.Goods;
import day0418.vo.Item;
import day0418.vo.OrderItem;

public class StoreApp {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		StoreService storeService = new StoreService();
		
		// 로그인된 고객의 정보를 저장
		Customer loginCustomer = null;
		while(true) {
			System.out.println();
			try {
				if (loginCustomer == null) {
					System.out.println("1.가입 2.로그인 0.종료");
				} else {
					System.out.println("3.내정보보기 4.탈퇴 5.카테고리조회 6.상품조회 7.구매 8.구매취소 9.구매내역 10.취소내역 11.로그아웃 0.종료");
				}
				
				System.out.print("메뉴 선택> ");
				int menu = scanner.nextInt();
				
				if (menu == 1) {
					System.out.println("[신규 고객 가입]");
					
					// 이름, 아이디, 비번, 성별(F,M), 이메일, 전화번호를 입력받는다.
					System.out.print("이름 입력> ");
					String name = scanner.next();
					System.out.print("아이디 입력> ");
					String id = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					System.out.print("성별('F' or 'M') 입력> ");
					String gender = scanner.next();
					System.out.print("이메일 입력> ");
					String email = scanner.next();
					System.out.print("전화번호 입력> ");
					String phone = scanner.next();
					
					// 입력된 정보를 VO객체에 저장한다.
					Customer customer = new Customer();
					customer.setName(name);
					customer.setId(id);
					customer.setPassword(password);
					customer.setGender(gender);
					customer.setEmail(email);
					customer.setPhone(phone);
					
					// 입력된 정보가 저장된 VO객체를 서비스에 전달해서 가입시킨다.
					storeService.addNewCustomer(customer);
					
				} else if (menu == 2) {
					System.out.println("[로그인 처리]");

					// 아이디와 비번을 입력받는다.
					System.out.print("아이디 입력> ");
					String id = scanner.next();
					System.out.print("비밀번호 입력> ");
					String password = scanner.next();
					
					// 고객정보 <-- 입력된 정보를 서비스에 전달해서 로그인 처리를 수행시킨다.
					//				서비스는 로그인이 성공하면 사용자 정보를 반환하고
					//					로그인이 실패하면 예외를 발생시킨다.
					Customer customer = storeService.loginProcess(id, password);
					
					// 반환받은 고객정보를 다른 메뉴에서 활용하기 위해 loginCustomer 변수에 저장한다.
					loginCustomer = customer;
				
				} else if (menu == 3) {
					System.out.println("[내 정보 보기]");
					
					// 고객정보 <-- 로그인한 사용자의 아이디를 서비스에 전달해서 고객정보를 가져오도록 시킨다.
					Customer customer = storeService.getCustomerDetail(loginCustomer.getId());
					
					// 제공받은 고객정보를 화면에 표시한다.
					// 고객번호, 고객이름, 이메일, 전화번호, 성별, 포인트, 가입일 표시
					System.out.println("고객번호 : " + customer.getNo());
					System.out.println("고객이름 : " + customer.getName());
					System.out.println("이 메 일 : " + customer.getEmail());
					System.out.println("전화번호 : " + customer.getPhone());
					System.out.println("성    별 : " + customer.getGender());
					System.out.println("포 인 트 : " + customer.getPoint());
					System.out.println("가 입 일 : " + customer.getCreateDate());
					System.out.println();
				
				} else if (menu == 4) {
					System.out.println("[회원 탈퇴하기]");
					
					// 로그인한 사용자의 아이디를 서비스에 전달해서 탈퇴를 진행시킨다.
					storeService.exitCustomer(loginCustomer.getId());
					
					// 로그아웃 <-- 로그인된 고객의 정보를 비운다. // App에서 진행
					loginCustomer = null;
				
				} else if (menu == 5) {
					System.out.println("[카테고리 조회하기]");
					
					// 카테고리목록 정보 <-- 서비스에게 최상위 카테고리 정보를 반환하도록 시킨다.
					// 조회된 카테고리 목록은 표시한다.
					ArrayList<Category> parentCategories = storeService.getAllParentCategoryList();
					
					System.out.println("[최상위 카테고리 목록]");
					System.out.println();
					for (Category category : parentCategories) {
						System.out.println("카테고리 번호 : " + category.getNo());
						System.out.println("카테고리 이름 : " + category.getName());
						System.out.println();
					}
					
					// 하위 카테고리를 확인하고 싶은 최상위 카테고리 번호를 입력받는다.
					// 카테고리목록 정보 <-- 카테고리번호를 전달해서 하위카테고리 목록을 제공하도록 서비스에 요청한다.
					// 조회된 하위 카테고리를 표시한다.
					System.out.print("카테고리 번호 입력> ");
					int parentCategoryNo = scanner.nextInt();
					
					ArrayList<Category> childCategories = storeService.getChildCategoryList(parentCategoryNo);
					
					for (Category category : childCategories) {
						if (category.getParentNo() == 0) {
							System.out.println("[상위 카테고리]");
							System.out.println("카테고리 번호 : " + category.getNo());
							System.out.println("카테고리 이름 : " + category.getName());
							System.out.println();
							System.out.println("[하위 카테고리 목록]");
							System.out.println();
						} else {
							System.out.println("     카테고리 번호 : " + category.getNo());
							System.out.println("     카테고리 이름 : " + category.getName());
							System.out.println("상위 카테고리 번호 : " + category.getParentNo());
							System.out.println();							
						}
					}
				
				} else if (menu == 6) {
					System.out.println("[상품 조회하기]");
					
					// 상품목록 정보 <-- 서비스에게 모든 상품정보를 반환하도록 시킨다.
					ArrayList<Goods> goodsList = storeService.getAllGoodsList();
					
					// 조회된 상품목록을 화면에 표시한다.
					// 상품번호, 상품명, 제조사, 가격, 재고, 카테고리명을 출력한다.
					for(Goods goods : goodsList) {
						System.out.println("상품  번호 : " + goods.getNo());
						System.out.println("상  품  명 : " + goods.getName());
						System.out.println("제  조  사 : " + goods.getCompany().getName());
						System.out.println("가      격 : " + goods.getPrice());
						System.out.println("재      고 : " + goods.getStock());
						System.out.println("카테고리명 : " + goods.getCategory().getName());
						System.out.println();
					}
						
				} else if (menu == 7) {
					System.out.println("[상품 구매하기]");
					
					// 구매정보(구매자정보 및 구매상품정보들)를 보관할 HashMap<String, Object> 객체를 생성한다.
					HashMap<String, Object> map = new HashMap<String, Object>();
					
					// 구매상품정보(상품번호와 수량)들을 저장할 콜렉션 만들기
					ArrayList<Item> items = new ArrayList<Item>();
					
					while (true) {
						// 구매할 상품 번호와 수량을 입력받는다.
						System.out.print("상품번호 입력> ");
						int productNo = scanner.nextInt();
						System.out.print("구매수량 입력> ");
						int amount = scanner.nextInt();
						// Item객체를 만들어서 상품번호와 상품수량을 저장한다.
						Item item = new Item();
						item.setProductNo(productNo);
						item.setAmount(amount);
						// 위에서 생성한 콜렉션에 Item 저장하기
						items.add(item);
						
						// 쇼핑계속여부를 입력받는다.
						System.out.print("구매를 계속하시겠습니까?(Y , N)");
						String yn = scanner.next();
						// Y이면 쇼핑계속, N이면 반복종료(break)
						if (yn.equals("N")) {
							break;
						}
					}
					
					// HashMap에 구매자 정보와 구매할상품정보들을 저장한다.
					map.put("customer", loginCustomer);
					map.put("cart", items);
					
					// 서비스에 HashMap을 전달하고 구매작업을 진행시킨다.
					storeService.order(map);
				
				} else if (menu == 8) {
					System.out.println("[구매 취소하기]");
					
					// 구매취소할 주문번호를 입력받는다.
					System.out.print("주문번호 입력> ");
					int orderNo = scanner.nextInt();
					
					// 서비스에 주문번호와 로그인한 고객정보를 전달하고 구매 취소 작업을 진행시킨다.
					storeService.orderCancel(orderNo, loginCustomer);
				
				} else if (menu == 9) {
					System.out.println("[구매 내역보기]");
					
					// 로그인한 고객정보와 cancel정보를 전달하여 구매정보들을 반환한다.
					String cancel = "N";
					ArrayList<OrderItem> orderItems = storeService.getAllOrderItemListByCustomer(loginCustomer, cancel);
					
					// 반환된 구매정보를 출력한다.
					for(OrderItem orderItem : orderItems) {
						System.out.println("상품이름 : " + orderItem.getGoods().getName());
						System.out.println("상품가격 : " + orderItem.getGoods().getPrice());
						System.out.println("카테고리 : " + orderItem.getGoods().getCategory().getName());
						System.out.println("제 조 사 : " + orderItem.getGoods().getCompany().getName());
						System.out.println("주문수량 : " + orderItem.getAmount());
						System.out.println("주문상태 : " + orderItem.getOrder().getState());
						System.out.println("주 문 일 : " + orderItem.getOrder().getCreateDate());
						System.out.println();
					}
	
				} else if (menu == 10) {
					System.out.println("[구매 취소내역 보기]");
					
					// 로그인한 고객정보와 cancel정보를 전달하여 구매정보들을 반환한다.
					String cancel = "Y";
					ArrayList<OrderItem> orderItems = storeService.getAllOrderItemListByCustomer(loginCustomer, cancel);
					
					// 반환된 구매취소정보를 출력한다.
					for(OrderItem orderItem : orderItems) {
						System.out.println("상품이름 : " + orderItem.getGoods().getName());
						System.out.println("상품가격 : " + orderItem.getGoods().getPrice());
						System.out.println("카테고리 : " + orderItem.getGoods().getCategory().getName());
						System.out.println("제 조 사 : " + orderItem.getGoods().getCompany().getName());
						System.out.println("주문수량 : " + orderItem.getAmount());
						System.out.println("주문상태 : " + orderItem.getOrder().getState());
						System.out.println("주 문 일 : " + orderItem.getOrder().getCreateDate());
						System.out.println();
					}
				
				} else if (menu == 11) {
					loginCustomer = null;
				
				} else if (menu == 0) {
					System.out.println("[프로그램 종료]");
					break;
				}
			} catch (Exception e) {
				System.err.println("오류내용 : " + e.getMessage());
				e.printStackTrace();
			}
		}
		scanner.close();
	}
}
