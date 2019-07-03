package day0418.service;


import java.util.ArrayList;
import java.util.HashMap;

import day0418.dao.CategoryDao;
import day0418.dao.CompanyDao;
import day0418.dao.CustomerDao;
import day0418.dao.GoodsDao;
import day0418.dao.OrderDao;
import day0418.vo.Category;
import day0418.vo.Company;
import day0418.vo.Customer;
import day0418.vo.Goods;
import day0418.vo.Item;
import day0418.vo.Order;
import day0418.vo.OrderItem;

public class StoreService {

	private CategoryDao categoryDao = new CategoryDao();
	private CompanyDao companyDao = new CompanyDao();
	private CustomerDao customerDao = new CustomerDao();
	private GoodsDao goodsDao = new GoodsDao();
	private OrderDao orderDao = new OrderDao();
	
	// 신규 고객 가입 서비스
	public void addNewCustomer(Customer customer) throws Exception {
		// Dao를 사용해서 동일한 아이디를 가진 고객정보를 조회해본다.
		Customer cus = customerDao.getCustomerById(customer.getId());
		
		if (cus != null) {
			throw new Exception("동일한 아이디가 존재합니다.");
		}
		
		customerDao.insertCustomer(customer);
		// 동일한 아이디를 가진 고객이 존재하지 않으면 Dao를 사용해서 저장한다.
	}
	
	public Customer loginProcess (String id, String password) throws Exception {
		// Dao를 사용해서 전달받은 아이디에 해당하는 고객정보를 조회해본다.
		Customer customer = customerDao.getCustomerById(id);
		
		// 로그인처리 실패 상황
		// 1. 고객정보가 없으면 예외발생
		if (customer == null) {
			throw new Exception("고객정보가 존재하지 않습니다.");
		}
		
		// 2. 비밀번호가 일치하지 않으면 예외발생
		if (!customer.getPassword().equals(password)) {
			throw new Exception("비밀번호가 틀렸습니다.");
		}
		
		// 1과 2의 경우가 아닌경우
		// 조회된 사용자 정보 반환
		return customer;
	}
	
	// 고객의 상세정보를 제공한다.
	public Customer getCustomerDetail (String id) throws Exception {
		// Dao를 사용해서 전달받은 아이디에 해당하는 고객정보를 조회해본다.
		Customer customer = customerDao.getCustomerById(id);
		
		// 고객정보가 존재하면 고객정보를 반환한다.
		return customer;
	}
	
	// 고객을 탈퇴처리시킨다.
	public void exitCustomer(String id) throws Exception {
		// Dao를 사용해서 전달받은 아이디에 해당하는 고객정보를 조회해본다.
		Customer customer = customerDao.getCustomerById(id);
		
		// 조회된 고객정보에서 사용여부만 N으로 변경한다.
		customer.setUsed("N");
		
		// 변경된 고객정보를 Dao에 전달해서 DB에 반영시킨다.
		customerDao.updateCustomer(customer);
	}
	
	// 최상위 카테고리 정보를 제공한다.
	public ArrayList<Category> getAllParentCategoryList() throws Exception {
		// Dao를 사용해서 최상위 카테고리 정보를 조회한다.
		ArrayList<Category> categories = categoryDao.getAllParentCategoryList();
		
		// 조회된 최상위 카테고리 정보를 반환한다.
		return categories;
	}
	
	// 최상위 카테고리번호를 전달받아서 하위 카테고리 정보를 제공한다.
	public ArrayList<Category> getChildCategoryList(int parentCategoryNo) throws Exception {
		// Dao를 사용해서 전달받은 최상위 카테고리번호에 해당하는 하위 카테고리 정보를 조회한다.
		ArrayList<Category> categories = categoryDao.getChildCategoryList(parentCategoryNo);
		
		// 조회된 하위 카테고리 정보를 반환한다.
		return categories;
	}
	
	// 모든 상품정보를 제공한다.
	public ArrayList<Goods> getAllGoodsList() throws Exception {
		// Dao를 사용해서 모든 상품정보를 조회한다.
		ArrayList<Goods> goodsList = goodsDao.getAllGoods();
		
		// 조회된 상품정보를 반환한다.
		return goodsList;
	}
	
