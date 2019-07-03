package day0318;

import java.util.Date;

public class MallService {

	private User[] users = new User[100];				// 가입된 회원정보 저장 배열
	private Product[] products = new Product[100];		// 등록된 상품정보 저장 배열
	private Item[] cart = new Item[100];				// 장바구니에 등록된 아이템 정보 저장 배열
	private Item[] orders = new Item[100];				// 구매한 아이템 정보 저장 배열
	
	private int usersPosition = 0;
	private int productsPosition = 0;
	private int cartPosition = 0;
	private int ordersPosition = 0;
	
	private User session = null;						// 로그인한 사용자객체 담는 변수
														// session이 null이면 로그인하지 않은 상황
	
	public MallService() {
		users[usersPosition++] = new User("hong", "zxcv1234", "홍길동");
		users[usersPosition++] = new User("kim", "zxcv1234", "김유신");
		users[usersPosition++] = new User("lee", "zxcv1234", "이순신");
		users[usersPosition++] = new User("kang", "zxcv1234", "강감찬");
		
		products[productsPosition++] = new Product(100, "아이패드프로", 1600000, 1000);
		products[productsPosition++] = new Product(200, "아이폰 XS", 1200000, 1000);
		products[productsPosition++] = new Product(300, "갤럭시 S10", 1300000, 1000);
		products[productsPosition++] = new Product(400, "맥북 프로", 2500000, 1000);
		products[productsPosition++] = new Product(500, "LG 그램", 1100000, 1000);
		products[productsPosition++] = new Product(600, "맥북 에어", 1200000, 1000);
		products[productsPosition++] = new Product(700, "갤럭시 워치", 350000, 1000);
	}
	
	// 회원정보를 전달받아서 저장하는 기능
	public void addUser(User user) {
		if (session != null) {
			System.out.println("[로그아웃 후에 이용해주세요]");
			return;
		}
		if (usersPosition < users.length) {
			users[usersPosition++] = user;
			System.out.println("[회원가입이 완료되었습니다]");
		}
	}
	/*
	 * public void addUser(User user) {
	 * 	if (usersPosition < users.length) {
	 * 		User foundUser = this.findUserByid(user.getId());
	 * 		if (foundUser != null) {
	 * 			System.out.println("동일한 아이디를 가진 사용자가 이미 존재합니다.");
	 * 			return;
	 * 		}
	 * 		users[usersPosition++] = user;
	 * 
	 * 	} else {
	 * 		System.out.println("회원정보를 더이상 저장할 수 없습니다.");
	 * 	}
	 * }
	 */
	
	// 아이디, 비밀번호를 전달받아서 로그인처리를 수행하는 기능
	public void login(String id, String password) {
		// 아이디에 해당하는 사용자정보를 찾아서
		// 비밀번호가 일치하면 session에 사용자정보를 저장한다.
		if (session != null) {
			System.out.println("[로그아웃 후에 이용해주세요]");
			return;
		}
		User user = null;
		for (User u : users) {
			if (u != null && u.getId().equals(id) && u.getPassword().equals(password)) {
				user = u;
				break;
			} 
		}
		if (user == null) {
			System.out.println("[입력하신 정보가 잘못되었습니다]");
			System.out.println("[다시 입력하세요]");
			return;
		}
		session = user;
		System.out.println("["+user.getName()+"님 환영합니다.]");
		
	}
	
	// 로그아웃을 수행하는 기능
	public void logout() {
		// session에 저장된 사용자정보를 제거한다.(null로 바꾼다.)
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		session = null; 
		System.out.println("[정상적으로 로그아웃 되었습니다.]");
	}
	
	// 현재 로그인된 사용자 정보를 제공하는 기능
	public User getSession() {
		return session;
	}
	
	// 모든 상품정보를 출력하는 기능
	public void printAllProducts() {
		// 모든 상품정보를 출력한다.
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		for (Product p : products ) {
			if(p != null) {
				System.out.println("상품번호: " + p.getNo());
				System.out.println("상품이름: " + p.getName());
				System.out.println("상품가격: " + CommonUtils.numberWithComma(p.getPrice()) + "원");
				System.out.println("상품재고: " + p.getStock());
				System.out.println();
			}
		}
	}
	
