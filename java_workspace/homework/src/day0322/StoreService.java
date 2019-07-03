package day0322;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class StoreService {
//	가입한 고객정보 저장
	ArrayList<Customer> customers = new ArrayList<Customer>();
//	등록된 상품정보 저장
	ArrayList<Product> products = new ArrayList<Product>();
//	장바구니 정보 저장
	ArrayList<CartItem> carts = new ArrayList<CartItem>();
//	주문정보 저장
	ArrayList<Order> orders = new ArrayList<Order>();
	
//	로그인된 고객정보 저장
	Customer session = null;
	
	public StoreService() {
		customers.add(new Customer("hong", "zxcv1234", "홍길동"));
		customers.add(new Customer("lee", "zxcv1234", "이순신"));
		customers.add(new Customer("kim", "zxcv1234", "김유신"));
		customers.add(new Customer("kang", "zxcv1234", "강감찬"));
		
		products.add(new Product(101, "iphone XS", "핸드폰", 1400000));
		products.add(new Product(102, "apple watch", "시계", 1400000));
		products.add(new Product(103, "galaxy watch", "시계", 1400000));
		products.add(new Product(104, "galaxy 10S", "핸드폰", 1400000));
		products.add(new Product(105, "LG gram", "노트북", 1400000));
		products.add(new Product(106, "playstation 4", "게임기", 1400000));
		products.add(new Product(107, "nintendo switch", "게임기", 1400000));
		products.add(new Product(108, "ipad pro", "태블릿", 1400000));
		products.add(new Product(110, "에어팟", "이어폰", 1400000));
		products.add(new Product(111, "갤럭시버즈", "이어폰", 1400000));
		
		carts.add(new CartItem(products.get(0), customers.get(0), 1));
		carts.add(new CartItem(products.get(3), customers.get(0), 1));
		carts.add(new CartItem(products.get(4), customers.get(0), 1));
		carts.add(new CartItem(products.get(3), customers.get(1), 1));
		carts.add(new CartItem(products.get(4), customers.get(2), 1));

	}
	
	public Customer getSession() {
		return session;
	}
	
	// 로그인
	public void login (String id, String password) {
		Customer findCustomer = findCustomerById(id);
		if (findCustomer == null) {
			System.out.println("회원정보가 존재하지 않습니다.");
			return;
		}
		if (!findCustomer.getPassword().equals(password)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		session = findCustomer;
		System.out.println("정상적으로 로그인되었습니다.");
	}

	// 로그아웃
	public void logout() {
		session = null;
		System.out.println("정상적으로 로그아웃되었습니다.");
	}
	
	// 상품 조회
	public void printAllProducts() {
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		for (Product product : products) {
			product.displayInfo();
		}
	}
	
	// 장바구니 담기
	public void addCart(int productNo, int amount) {
		/*
		 * 상품번호에 해당하는 상품객체 찾기
		 * CartItem을 생성해서 상품객체, 고객객체, 수량을 담기
		 * CartItem을 장바구니에 담기
		 */
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		Product findProduct = findProductByProductNo(productNo);
		if (findProduct == null) {
			System.out.println("상품정보가 존재하지 않습니다.");
			return;
		}
		CartItem cart = new CartItem(findProduct, session, amount);
		carts.add(cart);
		System.out.println("장바구니에 담았습니다.");
	}
	
	// 바로구매
	public void order(int productNo, int amount) {
		/*
		 * 상품번호에 해당하는 상품객체 찾기
		 * Goods를 생성해서 상품, 수량 담기
		 * Order객체를 생성해서 고객객체, Goods객체, 날짜를 담기
		 * Order를 orders에 담기
		 */
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		Product findProduct = findProductByProductNo(productNo);
		if (findProduct == null) {
			System.out.println("상품정보가 존재하지 않습니다.");
			return;
		}
		Goods goods = new Goods(findProduct, amount);

		Order order = new Order();
		order.getGoodsItems().add(goods);
		order.setCustomer(session);
		order.setCreateDate(new Date());
		
		orders.add(order);
		
		findProduct.setStock(findProduct.getStock() - amount);
		findProduct.setLikes(findProduct.getLikes() + amount);
		
		session.setPoint(session.getPoint() + goods.totalPrice()/100);
		
		System.out.println("구매가 완료되었습니다.");
	}
	
	// 장바구니 조회
	public void printCarts() {
		// 로그인한 사람이 장바구니에 담은 것만 표현하기
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}

		for (CartItem cart : carts) {
			if (cart.getCustomer().getId().equals(session.getId())) {
				cart.displayInfo();
			}
		}
	}
	
	// 장바구니에서 삭제
	// service.deleteGoodsInCarts("100,102")
	public void deleteGoodsInCarts(String str) {
		// 장바구니에서 현재 로그인한 사용자가 담은 상품중 상품번호와 일치하는 상품삭제
		// Iterator를 활용
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		String[] productNumbers = str.split(",");
		Iterator<CartItem> it = carts.iterator();
		while(it.hasNext()) {
			CartItem cart = it.next();
			for(String no : productNumbers) {
				int productNo = Integer.parseInt(no);
				if(cart.getProduct().getNo() == productNo) {
					it.remove();
					break;
				}
			}
		}
		System.out.println("장바구니에서 삭제가 완료되었습니다.");
	}
	
	// 장바구니에서 구매
	public void orderInCarts(String str) {
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		Order order = new Order();

		String[] productNumbers = str.split(",");
		for(String no : productNumbers) {
			int productNo = Integer.parseInt(no);
			for(CartItem cart : carts) {
				Product product = cart.getProduct();
				if (product.getNo() == productNo) {
					Goods goods = new Goods(product, cart.getAmount());

					order.getGoodsItems().add(goods);
					
					product.setStock(product.getStock() - cart.getAmount());
					product.setLikes(product.getLikes() + cart.getAmount());
					session.setPoint(session.getPoint() + goods.totalPrice()/100);
					deleteGoodsInCarts(str);
					break;
				}
			}
		}

		order.setCreateDate(new Date());
		order.setCustomer(session);

		orders.add(order);
		System.out.println("구매가 완료되었습니다.");
	}
	
	// 주문조회
	public void printOrders() {
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		
		for (Order order : orders) {
			if(order.getCustomer().getId().equals(session.getId())) {
				order.displayInfo();
			}
		}
	}
	
	// 주문취소
	public void cancelOrders(String str) {
		if(session == null) {
			System.out.println("로그인 후 사용해주세요.");
			return;
		}
		
		String[] productNumbers = str.split(",");
		Iterator<Order> it = orders.iterator();
		while(it.hasNext()) {
			Order order = it.next();
			for (String no : productNumbers) {
				int productNo = Integer.parseInt(no);
				for(Goods goods : order.getGoodsItems()) {
					Product product = goods.getProduct();
					if(product.getNo() == productNo) {
						it.remove();
						
						product.setStock(product.getStock() + goods.getAmount());
						product.setLikes(product.getLikes() - goods.getAmount());
						session.setPoint(session.getPoint() - goods.totalPrice()/100);
						break;
					}
				}
			}
		}
		System.out.println("주문취소가 완료되었습니다.");
	}
	
	private Customer findCustomerById(String id) {
		Customer foundCustomer = null;
		for (Customer customer : customers) {
			if(customer.getId().equals(id)) {
				foundCustomer = customer;
				break;
			}
		}
		return foundCustomer;
	}
	
	private Product findProductByProductNo(int productNo) {
		Product foundProduct = null;
		for (Product product : products) {
			if (product.getNo() == productNo) {
				foundProduct = product;
				break;
			}
		}
		return foundProduct;
	}
}