	// 전달받은 구매정보(구매자 정보, 구매 상품정보들)를 활용해서 구매작업을 진행한다.
	// 주문정보 저장, 주문상품정보 저장, 주문한 상품의 재고수량 변경, 고객의 포인트 증가
	public void order (HashMap<String, Object> map) throws Exception {
		
		// Dao를 이용해서 새로운 주문번호를 획득한다.
		int orderNo = orderDao.getOrderNo();
		
		// 주문정보를 담는 Order객체를 생성하고, 주문번호와 구매자정보를 담는다.
		// Dao에게 주문정보를 전달해서 저장한다.
		Order order = new Order();
		order.setNo(orderNo);
		order.setCustomer((Customer)(map.get("customer")));
		
		orderDao.insertOrder(order);
		
		// map에서 주문상품정보들을 꺼낸다.
		// 주문상품정보를 저장하는 반복작업
		ArrayList<Item> items = (ArrayList<Item>)(map.get("cart"));
		int totalPoint = 0;
		for (Item item : items) {
			// 주문상품정보를 담는 OrderItem 객체를 생성한다.
			// 주문상품, 주문수량, 주문정보를 담는다.
			// Dao에게 주문상품정보를 전달해서 저장한다.
			OrderItem orderItem = new OrderItem();
			
			Goods goods = goodsDao.getGoodsByProductNo(item.getProductNo());
			
			orderItem.setGoods(goods);
			orderItem.setAmount(item.getAmount());
			orderItem.setOrder(order);
			
			orderDao.insertOrderItem(orderItem);
			
			// 상품정보의 상품 재고를 변경한다.
			int stock = goods.getStock();
			int amount = item.getAmount();
			
			goods.setStock(stock - amount);
			// Dao를 이용해서 변경된 상품정보를 DB에 반영한다.
			goodsDao.updateGoods(goods);
			
			// 상품정보에서 가격을 조회해서 포인트를 계산한다. 포인트는 가격의 1%다.
			// 포인트 누적
			int price = goods.getPrice();
			
			totalPoint = totalPoint + (price/100)*amount;
		}
		
		// Dao에 고객아이디를 전달해서 고객정보를 조회한다. 
		Customer customer = customerDao.getCustomerById(order.getCustomer().getId());
		// 고객정보의 포인트를 증가시킨다.
		customer.setPoint(customer.getPoint() + totalPoint);
		// Dao에 고객정보를 전달해서 변경된 정보를 반영시킨다.
		customerDao.updateCustomer(customer);
	}
	
	// 구매 취소 기능
	public void orderCancel(int orderNo, Customer loginCustomer) throws Exception {
		// Dao에 orderNo를 전달하여 조회한 주문정보를 담는다.
		Order order = orderDao.getOrderByOrderNo(orderNo);
		if(order == null) {
			throw new Exception("존재하지 않는 주문정보 입니다.");
		}
		// 담은 주문정보의 customer의 no를 Dao에 전달하여 해당 고객의 전체 정보를 담는다.
		Customer customer = customerDao.getCustomerByNo(order.getCustomer().getNo());
		// 로그인한 고객의 주문정보가 맞는지 확인한다.
		if(!customer.getId().equals(loginCustomer.getId())) {
			throw new Exception(loginCustomer.getId() + "님의 주문정보가 아닙니다.");
		}
		order.setCustomer(customer);
		
		// 담은 Order객체의 cancel과 state를 주문취소 상태(Y, 구매취소)로 변경한다.
		order.setCancel("Y");
		order.setState("구매취소");
		// Order객체를 Dao에 전달하여 주문취소 작업을 진행한다.
		orderDao.updateOrder(order);
		
		// orderNo를 전달하여 조회한 주문상품 정보를 담는다.
		ArrayList<OrderItem> orderItems = orderDao.getOrderItemByOrderNo(orderNo);
		int totalPoint = 0;
		// 취소된 상품의 재고를 추가한다.
		for(OrderItem orderItem : orderItems) {
			Goods goods = goodsDao.getGoodsByProductNo(orderItem.getGoods().getNo());
			
			int stock = goods.getStock();
			int amount = orderItem.getAmount();
			
			goods.setStock(stock + amount);
			goodsDao.updateGoods(goods);
			
			int price = goods.getPrice();
			totalPoint = totalPoint + (price/100)*amount;
		}
		
		// 구매시 누적된 포인트를 뺀다.
		customer.setPoint(customer.getPoint() - totalPoint);
		customerDao.updateCustomer(customer);
		
	}
	
	// 구매내역 조회기능 고객정보와 cancel정보를 전달받아서 고객의 구매내역을 반환한다.
	public ArrayList<OrderItem> getAllOrderItemListByCustomer(Customer customer, String cancel) throws Exception {
		// 고객정보와 cancel정보를 Dao에 전달하여 주문 상품정보를 반환한다.
		ArrayList<OrderItem> orderItems = orderDao.getAllOrderItemListByCustomer(customer, cancel);
		
		for(OrderItem orderItem : orderItems) {
			// 주문상품정보의 상품번호를 Dao에 전달하여 상품정보를 반환한다.
			Goods goods = goodsDao.getGoodsByProductNo(orderItem.getGoods().getNo());
			
			// 반환한 상품정보의 회사번호를 Dao에 전달하여 회사정보를 상품정보에 넣는다.
			Company company = companyDao.getCompanyByNo(goods.getCompany().getNo());
			goods.setCompany(company);
			
			// 반환한 상품정보의 카테고리번호를 Dao에 전달하여 카테고리정보를 상품정보에 넣는다.
			Category category = categoryDao.getCategoryByNo(goods.getCategory().getNo());
			goods.setCategory(category);
			
			// 변경된 상품정보를 주문상품정보에 넣는다.
			orderItem.setGoods(goods);
			
			// 주문상품정보의 주문번호를 Dao에 전달하여 주문정보를 반환한다.
			Order order = orderDao.getOrderByOrderNo(orderItem.getOrder().getNo());
			
			// 반환한 주문정보를 주문상품정보에 넣는다.
			orderItem.setOrder(order);
		}
		
		return orderItems;
	}

}