	// 상품번호, 수량을 입력받아서 장바구니배열에 저장하는 기능
	public void addItemToCart(int productNo, int amount) {
		// 전달받은 상품번호에 해당하는 상품정보를 배열에서 찾는다.
		// Item객체를 생성해서
		// 상품정보(객체), 로그인한 사용자정보, 수량, 현재 날짜와 시간정보 (Date now = new Date();) 정보를 저장하고
		// 장바구니배열에 아이템을 저장한다.
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		
		Product product = null;
		for (Product p : products) {
			if (p != null && p.getNo() == productNo) {
				product = p;
				break;
			}
		}
		if (product == null) {
			System.out.println("[상품정보가 없습니다]");
			return;
		}
		
		Date now = new Date();
		Item i = new Item();
		i.setProduct(product);
		i.setUser(session);
		i.setAmount(amount);
		i.setCreateDate(now);
		
		if (cartPosition < cart.length) {
			cart[cartPosition++] = i;
			System.out.println("[상품을 장바구니에 담았습니다]");
		}
	}
	
	// 장바구니배열에서 현재 로그인된 사용자의 장바구니 정보를 출력하는 기능
	public void printCart() {
		// 장바구니 배열에서 현재 Item객체를 하나씩 꺼내서
		// Item에 저장된 사용자의 아이디와 현재 로그인한 사용자의 아이디가 일치하는
		// Item정보만 출력한다.
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		Item item = null;
		for(Item i : cart) {
			if(i != null && i.getUser().getId().equals(session.getId())) {
				System.out.println("상품번호: " + i.getProduct().getNo());
				System.out.println("상품이름: " + i.getProduct().getName());
				System.out.println("상품가격: " + CommonUtils.numberWithComma(i.getProduct().getPrice()) + "원");
				System.out.println("상품수량: " + i.getAmount());
				System.out.println("구매가격: " + CommonUtils.numberWithComma(i.getTotalPrice()) + "원");
				System.out.println("구매날짜: " + CommonUtils.dateToString(i.getCreateDate()));
				System.out.println();
				item = i;
			}
		}
		if (item == null) {
			System.out.println("[장바구니에 상품이 없습니다]");
		}
	}
	
	// 상품번호, 수량을 입력받아서 주문배열에 저장하는 기능
	public void addItemToOrders(int productNo, int amount) {
		// 전달받은 상품번호에 해당하는 상품정보를 배열에서 찾는다.
		// 상품정보의 재고에서 주문수량만큼 재고를 줄인다.
		// Item객체를 생성해서
		// Item객체에 상품정보(객체), 로그인한 사용자정보, 수량,
		// 현재 날짜와 시간정보(Date now = new Date();) 정보를 저장하고
		// 주문배열에 아이템을 저장한다.
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		Product product = null;
		for (Product p : products) {
			if (p != null && p.getNo() == productNo) {
				product = p;
				break;
			}
		}
		if (product == null) {
			System.out.println("[상품정보가 없습니다]");
			return;
		}
		product.setStock(product.getStock() - amount);
		
		Date now = new Date();
		Item i = new Item();
		i.setProduct(product);
		i.setUser(session);
		i.setAmount(amount);
		i.setCreateDate(now);
		
		if (ordersPosition < orders.length) {
			orders[ordersPosition++] = i;
			i.getUser().setPoint(i.getUser().getPoint() + i.getTotalPrice()/100);
			deleteItemFromCart(i);
		}
	}
	
	// 주문배열에서 현재 로그인된 사용자의 주문 정보를 출력하는 기능
	public void printOrders() {
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		for(Item i : orders) {
			if (i != null && i.getUser().getId().equals(session.getId())) {
				System.out.println("상품번호: " + i.getProduct().getNo());
				System.out.println("상품이름: " + i.getProduct().getName());
				System.out.println("상품가격: " + CommonUtils.numberWithComma(i.getProduct().getPrice()) + "원");
				System.out.println("상품수량: " + i.getAmount());
				System.out.println("구매가격: " + CommonUtils.numberWithComma(i.getTotalPrice()) + "원");
				System.out.println("구매날짜: " + CommonUtils.dateToString(i.getCreateDate()));
				System.out.println();
			}
		}
	}
	
	// 현재 로그인된 사용자의 정보를 출력하는 기능
	public void printMyInfo() {
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		System.out.println("아이디: " + getSession().getId());
		System.out.println("이  름: " + getSession().getName());
		System.out.println("포인트: " + getSession().getPoint());
	}
	
	// 이전 비밀번호, 새 비밀번호를 전달받아서 현재 로그인된 사용자의 비밀번호를 변경하는 기능
	public void changePassword(String oldPassword, String newPassword) {
		if(getSession() == null) {
			System.out.println("로그인 후 이용하세요.");
			return;
		}
		if(getSession().getPassword().equals(oldPassword)) {
			getSession().setPassword(newPassword);
			System.out.println("[비밀번호 변경이 완료되었습니다]");
		} else {
			System.out.println("[비밀번호가 틀렸습니다]");
			return;
		}
	}
	
	// 로그아웃 상태일 때 메소드를 탈출하는 기능	// 실패 / 해당 메소드만 탈출할뿐 외부 메소드는 탈출하지 않음
//	public void isLogin() {
//		if(getSession() == null) {
//			System.out.println("로그인 후 이용하세요.");
//			return;
//		}
//	}
	
	// 사용자에게 전체 상품구매를 확인(1:예 2:아니오)받은 후 로그인한 사용자의 장바구니에서 전체물건 구매하기
	public void addItemToOrdersFromCart(int no) {
		Item item = null;
		for (Item i : cart) {
			if (i != null && i.getUser().getId().equals(getSession().getId())) {
				if(ordersPosition < orders.length) {
					orders[ordersPosition++] = i;
					i.getProduct().setStock(i.getProduct().getStock() - i.getAmount());
					i.getUser().setPoint(i.getUser().getPoint() + i.getTotalPrice()/100);
					deleteItemFromCart(i);
					item = i;
				}
			}
		}
		if (item == null) {
			System.out.println("[장바구니에 상품이 없습니다]");
			return;
		}
	}
	
	// 상품번호를 전달받아서 해당 상품을 장바구니에서 삭제하기
	public void deleteItemFromCartByNo (int productNo) {
		Item item = null;
		for (Item i : cart) {
			if (i != null && i.getProduct().getNo() == productNo) {
				item = i;
				break;
			}
		}
		deleteItemFromCart(item);
	}
	
	// 장바구니에서 상품 삭제하기
	public void deleteItemFromCart (Item item) {
		boolean delItem = false;
		for (int i=0; i<=cartPosition; i++) {
			if (cart[i] != null && cart[i].getProduct().getNo() == item.getProduct().getNo() && cart[i].getUser().getId().equals(item.getUser().getId())) {
				cart[i] = null;
				delItem = true;
				break;
			}
		}
		if (!delItem) {
			System.out.println("[장바구니에 상품이 없습니다]");
			System.out.println("[장바구니에서 삭제되지 않습니다.]");
			return;
		}
		for(Item i : cart) {
			if (i == null && cart[cartPosition] != null) {
				i = cart[cartPosition];
				cart[cartPosition] = null;
				cartPosition--;
				System.out.println("[장바구니에서 "+ item.getProduct().getName() +" 삭제가 완료되었습니다]");
				break;
			} else if (i == null && cart[cartPosition] == null) {
				cartPosition--;
				System.out.println("[장바구니에서 "+ item.getProduct().getName() +" 삭제가 완료되었습니다]");
				break;
			}
		}
		
	}
	
	/*
	 * private User findUserById(String id) {
	 * 	for (User user : users) {
	 * 		if ( user != null && user.getId().equals(id)){
	 * 			return user;
	 * 		}
	 * }
	 * return null;
	 */
	
}
